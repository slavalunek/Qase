package tests;

import org.example.pages.LoginPage;
import org.example.utils.PropertiesLoader;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class LoginTest extends BaseTest {

    @Test
    public void loginValidUser() {
        Properties properties = PropertiesLoader.loadProperties();
        new LoginPage().open()
                       .login(properties.getProperty("username"), properties.getProperty("password"));
        assertThat($(id("createButton")).getText()).isEqualTo("Create new project");
    }
}