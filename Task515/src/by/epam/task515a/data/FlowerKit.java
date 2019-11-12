package by.epam.task515a.data;

public class FlowerKit extends Flower{
  private int amount;

  public FlowerKit() {
  }

  public FlowerKit(int amount) {
    this.amount = amount;
  }

  public FlowerKit(String kind, int length, String color, double price, int amount) {
    super(kind, length, color, price);
    this.amount = amount;
  }

  public FlowerKit(FlowerKit flowerKit) {
    super(flowerKit.getKind(), flowerKit.getLength(), flowerKit.getColor(), flowerKit.getPrice());
    this.amount = flowerKit.getAmount();
  }

  public FlowerKit(Flower flower, int amount) {
    super(flower);
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return getKind()+
            ": length='" + getLength()+ '\'' +
            ", color='" + getColor()+ '\'' +
            ", price=" + getPrice() +
            ", available=" + amount;
  }
}
