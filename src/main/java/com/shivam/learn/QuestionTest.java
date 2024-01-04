package com.shivam.learn;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class QuestionTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String DATA = "{\"questionId\":1001000,\"helpText\":\"\",\"options\":[{\"questionId\":1001000,\"answerCode\":\"0\",\"answerText\":\"0\",\"showChildren\":false},{\"questionId\":1001000,\"answerCode\":\"1\",\"answerText\":\"1\",\"showChildren\":false},{\"questionId\":1001000,\"answerCode\":\"2\",\"answerText\":\"2+\",\"showChildren\":false},{\"questionId\":1001000,\"answerCode\":\"N\",\"answerText\":\"NA\",\"showChildren\":false}],\"inputType\":\"1\",\"questionText\":\"Does your vehicle use key fobs? If so, how many do you have?\",\"parentid\":0}";


    public static void main(String[] args) throws IOException {
        final Question question = MAPPER.readValue(DATA, Question.class);

        System.out.println(question);
    }
}
