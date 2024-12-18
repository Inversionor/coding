package com.perfectcode.aida2.debug_test.testcode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        TreeMap<Student, Integer> map = new TreeMap<>(
            (p1, p2)-> p1.score-p2.score)
        ;
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Student("Bob", 66))); // null?
    }
}

class Student {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}