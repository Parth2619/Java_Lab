import java.util.Scanner;

public class color {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter a color to find the IPL team:");
        System.out.print("\nYour choice: ");

        String color = scanner.nextLine().toLowerCase();

        switch (color) {
            case "blue":
                System.out.println("\nTeam: Mumbai Indians");
                break;
            case "yellow":
                System.out.println("\nTeam: Chennai Super Kings");
                break;
            case "red":
                System.out.println("\nTeam: Royal Challengers Bangalore");
                break;
            case "purple":
                System.out.println("\nTeam: Kolkata Knight Riders");
                break;
            case "orange":
                System.out.println("\nTeam: Sunrisers Hyderabad");
                break;
            case "pink":
                System.out.println("\nTeam: Rajasthan Royals");
                break;
            case "green":
                System.out.println("\nTeam: Delhi Capitals");
                break;
            default:
                System.out.println("\nInvalid color! Please enter a valid IPL team color.");
                break;
        }

        scanner.close();
    }
}
