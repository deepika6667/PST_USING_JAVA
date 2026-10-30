import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance += amount;
            System.out.printf("Deposit successful. Balance: %.2f%n", balance);
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. Balance: %.2f%n", balance);
        }
    }

    void checkBalance() {
        System.out.printf("Current Balance: %.2f%n", balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double initialBalance = sc.nextDouble();
        BankAccount account = new BankAccount(initialBalance);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                default:
                    System.out.println("Invalid transaction type");
            }
        }

        sc.close();
    }
}
OUTPUT:
1000
4
1 500
2 200
3
2 2000


Deposit successful. Balance: 1500.00
Withdrawal successful. Balance: 1300.00
Current Balance: 1300.00
Insufficient balance
