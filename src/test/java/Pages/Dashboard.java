package Pages;

import BaseClass.Base;
import Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.management.Query;

public class Dashboard extends Base {

    @FindBy(id="remove_no")
    WebElement pop_up;

    @FindBy(id="MainContent_lblWfA1")
    WebElement bill_wfa;

    @FindBy(id="MainContent_lblWfA1_cr")
    WebElement credit_wfa;

    @FindBy(id="MainContent_lblQuery1_0")
    WebElement query_wfa;

    @FindBy(id="MainContent_lblResolveIssue_0")
    WebElement issue_resolve;

    @FindBy(id="lbl_link")
    WebElement sub_title;

    public Dashboard() {

        PageFactory.initElements(driver, this);

    }

    public void cancelPopUp() {

        try {
            if (pop_up.isDisplayed())
                pop_up.click();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public String verifyDashTitle() {

        return sub_title.getText();
    }

    public Bills clickOnBill() {

        Utils.WaitAndClick(bill_wfa);
        return new Bills();
    }

    public Credit_notes clickOnCreditNotes() {

        credit_wfa.click();
        return new Credit_notes();
    }

    public Query clickOnQuery() {

        query_wfa.click();
        return new Query();
    }


}
