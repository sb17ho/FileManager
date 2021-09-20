package FileManage;

import java.io.File;
import java.util.Objects;

public class Manage {

    private final File file;
    private String flag;

    Manage(String location, String flag) {
        file = new File(location);
        this.flag = flag;
        manage(location);
    }

    // Handle Empty Folders
    void manage(String location) {
        if (file.listFiles() != null && Objects.requireNonNull(file.listFiles()).length > 0) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                String filename = f.getPath();
                createFolderAddFiles(f, location, getExt(filename));
            }
        }
    }

    protected String getExt(String filename) {
        String[] ext = filename.split("\\.");
        return ext[ext.length - 1];
    }

    protected void createFolderAddFiles(File path, String location, String ext) {
        File b = new File(location + "\\" + ext.toUpperCase());
        System.out.println(b.mkdir());
        System.out.println(path.renameTo(new File(b.getPath() + "\\" + path.getName())));
    }
}