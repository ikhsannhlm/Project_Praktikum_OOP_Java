package Interface;
import Main.User;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Scanner input;
    private CurrentUser currentUser;
    private List<User> userList;

    public MainMenu(CurrentUser currentUser, List<User> userList) {
        input = new Scanner(System.in);
        this.currentUser = currentUser;
        this.userList = userList;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public void showMenu() {
        short option;
        boolean loop = true;

        while (loop) {
            displayMenu();
            option = getUserOption();

            switch (option) {
                case 1:
                    ChatMenu chatMenu = new ChatMenu(currentUser, userList);
                    chatMenu.showChatMenu();
                    break;
                case 2:
                    displayStatus();
                    break;
                case 3:
                    System.out.println("Calls");
                    // Implementasi logika untuk fitur panggilan
                    break;
                case 4:
                    System.out.println("Community");
                    // Implementasi logika untuk fitur komunitas
                    break;
                case 5:
                    System.out.println("Setting");
                    // Implementasi logika untuk fitur pengaturan
                    break;
                case 6:
                    System.out.println("Goodbye...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
                    break;
            }
        }

        input.close();
    }

    private void displayMenu() {
        System.out.println();
        Logo logo = new Logo();
        logo.logo2();
        displayStatus();
        System.out.println("Menu: ");
        System.out.println("1. Chat");
        System.out.println("2. Status");
        System.out.println("3. Calls");
        System.out.println("4. Community");
        System.out.println("5. Setting");
        System.out.println("6. Exit");
        System.out.print("Your option: ");
    }

    private short getUserOption() {
        short option = 0;
        boolean validOption = false;

        while (!validOption) {
            try {
                option = input.nextShort();
                input.nextLine();
                validOption = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.\n");
                input.nextLine();
            }
        }

        return option;
    }
    
    private void displayStatus() {
        currentUser.displayUserInfo();
    }

}
