import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("CreditCard payment processed");
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("UPI payment processed");
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("NetBanking payment processed");
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        payment.pay(amount);

        if (payment instanceof CreditCardPayment) {
            return amount * 1.02;
        } else if (payment instanceof UPIPayment) {
            return amount * 1.01;
        } else if (payment instanceof NetBankingPayment) {
            return amount * 1.015;
        }

        return amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        OnlinePaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < N; i++) {
            int type = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String paymentType;

            if (type == 1) {
                payment = new CreditCardPayment();
                paymentType = "CreditCard";
            } else if (type == 2) {
                payment = new UPIPayment();
                paymentType = "UPI";
            } else {
                payment = new NetBankingPayment();
                paymentType = "NetBanking";
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n", paymentType, finalAmount);
        }

        sc.close();
    }
}
OUTPUT:
3
1 1000
2 2000
3 5000
CreditCard 1020.00
UPI 2020.00
NetBanking 5075.00
