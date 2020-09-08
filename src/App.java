import Classes.FileManager;
import Classes.View;

public class App {
    public static void main(String[] args) throws Exception {
        FileManager.createProgramData();
        View.viewer();
    }

    
}
