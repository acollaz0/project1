package logging;

import org.apache.log4j.Logger;

public class MyLogger {

	final public static Logger logger = Logger.getLogger(MyLogger.class);
	
	public static void main(String[] args) {
		
		logger.info("Information Messages");
		logger.warn("Use this for when something occurs that isnt right but not necessarially an issue");
		logger.error("This is for exceptions and 'errors' shuold be stuff that doesn't crash apps");
		logger.debug("This is for debugging ie removing the milion printlines");
		logger.fatal("This is for catastrophic failures. Program crashed scenarios");
	}

}
