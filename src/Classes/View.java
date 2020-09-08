package Classes;

import java.io.IOException;

import javax.swing.JOptionPane;

public class View {
    public static void viewer() throws IOException {
        while (true) {
            int option;
            String choice = JOptionPane.showInputDialog(null,
            "-OPTIONS-\n" + "1- List passwords\n" + "2- Add a password\n" + "3- Delete a password\n"
                    + "4- Change a password\n" + "0- Exit\n",
            "PasswordReminder", JOptionPane.QUESTION_MESSAGE);
            nullOption(choice);
            option = Integer.parseInt(choice);
            switch (option) {
                case 1:
                    ArrayManager.printList();
                    break;

                case 2:
                    addView();
                    break;

                case 3:
                    deleteView();
                    break;

                case 4:
                    ChangeView();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Bye", "Password Reminder", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
            
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option!", "Password Reminder",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    public static void nullOption(String option){
       if(option == null){
            System.exit(0);
        }
    }

    public static void addView() throws IOException {
        String localToAdd = addLocalVerification();
        String userName = dataNullVerification(localToAdd, true);
        String password = dataNullVerification(userName, false);
        if (localToAdd != null && userName != null && password != null) {
            PasswordManager.addPassword(localToAdd, userName, password);
            FileManager.updateFile();
        }
    }

    public static String addLocalVerification() {
        String local;
        do {
            local = JOptionPane.showInputDialog(null, "Password from: ", JOptionPane.QUESTION_MESSAGE);
            if (!ArrayManager.localPasswordRepeted(local) && dataVerification(local)) {
                break;
            } else if (!dataVerification(local)) {
                JOptionPane.showMessageDialog(null, "Insert a valid name!", "Password Reminder",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Local already exists!", "Password Reminder",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        return local;
    }

    public static boolean dataVerification(String data) {
        if (data == "") {
            return false;
        }
        return true;
    }

    public static String dataNullVerification(String data, boolean isUserName) {
        if (data == null) {
            return null;
        }
        return dataInput(isUserName);
    }

    public static String dataInput(boolean isUserName) {
        String data;
        do {
            if (isUserName == true) {
                data = JOptionPane.showInputDialog(null, "UserName: ", JOptionPane.QUESTION_MESSAGE);
            } else {
                data = JOptionPane.showInputDialog(null, "Password: ", JOptionPane.QUESTION_MESSAGE);
            }

            if (dataVerification(data)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Insert a valid input!", "Password Reminder",
                    JOptionPane.ERROR_MESSAGE);
        } while (true);
        return data;
    }

    public static void deleteView() throws IOException {
        String localToDelete = repeatIfNotExist();
        if (localToDelete != null) {
            PasswordManager.deletePassword(localToDelete);
            FileManager.updateFile();
        }
    }

    public static void ChangeView() throws IOException {
        String localToChange = repeatIfNotExist();
        if (localToChange != null) {
            PasswordManager.change(localToChange);
            FileManager.updateFile();
        }
    }

    public static String repeatIfNotExist() {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, "Password from: ", JOptionPane.QUESTION_MESSAGE);
            if (ArrayManager.localPasswordRepeted(input)) {
                JOptionPane.showMessageDialog(null, "Local does not exists!", "Password Reminder",
                    JOptionPane.ERROR_MESSAGE);
            }else{
                break;
            }
        } while (true);
        return input;
    }
}
