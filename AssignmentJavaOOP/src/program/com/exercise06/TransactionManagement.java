package program.com.exercise06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionManagement {
    private List<Transaction> transactions;
    private Scanner scanner;

    public TransactionManagement() {
        transactions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menuProgram() {
        int option = 0;
        System.out.println("=====Transaction Program=====");
        System.out.println("1. Add new transaction");
        System.out.println("2. Total Transaction Gold");
        System.out.println("3. Total Transaction Currentcy");
        System.out.println("4. Average Transaction Currentcy");
        System.out.println("5. Transaction over one Billion");
        System.out.println("6. Exit Program");
        System.out.print("Choose: ");
        option = Integer.valueOf(scanner.nextLine());
        if (option == 6) {
            System.out.println("Transaction Program End");
        } else {
            if (option != 1 && this.getTransactions().isEmpty()) {
                System.out.println("We don't have any Transaction, Please input least a transaction !");
                this.menuProgram();
            } else {
                this.optionProgram(option);
                this.menuProgram();
            }
        }
    }

    private void optionProgram(int option) {
        switch (option) {
        case 1:
            this.subMenu();
            break;
        case 2:
            this.sumTransactionGold();
            break;
        case 3:
            this.sumTransactionCurrentcy();
            break;
        case 4:
            this.avgRevenueTransactionCurrentcy();
            break;

        case 5:
            this.transactionBillion();
            break;
        default:
            System.out.println("This option doesn't exist, please try another option !");
            break;
        }
    }

    private void inputTransaction(Transaction transaction) {
        System.out.print("Enter Transaction Code: ");
        String codeTransaction = scanner.nextLine();
        if (this.getTransactionsIndex(codeTransaction) != -1) {
            System.out.println("This transaction code has exists , please input other !");
            inputTransaction(transaction);
        } else {
            transaction.setCodeTransaction(codeTransaction);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Enter Transaction date with format dd/MM/yyyy: ");
            String inputDate = scanner.nextLine();
            LocalDate dateTransaction = LocalDate.parse(inputDate, formatter);
            transaction.setDateTransaction(dateTransaction);
            System.out.print("Enter Price of transaction: ");
            double priceTransaction = Double.valueOf(scanner.nextLine());
            transaction.setPrice(priceTransaction);
            System.out.print("Enter Amount of Transaction: ");
            int amount = Integer.valueOf(scanner.nextLine());
            transaction.setAmount(amount);
        }
    }

    private void subMenu() {
        System.out.println("======================");
        System.out.println("1. Transaction Currentcy");
        System.out.println("2. Transaction Gold");
        System.out.println("3. Back to main Program: ");
        int optionSub = Integer.valueOf(scanner.nextLine());
        if (optionSub == 3) {
            System.out.println("Input Transaction to  End !");
        } else {
            Transaction transaction = null;
            switch (optionSub) {
            case 1:
                transaction = new TransactionCurrency();
                this.inputTransaction(transaction);
                System.out.println("Enter Exchange Rate of Transaction: ");
                int exchangeRate = Integer.valueOf(scanner.nextLine());
                ((TransactionCurrency) transaction).setExchangeRate(exchangeRate);
                boolean isMoneyType = false;
                do {
                    System.out.println("Enter Type Of Money(1.VND 2.USD 3. EURO): ");
                    int type = Integer.valueOf(scanner.nextLine());
                    switch (type) {
                    case 1:
                        ((TransactionCurrency) transaction).setTypeMoney(TransactionEnum.VND.toString());
                        isMoneyType = true;
                        break;
                    case 2:
                        ((TransactionCurrency) transaction).setTypeMoney(TransactionEnum.USD.toString());
                        isMoneyType = true;
                        break;
                    case 3:
                        ((TransactionCurrency) transaction).setTypeMoney(TransactionEnum.EURO.toString());
                        isMoneyType = true;
                        break;
                    default:
                        System.out.println("This type not exist, please try input again !");
                        break;
                    }

                } while (!isMoneyType);
                this.addTransaction(transaction);
                break;
            case 2:
                transaction = new TransactionGold();
                this.inputTransaction(transaction);
                System.out.print("Enter type of Gold: ");
                String typeGold = scanner.toString();
                ((TransactionGold) transaction).setTypeGold(typeGold);
                this.addTransaction(transaction);
                break;
            default:
                System.out.println("We don't have any Transaction, Please input least a transaction !");
                break;
            }
            this.subMenu();
        }
    }

    private void addTransaction(Transaction transaction) {
        this.getTransactions().add(transaction);
    }

    private int getTransactionsIndex(String codeTransaction) {
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getCodeTransaction().equalsIgnoreCase(codeTransaction)) {
                return i;
            }
        }
        return -1;
    }

    private void printfTransactions() {
        for (Transaction transaction : this.transactions) {
            System.out.println(transaction.toString());
        }
    }

    private void sumTransactionGold() {
        int sumGold = 0;
        for (Transaction trasaction : this.transactions) {
            if (trasaction instanceof TransactionGold) {
                sumGold++;
            }
        }
        if (sumGold > 0) {
            System.out.println("TransactionGold have  " + sumGold + " transaction !");
        } else {
            System.out.println("TransactionGold doesn't any transaction !");
        }
    }

    private void sumTransactionCurrentcy() {
        int sumCurrency = 0;
        for (Transaction trasaction : this.transactions) {
            if (trasaction instanceof TransactionCurrency) {
                sumCurrency++;
            }
        }
        if (sumCurrency > 0) {
            System.out.println("TransactionCurrency have  " + sumCurrency + " transaction !");
        } else {
            System.out.println("TransactionCurrency doesn't any transaction !");
        }
    }

    private void avgRevenueTransactionCurrentcy() {
        int sumCurrency = 0;
        double totalRevenue = 0;
        for (Transaction trasaction : this.transactions) {
            if (trasaction instanceof TransactionCurrency) {
                sumCurrency++;
                totalRevenue += trasaction.chargeTransaction();
            }
        }
        if (sumCurrency > 0) {
            System.out.println("Average transactionCurrency have  " + (totalRevenue / sumCurrency));
        } else {
            System.out.println("TransactionCurrency doesn't any transaction !");
        }
    }

    private void transactionBillion() {
        for (Transaction trasaction : this.transactions) {
            if (trasaction.chargeTransaction() > 1000000000) {
                System.out.println(trasaction.toString());
            }
        }

    }

    /**
     * @return the transactions
     */
    private List<Transaction> getTransactions() {
        return transactions;
    }

}