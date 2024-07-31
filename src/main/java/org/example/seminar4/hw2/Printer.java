package org.example.seminar4.hw2;

import java.util.LinkedList;

class MyQueueInt {
    // Напишите свое решение ниже
    private LinkedList<Integer> queue = new LinkedList<>();

    public void enqueue(int element){
        // Напишите свое решение ниже
        this.queue.addLast(element);

    }

    public int dequeue(){
        // Напишите свое решение ниже
        if (!queue.isEmpty()) {
            return this.queue.removeFirst();
        } else {
            System.out.println("Список пуст");
            return -1;
        }
    }

    public int first(){
        // Напишите свое решение ниже
        if (!queue.isEmpty()) {
            return queue.getFirst();
        } else {
            System.out.println("Список пуст");
            return -1;
        }

    }

    public LinkedList<Integer> getElements() {
        // Напишите свое решение ниже
        return queue;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        MyQueueInt queue;
        queue = new MyQueueInt();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}