package org.example.seminar4.cw4;

public class ArrayStack {
    private int maxSize;
    private String[] stackArray;
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new String[maxSize];
        this.top = -1;
    }

    public int size(){
        return this.top + 1;
    }

    public boolean empty(){
        return this.top == -1;
    }

    public void push(String value){
        if (this.top < this.maxSize - 1) {
            top++;
            stackArray[top] = value;
        } else {
            System.out.println("Стек переполнен.");
        }
    }

    public String peek(){
        if (!this.empty()) {
            return stackArray[top];
        } else {
            System.out.println("Список пуст");
            return null;
        }
    }

    public String pop(){
        if (!this.empty()) {
            String value = stackArray[top];
            top--;
            stackArray[top] = null;
            return value;

        } else {
            System.out.println("Список пуст");
            return null;
        }
    }


}
