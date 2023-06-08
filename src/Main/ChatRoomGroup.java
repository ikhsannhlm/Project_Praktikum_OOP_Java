package Main;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomGroup {
    private Group group;

    // Konstructor
    public ChatRoomGroup(Group group) {
        this.group = group;
        new ArrayList<>();
    }

    // Mengirim pesan ke grup
    public void sendMessage(User sender, String content) {
        Message message = new Message(sender, group, content);
        addMessageToChatList(message);
        for (User member : group.getMembers()) {
            if (!member.equals(sender)) {
                member.receiveMessage(message);
            }
        }
    }
    
    // Menambahkan pesan ke List Chat Grup
    private void addMessageToChatList(Message message) {
        group.getGroupChatList().add(message);
    }

    // Menampilkan Grup Chat dan Last Message Grup
    public void displayGroupChatList() {
        System.out.println("Chat List for Group " + group.getGroupName() + ":");
    
        List<Message> groupChatList = group.getGroupChatList();
        if (groupChatList.isEmpty()) {
            System.out.println("No messages found");
        } else {
            Message lastMessage = groupChatList.get(groupChatList.size() - 1);
            String sender = lastMessage.getSender().getUsername();
            String content = lastMessage.getContent();
            System.out.println(group.getGroupName() + ": " + sender + ": " + content);
        }
        System.out.println();
    }
    
}