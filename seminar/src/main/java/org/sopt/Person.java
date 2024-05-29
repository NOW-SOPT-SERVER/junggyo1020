package org.sopt;

//Person 클래스 정의
public class Person {
    private String name;
    private int age;
    private String sex;

    //직접 생성자 추가 (여러 개의 생성자를 생성할 수 있다.)
//    public Person(String name, int age){
//        this.name = name;
//        this.age = age;
//    }

    //생성자 오버로딩
    public Person(String name, int age){
        this(name, age, "Unknown");
    }

    public Person(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    //Getter 메서드 : 객체 필드값을 가져오는 메서드
    public String getName(){
        return this.name;
    }

    //Setter 메서드 : 객체 필드값을 변경하는 메서드
    public void setName(String name){
        this.name = name;
    }

    public void walk(){
        System.out.println("사람이 걷습니다.");
    }

    //static 메서드 : 객체 생성 없이 사용가능한 메서드
    public static void run(){
        System.out.println("사람이 뜁니다.");
    }

    //정적 팩토리 메서드 패턴으로 객체 생성
    public static Person create(String name, int age, String sex){
        return new Person(name, age, sex);
    }

    public String getInfo(){
        return this.getName();
    }
}
