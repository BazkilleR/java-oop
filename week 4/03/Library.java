
public class Library {

    public String libraryName;
    public Book book1;
    public Book book2;
    public Book book3;

    public void addBook(Book book, int slot) {
        switch (slot) {
            case 1:
                book1 = book;
                break;
            case 2:
                book2 = book;
                break;
            case 3:
                book3 = book;
                break;
            default:
                System.out.println("Invalid slot number.");
        }
    }

    public void removeBook(int slot) {
        switch (slot) {
            case 1:
                book1 = null;
                break;
            case 2:
                book2 = null;
                break;
            case 3:
                book3 = null;
                break;
            default:
                System.out.println("Invalid slot number.");
        }
    }

    public void printLibraryDetails() {
        System.out.println("Library: " + libraryName);
        System.out.println();

        if (book1 != null) {
            printBookDetails(book1);
        } else {
            System.out.println("No book in this slot.");
        }
        System.out.println();

        if (book2 != null) {
            printBookDetails(book2);
        } else {
            System.out.println("No book in this slot.");
        }
        System.out.println();

        if (book3 != null) {
            printBookDetails(book3);
        } else {
            System.out.println("No book in this slot.");
        }
    }

    public void checkBookAvailability(int slot) {
        boolean status = false;
        String bookTitle = "Unknown";

        switch (slot) {
            case 1:
                if (book1 != null) {
                    status = true;
                    bookTitle = book1.title;
                }
                break;
            case 2:
                if (book2 != null) {
                    status = true;
                    bookTitle = book2.title;
                }
                break;
            case 3:
                if (book3 != null) {
                    status = true;
                    bookTitle = book3.title;
                }
                break;
            default:
                System.out.println("Invalid slot number.");
                return;
        }

        if (status) {
            System.out.println(bookTitle + " is available.");
        } else {
            System.out.println("Book in slot " + slot + " is not available.");
        }
    }

    public void updateBookPrice(int slot, double newPrice) {
        boolean status = false;
        String bookTitle = "Unknown";

        switch (slot) {
            case 1:
                if (book1 != null) {
                    status = true;
                    book1.price = newPrice;
                    bookTitle = book1.title;
                }
                break;
            case 2:
                if (book2 != null) {
                    status = true;
                    book2.price = newPrice;
                    bookTitle = book2.title;
                }
                break;
            case 3:
                if (book3 != null) {
                    status = true;
                    book3.price = newPrice;
                    bookTitle = book3.title;
                }
                break;
            default:
                System.out.println("Invalid slot number.");
                return;
        }

        if (status) {
            System.out.println("Updated price of " + bookTitle + " to $" + newPrice + ".");
        } else {
            System.out.println("No book in this slot.");
        }
    }

    public void printBookDetails(Book book) {
        if (book != null) {
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Publisher: " + book.publisher);
            System.out.println("Year Published: " + book.yearPublished);
            System.out.println("Price: $" + book.price);
            System.out.println("Available: " + (book.isAvailable ? "Yes" : "No"));
        } else {
            System.out.println("No book in this slot.");
        }
    }
}
