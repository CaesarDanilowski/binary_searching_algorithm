import com.cezarydanilowski.*;
import java.util.Scanner;
import java.util.Random;

/**
 * Program shows how binary searching algorithm works. Automatic or manual.
 * @author Cezary Daniłowski
 * @version 1.0 2019-03-09
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random generator = new Random();
    private static int upRange = -1;
    private static int shot;
    private static int looked;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("BinnarySearching (C) 2019");
        choice();

        scanner.close();
    }

    static void choice() throws InterruptedException {
        System.out.print("Automatic | Manual | Exit\n > ");
        String choice = scanner.next();

        while (!choice.equals("Exit") || !choice.equals("exit")) {
            if (choice.equals("Automatic") || choice.equals("automatic")) {
                automatic();
            } else if (choice.equals("Manual") || choice.equals("manual")) {
                manual();
            } else if (choice.equals("Exit") || choice.equals("exit")) {
                System.exit(0);
            } else {
                System.err.print("There isn't such function!\n > ");
                choice();
            }

            System.out.print("\nAutomatic | Manual | Exit\n > ");
            choice = scanner.next();
        }
    }

    static void automatic() throws InterruptedException {
        int upRange = -1;
        int looked;
        int shot;

        while (upRange < 0) {
            upRange = generator.nextInt();
        }

        System.out.print("Please enter up range: ");
        Thread.sleep(2000);
        System.out.print(upRange + "\n");
        looked = generator.nextInt(upRange);

        shot = upRange / 2 + 1;
        System.out.print("Please enter your shot: ");
        Thread.sleep(2000);
        System.out.print(shot + "\n");

        BinarySearchingNumber binary = new BinarySearchingNumber(upRange, looked, shot);
        binary.automaticSolving();
    }

    static void manual() {
        System.out.print("Please enter up range: ");
        upRange = scanner.nextInt();

        looked = generator.nextInt(upRange);

        System.out.print("Please enter your shot: ");
        shot = scanner.nextInt();

        BinarySearchingNumber binary = new BinarySearchingNumber(upRange, looked, shot);

        while (!binary.isCorrect()) {
            binary.check();
            shot = scanner.nextInt();
            binary = new BinarySearchingNumber(upRange, looked, shot);
        }

        binary.check();
        System.out.print(looked + "\n");
    }
}
