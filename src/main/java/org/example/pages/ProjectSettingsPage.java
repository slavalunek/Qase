package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.example.dto.Project;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.*;

public class ProjectSettingsPage {

    public ProjectSettingsPage open(String projectName) {
        String way = String.format(("/project/%s/settings/general"), projectName);
        Selenide.open(way);
        $x("//span[text()='Settings']").shouldBe(Condition.enabled);
        return this;
    }

    public Project getProjectSettings() {
        Project project = Project.builder()
                                 .projectName(getProjectName())
                                 .projectCode(getProjectCode())
                                 .description(getProjectDescription())
                                 .build();
        return project;
    }

    public String getProjectName() {
        return $(id("inputTitle")).shouldBe(Condition.enabled).getAttribute("value");
    }

    public String getProjectCode() {
        return $(id("inputCode")).shouldBe(Condition.enabled).getAttribute("value");
    }

    public String getProjectDescription() {
        return $(id("inputDescription")).shouldBe(Condition.enabled).getText();
    }
}
