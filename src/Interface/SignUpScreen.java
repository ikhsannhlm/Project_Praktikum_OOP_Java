package Interface;
import Main.User;

import java.util.List;
import java.util.Scanner;

public class SignUpScreen {
    private List<User> userList;
    private Scanner input;

    public SignUpScreen(List<User> userList) {
        this.userList = userList;
        input = new Scanner(System.in);
    }

    public CurrentUser signUp() {
        System.out.println();
        System.out.println("###########");
        System.out.println("# Sign Up #");
        System.out.println("###########");
        System.out.print("Enter your username: ");
        String username = input.nextLine();
        System.out.print("Enter your number: ");
        String number = input.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getNumber().equals(number)) {
                System.out.println("User with the same username and number already exists. Please try again.\n");
                return null;
            }
        }

        User newUser = new User(username, number);
        userList.add(newUser);
        return new CurrentUser(newUser.getUsername(), newUser.getNumber());
    }
}
