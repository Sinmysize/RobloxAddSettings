import java.io.File;
import java.nio.file.Files;
import javax.swing.JOptionPane;

public class Test{
    public static void main(String[] args) {

        String path = "C:\\Program Files (x86)\\Roblox\\Versions";
        File reader = new File(path);

        String fileName = "ClientAppSettings.json";

        File[] contents = reader.listFiles();

        for (int i = 0; i < 1; i++) {
            if (contents[1].isDirectory()) {
                String file = contents[1].getName();
                String fileDir = path + "\\" + file + "\\" + "ClientSettings";

                System.out.println(fileDir);

                File folder = new File(fileDir);
                File source = new File("Settings.json");
                File settings = new File(fileDir + "\\" + fileName);

                try {
                    if (!folder.exists()) {
                        if (folder.mkdirs()) {
                            JOptionPane.showMessageDialog(null, "Client Settings Has Been Added To Roblox!");
                            Files.copy(source.toPath(), settings.toPath());
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Run As Administrator.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "This File May Already Exist or The Roblox Version Is Outdated.");
                    }
        
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry. Could Not Find Latest Roblox Version.");
            }
        }       
    }
}