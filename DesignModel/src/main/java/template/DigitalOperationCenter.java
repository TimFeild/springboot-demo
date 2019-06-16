package template;

public abstract class DigitalOperationCenter {
    protected void openHole(){
        buy();
        electronic();
        open();
        work();
    }

    protected final void buy(){
        System.out.println("东风机床厂");
    }
    protected final void  electronic() {
        System.out.println("220V");
    }
    protected abstract void open();

    protected abstract void work();


}
