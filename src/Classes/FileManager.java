package Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileManager {
    public static String path;

    public static void write(String text, String path) throws IOException {
        File file = new File(path + "\\PR.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }

    public static String read(String fileLocationString) throws IOException {
        Path data = Paths.get(fileLocationString + "\\PR.txt");
        byte[] content = Files.readAllBytes(data);
        String text = new String(content);
        return text;
    }

    public static boolean FileExist(String path) {
        return (new File(path + "\\PR.txt")).exists();

    }

    public static void updateFile() throws IOException {
        String data = "";
        for (PasswordObject list : ArrayManager.passwordList) {
            data += list.getLocal() + "-" + list.getUsername() + "-" + list.getPassword() + "\n";
        }
        FileManager.write(data, path);
    }

    public static void loadFile() throws IOException {
        if (FileExist(path)) {
            String data = read(path);
            String dataSplited[] = data.split("\n");
            for (int i = 0; i < dataSplited.length; i++) {
                String passwordObj[] = dataSplited[i].split("-");
                ArrayManager.passwordList.add(new PasswordObject(passwordObj[0], passwordObj[1], passwordObj[2]));
            }
        }else{
            write("", path);
        }
    }

    public static void directoryChooser() {
        int operation;
        JFileChooser directory = new JFileChooser();
        directory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        operation = directory.showSaveDialog(null);
        directoryChooserError(operation);
        path = directory.getSelectedFile().getAbsolutePath();
    }

    public static void directoryChooserError(int operation) {
        if (operation == 1) {
            JOptionPane.showMessageDialog(null, "Bye!", "Password Reminder", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static void createProgramData() throws IOException {
        String dir = System.getProperty("user.dir");
        if (!FileExist(dir)) {
            FileManager.directoryChooser();
            write(path, dir);
        }
        path = read(dir);
        loadFile();
    }

    

}
