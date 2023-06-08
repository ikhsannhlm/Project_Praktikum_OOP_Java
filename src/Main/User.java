package Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private String number;
    private List<User> contactList;
    private List<Message> chatList;

    public User(String username, String number) {
        this.username = username;
        this.number = number;
        this.contactList = new ArrayList<>();
        this.chatList = new ArrayList<>();
    }

    // Mendapatkan Username User
    public String getUsername() {
        return username;
    }

    // Mendapatkan Nomor User
    public String getNumber() {
        return number;
    }

    // Menambahkan Kontak kedalam List Kontak User
    public void addContact(User user) {
        contactList.add(user);
    }

    // Menampilkan Daftar list Kontak
    public void displayContactList() {
        System.out.println("Contact " + username + ": ");
        for (User contact : contactList) {
            System.out.println(contact.getUsername() + " (" + contact.getNumber() + ")");
        }
        System.out.println();
    }
    
    // Mengirimkan Chat
    public void sendMessage(User recipient, String content) {
        Message message = new Message(this, recipient, content);
        recipient.receiveMessage(message);
        chatList.add(message);
    }

    // Menerima Chat dan menyimpannya ke dalam chatList 
    public void receiveMessage(Message message) {
        chatList.add(message);
    }

    // Menampilkan List Chat Private User
    public void displayChatList(User user) {
        System.out.println("Chat List for User: " + username + " with "+ user);
        boolean found = false;
        for (Message message : chatList) {
            if ((message.getSender().equals(this) && message.getRecipientUser().equals(user))
                    || (message.getSender().equals(user) && message.getRecipientUser().equals(this))) {
                System.out.println(message);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No messages found");
        }
        System.out.println();
    }

    // Menampilkan List Chat User dengan User lain
    public void displayReceivedChat() {    
        Map<User, Message> lastMessages = new HashMap<>();
        for (Message message : chatList) {
            if (message.getRecipientUser() != null && message.getRecipientUser().equals(this)) {
                User sender = message.getSender();
                lastMessages.put(sender, message);
            }
        }
    
        if (lastMessages.isEmpty()) {
            System.out.println("No received messages found");
        } else {
            for (Message message : lastMessages.values()) {
                String sender = message.getSender().getUsername();
                String content = message.getContent();
                System.out.println(sender + ": " + content);
            }
        }
        System.out.println();
    }
    
        // Override kelas object agar menghasilkan info yang dibutuhkan method DisplayChatList diatas
    public String toString() {
        return username;
    }

    // Mendapatkan objek User yang sesuai dengan nama penerima
    public User getContactByUsername(String username) {
        for (User contact : contactList) {
            if (contact.getUsername().equals(username)) {
                return contact;
            }
        }
        return null;
    }
    
}


