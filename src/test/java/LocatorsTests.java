import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsTests {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
//        driver.quit();
    }

    @Test
    public void cssTests() throws InterruptedException {
        //Открыть браузер по URL ссылке
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        WebElement userName =driver.findElement(By.cssSelector("#user-name"));
        WebElement password =driver.findElement(By.id("password"));
        WebElement loginButton =driver.findElement(By.xpath("//*[@id='login-button']"));



        userName.sendKeys("problem_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        WebElement title =driver.findElement(By.cssSelector("title"));
        String titleText =title.getText();

        Assertions.assertEquals("Description",titleText);

        Thread.sleep(5000);
    }
}




