package protoType.simple;


public class ProtoType implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println(this.getClass().getName());
        return super.clone();
    }
}
