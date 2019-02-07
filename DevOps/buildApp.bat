cd C:\Users\Administrator\.jenkins\workspace\Bball
call C:\Users\Administrator\Desktop\Dev\apache-tomcat-8.5.37\bin\mvn package
cd C:\Users\Administrator\.jenkins\workspace\Bball\BBallApp\target
copy BBallApp.war C:\Users\Administrator\Desktop\Dev\apache-tomcat-8.5.37\webapps /y

