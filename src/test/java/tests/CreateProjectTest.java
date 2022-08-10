package tests;

import com.github.javafaker.Faker;
import org.example.dto.Project;
import org.example.pages.LoginPage;
import org.example.pages.NewProjectModal;
import org.example.pages.NewProjectPage;
import org.example.pages.ProjectSettingsPage;
import org.example.steps.ProjectSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateProjectTest {

    String projectName;

    @BeforeMethod
    public void login() {
        new LoginPage().loginStandardUser();
    }

    @Test
    public void createValidProject() {

        Faker faker = new Faker();
        projectName = faker.code().asin();

        Project project = Project.builder()
                                 .projectName(projectName)
                                 .projectCode(projectName)
                                 .description(faker.company().catchPhrase())
                                 .build();

        new NewProjectPage().open();
        new NewProjectModal().fillInNewProjectModal(project)
                             .clickOnPublicButton()
                             .clickOnCreateProjectButton();
        assertThat($x("//span[text()='Create new suite']").isDisplayed()).isEqualTo(true);

        Project actualProject = new ProjectSettingsPage().open(projectName).getProjectSettings();
        Assert.assertEquals(actualProject, project);
    }

    @AfterMethod
    public void deleteProjectAndSignOut() {
        new ProjectSteps().deleteProject(projectName)
                          .signOut();
    }
}