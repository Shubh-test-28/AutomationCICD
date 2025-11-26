package rahulshettyacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import rahulshettyacademy.pageobjects.*;

import java.time.Duration;
import java.util.List;

public class SubmitOrder {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        ProductCatalogue productCatalogue = landingPage.loginApplication("Shubh28@gmail.com","Iamking@000");
        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationpage = checkoutPage.submitOrder();

        String confirmMessage = confirmationpage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();


    }
}
