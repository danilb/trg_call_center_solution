package com.trg.task.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CallerIssueRequest {

    @JsonProperty("registeredTime")
    long registeredTime;

    @JsonProperty("issue")
    String issue;

    @JsonGetter
    public long getRegisteredTime() {
        return registeredTime;
    }

    @JsonSetter
    public CallerIssueRequest setRegisteredTime(long registeredTime) {
        this.registeredTime = registeredTime;
        return this;
    }

    @JsonGetter
    public String getIssue() {
        return issue;
    }

    @JsonSetter
    public CallerIssueRequest setIssue(String issue) {
        this.issue = issue;
        return this;
    }

    @JsonCreator
    public CallerIssueRequest(@JsonProperty("registeredTime") long registeredTime, @JsonProperty("issue") String issue) {
        this.registeredTime = registeredTime;
        this.issue = issue;
    }
}
