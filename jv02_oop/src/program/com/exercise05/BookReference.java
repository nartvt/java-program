package program.com.exercise05;

import java.time.LocalDate;

public class BookReference extends Book {
    private double taxOfBook;

    public BookReference() {
        super();
    }

    public BookReference(String bookCode, String nameOfBook, LocalDate inputDateOfBook, int amountBook, int priceOfBook,
            String publishingBook, double taxOfBook) {
        super(bookCode, nameOfBook, inputDateOfBook, amountBook, priceOfBook, publishingBook);
        this.taxOfBook = taxOfBook;
    }

    public double getTaxOfBook() {
        return this.taxOfBook;
    }

    public void setTaxOfBook(double taxOfBook) {
        this.taxOfBook = taxOfBook;
    }

    @Override
    public double chargeBook() {
        return (this.amountBook * this.priceOfBook) * this.taxOfBook;
    }

    @Override
    public String toString() {
        return "BookReference" + super.toString() + " taxOfBook='" + getTaxOfBook() + "'" + "}";
    }

}