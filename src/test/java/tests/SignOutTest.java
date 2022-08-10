package tests;

import com.github.javafaker.Faker;
import org.example.pages.LoginPage;
import org.example.steps.ProjectSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class SignOutTest {

    String projectName;

    @BeforeMethod
    public void loginAndCreateProject() {
        new LoginPage().loginStandardUser();
        Faker faker = new Faker();
        projectName = faker.code().asin();
        new ProjectSteps().CreateProject(projectName)
                          .deleteProject(projectName);
    }

    @Test
    public void signOut() {
        new ProjectSteps().accountButtonClick()
                          .signOutButtonClick();
        assertThat($(id("btnLogin")).isDisplayed()).isEqualTo(true);
    }
}