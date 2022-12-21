import java.io.IOException;
import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

    CalorieCounting c = new CalorieCounting();
    CampCleanup ca = new CampCleanup();

    ca.start();


    }
    public void selectPuzzle(){

        System.out.println("Suchen Sie sich ein Puzzle aus mit Zahlen von 1-52");
        int eingabe = sc.nextInt();
    }
}