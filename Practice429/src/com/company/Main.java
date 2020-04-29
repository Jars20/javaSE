package com.company;

class Main {
    public static void main(String[] args) {
        PrimaryStudents s1 = new PrimaryStudents("张三");
        MiddleSchoolStudents s2 = new MiddleSchoolStudents("李四");
        HighSchoolStudents s3 = new HighSchoolStudents("王二");
        s1.study();
        s2.study();
        s3.study();
    }
}
