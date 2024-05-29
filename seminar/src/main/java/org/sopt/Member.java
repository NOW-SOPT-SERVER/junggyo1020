package org.sopt;

public class Member extends Person{ //Person 클래스를 상속

    private Part part;

    public Member(String name, int age, String sex, Part part){
        super(name, age, sex);
        this.part = part;
    }

    @Override
    public String getInfo(){
        return super.getInfo() + "파트: " + this.part.getPart();
    }
}
