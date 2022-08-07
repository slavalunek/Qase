package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.dto.Project;

import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModal {

    public NewProjectModal fillInNewProjectModal(Project project) {

        if (project.getProjectName() != null){
            new NewProjectPage().fillInProjectName(project.getProjectName());
        }

        if (project.getDescription() != null){
            new NewProjectPage().fillInDescription(project.getDescription());
        }
        return this;
    }

    public NewProjectModal clickOnPublicButton(){
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
