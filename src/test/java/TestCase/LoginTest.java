package TestCase;

import BaseClass.Base;
import Pages.Bills;
import Pages.Dashboard;
import Pages.LoginPage;
import org.apache.logging.log4j.Level;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    LoginPage loginPage;
    Dashboard dashboardPage;
    Bills billsPage;


    @BeforeTest
    public void setUp(){

        initialization();
        loginPage=new LoginPage();
        Base.logger.log(Level.INFO,"Setup Done");
    }


    @Test(priority = 2)
    public void ValidLogin(){
       dashboardPage=loginPage.login(prop.getProperty("userName"),prop.getProperty("password"));
    }

    @Test(priority = 3)
    public void DashboardCheck(){
        dashboardPage.cancelPopUp();
        billsPage=dashboardPage.clickOnBill();
    }

    @AfterTest
    public void close(){
        driver.quit();
    }

}
