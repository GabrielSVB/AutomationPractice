package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver webdriver;

    @Autowired
    private int maxTimeWaitLoadPage = 35;

    private WebDriverWait wait;

    LocalDateTime todayDate = LocalDateTime.now();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter fmtHr = DateTimeFormatter.ofPattern("hh-mm-ss");

    public PageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webdriver = driver;
        this.webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.webdriver.manage().window().maximize();

    }

    public void waitForElementToBeIsVisible(WebElement element) {
        wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
