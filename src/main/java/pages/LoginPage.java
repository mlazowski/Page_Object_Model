package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class LoginPage extends TestBase {


    /**** repozytorium elementów *****/
    @FindBy(id = "username")
    public WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement  logInButton;



    /**** konstruktor ****/
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }


    /****  metody  ****/

    // Pobranie i zwrócienie aktualnego tytułu strony
    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("LoginPage tytuł: " + title);
        return title;
    }

    // Wpisanie wartości tekstowej w pole login
    public void setLoginInput(String login){
        wait.until(visibilityOf(loginInput));
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    // Wpisanie wartości tekstowej w pole password
    public void setPasswordInput(String password){
        wait.until(visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Kliknięcie przycisku: Zaloguj się
    public void clickLoginButton(){
        wait.until(elementToBeClickable(logInButton)).click();

    }

    // Metoda wykonująca pełną akcję logowania
    // zwracająca stronę AccountPage
    public AccountPage login(String login, String password){
        setLoginInput(login);
        setPasswordInput(password);
        clickLoginButton();

        return new AccountPage();
    }

}
