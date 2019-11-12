package by.epam.task515b.data;

public class SweetKit extends Sweetness{
  private int amount;

  public SweetKit() {
  }

  public SweetKit(String kind, String name, String manufacturer, double price, int amount) {
    super(kind, name, manufacturer, price);
    this.amount = amount;
  }

  // конструктор копирования
  public SweetKit(SweetKit sweetKit) {
    super(sweetKit.getKind(), sweetKit.getName(),
            sweetKit.getManufacturer(), sweetKit.getPrice());
    this.amount = sweetKit.getAmount();
  }

  public SweetKit(Sweetness sweetness, int amount) {
    super(sweetness);
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
    return super.toString() +
            ", amount=" + amount +
            '}';
  }
}
