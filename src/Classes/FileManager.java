package Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public static void write(String text) throws IOException {
        File file = new File("C://Matheus//Test.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }

    public static String read(String fileLocationString) throws IOException {
        Path path = Paths.get(fileLocationString);
        byte[] content = Files.readAllBytes(path);
        String text = new String(content);
        return text;
    }

    public static boolean FileExist() {
        boolean exists = (new File("C://Matheus//Test.txt")).exists();
        return exists;
    }

    public static void updateFile() throws IOException {
        String file = "";
        for (PasswordObject list : ArrayManager.passwordList) {
            file += list.getLocal() + "-" + list.getUsername() + "-" + list.getPassword() + "\n";
        }
        FileManager.write(file);
    }

    public static void loadFile() throws IOException {
        if (FileExist()) {
            String data = read("C://Matheus//Test.txt");
            String dataSplited[] = data.split("\n");
            for (int i = 0; i < dataSplited.length; i++) {
                String passwordObj[] = dataSplited[i].split("-");
                ArrayManager.passwordList.add(new PasswordObject(passwordObj[0], passwordObj[1], passwordObj[2]));
            }
        }
    }
}
