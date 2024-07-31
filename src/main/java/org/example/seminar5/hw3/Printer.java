package org.example.seminar5.hw3;

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Строим кучу (max-heap) из массива
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            int largest = i;
            while (true) {
                int left = 2 * largest + 1;
                int right = 2 * largest + 2;
                int maxIndex = largest;

                if (left < sortLength && tree[left] > tree[maxIndex]) {
                    maxIndex = left;
                }

                if (right < sortLength && tree[right] > tree[maxIndex]) {
                    maxIndex = right;
                }

                if (maxIndex == largest) {
                    break;
                }

                int swap = tree[largest];
                tree[largest] = tree[maxIndex];
                tree[maxIndex] = swap;

                largest = maxIndex;
            }
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        // Построение кучи (max-heap)
        buildTree(sortArray, sortLength);

        // Один за другим извлекаем элементы из кучи
        for (int i = sortLength - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            // Приводим оставшуюся часть массива к форме кучи
            int largest = 0;
            int currentLength = i;
            while (true) {
                int left = 2 * largest + 1;
                int right = 2 * largest + 2;
                int maxIndex = largest;

                if (left < currentLength && sortArray[left] > sortArray[maxIndex]) {
                    maxIndex = left;
                }

                if (right < currentLength && sortArray[right] > sortArray[maxIndex]) {
                    maxIndex = right;
                }

                if (maxIndex == largest) {
                    break;
                }

                int swap = sortArray[largest];
                sortArray[largest] = sortArray[maxIndex];
                sortArray[maxIndex] = swap;

                largest = maxIndex;
            }
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
