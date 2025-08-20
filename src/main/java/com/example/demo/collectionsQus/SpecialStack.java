package com.example.demo.collectionsQus;

public class SpecialStack {
    private int arr[];
    private int top;
    private int maxSize;
    private int minElement;

    public SpecialStack(int size) {
        this.maxSize = size;
        this.arr = new int[maxSize];
        this.top = -1;
        this.minElement = Integer.MAX_VALUE;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full");
            return;
        }
        if (value < minElement) {
            minElement = value;
        }
        arr[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int poppedValue = arr[top--];
        if (poppedValue == minElement) {
            minElement = Integer.MAX_VALUE;
            for (int i = 0; i <= top; i++) {
                if (arr[i] < minElement) {
                    minElement = arr[i];
                }
            }
        }
        return poppedValue;
    }

    public int getMin() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return minElement;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
