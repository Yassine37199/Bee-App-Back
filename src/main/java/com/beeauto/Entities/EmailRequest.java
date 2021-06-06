package com.beeauto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailRequest {

    private String to;
    private String from;
    private String content;
    private String subject;
    private String fromPassword;

    public EmailRequest(@JsonProperty("to") String to,
                        @JsonProperty("from") String from,
                        @JsonProperty("content") String content,
                        @JsonProperty("subject") String subject,
                        @JsonProperty("fromPassword") String fromPassword) {
        this.to = to;
        this.from = from;
        this.content = content;
        this.subject = subject;
        this.fromPassword = fromPassword;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }
}
