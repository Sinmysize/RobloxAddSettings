/* Biggest Thanks To Celvis For The Help :) */

import java.io.File;
import java.nio.file.Files;
import javax.swing.JOptionPane;
public class Main{
    public static void main(String[] args) {
        String path = "C:\\Program Files (x86)\\Roblox\\Versions";
        File reader = new File(path);
        String fileName = "ClientAppSettings.json";
        File[] contents = reader.listFiles();
        File mRD = contents[0];
        for (File file : contents) {
            if (file.isDirectory() && file.lastModified() > mRD.lastModified()) {
                mRD = file;
            }
        }
        String dirName = mRD.getName();
        String fileDir = path + "\\" + dirName + "\\" + "ClientSettings";
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
                JOptionPane.showMessageDialog(null, "This File May Already Exist or Roblox Has Updated.");
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
