 BankingTransactionSystem :
import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: Rs." + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: Rs." + amount);
            System.out.println("Withdrawal successful.");
        }
    }

    void showBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    void showDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs." + balance);
    }

    void showTransactions() {
        System.out.println("\nTransaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions.");
            return;
        }

        for (String transaction : transactions)
            System.out.println(transaction);
    }
}

public class BankingTransactionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account =
                new BankAccount("ACC101", "Manideepika", 5000);

        while (true) {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Amount: Rs.");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Amount: Rs.");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.showBalance();
                    break;

                case 4:
                    account.showDetails();
                    break;

                case 5:
                    account.showTransactions();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

OUTPUT:

C:\Users\Deepu\Downloads>javac BankingTransactionSystem.java

C:\Users\Deepu\Downloads>java BankingTransactionSystem

===== BANKING SYSTEM =====
1. Deposit
2. Withdraw
3. Check Balance
4. Account Details
5. Transaction History
6. Exit
Choice: 1
Amount: Rs.1000000
Deposit successful.

===== BANKING SYSTEM =====
1. Deposit
2. Withdraw
3. Check Balance
4. Account Details
5. Transaction History
6. Exit
Choice: 2
Amount: Rs.5000
Withdrawal successful.

===== BANKING SYSTEM =====
1. Deposit
2. Withdraw
3. Check Balance
4. Account Details
5. Transaction History
6. Exit
Choice: 3
Balance: Rs.1000000.0

===== BANKING SYSTEM =====
1. Deposit
2. Withdraw
3. Check Balance
4. Account Details
5. Transaction History
6. Exit
Choice: 4

Account Number: ACC101
Account Holder: Manideepika
Balance: Rs.1000000.0

===== BANKING SYSTEM =====
1. Deposit
2. Withdraw
3. Check Balance
4. Account Details
5. Transaction History
6. Exit
Choice: 5

Transaction History:
Deposited: Rs.1000000.0
Withdrawn: Rs.5000.0

===== BANKING SYSTEM =====
1. Deposit
2. Withdraw
3. Check Balance
4. Account Details
5. Transaction History
6. Exit
Choice: 6
Thank you!
