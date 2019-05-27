package program.com.exercise06;

import java.time.LocalDate;

public class TransactionCurrency extends Transaction {
    private int exchangeRate;
    private String typeMoney;

    public TransactionCurrency() {
    }

    public TransactionCurrency(String codeTransaction, LocalDate dateTransaction, int price, int amount,
            int exchangeRate, String typeString) {
        super(codeTransaction, dateTransaction, price, amount);
        this.exchangeRate = exchangeRate;
        this.typeMoney = typeString;
    }

    /**
     * @return the exchangeRate
     */
    public int getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @param exchangeRate the exchangeRate to set
     */
    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getTypeMoney() {
        return this.typeMoney;
    }

    public void setTypeMoney(String typeMoney) {
        this.typeMoney = typeMoney;
    }

    @Override
    public double chargeTransaction() {
        if (this.typeMoney.equalsIgnoreCase(TransactionEnum.USD.toString())
                || this.typeMoney.equalsIgnoreCase(TransactionEnum.EURO.toString())) {
            return this.getAmount() * this.getPrice() * this.exchangeRate;
        } else {
            return this.getAmount() * this.getPrice();
        }
    }

}