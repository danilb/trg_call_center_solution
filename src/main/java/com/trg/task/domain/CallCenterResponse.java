package com.trg.task.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class CallCenterResponse {

    @JsonProperty("responseTime")
    long responseTime;
    @JsonProperty("problem")
    int problem;
    @JsonProperty("solutions")
    List<String> solutions;

    @JsonGetter
    public long getResponseTime() {
        return responseTime;
    }

    @JsonSetter
    public CallCenterResponse setResponseTime(long responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    @JsonGetter
    public int getProblem() {
        return problem;
    }

    @JsonSetter
    public CallCenterResponse setProblem(int problem) {
        this.problem = problem;
        return this;
    }

    @JsonGetter
    public List<String> getSolutions() {
        return solutions;
    }

    @JsonSetter
    public CallCenterResponse setSolutions(List<String> solutions) {
        this.solutions = solutions;
        return this;
    }

    @JsonCreator
    public CallCenterResponse(@JsonProperty("responseTime") long responseTime,
                              @JsonProperty("problem") int problem,
                              @JsonProperty("solutions") List<String> solutions) {

        this.responseTime = responseTime;
        this.problem = problem;
        this.solutions = solutions;
    }
}
