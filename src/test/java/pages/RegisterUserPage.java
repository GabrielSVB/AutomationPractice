package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserPage extends PageObject {

    public RegisterUserPage(WebDriver driver) {
        super(driver);
    }

    static WebDriver driver;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    public WebElement logoMyStore;

    @FindBy(xpath = "//a[@class='login']")
    public WebElement btnSingIn;

    @FindBy(xpath = "//h1[text()='Authentication']")
    public WebElement titleAuthentication;

    @FindBy(id = "email_create")
    public WebElement cmpEmail;

    @FindBy(id = "SubmitCreate")
    public WebElement btnCreatAccount;

    @FindBy(xpath = "//h3[text()='Your personal information']")
    public WebElement titleCreatAccount;

    @FindBy(id = "id_gender1")
    public WebElement rBoxMr;

    @FindBy(id = "customer_firstname")
    public WebElement cmpFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement cmpLastName;

    @FindBy(id = "passwd")
    public WebElement cmpPassword;

    @FindBy(id = "days")
    public WebElement cmpDays;

    @FindBy(id = "months")
    public WebElement cmpMonth;

    @FindBy(id = "years")
    public WebElement cmpYears;

    @FindBy(id = "newsletter")
    public WebElement checkNewsletter;

    @FindBy(id = "uniform-optin")
    public WebElement checkSpecialOffers;

    @FindBy(id = "company")
    public WebElement cmpCompany;

    @FindBy(id = "address1")
    public WebElement cmpAddress1;

    @FindBy(id = "city")
    public WebElement cmpCity;

    @FindBy(id = "id_state")
    public WebElement cmpState;

    @FindBy(id = "postcode")
    public WebElement cmpPostalCode;

    @FindBy(id = "id_country")
    public WebElement cmpCountry;

    @FindBy(id = "phone_mobile")
    public WebElement cmpPhone;

    @FindBy(id = "submitAccount")
    public WebElement btnRegister;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement btnSignOut;

    @FindBy(id = "email")
    public WebElement cmpEmailLogin;

    @FindBy(id = "passwd")
    public WebElement cmpPasswordLogin;

    @FindBy(id = "SubmitLogin")
    public WebElement btnSingInLogin;

}
