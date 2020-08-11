package program.com.exercise05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    private List<Book> books;
    private Scanner scanner;

    public BookLibrary() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public List<Book> getBooks() {
        return this.books;
    }

    private int getIndexBook(String bookCode) {
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getBookCode().equalsIgnoreCase(bookCode)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isExistBook(String bookCode) {
        if (this.getIndexBook(bookCode) == -1) {
            return false;
        }
        return true;
    }

    public void addNewBook(Book book) {
        this.getBooks().add(book);
    }

    public double chargeBookText() {
        double charge = 0;
        for (Book book : this.books) {
            if (book instanceof BookText) {
                charge = charge + book.chargeBook();
            }
        }
        return charge;
    }

    public double chargeBookReference() {
        double charge = 0;
        for (Book book : this.books) {
            if (book instanceof BookReference) {
                charge = charge + book.chargeBook();
            }
        }
        return charge;
    }

    public double chargeBooks() {
        return this.chargeBookReference() + this.chargeBookText();
    }

    public void printfBooksReference() {
        for (Book book : this.books) {
            if (book instanceof BookReference) {
                System.out.println(book.toString());
            }
        }
    }

    public void printfBooksText() {
        for (Book book : this.books) {
            if (book instanceof BookText) {
                System.out.println(book.toString());
            }
        }
    }

    public void printfBooks() {
        for (Book book : this.books) {
            System.out.println(book.toString());
        }
    }

    public void bookProgramMenu() {
        System.out.println("\n=====Book Management Program=====");
        System.out.println("1. Add new a Book");
        System.out.println("2. Charge for Book Text");
        System.out.println("3. Charge for Book Reference");
        System.out.println("4. Charge for all of Book");
        System.out.println("5. Print all of Book Text");
        System.out.println("6. Print all of Reference");
        System.out.println("7. Print  all of Book");
        System.out.println("8. Exit Program");
        System.out.print("Choose: ");
        int choose = Integer.valueOf(scanner.nextLine());
        if (choose == 8) {
            System.out.println("Book Management Program End ");
        } else {
            if (choose != 1 && this.getBooks().isEmpty()) {
                System.out.print("The Books of Library is Empty, please input least a book !");
                this.bookProgramMenu();
            } else {
                this.chooseProgram(choose);
                this.bookProgramMenu();
            }
        }

    }

    public void chooseProgram(int choose) {
        switch (choose) {
        case 1:
            this.subMenu();
            break;
        case 2:
            double chargeOfBookText = this.chargeBookText();
            System.out.println("Charge all of Book Text: " + chargeOfBookText);
            break;
        case 3:
            double chargeOfBookReference = this.chargeBookReference();
            System.out.println("Charge all of Book Reference: " + chargeOfBookReference);
            break;
        case 4:
            double chargeOfBooks = this.chargeBooks();
            System.out.println("Charge all of Books in the Library: " + chargeOfBooks);
            break;
        case 5:
            this.printfBooksText();
            break;
        case 6:
            this.printfBooksReference();
            break;
        case 7:
            this.printfBooks();
            break;
        default:
            System.out.println("This option doesn't exist, please try another option !");
            break;
        }
    }

    private void inputBook(Book book) {
        boolean isExist = false;
        String bookCode = "";

        System.out.println("Enter Book Code: ");
        bookCode = scanner.nextLine();
        if (this.isExistBook(bookCode)) {
            System.out.println("This Book Code has exist, please enter other book code !");
            // recursive instead of loop
            inputBook(book);
        } else {
            System.out.print("Enter name of book: ");
            String nameOfBook = scanner.nextLine();
            System.out.print("Enter input date(dd/MM/yyyy): ");
            String inputDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDateOfBook = LocalDate.parse(inputDate, formatter);
            System.out.print("Enter Amount Book: ");
            int amountBook = Integer.valueOf(scanner.nextLine());
            System.out.print("Enter Price of Book: ");
            int priceOfBook = Integer.valueOf(scanner.nextLine());
            System.out.print("Enter publishing Book: ");
            String publishingBook = scanner.nextLine();
            book.setBookCode(bookCode);
            book.setNameOfBook(nameOfBook);
            book.setInputDateOfBook(inputDateOfBook);
            book.setAmountBook(amountBook);
            book.setPriceOfBook(priceOfBook);
            book.setPublishingBook(publishingBook);

        }

    }

    public void subMenu() {
        int choose = 0;
        System.out.println("=========================");
        System.out.println("1. Book Text");
        System.out.println("2. Book Reference");
        System.out.println("3. Exit Program");
        System.out.print("Choose: ");
        choose = Integer.valueOf(scanner.nextLine());
        if (choose == 3) {
            System.out.println("Input Book End ");
        } else {
            Book book = null;
            switch (choose) {
            case 1:
                book = new BookText();
                this.inputBook(book);
                System.out.print("Enter Book Status: \n");
                System.out.print("1.NEW\n2.OLD\n:");
                int status = Integer.valueOf(scanner.nextLine());
                if (status == 1) {
                    ((BookText) book).setBookStatus(BookStatus.NEW.toString());
                } else if (status == 2) {
                    ((BookText) book).setBookStatus(BookStatus.OLD.toString());
                }
                this.addNewBook(book);
                break;
            case 2:
                book = new BookReference();
                this.inputBook(book);
                System.out.print("Enter tax of Book: ");
                double taxOfBook = Double.valueOf(scanner.nextLine());
                ((BookReference) book).setTaxOfBook(taxOfBook);
                this.addNewBook(book);
                break;
            default:
                System.out.println("This option doesn't exist, please try another option !");
                break;
            }
            // recursive instead of loop
            this.subMenu();
        }

    }

}