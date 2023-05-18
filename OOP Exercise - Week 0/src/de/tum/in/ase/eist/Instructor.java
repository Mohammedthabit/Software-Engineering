package de.tum.in.ase.eist;

public class Instructor extends Person {
    public Instructor(String name, int age, String tumid){
        super(name, age, tumid);
    }

    public void teach(String text){
        String teacherSay = String.format("Please learn \"%s\"", text);
        super.say(teacherSay);
    }

}
