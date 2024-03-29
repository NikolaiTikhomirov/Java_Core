package market;

import market.exceptions.FileNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Backup {
    public void printListFiles(String source){
        File path = new File(new File(source).getPath());
        File[] dir = path.listFiles();
        for (File file : dir) {
            if (file.isDirectory()) continue;
            System.out.println(file);
        }
    }

    public List<File> getListFiles(String source){
        File path = new File(new File(source).getPath());
        List<File> listFiles = new ArrayList<>();
        for (File file : path.listFiles()) {
            if (file.isDirectory()) continue;
            listFiles.add(file);
        }
        return listFiles;
    }

    private void copyFile(String source, String target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

    public void copyFilesInPath (String source, String target){
        File path = new File(new File(target).getPath());
        if (!path.exists()) {
            new File(path.getPath()).mkdirs();
        }
        for (File listFile : getListFiles(source)) {
            try {
                copyFile(listFile.getPath(), target + listFile.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
