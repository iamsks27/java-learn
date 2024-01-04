package com.shivam.learn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private Long questionId;
    private String helpText;
    private List<Option> options;
    private String inputType;
    private String questionText;

    @JsonProperty("parentid")
    private String parentId;

    @Data
    public static class Option {

        private Long questionId;
        private String answerCode;
        private String answerText;
        private boolean showChildren;
    }
}