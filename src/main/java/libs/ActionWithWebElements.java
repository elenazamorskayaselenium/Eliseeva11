package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ActionWithWebElements {

        WebDriver driver;
        Logger log;
        //WebDriverWait webDriverWait20;

        public ActionWithWebElements(WebDriver driver) {
            this.driver = driver;
            log = Logger.getLogger(getClass());
            //webDriverWait20 = new WebDriverWait(driver,20);
        }

        /**
         * This method Input text value to the text field
         *
         * @param element
         * @param value
         */
        public void InputToTextField(WebElement element, String value) {
            try {
                element.clear();
                element.sendKeys(value);
                log.info(value + "  is inputed to " + element);
            } catch (Exception ex) {
                log.error("Login doesn't input " + ex);
            }
        }

        /**
         * This method click to the web element
         *
         * @param element
         */
        public void ClickToElements(WebElement element) {

            try {
                //webDriverWait20.until(ExpectedConditions.visibilityOf(element));
                element.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * This method check is element present and enabled
         *
         * @param element
         * @return
         */
        public boolean isElementPresent(WebElement element) {
            return (element.isDisplayed() && element.isEnabled());

        }

        /**
         * This method select visible text from drop down
         *
         * @param elementDD
         * @param textForSelect
         */
        public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect) {
            try {
                Select optionsFromDD = new Select(elementDD);
                optionsFromDD.selectByVisibleText(textForSelect);
                log.info(textForSelect + " was selected in DD");

            } catch (Exception e) {
                log.error("Cannot work with element");
                Assert.fail("Cannot work with element");
            }

        }

        /**
         * @param elementDD
         * @param valueInDD
         */
        public void selectItemInDropDownByValue(WebElement elementDD, String valueInDD) {
            try {
                Select optionsFromDD = new Select(elementDD);
                optionsFromDD.selectByValue(valueInDD);
                log.info(valueInDD + " was select in DD");

            } catch (Exception e) {
                log.error("Cannot work with element");
                Assert.fail("Cannot work with element");
            }

        }

        public void selectCheckBox(WebElement element, boolean neededState) {
            try {
                if ((element.isSelected() && (!neededState)) || (!element.isSelected() && neededState)) {
                    element.click();
                }
            } catch (Exception e) {
                log.info("Exception " + e);
            }
        }

        public boolean isElementPresent(String locator) {
            try{
                WebElement webElement = driver.findElement(By.xpath(locator));
                return webElement.isDisplayed() && webElement.isEnabled();
            }catch (Exception e){
                return false;
            }
        }

   /* public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();

        } catch (Exception e) {
            return false;

        }
    }

    public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect) {
        try {
            Select optionsFromDD = new Select(elementDD);
            optionsFromDD.selectByVisibleText(textForSelect);
            logger.info(textForSelect + " was selected in DD");

        } catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    public void selectItemInDropDownByValue(WebElement elementDD, String valueInDD) {
        try {
            Select optionsFromDD = new Select(elementDD);
            optionsFromDD.selectByValue(valueInDD);
            logger.info(valueInDD + " was select in DD");

        } catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    //needed state = checked or unchecked
    public void setStateToCheckbox(WebElement element, String neededState) {
        boolean isChecked;
        isChecked = (element.isSelected());

        if (neededState.equals("checked")) {
            if (!isChecked)
                clickOnWebElement(element);

        } else if (neededState.equals("unchecked")) {
            if (isChecked)
                clickOnWebElement(element);
        }
    }

    /**
     *
     * @param element
     * @param neededState !! only Checked OR Unchecked
     */
  /*  public void setStateToCheckboxClass(WebElement element, String neededState) {
//        Assert.assertEquals("Not expected status","Checked",neededState);

        if (element.isSelected() && "Checked".equals(neededState)){
            logger.info("Element is checked");
        }else if (element.isSelected() && "Unchecked".equals(neededState)){
            clickOnWebElement(element);
        }else if (!element.isSelected() && "Checked".equals(neededState)){
            clickOnWebElement(element);
        }else if (!element.isSelected() && "Unchecked".equals(neededState)){
            logger.info("Element is unchecked");
        }
    }

    public boolean isElementPresent(String locator) {
        try{
            WebElement webElement = webDriver.findElement(By.xpath(locator));
            return webElement.isDisplayed() && webElement.isEnabled();
        }catch (Exception e){
            return false;
        }
    }

    */


}
