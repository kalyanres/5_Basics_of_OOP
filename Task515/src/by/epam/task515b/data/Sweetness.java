package by.epam.task515b.data;

public class Sweetness {
  private String kind;
  private String name;
  private String manufacturer;
  private double price;

  public Sweetness() {
  }

  public Sweetness(String kind, String name, String manufacturer, double price) {
    this.kind = kind;
    this.name = name;
    this.manufacturer = manufacturer;
    this.price = price;
  }

  // конструктор копирования
  public Sweetness(Sweetness sweetness) {
    this.kind = sweetness.getKind();
    this.name = sweetness.getName();
    this.manufacturer = sweetness.getManufacturer();
    this.price = sweetness.getPrice();
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

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return kind +
            ": name='" + name + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", price=" + price;
  }
}
