package org.example.dto;

import java.util.Objects;

public class Project {

    private String projectName;
    private String projectCode;
    private String Description;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName) && Objects.equals(projectCode, project.projectCode) && Objects.equals(Description, project.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, projectCode, Description);
    }
}
