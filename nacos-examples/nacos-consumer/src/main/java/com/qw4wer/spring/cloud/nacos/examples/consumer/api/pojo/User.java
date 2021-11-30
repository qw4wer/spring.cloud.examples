package com.qw4wer.spring.cloud.nacos.examples.consumer.api.pojo;

public class User {

    private String name;

    private String hr;

    private String avg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", hr=" + hr + ", avg=" + avg + '}';
    }

}