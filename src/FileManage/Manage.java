package FileManage;

import java.io.File;

public class Manage {
    private String flag;

    Manage(String location, String flag) {
        this.flag = flag;
        manage(new File(location));
    }

    // Handle Empty Folders
    void manage(File location) {
        File[] files = location.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) manage(f);
                createFolderAddFiles(f, location, getExt(f));
            }
        }
    }

    protected String getExt(File filename) {
        String[] ext = filename.toString().split("\\.");
        return ext[ext.length - 1];
    }

    protected void createFolderAddFiles(File path, File location, String ext) {
        File b = new File(location.toString() + "\\" + ext.toUpperCase());
        System.out.println(b.mkdir());
        System.out.println(path.renameTo(new File(b.getPath() + "\\" + path.getName())));
    }
}