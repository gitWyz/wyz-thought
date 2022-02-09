package juc.c_018_00_AtomicXXX;

import util.SleepHelperUtil;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T06_TestAtomicReference {

    private static class Student {
        String name;
        int age;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static AtomicReference<Student> chairman = new AtomicReference<>();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread(() -> {

                Student s = new Student();
                s.name = "s-" + j;
                SleepHelperUtil.sleepMilli(1);
                s.age = j;

                chairman.set(s);

            }).start();
        }

        SleepHelperUtil.sleepSeconds(3);

        System.out.println(chairman.get());
    }
}
