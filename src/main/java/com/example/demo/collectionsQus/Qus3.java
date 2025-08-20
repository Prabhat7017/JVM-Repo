package com.example.demo.collectionsQus;

public class Qus3 {
    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack(6);
        specialStack.push(3);
        specialStack.push(5);
        specialStack.push(2);
        specialStack.push(1);
        specialStack.push(4);
        specialStack.push(0);
        specialStack.push(53);

        System.out.println("Stack elements: " + specialStack);
        System.out.println("Minimum element in the stack: " + specialStack.getMin());
        System.out.println("Popped element: " + specialStack.pop());
        System.out.println("Stack after popping an element: " + specialStack);
        System.out.println("Minimum element in the stack after popping: " + specialStack.getMin());
        System.out.println("Is the stack empty? " + specialStack.isEmpty());
        System.out.println("Is the stack full? " + specialStack.isFull());
    }
}
