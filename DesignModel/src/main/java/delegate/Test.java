package delegate;

public class Test {
    public static void main(String[] args) {
        Excutor excutor = new ExcutorA();
        Excutor boss = new Boss(excutor);
        boss.doThing();
    }
}
