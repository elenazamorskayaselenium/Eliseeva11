package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidTest {


    public class ValidLogin extends ParentTest {


        public ValidLogin(String browser) {
            super(browser);
        }

        @Test
        public void validLogin() {
            loginPage.OpenPageLogin();
            loginPage.InputLoginName("Student");
            loginPage.InputPassword("909090");
            loginPage.ClickSubmitButton();
           // checkAcceptanceCriteria
                //    ("Avatar is not present", homePage.isAvatarPresent(), true);
           // checkAcceptanceCriteria
               //     ("Title is not expected", homePage.getTitle(),"Учет запчастей");
        }

}
