package delegate;

public class Boss implements Excutor {
    private Excutor excutor;

    public Boss(Excutor excutor) {
        this.excutor = excutor;
    }

    public void doThing() {
        excutor.doThing();
    }
}
