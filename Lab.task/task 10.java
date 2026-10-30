import java.util.*;

class AuthenticationSystem {
    private final String username = "admin";
    private final String password = "Secure123";
    private int failedAttempts = 0;
    private boolean locked = false;

    synchronized boolean login(String user, String pass) {
        if (locked) {
            return false;
        }

        if (username.equals(user) && password.equals(pass)) {
            failedAttempts = 0;
            return true;
        }

        failedAttempts++;

        if (failedAttempts >= 3) {
            locked = true;
        }

        return false;
    }

    synchronized boolean isLocked() {
        return locked;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AuthenticationSystem auth = new AuthenticationSystem();

        int totalAttempts = 100;
        int success = 0;
        int failure = 0;

        for (int i = 0; i < totalAttempts; i++) {
            if (auth.login("admin", "wrongPassword")) {
                success++;
            } else {
                failure++;
            }
        }

        System.out.println("Total Login Attempts: " + totalAttempts);
        System.out.println("Successful Logins: " + success);
        System.out.println("Failed Logins: " + failure);
        System.out.println("Account Locked: " + auth.isLocked());
        System.out.println("Stress Test Completed");
    }
}

OUTPUT:
Total Login Attempts: 100
Successful Logins: 0
Failed Logins: 100
Account Locked: true
Stress Test Completed
