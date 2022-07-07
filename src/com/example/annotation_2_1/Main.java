package com.example.annotation_2_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Temple{
    @Test(a=2,b=5)
    public int test(int a, int b){
        return a+b;
    }
}

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Temple temple=new Temple();
        Class<?> cls=temple.getClass();

        Method[] methods=cls.getDeclaredMethods();

        for (Method md: methods){
            if(md.isAnnotationPresent(Test.class)){
                Test test=md.getAnnotation(Test.class);
                int result= (int) md.invoke(temple,test.a(),test.b());
                System.out.println(result);
            }
        }
    }
}
