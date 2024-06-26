package org.sopt;

import org.sopt.classes.Person;
import org.sopt.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        // Person 클래스의 객체 생성
        Person person = new Person("정정교", 20, "MALE");
        // Person 클래스 내부 메소드 호출
        person.walk();

        // 출력 결과 수정
        System.out.println("이름: " + person.getName()); // 기대 결과: 정정교

        person.setName("정교");

        System.out.println("정정교 -> 정교로 변경 후... \n" + "이름: " + person.getName()); // 기대 결과: 정교

        Person personWithBuilder = new PersonBuilder()
                .name("정정교")
                .age(27)
                .sex("male")
                .build();
        Person personWithFactoryMethod = Person.create("정정교", 27, "MALE");

        System.out.println(personWithFactoryMethod.getInfo());
    }
}
