package org.example.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectSteps {

    public void deleteProject(String projectName) {
        Selenide.open("/projects");
        String locator = String.format(("//a[text()='%s']//ancestor::tr//a[@aria-expanded='false']"), projectName);
        $x(locator).shouldBe(enabled).click();
    }
}
