package org.example.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class NewProjectPage {

    public NewProjectPage open() {
        Selenide.open("/project/create");
        getWebDriver().manage().window().maximize();
        assertThat($x("//h1[text()='New Project']").getText()).isEqualTo("New Project");
        return this;
    }

    public NewProjectPage fillInProjectName(String projectName) {
        $x("//input[@id='inputTitle']").shouldBe(enabled).sendKeys(projectName);
        return this;
    }

    public NewProjectPage fillInProjectCode(String projectCode) {
        $x("//input[@id='inputCode']").shouldBe(enabled).sendKeys(projectCode);
        return this;
    }

    public NewProjectPage fillInDescription(String description) {
        $x("//textarea[@id='inputDescription']").shouldBe(enabled).sendKeys(description);
        return this;
    }

    public NewProjectPage clickOnPublicButton() {
        $x("//input[@id='public-access-type']").shouldBe(enabled).click();
        $x("//div[contains(@class,'hide')]").shouldBe();
        return this;
    }

    public RepositoryPage clickOnCreateProjectButton() {
        $x("//button[text()='Create project']").shouldBe(enabled).click();
        $x("//span[text()='Create new suite']").shouldBe(visible);
        return new RepositoryPage();
    }
}
