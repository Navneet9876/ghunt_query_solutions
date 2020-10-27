package global;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import reporting.extentreports.ExtentManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GenericFunctions {

    public static synchronized void initExtentReports() {
        ExtentManager.createInstance();
    }

    public synchronized static void initDirectories() {
        try {
            File reportDirectory = new File(GlobalData.OUTPUT_FOLDER_REPORT);
            FileUtils.forceMkdir(reportDirectory);
            FileUtils.cleanDirectory(reportDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void addExecutionDetailsExtentReport(ITestContext context) {
        String passPercentage = (context.getPassedTests().size() * 100) / (context.getPassedTests().size() + context.getFailedTests().size()
                + context.getSkippedTests().size()) + "%";
        ExtentManager.addSystemInfo("Pass %", MarkupHelper.createLabel(passPercentage, ExtentColor.GREEN).getMarkup());
    }
}
