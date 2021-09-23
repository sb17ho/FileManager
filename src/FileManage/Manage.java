package FileManage;

import java.io.File;

public class Manage {
    private String separator;

    Manage(String location, String flag, String OS) {
        if (OS.contains("linux")) {
            separator = "/";
        } else if (OS.contains("win") || OS.contains("windows")) {
            separator = "\\";
        }
        manage(new File(location));
    }

    // Handle Empty Folders
    void manage(File location) {
        File[] files = location.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory() && !extensionNamedFolder(f)) {
                    manage(f);
                } else {
                    continue;
                }
                createFolderAddFiles(f, location, getExt(f));
            }
        }
    }

    protected boolean extensionNamedFolder(File directory) {
        return directory.getName().equals(getExt(directory).toUpperCase());
    }

    protected String getExt(File filename) {
        String[] ext = filename.toString().split("\\.");
        return ext[ext.length - 1];
    }

    protected void createFolderAddFiles(File path, File location, String ext) {
        File b = new File(location.toString() + separator + ext.toUpperCase());
        System.out.println(b.mkdir());
        System.out.println(path.renameTo(new File(b.getPath() + separator + path.getName())));
    }
}