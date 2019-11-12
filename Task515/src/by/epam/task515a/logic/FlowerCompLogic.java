package by.epam.task515a.logic;

import by.epam.task515a.data.FlowerComp;

public class FlowerCompLogic {
  public double getPrice(FlowerComp flowerComp) {
    double price = 0;
    for (int i = 0; i < flowerComp.getFlowerKits().size(); i++) {
      price += flowerComp.getFlowerKit(i).getPrice() *
                flowerComp.getFlowerKit(i).getAmount();
    }
    price += flowerComp.getPackages().getPrice();
    return price;
  }
}
