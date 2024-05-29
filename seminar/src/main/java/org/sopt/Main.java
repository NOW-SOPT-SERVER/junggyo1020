package org.sopt;

public class Main {
    public static void main(String[] args) {
        //Person 클래스의 객체 생성
        Person person = new Person("정정교", 27, "male");

        //Getter를 메인메서드에서 사용하기
        System.out.println(person.getName());

        //Setter를 메인메서드에서 사용하기
        System.out.println("Setter 적용 전: " + person.getName());
        person.setName("변경된 정정교");
        System.out.println("Setter 적용 후: " + person.getName());

        //Person 클래스의 내부 메소드 호출
        person.walk();

        //Person 객체 호출 없이 static 메서드 호출
        Person.run();

        //빌더패턴으로 객체 생성
        Person personWithBuilder = new PersonBuilder()
                .name("정정교")
                .age(27)
                .sex("male")
                .build();

        //정적팩토리메서드로 객체 생성
        Person personWithFactoryMethod = Person.create("정현교", 25, "male");
    }
}