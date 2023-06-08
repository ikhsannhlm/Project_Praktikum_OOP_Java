package Interface;
import Main.User;

public class CurrentUser extends User {
    public CurrentUser(String username, String number) {
        super(username, number);
    }

    // Contoh method khusus untuk CurrentUser
    public void updateUserStatus(String status) {
        // Implementasi logika untuk mengubah status pengguna
        // ...
    }

    // Contoh method lain yang menggunakan atribut dan method dari kelas User
    public void displayUserInfo() {
        System.out.println("Username: " + getUsername());
        System.out.println("Number: " + getNumber());
    }
}
