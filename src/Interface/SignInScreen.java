package Interface;
import Main.User;

import java.util.List;
import java.util.Scanner;

public class SignInScreen {
    private List<User> userList;
    private Scanner input;

    public SignInScreen(List<User> userList) {
        this.userList = userList;
        input = new Scanner(System.in);
    }

    public CurrentUser signIn() {
        System.out.println();
        System.out.println("###########");
        System.out.println("# Sign In #");
        System.out.println("###########");
        System.out.print("Enter your username: ");
        String username = input.nextLine();
        System.out.print("Enter your number: ");
        String number = input.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getNumber().equals(number)) {
                return new CurrentUser(user.getUsername(), user.getNumber());
            }
        }

        return null;
    }
}
