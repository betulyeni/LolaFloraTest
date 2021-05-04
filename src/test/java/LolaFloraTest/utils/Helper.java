package LolaFloraTest.utils;


import LolaFloraTest.core.PropKey;
import LolaFloraTest.core.PropertyReader;
import LolaFloraTest.driver.BrowserType;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class Helper {

    public static boolean isRemote() throws IOException {
        String isRemote = SystemPropertyHelper.getRemoteVal();

        if(isRemote.equalsIgnoreCase("TRUE")){
            return true;
        }
        return false;
    }

    public static String getHubUrl() throws IOException {
        return PropertyReader.getInstance().getProperty(PropKey.HUB_URL.getPropVal());
    }

    public static String getBrowserPath() throws IOException {


        if(IS_OS_WINDOWS){

            if(SystemPropertyHelper.getBrowserFromSystemVariable() == BrowserType.CHROME){

                return PropertyReader.getInstance()
                        .getProperty(PropKey.CHROME_DRIVER_PATH_WIN.getPropVal());

            }else if(SystemPropertyHelper.getBrowserFromSystemVariable() == BrowserType.FIREFOX){

                return PropertyReader.getInstance()
                        .getProperty(PropKey.GECKO_DRIVER_PATH_WIN.getPropVal());

            }else if(SystemPropertyHelper.getBrowserFromSystemVariable() == BrowserType.IE){

                return PropertyReader.getInstance()
                        .getProperty(PropKey.IE_DRIVER_PATH_WIN.getPropVal());
            }
        }

        if(SystemPropertyHelper.getBrowserFromSystemVariable() == BrowserType.FIREFOX){

            return PropertyReader.getInstance()
                    .getProperty(PropKey.GECKO_DRIVER_PATH_OSX.getPropVal());
        }else{
            return PropertyReader.getInstance()
                    .getProperty(PropKey.CHROME_DRIVER_PATH_OSX.getPropVal());
        }
    }

    public static synchronized  boolean takeScreenShot(WebDriver driver, String name) throws IOException {
        boolean isScreenShot = PropertyReader.getInstance()
                .getProperty(PropKey.SCREENSHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if(isScreenShot){
            attachScreenShot(driver,name);
            return true;
        }
        return false;
    }

    @Attachment(value = "{name}" , type = "image/png")
    private static synchronized byte[] attachScreenShot(WebDriver driver,
                                                        String name){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
