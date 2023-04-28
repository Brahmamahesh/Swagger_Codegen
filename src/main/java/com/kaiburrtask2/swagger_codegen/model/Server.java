package com.kaiburrtask2.swagger_codegen.model;

import org.springframework.data.mongodb.core.mapping.Document;

//Define the Server Model.
//Create a new Java class named 'Server' with the following attributes.
@Document(collection = "Testtask1")
public class Server
{
    private String id;
    private String name;
    private String language;
    private String framework;

    public String getId() {
        return id;
    }

    public Server() {
    }

    public Server(String id, String name, String language, String framework) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.framework = framework;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
