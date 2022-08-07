package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class NewProjectPage {

    public NewProjectPage open(){
        Selenide.open("/project/create");
        getWebDriver().manage().window().maximize();
        assertThat($x("//h1[text()='New Project']").getText()).isEqualTo("New Project");
        return this;
    }

    public NewProjectPage fillInProjectName(String projectName){
        $x("//input[@id='inputTitle']").sendKeys(projectName);
        return this;
    }

    public NewProjectPage fillInDescription(String description){
        $x("//textarea[@id='inputDescription']").sendKeys(description);
        return this;
    }

    public NewProjectPage clickOnPublicButton(){
        $x("//input[@id='public-access-type']").click();
        $x("//div[contains(@class,'hide')]").shouldBe();
        return this;
    }

    public RepositoryPage clickOnCreateProjectButton(){
        $x("//button[text()='Create project']").click();
        $x("//span[text()='Create new suite']").shouldBe(Condition.visible);
        return new RepositoryPage();
    }
}
