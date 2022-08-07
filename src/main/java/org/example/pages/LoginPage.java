package org.example.pages;

import com.codeborne.selenide.Selenide;
import org.example.utils.PropertiesLoader;

import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class LoginPage {

    public LoginPage open(){
        Selenide.open("/login");
        getWebDriver().manage().window().maximize();
        return this;
    }

    public ProjectsPage login(String name, String password){
        $(id("inputEmail")).shouldBe(visible).sendKeys(name);
        $(id("inputPassword")).sendKeys(password);
        $(id("btnLogin")).click();
        return new ProjectsPage();
    }

    public ProjectsPage loginStandardUser(){
        Properties properties = PropertiesLoader.loadProperties();
        new LoginPage().open()
                       .login(properties.getProperty("username"), properties.getProperty("password"));
        assertThat($(id("createButton")).getText()).isEqualTo("Create new project");
        return new ProjectsPage();
    }
}
