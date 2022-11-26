package org.Globant.endpoints;

/**
 * Represents a bank transaction.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class BankTransaction {
    /**
     * The number id of the bank transaction.
     */
    private int id;

    /**
     * The customer's name.
     */
    private String name;

    /**
     * The customer's last name.
     */
    private String lastName;

    /**
     * The account number associated to the bank transaction.
     */
    private int accountNumber;

    /**
     * The amount of money associated to the bank transaction.
     */
    private double amount;

    /**
     * The type of transaction.
     */
    private String transactionType;

    /**
     * The customer's email.
     */
    private String email;

    /**
     * The status of the bank transaction.
     */
    private boolean active;

    /**
     * The customer's country of residence.
     */
    private String country;

    /**
     * The customer's cellphone number.
     */
     private String telephone;

    /**
     * Constructor method for the Bank Transaction class.
     */
    public BankTransaction() {}

    /**
     * Creates a bank transaction with minimal requirements.
     * @param name The customer's name.
     * @param lastName The customer's last name.
     * @param accountNumber The account number associated to the bank transaction.
     * @param amount The amount of money associated to the bank transaction.
     * @param transactionType The type of transaction.
     * @param email The customer's email.
     * @param active The status of the bank transaction.
     * @param country The customer's country of residence.
     * @param telephone The customer's cellphone number.
     *
     */
    public BankTransaction(String name, String lastName, int accountNumber, double amount, String transactionType, String email, boolean active, String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }

    /** Gets the number id of the bank transaction.
     * @return An integer representing the number id of the bank transaction.
     */
    public int getId() { return id; }

    /** Gets the customer’s name.
     * @return A string representing the customer’s name.
     */
    public String getName() {
        return name;
    }

    /** Gets the customer’s last name.
     * @return A string representing the customer’s last name.
     */
    public String getLastName() {
        return lastName;
    }

    /** Gets the account number associated to the bank transaction.
     * @return An integer representing the account number associated to the bank transaction.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /** Gets the amount of money associated to the bank transaction.
     * @return A double representing the amount of money associated to the bank transaction.
     */
    public double getAmount() {
        return amount;
    }

    /** Gets the type of transaction.
     * @return A string representing the type of transaction.
     */
    public String getTransactionType() {
        return transactionType;
    }

    /** Gets the customer's email.
     * @return A string representing the customer's email.
     */
    public String getEmail() {
        return email;
    }

    /** Gets the status of the bank transaction.
     * @return A boolean representing the status of the bank transaction.
     */
    public boolean isActive() {
        return active;
    }

    /** Gets the customer's country of residence.
     * @return A string representing the customer's country of residence.
     */
    public String getCountry() {
        return country;
    }

    /** Gets the customer's cellphone number.
     * @return A string representing the customer's cellphone number.
     */
    public String getTelephone() {
        return telephone;
    }

    /** Sets the customer’s name.
     * @param name A string containing the customer’s name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Sets the customer’s last name.
     * @param lastName A string containing the customer’s last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Sets the account number associated to the bank transaction.
     * @param accountNumber An integer containing the account number associated to the bank transaction.
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /** Sets the amount of money associated to the bank transaction.
     * @param amount A double containing the amount of money associated to the bank transaction.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Sets the type of transaction.
     * @param transactionType A string containing the type of transaction.
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /** Sets the customer's email.
     * @param email A string containing the customer's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Sets the status of the bank transaction.
     * @param active A boolean containing the status of the bank transaction.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /** Sets the customer's country of residence.
     * @param country A string containing the customer's country of residence.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /** Sets the customer's cellphone number.
     * @param telephone A string containing the customer's cellphone number.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
