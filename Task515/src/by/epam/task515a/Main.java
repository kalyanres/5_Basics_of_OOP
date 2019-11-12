package by.epam.task515a;

import by.epam.task515a.data.Flower;
import by.epam.task515a.data.FlowerComp;
import by.epam.task515a.data.FlowerKit;
import by.epam.task515a.data.FlowerPackage;
import by.epam.task515a.logic.FlowerCompLogic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
        Задача 5.

    Создать консольное приложение, удовлетворяющее следующим требованиям:
    • Корректно спроектируйте и реализуйте предметную область задачи.
    • Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
проектирования.
    • Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
      • для проверки корректности переданных данных можно применить регулярные выражения.
    • Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
    • Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

    Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы
и упаковка.

 */
public class Main {

    public static void main(String[] args) {

        // данные
        Flower[] flowers = new Flower[10];
        flowers[0] = new Flower("Rose", 60, "Red", 1.5);
        flowers[1] = new Flower("Rose", 70, "Red", 1.7);
        flowers[2] = new Flower("Rose", 60, "Blue", 1.8);
        flowers[3] = new Flower("Rose", 50, "Pink", 1.6);
        flowers[4] = new Flower("Rose", 60, "Pink", 1.8);
        flowers[5] = new Flower("Rose", 80, "White", 1.6);
        flowers[6] = new Flower("Orchid", 50, "Blue", 2.3);
        flowers[7] = new Flower("Sunflower", 80, "Yellow", 1.3);
        flowers[8] = new Flower("Chrysanthemum", 70, "White", 0.9);
        flowers[9] = new Flower("Lily", 60, "White", 3.0);

        FlowerKit[] flowerKits = new FlowerKit[10];
        flowerKits[0] = new FlowerKit(flowers[0], 50);
        flowerKits[1] = new FlowerKit(flowers[1], 38);
        flowerKits[2] = new FlowerKit(flowers[2], 28);
        flowerKits[3] = new FlowerKit(flowers[3], 18);
        flowerKits[4] = new FlowerKit(flowers[4], 21);
        flowerKits[5] = new FlowerKit(flowers[5], 11);
        flowerKits[6] = new FlowerKit(flowers[6], 29);
        flowerKits[7] = new FlowerKit(flowers[7], 19);
        flowerKits[8] = new FlowerKit(flowers[8], 44);
        flowerKits[9] = new FlowerKit(flowers[9], 27);

        FlowerPackage[] packages = new FlowerPackage[9];
        packages[0] = new FlowerPackage("Envelope", "Transparent", 0.5);
        packages[1] = new FlowerPackage("Linen", "Blue", 0.8);
        packages[2] = new FlowerPackage("Crepe", "Red", 1.2);
        packages[3] = new FlowerPackage("Organza", "Orange", 1.5);
        packages[4] = new FlowerPackage("Grid", "Brown", 2.8);
        packages[5] = new FlowerPackage("Felt", "White", 1.2);
        packages[6] = new FlowerPackage("Foamiran", "Yellow", 2.5);
        packages[7] = new FlowerPackage("Foil", "Gray", 3.5);
        packages[8] = new FlowerPackage("Paper", "Red", 0.3);

        FlowerComp flowerComp = new FlowerComp();
        FlowerCompLogic flowerCompLogic = new FlowerCompLogic();

        // реализация меню
        Scanner in = new Scanner(System.in);
        Scanner inDig = new Scanner(System.in);
        System.out.print("How do you do! Do you want to make a flower composition? (y/n): ");

        String scan = in.nextLine();
        // проверка ввода с помощью регулярных выражений
        String index1 = "[yYnN]";
        String index2 = "\\d+";
        Pattern patt1 = Pattern.compile(index1);
        Matcher m1 = patt1.matcher(scan);
        Pattern patt2 = Pattern.compile(index2);
        Matcher m2;

        // проверка ввода
        while (!m1.find()) {
            System.out.print("Enter correct letter! (y/n): ");
            scan = in.nextLine();
            m1 = patt1.matcher(scan);
        }
        while (scan.equals("y")) {
            System.out.println("\nPlease select the flowers you need from the list of flowers\n");
            for (int i = 0; i < flowers.length; i++) {
                System.out.print((i + 1) + ": ");
                System.out.println(flowerKits[i].toString());
            }

            System.out.print("\nDo you want to choose the flowers you need and their number? (y/n): ");
            scan = in.nextLine();
            m1 = patt1.matcher(scan);
            // проверка ввода
            while (!m1.find()) {
                System.out.print("Enter correct letter! (y/n): ");
                scan = in.nextLine();
                m1 = patt1.matcher(scan);
            }
            m1 = patt1.matcher(scan);
            while (m1.find() && !scan.equals("n")) {
                System.out.println("(enter number of flower and amount)");
                int choice = 0;
                int amount = 0;
                System.out.print("enter a digit of flower: ");
                scan = in.nextLine();
                m2 = patt2.matcher(scan);
                // проверка на цифровой ввод
                while (!m2.find()) {
                    System.out.print("Enter the number: ");
                    scan = in.nextLine();
                    m2 = patt2.matcher(scan);
                }
                choice = Integer.parseInt(scan);
                choice--;
                System.out.print("enter amount: ");
                scan = in.nextLine();
                m2 = patt2.matcher(scan);
                // проверка на цифровой ввод
                while (!m2.find()) {
                    System.out.print("Enter the number: ");
                    scan = in.nextLine();
                    m2 = patt2.matcher(scan);
                }
                amount = Integer.parseInt(scan);


                int result = flowerKits[choice].getAmount() - amount;

                // если нужных цветов нет
                if (flowerKits[choice].getAmount() == 0) {
                    System.out.println("We don't have flowers");

                    // если введенное количество корректно
                } else if (result >= 0) {
                    flowerComp.addFlowerKit(flowers[choice], amount);
                    flowerKits[choice].setAmount(result);
                    // если введенное количество больше реального
                } else {
                    System.out.println("Flowers is not enough, do you want to give all of them? (y/n):");
                    scan = in.nextLine();
                    m1 = patt1.matcher(scan);
                    // если соглашаемся забрать все
                    if (m1.find() && scan.equals("y")) {
                        flowerComp.addFlowerKit(flowers[choice], flowerKits[choice].getAmount());
                        flowerKits[choice].setAmount(0);
                        // если не соглашаемся, выбираем по новой
                    } else if (m1.find() && scan.equals("n")) {
                        scan = "y";
                        m1 = patt1.matcher(scan);
                        continue;
                    }
                }
                System.out.print("Do you want to continue? (y/n): ");
                scan = in.nextLine();
                m1 = patt1.matcher(scan);
                // проверка ввода
                while (!m1.find()) {
                    System.out.println("Enter correct letter! (y/n): ");
                    scan = in.nextLine();
                    m1 = patt1.matcher(scan);
                }
                m1 = patt1.matcher(scan);
            }
            // ввод упаковки
            System.out.print("\nDo you want to choose package for your composition? (y/n): ");

            scan = in.nextLine();
            m1 = patt1.matcher(scan);

            // проверка ввода
            while (!m1.find()) {
                System.out.print("Enter correct letter! (y/n): ");
                scan = in.nextLine();
                m1 = patt1.matcher(scan);
            }
            while (scan.equals("y")) {
                System.out.println("\nPlease select the package you need from the list of package\n");
                for (int i = 0; i < packages.length; i++) {
                    System.out.print((i + 1) + ": ");
                    System.out.println(packages[i].toString());
                }
                System.out.print("\nDo you want to choose the package you need and their number? (y/n): ");
                scan = in.nextLine();
                m1 = patt1.matcher(scan);
                // проверка ввода
                while (!m1.find()) {
                    System.out.print("Enter correct letter! (y/n): ");
                    scan = in.nextLine();
                    m1 = patt1.matcher(scan);
                }
                m1 = patt1.matcher(scan);
                while (m1.find() && !scan.equals("n")) {
                    System.out.print("enter number of package: ");
                    int choice = 0;
                    scan = in.nextLine();
                    m2 = patt2.matcher(scan);
                    // проверка на цифровой ввод
                    while (true) {
                        while (!m2.find()) {
                            System.out.print("Enter the number: ");
                            scan = in.nextLine();
                            m2 = patt2.matcher(scan);
                        }
                        choice = Integer.parseInt(scan);
                        choice--;
                        if (choice < 0 || choice >= 10) {
                            System.out.println("We don't have that number! Try again: ");
                            continue;
                        }
                        flowerComp.setPackages(packages[choice]);
                        break;
                    }
                }
                System.out.println("\nIn the end we have:");
                System.out.println(flowerComp.toString());
                System.out.println("Total cost: " +
                        flowerCompLogic.getPrice(flowerComp));
            }


        }

        System.out.println("\nHave a nice day!");
    }
}
