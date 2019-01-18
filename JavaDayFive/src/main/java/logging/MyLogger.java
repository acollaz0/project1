package logging;

// Rather than trying to use Java's Logger package
// we want outside custom
import org.apache.log4j.Logger;

public class MyLogger {
	
	
	final public static Logger logger = Logger.getLogger(MyLogger.class);

	public static void main(String[] args) {
		
		logger.info("information messages stuff that is happening");
		logger.warn("Use this for when something occurs that isnt right but not necesarrily an isse");
		logger.error("This for exceptions and 'errors' should be stuff that does not crash appplication");
		logger.debug("Use this for debugging ie remove the million print lines");
		logger.fatal("This if for catatsophic failures. Program crashed scenarios");
		
	}

}
