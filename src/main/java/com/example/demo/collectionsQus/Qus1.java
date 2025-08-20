package com.example.demo.collectionsQus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Qus1 {
    public static void main(String[] args) {
        List<Float> list= new ArrayList<>();
        list.add(1.2f);
        list.add(2.3f);
        list.add(3.4f);
        list.add(4.5f);
        list.add(5.6f);

        Iterator<Float> it= list.iterator();
        float sum = 0.0f;
        while (it.hasNext()) {
            sum += it.next();
        }
        System.out.println("Sum of all elements in the list: " + sum);
    }

}
