// Base class
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        balance -= amount; // No overdraft check or penalty in the base class
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
class basicAccount extends bankAccount {
    private static final double OVERDRAFT_PENALTY = 30.0;

    public basicAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Overdraft occurred. Charging a penalty of $" + OVERDRAFT_PENALTY);
            super.withdraw(amount + OVERDRAFT_PENALTY);
        } else {
            super.withdraw(amount);
        }
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        basicAccount account = new basicAccount("John Doe", 100.0);

        System.out.println(account); // Account Holder: John Doe, Balance: 100.0

        account.deposit(50.0);
        System.out.println("Balance after deposit: " + account.getBalance()); // Balance after deposit: 150.0

        account.withdraw(30.0);
        System.out.println("Balance after withdrawal: " + account.getBalance()); // Balance after withdrawal: 120.0

        account.withdraw(200.0); // This will cause an overdraft and apply a penalty
        System.out.println("Balance after overdraft withdrawal: " + account.getBalance());
    }
}
