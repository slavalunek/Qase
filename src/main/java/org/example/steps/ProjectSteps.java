package org.example.steps;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.example.dto.Project;
import org.example.pages.LoginPage;
import org.example.pages.NewProjectModal;
import org.example.pages.NewProjectPage;
import org.example.pages.ProjectsPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class ProjectSteps {

    public ProjectSteps dropdownButtonClick(String projectName) {
        String dropdownButton = String.format(("//a[text()='%s']//ancestor::tr//a[@aria-expanded='false']"), projectName);
        $x(dropdownButton).shouldBe(enabled).click();
        return this;
    }

    public ProjectSteps deleteButtonClick(String projectName) {
        String deleteButton = String.format(("//a[@href='/project/%s/delete']"), projectName);
        $x(deleteButton).shouldBe(enabled).click();
        return this;
    }

    public ProjectsPage confirmationOfDeletion() {
        $x("//button[text()=' Delete project']").shouldBe(enabled).click();
        return new ProjectsPage();
    }

    public ProjectSteps deleteProject(String projectName) {
        Selenide.open("/projects");
        dropdownButtonClick(projectName);
        deleteButtonClick(projectName);
        confirmationOfDeletion();
        String nameProject = String.format(("//a[text()='%s']"), projectName);
        assertThat($x(nameProject).isDisplayed()).isEqualTo(false);
        return this;
    }

    public ProjectSteps accountButtonClick() {
        $x("//img[@class='X8BNLp']").shouldBe(enabled).click();
        return this;
    }

    public ProjectSteps signOutButtonClick() {
        $x("//span[text()='Sign out']").shouldBe(enabled).click();
        $(id("btnLogin")).shouldBe(enabled);
        return this;
    }

    public LoginPage signOut() {
        accountButtonClick();
        signOutButtonClick();
        assertThat($(id("btnLogin")).isDisplayed()).isEqualTo(true);
        return new LoginPage();
    }

    public ProjectSteps CreateProject(String projectName) {
        Faker faker = new Faker();

        Project project = Project.builder()
                                 .projectName(projectName)
                                 .projectCode(projectName)
                                 .description(faker.company().catchPhrase())
                                 .build();

        new NewProjectPage().open();
        new NewProjectModal().fillInNewProjectModal(project)
                             .clickOnCreateProjectButton();
        return this;
    }
}