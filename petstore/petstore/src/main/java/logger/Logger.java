package logger;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static org.apache.logging.log4j.Logger resultLogger = LogManager.getLogger("LOGGER-RESULTS");
    private static org.apache.logging.log4j.Logger debugLogger = LogManager.getLogger("LOGGER-DEBUG");
    private static org.apache.logging.log4j.Logger consoleLogger = LogManager.getLogger("LOGGER-CONSOLE");


    public synchronized static void logInfo(String message) {
        resultLogger.info(message);
        consoleLogger.info(message);
        ExtentLogger.logPass(message);
    }

    public static void logDebug(String message) {
        debugLogger.debug(message);
        ExtentLogger.logInfo(message);
    }

    public static void logError(String message, Throwable throwable) {
        debugLogger.error(message, throwable);
        ExtentLogger.logDebug(throwable);
    }

}
