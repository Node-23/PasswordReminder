package Classes;

import java.io.IOException;

import javax.swing.JOptionPane;

public class PasswordManager {

    public static void addPassword(String local, String userName, String password) throws IOException {
        PasswordObject passwordObject = new PasswordObject(local, userName, password);
        ArrayManager.passwordList.add(passwordObject);
        JOptionPane.showMessageDialog(null, "successful added", "Password Reminder", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void deletePassword(String local) {
        int index = ArrayManager.findLocal(local);
        ArrayManager.passwordList.remove(index);
        JOptionPane.showMessageDialog(null, "Local deleted!", "Password Reminder", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void change(String local) {
        int index = ArrayManager.findLocal(local);
        String userName = View.dataNullVerification("", true);
        String password = View.dataNullVerification(userName, false);
        if (userName != null && password != null) {
            ArrayManager.passwordList.remove(index);
            ArrayManager.passwordList.add(index, new PasswordObject(local, userName, password));
            JOptionPane.showMessageDialog(null, "Local changed!", "Password Reminder", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operation canceled!", "Password Reminder",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
