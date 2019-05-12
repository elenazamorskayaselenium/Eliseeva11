package pages;
import libs.ActionWithWebElements;
import libs.ConfigData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage{


        //String LoginNameInputName =    "_username";
        By LoginNameInputName = By.name("_username");
        String LoginNameInputXpath  = "//*[@name='_username']";
        By PasswordField = By.id("password");
        String inputPasswordid = "password";
        By ButtonSubmitType = By.xpath("//button[@type='submit']");

        @FindBy(xpath = "//input[@name='_username']")
        WebElement InputLoginElement;

        @FindBy(id = "password")
        WebElement InputPasswordId;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement SubmitButtonXpath;

        // @FindBy(tagName = "button")
        //  WebElement buttonLogIn;

   /* @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonLogIn;*/

        public LoginPage(WebDriver driver)
        {
            super(driver);
        }


        public void OpenPageLogin() {
            try
            {
                driver.get(ConfigData.getCfgValue("base_url")+ "/login");
                log.info("Page login was opened");
            } catch (Exception e) {
                log.error("Can not open URL");
                Assert.fail("Can not open URL");

            }
        }

        public void OpenLoginPage(String link)
        {
            try
            {
                driver.get(link);
                log.info("Page is opened");
            }
            catch (Exception ex)
            {
                log.error("Page doesn't open " + ex);
            }
        }

        public void InputLoginName(String login)
        {
            actionsWithWebElements.InputToTextField(InputLoginElement, login);
        }


        public void InputPassword(String pass)
        {
            actionsWithWebElements.InputToTextField(InputPasswordId, pass);
        }

        public void ClickSubmitButton() {

            actionsWithWebElements.ClickToElements(SubmitButtonXpath);
        }

        // public boolean isButtonLoginPresent() {
        // return actionsWithWebElements.isElementPresent(buttonLogIn);
        //  }

        public void loginUser(String login, String pass)
        {
            OpenPageLogin();
            InputLoginName(login);
            InputPassword(pass);
            ClickSubmitButton();

        }

        // public boolean isInputLoginFieldPresent() {
        //return actionsWithWebElements.isElementPresent(inputLogin);
        // }



}
