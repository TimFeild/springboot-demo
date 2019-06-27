package protoType.simple;


import java.util.ArrayList;
import java.util.List;

public class ConcreteProtoType extends ProtoType {

    private String name;

    private List<String> list = new ArrayList<String>();

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setList(List<String> list){
        this.list = list;
    }
    public List<String> getList(){
        return this.list;
    }
}
