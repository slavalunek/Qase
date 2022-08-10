package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.example.pages.LoginPage;
import org.example.steps.ProjectSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteProjectTest {

    String projectName;

    @BeforeMethod
    public void loginAndCreateProject() {
        new LoginPage().loginStandardUser();
        Faker faker = new Faker();
        projectName = faker.code().asin();
        new ProjectSteps().CreateProject(projectName);
    }

    @Test
    public void deleteValidProject() {
        Selenide.open("/projects");
        new ProjectSteps().dropdownButtonClick(projectName)
                          .deleteButtonClick(projectName)
                          .confirmationOfDeletion();

        String nameProject = String.format(("//a[text()='%s']"), projectName);
        assertThat($x(nameProject).isDisplayed()).isEqualTo(false);
    }

    @AfterMethod
    public void signOut() {
        new ProjectSteps().signOut();
    }
}
