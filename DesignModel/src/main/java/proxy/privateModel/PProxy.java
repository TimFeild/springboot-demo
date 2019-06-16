package proxy.privateModel;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//生成代理对象的代码
public class PProxy {

    public static Object newProxyInstance(PClassLoader loader, Class<?>[] interfaces, PInvocationHandler handler) {
        //2.将原代码输出到磁盘.java
        try {
            //1.生成源代码
            String proxySrc = generateSrc(interfaces[0]);
            String filePath = "D:\\workspace\\DesignModel\\src\\main\\java\\proxy\\privateModel\\";
            filePath = PProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();
            //3.将.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null,iterable);
            task.call();
            manager.close();
            //4.将class文件中的内容加载到jvm中
            Class proxyClass = loader.findClass("$Proxy0");
            //5.返回代理后的对象
            Constructor constructor = proxyClass.getConstructor(PInvocationHandler.class);
            return constructor.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成源代码
    private static String generateSrc(Class<?> interfaces) {
        //1.生成源代码
        StringBuffer src = new StringBuffer();
        String ln = "\r\n";
        src.append("package proxy.privateModel;" + ln)
                .append("import java.lang.reflect.Method;" + ln)
                .append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln)
                .append("PInvocationHandler h;" + ln)
                .append("public $Proxy0(PInvocationHandler h){" + ln)
                .append("this.h = h;")
                .append("}" + ln);
        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){");
            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);");
            src.append("} catch(Exception e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }
        src.append("}");
        return src.toString();
    }

}
