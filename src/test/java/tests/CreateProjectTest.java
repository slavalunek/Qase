package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.example.dto.Project;
import org.example.pages.LoginPage;
import org.example.pages.NewProjectModal;
import org.example.pages.NewProjectPage;
import org.example.steps.ProjectSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

public class CreateProjectTest {

    Faker faker = new Faker();
    String accountName = faker.company().name();

    @Test
    public void createValidProject() {
        new LoginPage().loginStandardUser();

//        Faker faker = new Faker();
//        Project project = new Project();
//        project.setProjectName(faker.company().name());
//        project.setDescription(faker.company().catchPhrase());
//
//        new NewProjectPage().open();
//        new NewProjectModal().fillInNewProjectModal(project)
//                             .clickOnPublicButton()
//                             .clickOnCreateProjectButton();
//        assertThat($x("//span[text()='Create new suite']").isDisplayed()).isEqualTo(true);
        Faker faker = new Faker();
        new NewProjectPage().open()
                            .fillInProjectName(accountName)
                            .fillInDescription(faker.company().catchPhrase())
                            .clickOnPublicButton()
                            .clickOnCreateProjectButton();
        assertThat($x("//span[text()='Create new suite']").isDisplayed()).isEqualTo(true);
    }

//    @AfterMethod
//    public void geleteProject(){
//      new ProjectSteps().deleteProject(accountName);
//
//    }
}
