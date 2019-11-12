package by.epam.task514.logic;

import by.epam.task514.data.Treasure;
import by.epam.task514.data.TreasureAgg;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreasureLogic {
  ArrayList<String> treasures;

  public TreasureLogic() {
    treasures = new ArrayList<String>();
  }

  // выбор самого дорогого сокровища
  public Treasure getTheMostExpensive(TreasureAgg treasureAgg) {
    Treasure maxPrice = new Treasure();
    for (int i = 0; i < treasureAgg.getSize(); i++) {
      if (maxPrice.getPrice() < treasureAgg.getTreasure(i).getPrice()) {
        maxPrice = treasureAgg.getTreasure(i);
      }
    }
    return maxPrice;
  }

  // выбор самого дешевого сокровища
  public Treasure getTheCheapest(TreasureAgg treasureAgg) {
    Treasure minPrice = new Treasure();
    for (int i = 0; i < treasureAgg.getSize(); i++) {
      if (minPrice.getPrice() > treasureAgg.getTreasure(i).getPrice()) {
        minPrice = treasureAgg.getTreasure(i);
      }
    }
    return minPrice;
  }

  // вывод полной суммы
  public int getTotalCost(TreasureAgg treasureAgg) {
    int totalCost = 0;
    for (int i = 0; i < treasureAgg.getSize(); i++) {
      totalCost += treasureAgg.getTreasure(i).getPrice();
    }
    return totalCost;
  }

  // создание массива String из файла
  public boolean readFile(String fileName) throws Exception {
    boolean success = true;
    FileReader fr = new FileReader(fileName);
    try {
      Scanner scan = new Scanner(fr);

      char[] ch = new char[100];
      while (scan.hasNextLine()) {
        treasures.add(scan.nextLine());
      }
      fr.close();
    } catch (IOException e) {
      success = false;
    }
    return success;
  }

  // заполнение данными TreasureAdd
  public void fillData(TreasureAgg treasureAgg) {
    int element = 0;
    int count = 0;
    char[] buf;
    char[] buff;
    String s;
    for (int i = 0; i < treasures.size(); i++) {
      treasureAgg.addTreasure(new Treasure());
      for (int j = 0; j < treasures.get(i).length(); j++) {
        buf = new char[100];

        // поэлементно копируем в буфер
        for (int k = j; k < treasures.get(i).length(); k++) {
          if (treasures.get(i).charAt(k) == ';')
            break;
          buf[k - j] = treasures.get(i).charAt(k);
          count = k + 1;
        }
        // избавляемся от лишних элементов буфера
        buff = new char[count - j];
        for (int k = 0; k < count - j; k++) {
          buff[k] = buf[k];
        }
        s = new String(buff);
        if (element == 0) {
          treasureAgg.getTreasure(i).setName(s);
          element++;
        } else if (element == 1) {
          treasureAgg.getTreasure(i).setMaterial(s);
          element++;
        } else if (element == 2) {
          treasureAgg.getTreasure(i).setProduct(s);
          element++;
        } else if (element == 3) {
          treasureAgg.getTreasure(i).setPrice(Integer.parseInt(s));
          element = 0;
        }
        j = count;
      }
    }
  }

}

