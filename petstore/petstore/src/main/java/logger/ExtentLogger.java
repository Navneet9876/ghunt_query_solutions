package logger;

import com.aventstack.extentreports.Status;
import reporting.extentreports.ExtentManager;

public class ExtentLogger {

    private static InheritableThreadLocal<LOG_LEVEL> logLevel = new InheritableThreadLocal<LOG_LEVEL>() {
        @Override
        public LOG_LEVEL initialValue() {
            return LOG_LEVEL.DEBUG;
        }
    };

    private static LOG_LEVEL getLogLevel() {
        return logLevel.get();
    }

    public static void setLogLevel(LOG_LEVEL logLevel) {
        ExtentLogger.logLevel.set(logLevel);
    }

    public static void logPass(String log) {
        if (ExtentManager.getTest().get() != null)
            ExtentManager.getTest().get().log(Status.PASS, replaceNewLines(log));
    }

    public static void logDebug(Throwable throwable) {
        if (getLogLevel().getLevel() <= LOG_LEVEL.DEBUG.getLevel()) {
            if (ExtentManager.getTest().get() != null)
                ExtentManager.getTest().get().debug(throwable);
        }
    }


    public static void logInfo(String log) {
        if (getLogLevel().getLevel() <= LOG_LEVEL.DEBUG.getLevel()) {
            if (ExtentManager.getTest().get() != null)
                ExtentManager.getTest().get().info(replaceNewLines(log));
        }
    }

    private static String replaceNewLines(String log) {
        return log.replace(System.lineSeparator(), "<br>");
    }

    public enum LOG_LEVEL {
        PASS(2), DEBUG(1);

        private int level;

        LOG_LEVEL(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

    }

}
