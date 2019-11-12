package by.epam.task515a.data;

import java.util.Objects;

public class Flower {
  private String kind;
  private int length;
  private String color;
  private double price;

  public Flower() {
  }

  public Flower(Flower flower) {
    this.kind = flower.kind;
    this.length = flower.length;
    this.color = flower.color;
    this.price = flower.price;
  }

  public Flower(String kind, int length, String color, double price) {
    this.kind = kind;
    this.length = length;
    this.color = color;
    this.price = price;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Flower)) return false;
    Flower flower = (Flower) o;
    return getLength() == flower.getLength() &&
            Double.compare(flower.getPrice(), getPrice()) == 0 &&
            Objects.equals(getKind(), flower.getKind()) &&
            Objects.equals(getColor(), flower.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getKind(), getLength(), getColor(), getPrice());
  }

  @Override
  public String toString() {
    return kind +
            ": length='" + length + '\'' +
            ", color='" + color + '\'' +
            ", price=" + price;
  }
}
