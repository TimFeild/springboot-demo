package proxy;

public class Tianye implements Person{
    private String name;
    private String sex;

    public Tianye(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
    public void findLove() {
        System.out.println("胸大");
        System.out.println("美女");
    }
}
