package org.example.seminar4.cw4;

public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        System.out.println(arrayStack.size());
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        System.out.println("arrayStack.peek() = " + arrayStack.peek());
        System.out.println("arrayStack.pop() = " + arrayStack.pop());
        System.out.println("arrayStack.peek() = " + arrayStack.peek());
        System.out.println("arrayStack.empty() = " + arrayStack.empty());
        System.out.println("arrayStack.size() = " + arrayStack.size());
    }
}
