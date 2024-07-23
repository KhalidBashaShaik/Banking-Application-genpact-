package System.Model;
public class Transaction {
    private String accountNumber;
    private String transactionType;
    private double amount;
    private String description;
    private String transactionDate;

    // Constructor
    public Transaction(String accountNumber, String transactionType, double amount, String description, String transactionDate) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    // Setters (optional)
    public void setTransactionId(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Transaction [accountNumber=" + accountNumber + ", transactionType=" + transactionType + 
               ", amount=" + amount + ", description=" + description + ", transactionDate=" + transactionDate + "]";
    }
}
