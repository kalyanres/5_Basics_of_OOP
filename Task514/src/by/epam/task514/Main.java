package by.epam.task514;

/*
        Задача 4.
    Создать консольное приложение, удовлетворяющее следующим требованиям:
    • Приложение должно быть объектно-, а не процедурно-ориентированным.
    • Каждый класс должен иметь отражающее смысл название и информативный состав.
    • Наследование должно применяться только тогда, когда это имеет смысл.
    • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
    • Классы должны быть грамотно разложены по пакетам.
    • Консольное меню должно быть минимальным.
    • Для хранения данных можно использовать файлы.
        Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
выбора сокровищ на заданную сумму.
 */

import by.epam.task514.data.TreasureAgg;
import by.epam.task514.logic.TreasureLogic;
import by.epam.task514.view.TreasureView;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {

    TreasureAgg treasureAgg = new TreasureAgg();
    TreasureLogic treasureLogic = new TreasureLogic();
    TreasureView treasureView = new TreasureView();
    int money = 0;
    int choice = 0;

    // читаем файл Treasure.txt
    if (treasureLogic.readFile("Treasure.txt"))
      treasureLogic.fillData(treasureAgg);
    else
      System.out.println("Not success!!!");
    System.out.println();

    boolean enter = false;

    System.out.println("Welcome to The Dragon Treasure Cave!");
    System.out.print("Do you want to go inside? (y/n): ");
    Scanner in = new Scanner(System.in);
    String st = in.nextLine();

    while (!st.equals("n")) {
      if (st.equals("y")) {
        System.out.println("You will meet the dragon treasures!");
        System.out.println("There are " + treasureAgg.getSize() +
                " treasures in the Dragon Cave!" );
        System.out.print("Do you want to see all treasures? (y/n): ");
        st = in.nextLine();
        while (!st.equals("n")) {
          if (st.equals("y")) {
            treasureView.showTreasures(treasureAgg);
            System.out.print("Do you want to know how treasure is the most expensive? (y/n): ");
            st = in.nextLine();
            while (!st.equals("n")) {
              if (st.equals("y")) {
                System.out.println(treasureLogic.getTheMostExpensive(treasureAgg).toString());
                break;
              } else {
                System.out.print("Please, be careful, enter a correct letter: ");
                st = in.nextLine();
              }
            }
            System.out.print("Do you want to buy any treasures? (y/n): ");
            st = in.nextLine();
            while (!st.equals("n")) {
              if (st.equals("y")) {
                System.out.print("How much money do you ready to spend? : ");
                money = in.nextInt();
                while (money > 0) {
                  System.out.print("You can choose any treasure (enter number, 0 for end):");
                  choice = in.nextInt() - 1;
                  while (choice < -1 || choice > 100) {
                    System.out.print("We have only 100 treasures");
                    choice = in.nextInt() - 1;
                  }
                  if (choice == -1)
                    break;
                  if (treasureAgg.getTreasure(choice).isAvailable() &&
                      treasureAgg.getTreasure(choice).getPrice() <= money) {
                    treasureAgg.getTreasure(choice).setAvailable(false);
                    money -= treasureAgg.getTreasure(choice).getPrice();
                  } else if (treasureAgg.getTreasure(choice).isAvailable()) {
                    System.out.println("You already have that treasure");
                  } else if (treasureAgg.getTreasure(choice).getPrice() > money) {
                    System.out.println("That treasure is too expensive for you");
                  } else if (money < treasureLogic.getTheCheapest(treasureAgg).getPrice()) {
                    System.out.println("Money is over");
                    break;
                  }
                  System.out.println("You have: " + money);
                }
                System.out.println("Eventually, you have: ");
                treasureView.showNotAvailable(treasureAgg);
                break;
              } else {
                System.out.print("Please, be careful, enter a correct letter: ");
                st = in.nextLine();
              }
            }
            break;
          } else {
            System.out.print("Please, be careful, enter a correct letter: ");
            st = in.nextLine();
          }
          break;
        }
        break;
      } else {
        System.out.print("Please, be careful, enter a correct letter: ");
        st = in.nextLine();
      }
    }
    System.out.println("Thanks for stopping by!");


  }
}