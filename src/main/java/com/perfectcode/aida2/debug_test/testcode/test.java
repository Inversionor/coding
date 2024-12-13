package com.perfectcode.aida2.debug_test.testcode;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};


        List modifiableList = Arrays.asList(numbers);

        modifiableList.set(0, 10); // 将第一个元素从1改为10
        Object[] array = modifiableList.toArray();
        for (Object o : array){
            System.out.println(o);
        }

        System.out.println(modifiableList);
    }
}
