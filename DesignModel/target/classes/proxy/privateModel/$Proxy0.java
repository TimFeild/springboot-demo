package proxy.privateModel;
import java.lang.reflect.Method;
public class $Proxy0 implements proxy.Person{
PInvocationHandler h;
public $Proxy0(PInvocationHandler h){
this.h = h;}
public void findLove(){try{
Method m = proxy.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);} catch(Exception e){e.printStackTrace();}
}
}