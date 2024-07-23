package System.Model;
public class Customers {
    private int id;
    private String fullname;
    private String address;
    private String mobile;
    private String email;
    private String accountType;
    private String dob;
    private String idProofType;
    private String idProofInput;
    private String accountNumber;
    private String password;
    private double Balance;  // Changed balance to Balance

    public Customers(int id, String fullname, String address, String mobile, String email,
                     String accountType, String dob, String idProofType, String idProofInput,
                     String accountNumber, String password, double Balance) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.accountType = accountType;
        this.dob = dob;
        this.idProofType = idProofType;
        this.idProofInput = idProofInput;
        this.accountNumber = accountNumber;
        this.password = password;
        this.Balance = Balance;  // Initialize Balance
    }

    // Getters and Setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

    public String getIdProofInput() {
        return idProofInput;
    }

    public void setIdProofInput(String idProofInput) {
        this.idProofInput = idProofInput;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
}
