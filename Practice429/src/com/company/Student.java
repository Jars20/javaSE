package com.company;

import java.security.spec.RSAOtherPrimeInfo;

public class Student {
    private  String name;
    public Student(String name){
        setName(name);
    }

    public final String getName() {
        return name;
    }

    private final void setName(String name) {
        this.name = name;
    }

    public void study(){
        System.out.println(" "+getName()+"在学习！");
    }
}
