package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

        static WebDriver driver;

        public LandingPage(WebDriver driver)
        {
            super(driver);
            //initialization
            this.driver=driver;
            PageFactory.initElements(driver, this);

        }

        //WebElement userEmails = driver.findElement(By.id("userEmail"));
        //PageFactory

        @FindBy(id="userEmail")
        static WebElement userEmail;

        @FindBy(id="userPassword")
        static WebElement passwordEle;

        @FindBy(id="login")
        static WebElement submit;
        @FindBy(css="[class*='flyInOut']")
        WebElement errorMessage;


        public ProductCatalogue loginApplication(String email, String password)
        {
            userEmail.sendKeys(email);
            passwordEle.sendKeys(password);
            submit.click();
            ProductCatalogue productCatalogue = new ProductCatalogue(driver);
            return productCatalogue;
        }

       /* public String getErrorMessage()
        {
            waitForWebElementToAppear(errorMessage);
            return errorMessage.getText();
        }
**/
        public void goTo()
        {
            driver.get("https://rahulshettyacademy.com/client");
        }


    }


