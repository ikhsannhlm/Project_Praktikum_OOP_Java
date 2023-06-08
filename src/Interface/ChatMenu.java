package Interface;
import Main.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChatMenu {
    private Scanner input;
    private CurrentUser currentUser;
    private List<User> userList;

    public ChatMenu(CurrentUser currentUser, List<User> userList) {
        this.currentUser = currentUser;
        this.userList = userList;
        input = new Scanner(System.in);
    }

    public void showChatMenu() {
        Logo logo = new Logo();
        short choice;
        boolean loop = true;

        do {
            User user1 = new User("upin", "088");
            User user2 = new User("ipin", "089");
            userList.add(user1);
            userList.add(user2);
            currentUser.addContact(user1);
            currentUser.addContact(user2);

            logo.logo2();
            System.out.println("Chat");
            System.out.println("--------");
            System.out.println("Available Private Chats:");
            currentUser.displayReceivedChat();
            System.out.println("Available Group Chats:");
            System.out.println("No groups Available\n");
            System.out.println("Menu: ");
            System.out.println("1. New Personal Chat");
            System.out.println("2. New Group");
            System.out.println("3. New Contacts");
            System.out.println("4. New Broadcast");
            System.out.println("5. Show Chat");
            System.out.println("6. Pinned Chat");
            System.out.println("7. Starred Chat");
            System.out.println("8. Archive Chat");
            System.out.println("9. Delete Chat");
            System.out.println("10. Open Camera");
            System.out.println("11. Search something");
            System.out.println("12. Back to main menu");
            System.out.print("\nYour choice: ");

            // try catch digunakan untuk menghindari masalah input
            try {
                choice = input.nextShort();
                input.nextLine();
                processChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.\n");
                showChatMenu();
            }
        } while (loop);
    }

    public void processChoice(short choice) {
        switch (choice) {
            case 1:
                boolean loop1 = true;
                do {
                    currentUser.displayContactList();
                    System.out.print("To: ");
                    String receiver = input.nextLine();
                    User user = currentUser.getContactByUsername(receiver);
                    if (user != null) {
                        System.out.print("Message: ");
                        String message = input.nextLine();
                        // Kirim pesan personal
                        ChatRoomPrivate pc = new ChatRoomPrivate();
                        pc.sendMessage(currentUser, user, message);
                    } else {
                        System.out.println("Username not found. Please enter a valid contact username.");
                    }
                    System.out.print("Chat with another user? (Y/N): ");
                    String option1 = input.nextLine();
                    if (option1.equalsIgnoreCase("N")) {
                        loop1 = false;
                    }
                } while (loop1);
                break;
            case 2:
                boolean loop2 = true;
                boolean loop21 = true;
                do {
                    System.out.println("New Group");
                    System.out.print("Group Name: ");
                    String groupName = input.nextLine();
                    Group group = new Group(groupName);
                    currentUser.displayContactList();
                    do {
                        System.out.print("Add member (type username): ");
                        String memberName = input.nextLine();
                        User member = currentUser.getContactByUsername(memberName);
                        if (member != null) {
                            group.addMember(member);
                        } else {
                            System.out.println("Username not found. Please enter a valid contact username.");
                        }
                        System.out.print("Add more members? (Y/N): ");
                        String option2 = input.nextLine();
                        if (option2.equalsIgnoreCase("N")) {
                            loop21 = false;
                        }
                    } while (loop21);
                    System.out.print("Make more Groups? (Y/N): ");
                    String option21 = input.nextLine();
                    if (option21.equalsIgnoreCase("N")) {
                        loop2 = false;
                    }
                } while (loop2);
                break;
            case 3:
                boolean loop3 = true;
                do {
                    System.out.println("New Contacts");
                    User user = null;
                    System.out.print("Username: ");
                    String username = input.nextLine();
                    System.out.print("Number: ");
                    String number = input.nextLine();
                    user = new User(username, number);
                    currentUser.addContact(user);

                    System.out.print("Add again? (Y/N): ");
                    String option3 = input.nextLine();

                    if (option3.equalsIgnoreCase("N")) {
                        loop3 = false;
                    }
                } while (loop3);
                break;
            case 4:
                System.out.println("New Broadcast");
                System.out.println("Coming Soon..");
                break;
            case 5:
                System.out.println("Show Chat");
                System.out.println("Coming Soon..");
                break;
            case 6:
                System.out.println("Pinned Chat");
                System.out.println("Coming Soon..");
                break;
            case 7:
                System.out.println("Starred Chat");
                System.out.println("Coming Soon..");
                break;
            case 8:
                System.out.println("Archive Chat");
                System.out.println("Coming Soon..");
                break;
            case 9:
                System.out.println("Delete Chat");
                System.out.println("Coming Soon..");
                break;
            case 10:
                System.out.println("Open Camera");
                System.out.println("Coming Soon..");
                break;
            case 11:
                System.out.println("Search something");
                System.out.println("Coming Soon..");
                break;
            case 12:
                System.out.println("Back to main menu");
                break;
            default:
                System.out.println(choice + " is not available");
                System.out.println("Please try again..\n");
        }
    }
}