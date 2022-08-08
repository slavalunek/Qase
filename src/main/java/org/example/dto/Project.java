package org.example.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Project {

    private String projectName;
    private String projectCode;
    private String description;
}
