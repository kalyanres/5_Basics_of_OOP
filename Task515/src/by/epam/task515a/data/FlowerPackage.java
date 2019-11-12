package by.epam.task515a.data;

import java.util.Objects;

public class FlowerPackage {
  private String kind;
  private String color;
  private double price;

  public FlowerPackage() {
  }

  public FlowerPackage(String kind, String color, double price) {
    this.kind = kind;
    this.color = color;
    this.price = price;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
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
    if (!(o instanceof FlowerPackage)) return false;
    FlowerPackage aFlowerPackage = (FlowerPackage) o;
    return Double.compare(aFlowerPackage.getPrice(), getPrice()) == 0 &&
            Objects.equals(getKind(), aFlowerPackage.getKind()) &&
            Objects.equals(getColor(), aFlowerPackage.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getKind(), getColor(), getPrice());
  }

  @Override
  public String toString() {
    return "FlowerPackage:" +
            " kind='" + kind + '\'' +
            ", color='" + color + '\'' +
            ", price=" + price;
  }
}
