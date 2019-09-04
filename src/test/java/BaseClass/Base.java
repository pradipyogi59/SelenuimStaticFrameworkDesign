package BaseClass;

import Utilities.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static FileInputStream fis;
    public static Properties prop;
    public static WebDriverWait wait;
    public static Logger logger;


    public Base() {

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger = LogManager.getLogger();
    }

    public void initialization() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        logger.log(Level.INFO,"Navigating site");
        wait = new WebDriverWait(driver, 5);
        Utils.HandleWindows();

    }

}
