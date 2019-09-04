package Pages;

import BaseClass.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    @FindBy(id="UserName")
    WebElement username;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(id="LoginButton")
    WebElement login_button;

    @FindBy(xpath=".//*[@class='wrapper']/h1/a/img")
    WebElement logo;


    public LoginPage() {

        PageFactory.initElements(driver, this);

    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCaaxLogo() {
        return logo.isDisplayed();
    }

    public Dashboard login(String un,String pw) {
        username.sendKeys(un);
        password.sendKeys(pw);
        login_button.click();

        return new Dashboard();

    }


}
