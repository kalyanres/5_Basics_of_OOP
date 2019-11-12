package by.epam.task515b.data;

import java.util.ArrayList;
import java.util.Objects;

public class SweetnessGift {
  private ArrayList<SweetKit> sweetKits;
  private SweetPackage sweetPackage;

  public SweetnessGift() {
    sweetKits = new ArrayList<SweetKit>();
  }

  public SweetnessGift(ArrayList<SweetKit> sweetKits, SweetPackage sweetPackage) {
    this.sweetKits = sweetKits;
    this.sweetPackage = sweetPackage;
  }

  public SweetKit getSweetKit(int index) {
    return sweetKits.get(index);
  }

  public ArrayList<SweetKit> getSweetKits() {
    return sweetKits;
  }

  public void setSweetKits(ArrayList<SweetKit> sweetKits) {
    this.sweetKits = sweetKits;
  }

  public SweetPackage getSweetPackage() {
    return sweetPackage;
  }

  public void setSweetPackage(SweetPackage sweetPackage) {
    this.sweetPackage = sweetPackage;
  }

  public void addSweetness(Sweetness sweetness, int amount) {
    sweetKits.add(new SweetKit(sweetness, amount));
  }

  public void addSweetness(SweetKit sweetKit) {
    sweetKits.add(sweetKit);
  }

  public void removeSweetness(SweetKit sweetKit) {
    sweetKits.remove(sweetKit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SweetnessGift)) return false;
    SweetnessGift that = (SweetnessGift) o;
    return Objects.equals(getSweetKits(), that.getSweetKits()) &&
            Objects.equals(getSweetPackage(), that.getSweetPackage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSweetKits(), getSweetPackage());
  }

  @Override
  public String toString() {
    String string = "Ваш подарок{ \n";
    for (int i = 0; i < sweetKits.size(); i++) {
      string = string + sweetKits.get(i).toString() + '\n';
    }
    string += sweetPackage.toString();
    return string;
  }
}
