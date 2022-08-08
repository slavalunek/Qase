package org.example.steps;

import com.codeborne.selenide.Selenide;
import org.example.pages.LoginPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class ProjectSteps {

    public void dropdownButtonClick(String projectName) {
        String dropdownButton = String.format(("//a[text()='%s']//ancestor::tr//a[@aria-expanded='false']"), projectName);
        $x(dropdownButton).shouldBe(enabled).click();
    }

    public void deleteButtonClick(String projectName) {
        String deleteButton = String.format(("//a[@href='/project/%s/delete']"), projectName);
        $x(deleteButton).shouldBe(enabled).click();
    }

    public ProjectSteps deleteProject(String projectName) {
        Selenide.open("/projects");
        dropdownButtonClick(projectName);
        deleteButtonClick(projectName);
        $x("//button[text()=' Delete project']").shouldBe(enabled).click();
        String nameProject = String.format(("//a[text()='%s']"), projectName);
        assertThat($x(nameProject).isDisplayed()).isEqualTo(false);
        return this;
    }

    public LoginPage signOut() {
        $x("//img[@class='X8BNLp']").shouldBe(enabled).click();
        $x("//span[text()='Sign out']").shouldBe(enabled).click();
        $(id("btnLogin")).shouldBe(enabled);
        assertThat($(id("btnLogin")).isDisplayed()).isEqualTo(true);
        return new LoginPage();
    }
}
