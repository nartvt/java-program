package program.com.exercise06;

import java.time.LocalDate;

public abstract class Transaction {
    private String codeTransaction;
    private LocalDate dateTransaction;
    private double price;
    private int amount;

    protected Transaction(String codeTransaction, LocalDate dateTransaction, double price, int amount) {
        this.codeTransaction = codeTransaction;
        this.dateTransaction = dateTransaction;
        this.price = price;
        this.amount = amount;
    }

    protected Transaction() {
    }

    /**
     * @return the codeTransaction
     */
    public String getCodeTransaction() {
        return codeTransaction;
    }

    /**
     * @param codeTransaction the codeTransaction to set
     */
    public void setCodeTransaction(String codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    /**
     * @return the dateTransaction
     */
    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    /**
     * @param dateTransaction the dateTransaction to set
     */
    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract double chargeTransaction();

    @Override
    public String toString() {
        return "{" + " codeTransaction='" + this.codeTransaction + "'" + ", dateTransaction='" + this.dateTransaction
                + "'" + ", price='" + this.price + "'" + ", amount='" + this.amount + "'";
    }

}