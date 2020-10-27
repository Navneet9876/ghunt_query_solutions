package base;

import global.GenericFunctions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import reporting.listeners.TestNGReportListener;

@Listeners({TestNGReportListener.class})
public class BaseTestClass {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("--------------------- INSIDE BEFORE SUITE ---------------------");
        GenericFunctions.initDirectories();
        GenericFunctions.initExtentReports();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(ITestContext context) {
        System.out.println("--------------------- INSIDE AFTER SUITE ---------------------");
        GenericFunctions.addExecutionDetailsExtentReport(context);
    }

}