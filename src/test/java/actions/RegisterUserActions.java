package actions;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterUserPage;

import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterUserActions {

    //Isntanciating utilities
    static WebDriver driver;
    static RegisterUserPage registerUserPage;
    private static final Faker faker = new Faker();

    @BeforeClass
    public static void setUpBeforeClass() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        //Isntanciating pages
        registerUserPage = new RegisterUserPage(driver);

    }

    public void chooseWhichButtonToClick(String button) throws Exception {
        switch (button){
            case "SignIn":
                registerUserPage.btnSingIn.click();
                break;
            case "CreatAccount":
                registerUserPage.btnCreatAccount.click();
                break;
            case "SignOut":
                registerUserPage.btnSignOut.click();
                break;
            case "Register":
                registerUserPage.btnRegister.click();
                break;
            case "Login":
                registerUserPage.btnSingInLogin.click();
                break;
            case "Mr.":
                registerUserPage.rBoxMr.click();
                break;
            case "Newsletter":
                registerUserPage.checkNewsletter.click();
                break;
            case "SpecialOffers":
                registerUserPage.checkSpecialOffers.click();
                break;
            default:throw new Exception("Button does not exist");
        }
    }

    public void fillInEmailAddress(String email){
        registerUserPage.waitForElementToBeIsVisible(registerUserPage.titleAuthentication);
        registerUserPage.cmpEmail.sendKeys(email);
    }

    public boolean getPageCreatAccount(){
        return registerUserPage.titleCreatAccount.isDisplayed();
    }

    public void fillInPersonalInformation(String firstName, String lastName, String password) throws Exception{
        registerUserPage.cmpFirstName.sendKeys(firstName);
        registerUserPage.cmpLastName.sendKeys(lastName);
        registerUserPage.cmpPassword.sendKeys(password);
        registerUserPage.cmpDays.sendKeys("5");
        registerUserPage.cmpMonth.sendKeys("October");
        registerUserPage.cmpYears.sendKeys("1999");
    }

    public void fillYourAddress() throws Exception {
        registerUserPage.cmpCompany.sendKeys(faker.company().name());
        registerUserPage.cmpAddress1.sendKeys(faker.address().fullAddress());
        registerUserPage.cmpCity.sendKeys(faker.address().city());
        registerUserPage.cmpState.sendKeys("California");
        registerUserPage.cmpPostalCode.sendKeys("12345");
        registerUserPage.cmpCountry.sendKeys("United States");
        registerUserPage.cmpPhone.sendKeys(faker.phoneNumber().cellPhone());
    }

    public boolean getRegisteredUser(String firstName, String lastName) throws IOException {
        return driver.findElement(new By.ByXPath(
                "//span[text()='" + firstName + " " + lastName + "']")).isDisplayed();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        driver.quit();
    }
}
