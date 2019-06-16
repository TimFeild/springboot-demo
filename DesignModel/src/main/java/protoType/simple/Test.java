package protoType.simple;

public class Test {
    public static void main(String[] args) {
        ConcreteProtoType c = new ConcreteProtoType();
        c.setName("jack");
        System.out.println(c);
        try {
            ConcreteProtoType cp = (ConcreteProtoType)c.clone();
            System.out.println(cp);
            System.out.println(cp.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
