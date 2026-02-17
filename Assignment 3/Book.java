public class Book {
    public String title;
    public String author;
    public String ISBN;
    public String genre;
    public int price;

    // Default constructor
    public Book() {
        this.title = "";
        this.author = "";
        this.ISBN = "";
        this.genre = "";
        this.price = 0;
    }


    public Book(String t, String a, String i, String g, int p) throws InvalidPriceException , InvalidGenreException
    {
        this.title = t;
        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative: " + p);
        }
        if (!g.equalsIgnoreCase("Action") && !g.equalsIgnoreCase("Biography") && !g.equalsIgnoreCase("Best") && !g.equalsIgnoreCase("Boring") && !g.equalsIgnoreCase("Thriller")) {
            throw new InvalidGenreException("Invalid genre: " + g);
        }
        this.author = a;
        this.ISBN = i;
        this.genre = g;
        this.price = p;
    }


    // Copy constructor
    public Book(Book b) {
        this.title = b.title;
        this.author = b.author;
        this.ISBN = b.ISBN;
        this.genre = b.genre;
        this.price = b.price;
    }


    public String getTitle() {
        
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }
}
