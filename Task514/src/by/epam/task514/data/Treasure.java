package by.epam.task514.data;

import java.util.Objects;

public class Treasure {
  private String name;
  private String material;
  private String product;
  private int price;
  private boolean available;

  public Treasure() {
    available = true;
  }

  public Treasure(String name, String material, String product, int price) {
    this.name = name;
    this.material = material;
    this.product = product;
    this.price = price;
    available = true;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Treasure)) return false;
    Treasure treasure = (Treasure) o;
    return Double.compare(treasure.getPrice(), getPrice()) == 0 &&
            Objects.equals(getName(), treasure.getName()) &&
            Objects.equals(getMaterial(), treasure.getMaterial()) &&
            Objects.equals(getProduct(), treasure.getProduct());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getMaterial(), getProduct(), getPrice());
  }

  @Override
  public String toString() {
    return "Treasure{" +
            "name='" + name + '\'' +
            ", material='" + material + '\'' +
            ", product='" + product + '\'' +
            ", price=" + price +
            '}';
  }
}

