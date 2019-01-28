package logging;

import org.apache.log4j.Logger; //Be sure to use this logger, not the native java logger
//since this is the one we added to our pom.xml file, and set up in our log4j.properties

//If this import doesn't work, then delete the folder from .m2/repository and have Maven update the project 

public class MyLogger {
	
	final public static Logger logger = Logger.getLogger(MyLogger.class);
	
	public static void main(String[] args) {
		
		//How logging works:
		logger.info("Information message: some stuff happened");
		logger.warn("Use this for when something occurs that isn't right but not necessarily bad");
		logger.error("Used for exceptions and 'errors'. Should be stuff that doesn't crash the app");
		logger.debug("Use this for debugging purposes. Replace the System.out.println");
		logger.fatal("For catastrophic failures. Program crashed");
		
	}

}