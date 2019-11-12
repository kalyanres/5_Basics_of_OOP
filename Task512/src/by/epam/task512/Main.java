package by.epam.task512;

/*
 *Задача 2.
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.
 */
public class Main {

    public static void main(String[] args) {

      Payment payment = new Payment();

      // добавляем товары
      payment.addGood("AMD Ryzen 5 3600", "USA", 2019, 414.10);
      payment.addGood("Gigabyte B450M DS3H", "Taiwan", 2018, 139.33);
      payment.addGood("SSD Samsung 860 Evo 1TB MZ-76E1T0", "Korea", 2018, 297.11);
      payment.addGood("Crucial Ballistix Sport LT 2x8GB DDR4", "USA", 2018, 177.48);
      payment.addGood("Maxsun Radeon RX 570 Diamond 8GB GDDR5", "China", 2017, 289.02);

      PaymentView paymentView = new PaymentView(payment);
      paymentView.showPayment();

      System.out.print("The full price is ");
      System.out.println(payment.getPrice());

    }

}
