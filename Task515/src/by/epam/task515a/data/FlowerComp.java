package by.epam.task515a.data;

import java.util.ArrayList;
import java.util.Objects;

public class FlowerComp {
  ArrayList<FlowerKit> flowers;
  FlowerPackage packages;

  public FlowerComp() {
    flowers = new ArrayList<FlowerKit>();
  }

  public FlowerComp(ArrayList<FlowerKit> flowers, FlowerPackage packages) {
    this.flowers = flowers;
    this.packages = packages;
  }

  public ArrayList<FlowerKit> getFlowerKits() {
    return flowers;
  }

  public void setFlowerKits(ArrayList<FlowerKit> flowers) {
    this.flowers = flowers;
  }

  public FlowerPackage getPackages() {
    return packages;
  }

  public void setPackages(FlowerPackage packages) {
    this.packages = packages;
  }

  public FlowerKit getFlowerKit(int index) {
    return flowers.get(index);
  }

  public void addFlowerKit(Flower flower, int amount) {
    flowers.add(new FlowerKit(flower, amount));
  }

  public void removeFlowerKit(int index) {
    flowers.remove(index);
  }

  public void removeFlowerKit(FlowerKit flower) {
    flowers.remove(flower);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FlowerComp)) return false;
    FlowerComp that = (FlowerComp) o;
    return Objects.equals(getFlowerKits(), that.getFlowerKits()) &&
            Objects.equals(getPackages(), that.getPackages());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFlowerKits(), getPackages());
  }

  @Override
  public String toString() {
    String string = "Your flower composition {\n";
    for (int i = 0; i < flowers.size(); i++) {
      string = string + flowers.get(i).toString() + '\n';
    }
    string += packages.toString();
    return string;
  }
}
