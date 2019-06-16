package proxy.cgLib;

public class Man {
    public String name;
    public String gender;

    public void marry() {
        System.out.println("my name is " + name + " + I am a " + gender);
    }

    public Man(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Man() {
    }
}
