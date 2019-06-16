package proxy.privateModel;

import java.lang.reflect.Method;

public interface PInvocationHandler {
    Object invoke(Object object, Method method, Object[] args);
}
