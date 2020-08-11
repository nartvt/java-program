package program.com.exercise05;

import java.time.LocalDate;

public class BookText extends Book {

    private String bookStatus;

    public BookText() {
        super();
    }

    public BookText(String bookCode, String nameOfBook, LocalDate inputDateOfBook, int amountBook, int priceOfBook,
            String publishingBook, String bookStatus) {
        super(bookCode, nameOfBook, inputDateOfBook, amountBook, priceOfBook, publishingBook);
        this.bookStatus = bookStatus;
    }

    public String getBookStatus() {
        return this.bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "BookText" + super.toString() + " bookStatus='" + getBookStatus() + "'" + "}";
    }

    @Override
    public double chargeBook() {
        if (this.bookStatus.equalsIgnoreCase(BookStatus.NEW.toString())) {
            return this.amountBook * this.priceOfBook;
        }
        return this.amountBook * this.priceOfBook * 0.5;

    }

}