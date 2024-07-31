/*
Нугманов Егор.
Простите, чуть-чуть пользовался GPT 🥲
 */

package org.example.seminar6.attestation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, String>> laptops = new HashMap<>();
        addLaptop(laptops, "Laptop 1", 4, 500, "Windows 10", "Black");
        addLaptop(laptops, "Laptop 1.2", 4, 500, "Windows 10", "White");
        addLaptop(laptops, "Laptop 2", 8, 1000, "Windows 10", "Black");
        addLaptop(laptops, "Laptop 2.2", 8, 1000, "Windows 10", "White");
        addLaptop(laptops, "Laptop 3", 16, 2000, "Windows 10", "Black");
        addLaptop(laptops, "Laptop 3.2", 16, 2000, "Windows 10", "White");
        addLaptop(laptops, "Laptop 4", 32, 4000, "Windows 10", "Black");
        addLaptop(laptops, "Laptop 4.2", 32, 4000, "Windows 10", "White");

        Map<String, String> filters = getFiltersFromUser();
        filterLaptops(laptops, filters);
    }

    private static Map<String, String> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        int choice;
        do {
            choice = userInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Введите минимальное значение ОЗУ: ");
                    filters.put("ОЗУ", scanner.next());
                    break;
                case 2:
                    System.out.print("Введите минимальное значение объема ЖД: ");
                    filters.put("Объем ЖД", scanner.next());
                    break;
                case 3:
                    System.out.print("Введите операционную систему: ");
                    filters.put("Операционная система", scanner.next());
                    break;
                case 4:
                    System.out.print("Введите цвет: ");
                    filters.put("Цвет", scanner.next());
                    break;
            }

            System.out.print("Хотите добавить еще один критерий? (да/нет): ");
        } while ("да".equalsIgnoreCase(scanner.next()));

        return filters;
    }

    private static int userInput(Scanner scanner) {
        System.out.print("Введите цифру, соответствующую необходимому критерию:\n" +
                "1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет\n");
        System.out.print("\nВвод: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 4) {
            System.out.println("Неверный ввод. Пожалуйста, введите цифру от 1 до 4.");
            return userInput(scanner);
        } else {
            return choice;
        }
    }

    private static void addLaptop(Map<String, Map<String, String>> laptops, String name, int ram, int hddCapacity, String operatingSystem, String color) {
        Map<String, String> laptopProperties = new HashMap<>();
        laptopProperties.put("ОЗУ", String.valueOf(ram));
        laptopProperties.put("Объем ЖД", String.valueOf(hddCapacity));
        laptopProperties.put("Операционная система", operatingSystem);
        laptopProperties.put("Цвет", color);

        laptops.put(name + " - " + operatingSystem + " - " + color, laptopProperties);
    }

    private static void filterLaptops(Map<String, Map<String, String>> laptops, Map<String, String> filters) {
        boolean found = false;
        for (Map.Entry<String, Map<String, String>> entry : laptops.entrySet()) {
            String laptopName = entry.getKey();
            Map<String, String> laptopProperties = entry.getValue();

            boolean matches = true;
            for (Map.Entry<String, String> filter : filters.entrySet()) {
                String property = laptopProperties.get(filter.getKey());
                if (filter.getKey().equals("ОЗУ") || filter.getKey().equals("Объем ЖД")) {
                    if (Integer.parseInt(property) < Integer.parseInt(filter.getValue())) {
                        matches = false;
                        break;
                    }
                } else {
                    if (!property.equalsIgnoreCase(filter.getValue())) {
                        matches = false;
                        break;
                    }
                }
            }

            if (matches) {
                found = true;
                System.out.println("Laptop: " + laptopName);
                System.out.println("ОЗУ: " + laptopProperties.get("ОЗУ"));
                System.out.println("Объем ЖД: " + laptopProperties.get("Объем ЖД"));
                System.out.println("Операционная система: " + laptopProperties.get("Операционная система"));
                System.out.println("Цвет: " + laptopProperties.get("Цвет"));
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("Нет ноутбуков, соответствующих заданным критериям.");
        }
    }
}