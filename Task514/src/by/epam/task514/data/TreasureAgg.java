package by.epam.task514.data;

import java.util.ArrayList;
import java.util.Objects;

public class TreasureAgg {

  ArrayList<Treasure> treasures;

  public TreasureAgg() {
    treasures = new ArrayList<Treasure>();
  }

  public TreasureAgg(ArrayList<Treasure> treasures) {
    this.treasures = treasures;
  }

  public int getSize() {
    return treasures.size();
  }

  public Treasure getTreasure(int index) {
    return treasures.get(index);
  }

  public ArrayList<Treasure> getTreasures() {
    return treasures;
  }

  public void setTreasures(ArrayList<Treasure> treasures) {
    this.treasures = treasures;
  }

  // добавление элемента
  public void addTreasure(Treasure treasure) {
    treasures.add(treasure);
  }

  // удаление элемента
  public void deleteTreasure(int index) {
    treasures.remove(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TreasureAgg)) return false;
    TreasureAgg that = (TreasureAgg) o;
    return Objects.equals(getTreasures(), that.getTreasures());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTreasures());
  }

  @Override
  public String toString() {
    return "TreasureAgg{" +
            "treasures=" + treasures +
            '}';
  }
}
