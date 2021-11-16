package steps;

import actions.RegisterUserActions;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runners.MethodSorters;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterUserStep extends RegisterUserActions {

    //Isntanciating utilities
    private static final Faker faker = new Faker();

    private static final String  firstName = faker.name().firstName();
    private static final String lastName = faker.name().lastName();
    private static final String email = faker.internet().emailAddress();
    private static final String password = "123a123s";

    @Test
    @Order(1)
    public void aIAccessTheAccountCreationScreen() throws Exception {
        chooseWhichButtonToClick("SignIn");
        fillInEmailAddress(email);
        chooseWhichButtonToClick("CreatAccount");
        Assert.assertTrue("Account creation page not displayed", getPageCreatAccount());
    }

    @Test
    @Order(2)
    public void bIFillInTheNecessaryInformationToRegister() throws Exception {
        chooseWhichButtonToClick("Mr.");
        fillInPersonalInformation(firstName, lastName, password);
        chooseWhichButtonToClick("Newsletter");
        chooseWhichButtonToClick("SpecialOffers");
        fillYourAddress();
    }

    @Test
    @Order(3)
    public void cIClickRegister() throws Exception {
        chooseWhichButtonToClick("Register");
    }

    @Test
    @Order(4)
    public void dRegistrationIsPerformedSuccessfully() throws IOException {
        Assert.assertTrue("Unregistered user", getRegisteredUser(firstName, lastName));
    }

}
