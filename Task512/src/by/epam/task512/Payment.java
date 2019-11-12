package by.epam.task512;

import java.util.LinkedList;

public class Payment {

  private class Good {
    private String name;
    private String madeIn;
    private int year;
    private double price;

    public Good() {
    }

    public Good(String name, String madeIn, int year, double price) {
      this.name = name;
      this.madeIn = madeIn;
      this.year = year;
      this.price = price;
    }

    public double getPrice() {
      return price;
    }

    public void setPrice(double price) {
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getMadeIn() {
      return madeIn;
    }

    public void setMadeIn(String madeIn) {
      this.madeIn = madeIn;
    }

    public int getYear() {
      return year;
    }

    public void setYear(int year) {
      this.year = year;
    }

    @Override
    public String toString() {
      return "Good {" +
              " name = '" + name + '\'' +
              ", madeIn = '" + madeIn + '\'' +
              ", year = " + year +
              ", price = " + price +
              '}';
    }
  }


  private LinkedList<Good> goods;

  public Payment() {
    goods = new LinkedList<Good>();
  }


  public void addGood(String name, String madeIn, int year, double price) {
    goods.add(new Good(name, madeIn, year, price));
  }

  public LinkedList<Good> getGoods() {
    return goods;
  }

  public int getSize() {
    return goods.size();
  }

  public double getPrice() {
    double sum = 0;
    for (int i = 0; i < goods.size(); i++) {
      sum += goods.get(i).getPrice();
    }
    return sum;
  }

  public String getString(int index) {
    return goods.get(index).toString();
  }

}
