package by.epam.task515b.logic;

import by.epam.task515b.data.SweetnessGift;

public class SweetLogic {

  public double getPrice(SweetnessGift sweetnessGift) {
    double price = 0;
    for (int i = 0; i < sweetnessGift.getSweetKits().size(); i++) {
      price += sweetnessGift.getSweetKit(i).getPrice() *
              sweetnessGift.getSweetKit(i).getAmount();
    }
    price += sweetnessGift.getSweetPackage().getPrice();
    return price;
  }
}
