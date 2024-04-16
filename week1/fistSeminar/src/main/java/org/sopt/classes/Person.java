package org.sopt.classes;

public class Person {
    private String name;
    private int age;
    private String sex;

    // 생성자
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, int age) {
        this(name, age, "unknown");
    }

    public String getInfo() {
        return "이름: " + name + ", 나이: " + age + ", 성별: " + sex;
    }
    // 이름을 반환하는 메소드
    public String getName() {
        return name;
    }

    // 이름을 설정하는 메소드
    public void setName(String name) {
        this.name = name;
    }

    // 걷는 행동을 출력하는 메소드
    public void walk() {
        System.out.println(name + "이(가) 걷고 있습니다.");
    }

    public static Person create(String name, int age, String sex) {
        return new Person(name, age, sex);
    }
}
