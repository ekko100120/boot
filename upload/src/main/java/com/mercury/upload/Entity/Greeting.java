package com.mercury.upload.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Greeting {


    public Greeting() {
    }

    public Greeting(long id, String context) {
        this.id = id;
        this.context = context;
    }

     private long id;


     private String context;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", context='" + context + '\'' +
                '}';
    }
}
