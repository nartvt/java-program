package program.com.exercise06;

import java.time.LocalDate;

public class TransactionGold extends Transaction {
    private String typeGold;

    public TransactionGold(String codeTransaction, LocalDate dateTransaction, int price, int amount, String typeGold) {
        super(codeTransaction, dateTransaction, price, amount);
        this.typeGold = typeGold;
    }

    public TransactionGold() {

    }

    /**
     * @return the typeGold
     */
    public String getTypeGold() {
        return typeGold;
    }

    /**
     * @param typeGold the typeGold to set
     */
    public void setTypeGold(String typeGold) {
        this.typeGold = typeGold;
    }

    @Override
    public double chargeTransaction() {
        return (this.getAmount()*this.getPrice());
    }


    @Override
    public String toString() {
        return "TransactionGold" +super.toString()+
            " typeGold='" + this.typeGold + "'" +
            "}";
    }


}