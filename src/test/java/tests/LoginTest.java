package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;

public class LoginTest {

    @Test
    public void firstTest(){
        open("https://app.qase.io/login");
        $(id("inputEmail")).sendKeys("lunekv@bk.ru");
        $(id("inputPassword")).sendKeys("2435qwer");
        $(id("btnLogin")).click();
    }
}
