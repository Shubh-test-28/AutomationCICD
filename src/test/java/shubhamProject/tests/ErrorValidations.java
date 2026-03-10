package shubhamProject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import shubhamProject.TestComponents.BaseTest;
import shubhamProject.tests.pageobjects.CartPage;
import shubhamProject.tests.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

@Test
public class ErrorValidations extends BaseTest {
    public void submitOrder() throws InterruptedException, IOException {
        // TODO Auto-generated method stub
        String productName = "ZARA COAT 3";
        landingPage.loginApplication("Shubh28@gmail.com","Iamking@009");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

    }
    @Test(groups = {"ErrorHandling"})
    public void ProductErrorValidation()  throws IOException, InterruptedException
    {
        // updated Comment
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("Shubh28@gmail.com","Iamking@000");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);

    }
}
