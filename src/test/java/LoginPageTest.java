package test;
import pages.*;
import base.*;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPageTest extends TestBase {

    /******* deklaracja obiektów ********/
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;

    /********* konstruktor ***********/
    public LoginPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }




    /********* TESTY ***********/
    @Test(priority = 0)
    public void verifyPageTitle(){
        Assert.assertTrue(loginPage.getPageTitle().equals(testdata.getProperty("correctAccountPageTitle")));
    }


}
