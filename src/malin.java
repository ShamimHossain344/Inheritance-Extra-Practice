// Base class
class bankAccount {
    private String accountHolder;
    private double balance;

    public bankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        balance -= amount; // Base class doesn't handle overdraft
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account Holder: " + accountHolder + ", Balance: " + balance;
    }
}

// Subclass
class BasicAccount extends bankAccount {

    public BasicAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient funds. Withdrawal denied.");
        } else {
            super.withdraw(amount);
        }
    }
}

// Example Usage
public class main {
    public static void main(String[] args) {
        basicAccount account = new basicAccount("John Doe", 100.0);

        System.out.println(account); // Output: Account Holder: John Doe, Balance: 100.0

        account.deposit(50.0);
        System.out.println("Balance after deposit: " + account.getBalance()); // Output: 150.0

        account.withdraw(30.0);
        System.out.println("Balance after withdrawal: " + account.getBalance()); // Output: 120.0

        account.withdraw(200.0); // Insufficient funds
        System.out.println("Balance: " + account.getBalance()); // Output: 120.0
    }
}
