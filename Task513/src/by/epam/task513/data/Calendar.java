package by.epam.task513.data;


import java.util.ArrayList;
import java.util.Objects;

public class Calendar {
  private int day;
  private int month;
  private int year;
  ArrayList<Holiday> holidays;

  private class Holiday {
    String name;
    private int day;
    private int month;
    private int year;

    public Holiday() {
    }

    public Holiday(String name, int day, int month, int year) {
      this.name = name;
      if (year > 1901 && year < 2100)
        this.year = year;
      else
        this.year = 2019;
      if (month > 0 && month <= 12)
        this.month = month;
      else
        this.month = 1;
      if (day > 0)
        if ((month == 2 && day <= 28 && year % 4 != 0) ||
              (month == 2 && day <= 29 && year % 4 == 0) ||
              ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) ||
                ((month == 1 || month == 3 || month == 5 || month == 7 ||
                        month == 8 || month == 10 || month == 12) && day <= 31))
          this.day = day;
    }

    @Override
    public String toString() {
      return "Holiday{ " + name +
              " " + day +
              "." + month +
              "." + year +
              '}';
    }
  }

  public Calendar() {
    holidays = new ArrayList<Holiday>();
  }

  public Calendar(int day, int month, int year) {
    if (year > 1901 && year < 2100)
      this.year = year;
    else
      this.year = 2019;
    if (month > 0 && month <= 12)
      this.month = month;
    else
      this.month = 1;
    if (day > 0) {
      if (checkDay(day, month, year)) {
        this.day = day;
      }
    } else {
      this.day = 1;
    }
    holidays = new ArrayList<Holiday>();
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  private boolean checkDay(int day, int month, int year) {
    return (month == 2 && day <= 28 && year % 4 != 0) ||
            (month == 2 && day <= 29 && year % 4 == 0) ||
            ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) ||
            ((month == 1 || month == 3 || month == 5 || month == 7 ||
                    month == 8 || month == 10 || month == 12) && day <= 31);
  }

  public boolean setMonth(int month) {
    if (month > 0 && month <= 12) {
      this.month = month;
      return true;
    }
    return false;
  }

  public int getYear() {
    return year;
  }

  public boolean setYear(int year) {
    if (year > 1901 && year < 2100) {
      this.year = year;
      return true;
    }
    return false;
  }

  public Holiday getHolidays(int index) {
    return holidays.get(index);
  }

  public ArrayList<Holiday> getHolidays() {
    return holidays;
  }

  public void setHolidays(ArrayList<Holiday> holidays) {
    this.holidays = holidays;
  }

  public void setData (int day, int month, int year) {
    if (year > 1901 && year < 2100)
      this.year = year;
    else
      this.year = 2019;
    if (month > 0 && month <= 12)
      this.month = month;
    else
      this.month = 1;
    if (day > 0) {
      if (checkDay(day, month, year)) {
        this.day = day;
      }
    } else {
      this.day = 1;
    }
  }

  public void addHoliday (String name, int day, int month, int year) {
    holidays.add(new Holiday(name, day, month, year));
  }

  public String checkData () {
    for (Holiday holiday : holidays) {
      if (holiday.day == this.day &&
          holiday.month == this.month &&
          holiday.year == this.year) {
        return "On this day is " + holiday.name;
      }
    }
    return "We can meet on this day ";
  }
  public void deleteHoliday (int index) {
    holidays.remove(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Calendar)) return false;
    Calendar calendar = (Calendar) o;
    return getDay() == calendar.getDay() &&
            getMonth() == calendar.getMonth() &&
            getYear() == calendar.getYear() &&
            Objects.equals(getHolidays(), calendar.getHolidays());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDay(), getMonth(), getYear(), getHolidays());
  }

  @Override
  public String toString() {
    return "Calendar{" +
            "day=" + day +
            ", month=" + month +
            ", year=" + year +
            ", holidays=" + holidays +
            '}';
  }
}
