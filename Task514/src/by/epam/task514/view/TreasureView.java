package by.epam.task514.view;

import by.epam.task514.data.Treasure;
import by.epam.task514.data.TreasureAgg;

public class TreasureView {

  public void showTreasures(TreasureAgg treasureAgg) {
    for (int i = 0; i < treasureAgg.getSize(); i++) {
      System.out.print((i + 1) + ": ");
      System.out.println(treasureAgg.getTreasure(i).toString());
    }
    System.out.println();
  }

  public void showTreasure(Treasure treasure) {
    System.out.println(treasure.toString());
  }

  public void showNotAvailable(TreasureAgg treasureAgg) {
    for (int i = 0; i < treasureAgg.getSize(); i++) {
      if (!treasureAgg.getTreasure(i).isAvailable()) {
        System.out.print((i + 1) + ": ");
        System.out.println(treasureAgg.getTreasure(i).toString());
      }
    }
    System.out.println();
  }


}
