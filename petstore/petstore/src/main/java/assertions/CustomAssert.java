package assertions;

import http.HTTPStatusCode;
import logger.ExtentLogger;
import org.testng.Assert;

import java.util.List;

public class CustomAssert {
    private List<Throwable> m_errors;

    private CustomAssert() {
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
        ExtentLogger.logPass(message + " = <b>Pass</b>");
    }

    public static void assertFail(String message) {
        Assert.fail(message);
    }

    public static void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
        String str = message + "<br><b>Actual : </b>" + actual + "<br><b>Expected : </b>" + expected;
        ExtentLogger.logPass(str);

    }

    public static void assertEquals(HTTPStatusCode actual, HTTPStatusCode expected, String message) {
        Assert.assertEquals(actual, expected, message);
        String str = message + "<br><b>Actual : </b>" + actual.name() + "<br><b>Expected : </b>" + expected.name();
        ExtentLogger.logPass(str);

    }

    public static void assertEquals(boolean actual, boolean expected, String message) {
        Assert.assertEquals(actual, expected, message);
        String str = message + "<br><b>Actual : </b>" + actual + "<br><b>Expected : </b>" + expected;
        ExtentLogger.logPass(str);
    }
}
