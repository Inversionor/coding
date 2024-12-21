package com.perfectcode.aida2.debug_test.testcode;

/**
 * 编译期：
 *
 * 编译器会保留泛型类型信息，用于类型检查和安全验证。
 * 类型错误（如尝试向 List<Integer> 添加 String）会被编译器阻止。
 * 编译成功后，字节码中的泛型信息被擦除。
 * 运行期：
 *
 * 泛型信息被擦除，JVM 仅知道操作的是一个 List，而不知道其具体的泛型类型。
 * 因此，不能在运行期通过 instanceof 检查泛型类型。
 */
import java.lang.reflect.Method;
import java.util.*;

public class test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        try {
            Method method = list.getClass().getDeclaredMethod("add", Object.class);
            method.invoke(list, "string");
            method.invoke(list, true);
            method.invoke(list, 45.6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }
    }