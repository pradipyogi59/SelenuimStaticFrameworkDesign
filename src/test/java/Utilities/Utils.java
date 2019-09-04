package Utilities;

import BaseClass.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import static org.apache.commons.io.FileUtils.*;

public class Utils extends Base {

    static String path=System.getProperty("user.dir")+"\\src\\main\\resources\\ScreenShot";

    public static void TeakeScrrenShot(){

        TakesScreenshot ts=(TakesScreenshot) driver;
        File srcFile= ts.getScreenshotAs(OutputType.FILE);

        Date d=new Date();
        String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        try {
            copyFile(srcFile,new File(path+screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void HandleWindows(){
        String parent=driver.getWindowHandle();
        Set<String> all=driver.getWindowHandles();
        for(String s:all)
        {
           if (!parent.equalsIgnoreCase(s)){
               driver.switchTo().window(s);
               driver.close();
           }
        }
        driver.switchTo().window(parent);
    }

    public static void WaitAndClick(WebElement ele)
    {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();
    }

}
