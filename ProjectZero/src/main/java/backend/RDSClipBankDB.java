package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.rds.auth.GetIamAuthTokenRequest;
import com.amazonaws.services.rds.auth.RdsIamAuthTokenGenerator;

public class RDSClipBankDB implements ClipBankDao {
	
	private static RDSClipBankDB bank = null; // this class will be a singleton
	private Connection connection;
	
	//AWS Credentials of the IAM user with policy enabling IAM Database Authenticated access to the db by the db user.
    private static final DefaultAWSCredentialsProviderChain creds = new DefaultAWSCredentialsProviderChain();
    private static final String AWS_ACCESS_KEY = creds.getCredentials().getAWSAccessKeyId();
    private static final String AWS_SECRET_KEY = creds.getCredentials().getAWSSecretKey();

    //Configuration parameters for the generation of the IAM Database Authentication token
    private static final String RDS_INSTANCE_HOSTNAME = "tomsdetdb.cjroyz7uh9et.us-east-1.rds.amazonaws.com";
    private static final int RDS_INSTANCE_PORT = 1521;
    private static final String REGION_NAME = "us-east-1d";
    private static final String DB_USER = "tbnilson";
    private static final String JDBC_URL = "jdbc:oracle:thin:@" + RDS_INSTANCE_HOSTNAME + ":" + RDS_INSTANCE_PORT + ":orcl"; 

    private static final String SSL_CERTIFICATE = "rds-ca-2015-us-east-1.pem";

    private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE_PROVIDER = "SUN";
    private static final String KEY_STORE_FILE_PREFIX = "sys-connect-via-ssl-test-cacerts";
    private static final String KEY_STORE_FILE_SUFFIX = ".jks";
    private static final String DEFAULT_KEY_STORE_PASSWORD = "password"; //not sure if correct place for the password? NVM, def not, though apparently id doesn't break anything
	public static final int MAX_DEPOSIT = 1000000;

    private RDSClipBankDB() throws Exception {
    	this.connection = getDBConnectionUsingIam();
    }
    
    public static RDSClipBankDB getRDSClipBankDB() throws Exception {
    	
    	if (bank == null) {
    		return new RDSClipBankDB();
    	} else {
    		return bank;
    	}
    	
    }

    /**
     * This method returns a connection to the db instance authenticated using IAM Database Authentication
     * @return
     * @throws Exception
     */
    public static Connection getDBConnectionUsingIam() throws Exception {
        setSslProperties();
        Properties p = setMySqlConnectionProperties();
        try {
			return DriverManager.getConnection(JDBC_URL, p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        
    }

    /**
     * This method sets the mysql connection properties which includes the IAM Database Authentication token
     * as the password. It also specifies that SSL verification is required.
     * @return
     */
    private static Properties setMySqlConnectionProperties() {
        Properties mysqlConnectionProperties = new Properties();
        mysqlConnectionProperties.setProperty("verifyServerCertificate","true");
        mysqlConnectionProperties.setProperty("useSSL", "true");
        mysqlConnectionProperties.setProperty("user",DB_USER);
//        mysqlConnectionProperties.setProperty("password",generateAuthToken());
        mysqlConnectionProperties.setProperty("password","password");
        return mysqlConnectionProperties;
    }

    /**
     * This method generates the IAM Auth Token.
     * An example IAM Auth Token would look like follows:
     * btusi123.cmz7kenwo2ye.rds.cn-north-1.amazonaws.com.cn:3306/?Action=connect&DBUser=iamtestuser&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20171003T010726Z&X-Amz-SignedHeaders=host&X-Amz-Expires=899&X-Amz-Credential=AKIAPFXHGVDI5RNFO4AQ%2F20171003%2Fcn-north-1%2Frds-db%2Faws4_request&X-Amz-Signature=f9f45ef96c1f770cdad11a53e33ffa4c3730bc03fdee820cfdf1322eed15483b
     * @return
     */
    private static String generateAuthToken() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);

        RdsIamAuthTokenGenerator generator = RdsIamAuthTokenGenerator.builder()
                .credentials(new AWSStaticCredentialsProvider(awsCredentials)).region(REGION_NAME).build();
        return generator.getAuthToken(GetIamAuthTokenRequest.builder()
                .hostname(RDS_INSTANCE_HOSTNAME).port(RDS_INSTANCE_PORT).userName(DB_USER).build());
    }

