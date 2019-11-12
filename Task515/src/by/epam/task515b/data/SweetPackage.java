package by.epam.task515b.data;

public class SweetPackage {
  private String kind;
  private String name;
  private double price;

  public SweetPackage(String kind) {
    this.kind = kind;
  }

  public SweetPackage(String kind, String name, double price) {
    this.kind = kind;
    this.name = name;
    this.price = price;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Подарочная упаковка: " +
            "kind='" + kind + '\'' +
            ", name='" + name + '\'' +
            ", price=" + price;
  }
}
