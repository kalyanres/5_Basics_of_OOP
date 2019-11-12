package by.epam.task515b;

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

    Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
подарок). Составляющими целого подарка являются сладости и упаковка.
 */


import by.epam.task515b.data.SweetKit;
import by.epam.task515b.data.SweetPackage;
import by.epam.task515b.data.Sweetness;
import by.epam.task515b.data.SweetnessGift;
import by.epam.task515b.logic.SweetLogic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {

    Sweetness[] sweetnesses = new Sweetness[10];
    sweetnesses[0] = new Sweetness("Конфета", "Грильяж", "Коммунарка", 0.75);
    sweetnesses[1] = new Sweetness("Конфета", "Белорусские", "Коммунарка", 0.35);
    sweetnesses[2] = new Sweetness("Конфета", "Стандарт 1969", "Коммунарка", 0.31);
    sweetnesses[3] = new Sweetness("Шоколад", "«Alpen Gold» с печеньем орео", "Alpen Gold", 2.65);
    sweetnesses[4] = new Sweetness("Плитка", "«Аленкина буренка» молочная", "Аленкина Буренка", 0.65);
    sweetnesses[5] = new Sweetness("Шоколад", "Молочный шоколад с начинкой «Roshen» Tidbit", "Roshen", 1.35);
    sweetnesses[6] = new Sweetness("Конфета", "«Петровский форт»", "Россия", 0.59);
    sweetnesses[7] = new Sweetness("Конфета", "Любимая Аленка", "Коммунарка", 0.45);
    sweetnesses[8] = new Sweetness("Конфета", "Трюфель молочный", "Россия", 0.95);
    sweetnesses[9] = new Sweetness("Конфета", "Bon Bonel", "Россия", 0.82);

    SweetKit[] sweetKits = new SweetKit[sweetnesses.length];
    sweetKits[0] = new SweetKit(sweetnesses[0], 123);
    sweetKits[1] = new SweetKit(sweetnesses[1], 73);
    sweetKits[2] = new SweetKit(sweetnesses[2], 94);
    sweetKits[3] = new SweetKit(sweetnesses[3], 332);
    sweetKits[4] = new SweetKit(sweetnesses[4], 87);
    sweetKits[5] = new SweetKit(sweetnesses[5], 221);
    sweetKits[6] = new SweetKit(sweetnesses[6], 88);
    sweetKits[7] = new SweetKit(sweetnesses[7], 555);
    sweetKits[8] = new SweetKit(sweetnesses[8], 332);
    sweetKits[9] = new SweetKit(sweetnesses[9], 183);

    SweetPackage[] sweetPackages = new SweetPackage[6];
    sweetPackages[0] = new SweetPackage("Коробка", "Новогодний Сундучок", 0.92);
    sweetPackages[1] = new SweetPackage("Коробка", "Новогодняя Ярмарка", 0.95);
    sweetPackages[2] = new SweetPackage("Пакет-ламинат", "С Новым Годом!", 6.45);
    sweetPackages[3] = new SweetPackage("Коробка деревянная", "Снеговик-почтовик", 12.45);
    sweetPackages[4] = new SweetPackage("Коробка деревянная", "Снеговик-почтовик", 12.45);
    sweetPackages[5] = new SweetPackage("Носок для подарков", "От Деда Мороза", 3.49);

    SweetnessGift sweetnessGift = new SweetnessGift();
    SweetLogic sweetLogic = new SweetLogic();

    // реализация меню
    Scanner in = new Scanner(System.in);
    Scanner inDig = new Scanner(System.in);
    System.out.print("Добрый день! Хотите собрать подарок? (y/n): ");

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
      System.out.print("Введите корректную букву! (y/n): ");
      scan = in.nextLine();
      m1 = patt1.matcher(scan);
    }
    while (scan.equals("y")) {
      System.out.println("\nПожалуйста, посмотрите список имеющихся в наличии сладостей\n");
      for (int i = 0; i < sweetKits.length; i++) {
        System.out.print((i + 1) + ": ");
        System.out.println(sweetKits[i].toString());
      }

      System.out.print("\nХотите что-то выбрать из приведенного списка? (y/n): ");
      scan = in.nextLine();
      m1 = patt1.matcher(scan);
      // проверка ввода
      while (!m1.find()) {
        System.out.print("Введите корректную букву! (y/n): ");
        scan = in.nextLine();
        m1 = patt1.matcher(scan);
      }
      m1 = patt1.matcher(scan);
      while (m1.find() && !scan.equals("n")) {
        System.out.println("(введите цифру нужной вам сладости и укажите количество)");
        int choice = 0;
        int amount = 0;
        System.out.print("введите цифру сладости: ");
        scan = in.nextLine();
        m2 = patt2.matcher(scan);
        // проверка на цифровой ввод
        while (!m2.find()) {
          System.out.print("Вводите только цифры: ");
          scan = in.nextLine();
          m2 = patt2.matcher(scan);
        }
        choice = Integer.parseInt(scan);
        choice--;
        System.out.print("Введите количество: ");
        scan = in.nextLine();
        m2 = patt2.matcher(scan);
        // проверка на цифровой ввод
        while (!m2.find()) {
          System.out.print("Вводите только цифры: ");
          scan = in.nextLine();
          m2 = patt2.matcher(scan);
        }
        amount = Integer.parseInt(scan);


        int result = sweetKits[choice].getAmount() - amount;

        // если нужных цветов нет
        if (sweetKits[choice].getAmount() == 0) {
          System.out.println("У нас не осталось больше таких сладостей");

          // если введенное количество корректно
        } else if (result >= 0) {
          sweetnessGift.addSweetness(sweetnesses[choice], amount);
          sweetKits[choice].setAmount(result);
          // если введенное количество больше реального
        } else {
          System.out.println("Этих сладостей недостаточно, хотите забрать все имеющиеся? (y/n):");
          scan = in.nextLine();
          m1 = patt1.matcher(scan);
          // если соглашаемся забрать все
          if (m1.find() && scan.equals("y")) {
            sweetnessGift.addSweetness(sweetnesses[choice], sweetKits[choice].getAmount());
            sweetKits[choice].setAmount(0);
            // если не соглашаемся, выбираем по новой
          } else if (m1.find() && scan.equals("n")) {
            scan = "y";
            m1 = patt1.matcher(scan);
            continue;
          }
        }
        System.out.print("Хотите продолжить выбор? (y/n): ");
        scan = in.nextLine();
        m1 = patt1.matcher(scan);
        // проверка ввода
        while (!m1.find()) {
          System.out.print("Введите корректную букву! (y/n): ");
          scan = in.nextLine();
          m1 = patt1.matcher(scan);
        }
        m1 = patt1.matcher(scan);
      }
      // ввод упаковки
      System.out.print("\nХотите выбрать упаковку для своего подарка? (y/n): ");

      scan = in.nextLine();
      m1 = patt1.matcher(scan);

      // проверка ввода
      while (!m1.find()) {
        System.out.print("Введите корректную букву! (y/n): ");
        scan = in.nextLine();
        m1 = patt1.matcher(scan);
      }
      while (scan.equals("y")) {
        System.out.println("\nПожалуйста, посмотрите список имеющихся упаковок\n");
        for (int i = 0; i < sweetPackages.length; i++) {
          System.out.print((i + 1) + ": ");
          System.out.println(sweetPackages[i].toString());
        }
        System.out.print("\nХотите что-либо выбрать из имеющегося списка? (y/n): ");
        scan = in.nextLine();
        m1 = patt1.matcher(scan);
        // проверка ввода
        while (!m1.find()) {
          System.out.print("Введите корректную букву! (y/n): ");
          scan = in.nextLine();
          m1 = patt1.matcher(scan);
        }
        m1 = patt1.matcher(scan);
        while (m1.find() && !scan.equals("n")) {
          System.out.print("введите номер нужной упаковки: ");
          int choice = 0;
          scan = in.nextLine();
          m2 = patt2.matcher(scan);
          // проверка на цифровой ввод
          while (true) {
            while (!m2.find()) {
              System.out.print("Вводите только цифры: ");
              scan = in.nextLine();
              m2 = patt2.matcher(scan);
            }
            choice = Integer.parseInt(scan);
            choice--;
            if (choice < 0 || choice >= 10) {
              System.out.println("Мы не имеем упаковки с таким номером, попытайтесь снова: ");
              continue;
            }
            sweetnessGift.setSweetPackage(sweetPackages[choice]);
            break;
          }
        }
        System.out.println("\nВаш заказ:");
        System.out.println(sweetnessGift.toString());
        System.out.println("Полная стоимость заказа: " +
                sweetLogic.getPrice(sweetnessGift));
      }


    }

    System.out.println("\nHave a nice day!");
  }

}
