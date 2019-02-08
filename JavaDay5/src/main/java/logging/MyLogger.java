package logging;

//Rather than trying to use Java's Logger package
//we want outside custom

import org.apache.log4j.Logger;

public class MyLogger {

	
	final public static Logger logger = Logger.getLogger(MyLogger.class);
	
	public static void main(String[] args) {
		
		logger.info("Information messages stuff that is happening");
		logger.warn("Use this when something occurs that isnt right but not necessarily correct");
		logger.error("This is for exceptions and 'errors' should be stuff that does not crash the application");
		logger.debug("Use this for debugging purposes ie remove the million print lines");
		logger.fatal("This is for catastrophic failures. Program crashed scenario");
	
	}

}
