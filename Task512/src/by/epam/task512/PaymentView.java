package by.epam.task512;

public class PaymentView {

  private Payment payment;

  public PaymentView() {
  }

  public PaymentView(Payment payment) {
    this.payment = payment;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public void showPayment() {
    for (int i = 0; i < payment.getSize(); i++) {
      System.out.println(payment.getString(i));
    }
  }

}
