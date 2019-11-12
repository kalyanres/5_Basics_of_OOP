package by.epam;

/*
    Задача 3.
    Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
 */

import by.epam.task513.data.Calendar;

import java.util.Scanner;


public class Main {

  public static void main(String[] args) {

    Calendar calendar = new Calendar();

    // государственные праздники
    calendar.addHoliday("Orthodox Christmas", 7, 1, 2020);
    calendar.addHoliday("Women day", 8, 3, 2020);
    calendar.addHoliday("Victory day", 9, 5, 2020);
    calendar.addHoliday("Independence day", 3, 7, 2020);

    // назначаем день встречи, который не должен попадать на праздники
    System.out.println("What day do you want to meet: ");
    Scanner in = new Scanner(System.in);
    System.out.print("Enter day: ");
    int day = in.nextInt();
    System.out.print("Enter month: ");
    int month = in.nextInt();
    System.out.print("Enter year: ");
    int year = in.nextInt();
    calendar.setData(day, month, year);

    System.out.println(calendar.checkData());
  }
}


