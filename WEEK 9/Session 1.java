TASK 5:
BANK TRANSACTION SYSTEM:
import java.util.*;

class BankAccount {
    private String accountHolder;
    private long accountNumber;
    private double balance;
    private ArrayList<String> transactions;

    BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactions = new ArrayList<>();
        transactions.add("Account created with balance: Rs. " + balance);
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        balance += amount;
        transactions.add("Deposited: Rs. " + amount);
        System.out.println("Deposit successful.");
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: Rs. " + amount);
            System.out.println("Withdrawal successful.");
        }
    }

    void checkBalance() {
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }

    void showDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        checkBalance();
    }

    void showTransactions() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        long accountNumber = sc.nextLong();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accountNumber, balance);

        int choice;
        do {
            System.out.println("\n--- Banking Transaction System ---");
            System.out.println("1. Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.showDetails();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 4:
                    account.checkBalance();
                    break;

                case 5:
                    account.showTransactions();
                    break;

                case 6:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
OUTPUT:
Enter account holder name: deepika
Enter account number: 1009
Enter initial balance: 50000

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 4
Current Balance: Rs. 50000.00

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 1
Account Holder: deepika
Account Number: 1009
Current Balance: Rs. 50000.00

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 2
Enter deposit amount: 10000
Deposit successful.

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 3
Enter withdrawal amount: 10000
Withdrawal successful.

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 4
Current Balance: Rs. 50000.00

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 5

Transaction History:
Account created with balance: Rs. 50000.0
Deposited: Rs. 10000.0
Withdrawn: Rs. 10000.0

--- Banking Transaction System ---
1. Account Details
2. Deposit
3. Withdraw
4. Check Balance
5. Transaction History
6. Exit
Enter your choice: 6
Thank you for using our banking system!
