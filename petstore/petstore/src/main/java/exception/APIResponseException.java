package exception;


import logger.Logger;

public class APIResponseException extends Exception {

    public APIResponseException(String message, Throwable throwable) {
        Logger.logError(message, throwable);
    }
}