    /**
     * This method sets the SSL properties which specify the key store file, its type and password:
     * @throws Exception
     */
    private static void setSslProperties() throws Exception {
        System.setProperty("javax.net.ssl.trustStore", createKeyStoreFile());
        System.setProperty("javax.net.ssl.trustStoreType", KEY_STORE_TYPE);
        System.setProperty("javax.net.ssl.trustStorePassword", DEFAULT_KEY_STORE_PASSWORD);
    }

    /**
     * This method returns the path of the Key Store File needed for the SSL verification during the IAM Database Authentication to
     * the db instance.
     * @return
     * @throws Exception
     */
    private static String createKeyStoreFile() throws Exception {
        return createKeyStoreFile(createCertificate()).getPath();
    }

    //unnecessary?
    /**
     *  This method generates the SSL certificate
     * @return
     * @throws Exception
     */
    private static X509Certificate createCertificate() throws Exception {
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        URL url = new File(SSL_CERTIFICATE).toURI().toURL();
        if (url == null) {
            throw new Exception();
        }
        try (InputStream certInputStream = url.openStream()) {
            return (X509Certificate) certFactory.generateCertificate(certInputStream);
        }
    }

    /**
     * This method creates the Key Store File
     * @param rootX509Certificate - the SSL certificate to be stored in the KeyStore
     * @return
     * @throws Exception
     */
    private static File createKeyStoreFile(X509Certificate rootX509Certificate) throws Exception {
        File keyStoreFile = File.createTempFile(KEY_STORE_FILE_PREFIX, KEY_STORE_FILE_SUFFIX);
        try (FileOutputStream fos = new FileOutputStream(keyStoreFile.getPath())) {
            KeyStore ks = KeyStore.getInstance(KEY_STORE_TYPE, KEY_STORE_PROVIDER);
            ks.load(null);
            ks.setCertificateEntry("rootCaCertificate", rootX509Certificate);
            ks.store(fos, DEFAULT_KEY_STORE_PASSWORD.toCharArray());
        }
        return keyStoreFile;
    }
    
    /**
     * This method clears the SSL properties.
     * @throws Exception
     */
    private static void clearSslProperties() throws Exception {
           System.clearProperty("javax.net.ssl.trustStore");
           System.clearProperty("javax.net.ssl.trustStoreType");
           System.clearProperty("javax.net.ssl.trustStorePassword"); 
    }

