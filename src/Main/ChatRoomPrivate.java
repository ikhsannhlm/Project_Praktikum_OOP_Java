package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRoomPrivate extends ChatRoom {
    private Map<User, List<Message>> privateChatMap;

    // Konstruktor
    public ChatRoomPrivate() {
        privateChatMap = new HashMap<>();
    }

    // Override implementasi inheritance
    public void sendMessage(User sender, User recipient, String content) {
        sender.sendMessage(recipient, content);
    }

    // Menambahkan Chat ke List Chat Private
    public void addPrivateMessage(User sender, User recipient, String content) {
        List<Message> chatList = privateChatMap.getOrDefault(recipient, new ArrayList<>());
        Message message = new Message(sender, recipient, content);
        chatList.add(message);
        privateChatMap.put(recipient, chatList);
    }

    // Mendapatkan List Chat Private
    public List<Message> getPrivateChatList(User user) {
        return privateChatMap.getOrDefault(user, new ArrayList<>());
    }

    // Menampilkan List Chat Private
    public void displayPrivateChat(User user) {
        List<Message> chatList = getPrivateChatList(user);

        System.out.println("Private Chat with " + user.getUsername() + ":");

        if (chatList.isEmpty()) {
            System.out.println("No messages found");
        } else {
            for (Message message : chatList) {
                String sender = message.getSender().getUsername();
                String content = message.getContent();
                System.out.println(sender + ": " + content);
            }
        }
        System.out.println();
    }

}
