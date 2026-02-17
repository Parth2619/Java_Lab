import java.util.ArrayList;

public class MainBook {
    public static void main(String[] args) throws InvalidGenreException , InvalidPriceException {
        try {
            Book b1 = new Book("How to get 9 CGPA", "Kavish", "978", "Boring", 500);

            ArrayList<Book> alb = new ArrayList<>();
            alb.add(b1);
            Book b2 = new Book("How to get 0 CGPA", "robert", "978", "tp", 300);
            alb.add(b2);
            Book b3 = new Book("Harry Potter", "K J Rowling", "978", "Best", 400);
            alb.add(b3);

            Book b4 = new Book(b3);
            b4.title = "Harry Potter and the Sorcerer's Stone";
            b4.price = 450;
            alb.add(b4);
            
            Book b5 = new Book("Inferno", "Dan Brown", "978", "Thriller", 350);

            Book b6 = new Book("My experiment with truth", "Mystery", "978", "Biography", 400);
        ArrayList<Book> alb2 = new ArrayList<>(alb);
        alb2.add(b5);
        alb2.add(b6);
        alb.addAll(alb2);


        System.out.println("All Books:");
        alb.forEach(b -> { {
                System.out.println("Title: " + b.getTitle());
                System.out.println("Author: " + b.getAuthor());
                System.out.println("ISBN: " + b.getISBN());
                System.out.println("Genre: " + b.getGenre());
                System.out.println("Price: " + b.getPrice());
                System.out.println();
            }
        });

            alb.forEach(e -> {int w = ((b1.getPrice()+ b2.getPrice()+ b3.getPrice()+ b5.getPrice()+ b6.getPrice())/5); System.out.println("Average Price: " + w);});
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
        }
    }
}
