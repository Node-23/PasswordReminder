package Classes;

import java.io.IOException;

import javax.swing.JOptionPane;

public class View {
    public static void viewer() throws IOException {
        while(true){
            int option;
            option = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "-OPTIONS-\n" + 
                        "1- List passwords\n" + 
                        "2- Add a password\n"+ 
                        "3- Delete a password\n" + 
                        "0- Exit\n","PasswordReminder", JOptionPane.QUESTION_MESSAGE));
            switch(option){
                case 1:
                    ArrayManager.printList();    
                    break;
                case 2:
                    String localToAdd = JOptionPane.showInputDialog(null,"Password from: ", JOptionPane.QUESTION_MESSAGE);
                    if (ArrayManager.localPasswordRepeted(localToAdd)) {
                        JOptionPane.showMessageDialog(null, "Local already exists!", "Password Reminder",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    String userName = JOptionPane.showInputDialog(null,"UserName: ", JOptionPane.QUESTION_MESSAGE);
                    String password = JOptionPane.showInputDialog(null,"Password: ", JOptionPane.QUESTION_MESSAGE);
                    PasswordManager.addPassword(localToAdd,userName,password);
                    break;
                case 3:
                String localToDelete = JOptionPane.showInputDialog(null,"Password from: ", JOptionPane.QUESTION_MESSAGE);
                    PasswordManager.deletePassword(localToDelete);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Bye", "Password Reminder",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option!", "Password Reminder",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        FileManager.updateFile();
        }
    }

}
