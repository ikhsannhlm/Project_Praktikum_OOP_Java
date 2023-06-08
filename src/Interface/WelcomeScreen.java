package Interface;
import java.util.Scanner;

public class WelcomeScreen {
    private Scanner input;

    public WelcomeScreen() {
        input = new Scanner(System.in);
    }

    public String getOption() {
        System.out.println();
        System.out.println("#####################");
        System.out.println("# Welcome to Chatty #");
        System.out.println("#####################");
        System.out.print("Apakah Anda sudah memiliki akun? (y/n): ");
        return input.nextLine();
    }
}