	@Override
	public boolean createUser(String username, String password) {
		
		try {
			Statement s = connection.createStatement();
			s.executeUpdate("INSERT INTO USERS (USRNAME, PASS) \n"
					+ "VALUES ('" + username + "' , '" + password + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public ClipBox createClipBox(String username) {
		
		String newID = generateUniqueClipBoxID(10);
		
		try {
			Statement s = connection.createStatement();
			
			System.out.println(newID + ": " + username);
			
			s.executeUpdate("INSERT INTO CLIPBOXES (BOXID, USERNAME) \n"
					+ "VALUES ('" + newID + "' , '" + username + "')");
			s.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return ClipBox.getClipBox(newID);
	}
	
	private String generateUniqueClipBoxID(int length) {
		
		char[] alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder newID = new StringBuilder(length);
		Random r = new Random();
		
		do {
			for (int i = 0; i < length; i++) {
				newID.append(
						alphanum[r.nextInt(alphanum.length)] );
			}
		} while (exists("CLIPBOXES","BOXID",newID.toString()));
		
		return newID.toString();
		
	}

	@Override
	public boolean hasAccount(String username) {
		
		//Statement s = connection.createStatement();
		
		return false;
	}

	@Override
	public boolean validate(String username, String password) {
		
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("SELECT COUNT(*) AS NUM FROM USERS\n"
					+ "WHERE "
					+ "USRNAME='" + username + "' AND PASS='" + password + "'");
			r.next();
//			System.out.println(r.next());
//			System.out.println(r.getInt("COUNT(*)"));
			boolean b = r.getInt("NUM")>0;
			r.close();
			return b;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean isSuperUser(String username) {
		return false;
	}

	@Override
	public List<ClipTransaction> getTransactions(String username) {
		return null;
	}

	@Override
	public List<ClipBox> getClipBoxes(String username) {
		
		List<ClipBox> boxes = new ArrayList<>();
		
		if (this.exists("USERS", "USRNAME", username) && this.exists("CLIPBOXES", "USERNAME", username)) {
			Statement s=null;
			try {
				s = connection.createStatement();
				ResultSet r = s.executeQuery("SELECT * FROM CLIPBOXES\n"
						+ "WHERE USERNAME='" + username + "'");
				//r.next();
				while (r.next()) {
					boxes.add(ClipBox.getClipBox(
							r.getString("BOXID")
							));
				}
				r.close();
			} catch (SQLException e) {
				e.printStackTrace();
				boxes = null;
			}
		}
		
		return boxes;
	}

	@Override
	public int getBalance(String boxID) {
		
		Statement s;
		int balance = 0;
		
		try {
			s = connection.createStatement();
			
			if (this.exists("CLIPBOXES", "BOXID", boxID)) {
				ResultSet r = s.executeQuery("SELECT BALANCE FROM CLIPBOXES\n"
						+ "WHERE BOXID='" + boxID + "'");
				r.next();
				balance = r.getInt(1);
				r.close();
			} else {balance = -1;}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			balance = -1;
		}
		
		return balance;
	}

	@Override
	public int withdraw(int value, ClipBox box) {
		
		int oldbalance = box.getBalance();
		int newbalance = oldbalance - value;
		try {
			Statement s = connection.createStatement();
		
			int r = s.executeUpdate(
					"UPDATE CLIPBOXES\n"
					+ "SET BALANCE='" + newbalance + "'\n"
					+ "WHERE BOXID='" + box.getClipboxID() + "'");
			
			this.recordTransaction(box,(-1)*value);
			
			return box.getBalance();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int deposit(int value, ClipBox box) {
		return withdraw(value*(-1), box);
	}

	@Override
	public int getBalance(ClipBox box) {
		return getBalance(box.getClipboxID());
	}

	@Override
	public boolean deleteClipBox(ClipBox box) {
		
		try {
			Statement s = connection.createStatement();
			s.executeUpdate(String.format("DELETE FROM CLIPBOXES WHERE BOXID='%s'", box.getClipboxID()));
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public void closeConnection() {
	}

	@Override
	public boolean exists(String table, String column, String value) {
		
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("SELECT COUNT(*) FROM " + table + " \n"
					+ "WHERE " + column + "='" + value + "'");
			r.next();
			return r.getInt(1)>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getClipBoxUserName(String clipboxID) {
		
		if (this.exists("CLIPBOXES", "BOXID", clipboxID)) {
			Statement s=null;
			try {
				s = connection.createStatement();
				ResultSet r = s.executeQuery("SELECT * FROM CLIPBOXES\n"
						+ "WHERE BOXID='" + clipboxID + "'");
				r.next();
				String result = r.getString("USERNAME");
				
				r.close();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public boolean userExists(String username) {
		
		return this.exists("USERS", "USRNAME", username);
	}

	@Override
	public boolean recordTransaction(ClipBox box, int value) {
		
		try {
			Statement s = connection.createStatement();
			
			int r = s.executeUpdate(
					String.format("INSERT INTO TRANSACTIONS (boxid, finalbalance, transaction_value, transaction_date)\r\n" + 
					"VALUES ('%s', '%d','%d', SYSDATE)",
					box.getClipboxID(), 
					box.getBalance(), 
					value));
			return r==0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
