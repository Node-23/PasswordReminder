package Classes;

import java.io.IOException;

import javax.swing.JOptionPane;

public class PasswordManager {

    public static void addPassword(String local, String userName, String password) throws IOException {
        PasswordObject passwordObject = new PasswordObject(local, userName, password);
        ArrayManager.passwordList.add(passwordObject);
        JOptionPane.showMessageDialog(null, "successful added", "Password Reminder",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void deletePassword(String local) {
        int index = ArrayManager.findLocal(local);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Local does not exists!", "Password Reminder",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayManager.passwordList.remove(index);
        }
    }

    public static void loadList() {

    }

}
