package com.shxdee.eigthtask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionDemo {
    public static int getCountObject(List<Object> list) {
        int count = 0;
        for (Object item: list) {
            if (item instanceof Human) {
                count++;
            }
        }
        return count;
    }

    public static List<String> getNamesMethods(Object obj) {
        List<String> result = new ArrayList<>();
        for (Method item: obj.getClass().getMethods()) {
            result.add(item.getName());
        }
        return result;
    }

    public static List<String> getSuperClassesNames(Object obj) {
        List<String> result = new ArrayList<>();
        Class<?> cur = obj.getClass();
        cur = cur.getSuperclass();
        while (cur != null) {
            result.add(cur.getName());
            cur = cur.getSuperclass();
        }
        return result;
    }

    public static int getCountExecutableClasses(List<Object> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int count = 0;
        for (Object item: list) {
            if (item instanceof Executable) {
                count++;
                item.getClass().getMethod("execute").invoke(item);
            }
        }
        return count;
    }

    public static List<String> getGettersAndSetters(Object obj) {
        List<String> result = new ArrayList<>();
        for (Method method: obj.getClass().getMethods()) {
            if (!Modifier.isStatic(method.getModifiers()) && (
                    method.getName().indexOf("get") == 0 &&
                    method.getParameterCount() == 0 &&
                    !method.getReturnType().getName().equals("void")
                    ||
                    method.getName().indexOf("set") == 0 &&
                    method.getParameterCount() == 1 &&
                    method.getReturnType().getName().equals("void")
                    )
            ) {
                result.add(method.getName());
            }
        }
        return result;
    }
}
