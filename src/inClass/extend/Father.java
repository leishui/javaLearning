package inClass.extend;

import java.lang.reflect.InvocationTargetException;

class Father {
    void fun1(){
        Class c;
        try {
            c =  Class.forName("inClass.extend.Son");
            //Son son = c.newInstance();
            Son son = (Son) c.getConstructor().newInstance();
            son.fun2();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
