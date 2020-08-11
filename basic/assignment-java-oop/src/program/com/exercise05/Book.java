package program.com.exercise05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Book {
    protected String bookCode;
    protected String nameOfBook;
    protected LocalDate inputDateOfBook;;
    protected int amountBook;
    protected int priceOfBook;
    protected String publishingBook;

    public Book() {
    }

    protected Book(String bookCode, String nameOfBook, LocalDate inputDateOfBook, int amountBook, int priceOfBook,
            String publishingBook) {
        this.bookCode = bookCode;
        this.nameOfBook = nameOfBook;
        this.inputDateOfBook = inputDateOfBook;
        this.amountBook = amountBook;
        this.priceOfBook = priceOfBook;
        this.publishingBook = publishingBook;
    }

    public String getBookCode() {
        return this.bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getNameOfBook() {
        return this.nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public LocalDate getInputDateOfBook() {
        return this.inputDateOfBook;
    }

    public void setInputDateOfBook(LocalDate inputDateOfBook) {
        this.inputDateOfBook = inputDateOfBook;
    }

    public int getAmountBook() {
        return this.amountBook;
    }

    public void setAmountBook(int amountBook) {
        this.amountBook = amountBook;
    }

    public int getPriceOfBook() {
        return this.priceOfBook;
    }

    public void setPriceOfBook(int priceOfBook) {
        this.priceOfBook = priceOfBook;
    }

    public String getPublishingBook() {
        return this.publishingBook;
    }

    public void setPublishingBook(String publishingBook) {
        this.publishingBook = publishingBook;
    }

    public abstract double chargeBook();

    @Override
    public String toString() {
        return "{" + " bookCode='" + bookCode + "'" + ", nameOfBook='" + nameOfBook + "'" + ", inputDateOfBook='"
                + inputDateOfBook + "'" + ", amountBook='" + amountBook + "'" + ", priceOfBook='" + priceOfBook + "'"
                + ", publishingBook='" + publishingBook + "'";
    }
}