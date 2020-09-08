package Classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ArrayManager {
   public static ArrayList<PasswordObject> passwordList = new ArrayList<>();

    public static boolean localPasswordRepeted(String local) {
        for (PasswordObject list : passwordList) {
            if(list.getLocal().equals(local)){
                return true;
            }
        }
        return false;
    }
    
    public static int findLocal(String local) {
        for (PasswordObject list : passwordList) {
            if(list.getLocal().equals(local)){
                return passwordList.indexOf(list);
            }
        }
        return -1;
    }

    public static void printList(){
        if(passwordList.isEmpty()){
            JOptionPane.showMessageDialog(null,"The list is empty", "Password Reminder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String logList = "";
        int count = 1;
        for (PasswordObject list : passwordList) {
            logList += Integer.toString(count)+"- " + list + "\n";
            count++;
        }
        JOptionPane.showMessageDialog(null,logList, "Password Reminder",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
