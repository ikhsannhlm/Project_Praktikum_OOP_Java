// Abstraction 
package Main;
public abstract class ChatRoom {
    public abstract void sendMessage(User sender, User recipient, String content);
}
