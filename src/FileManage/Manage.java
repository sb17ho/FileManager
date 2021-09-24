package FileManage;

import java.io.File;
import java.util.Objects;

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

    void manage(File location) {
        File[] files = location.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory() && checkIfEmpty(f)) deleteDirectory(f);
                if (f.isDirectory() && !extensionNamedFolder(f)) {
                    manage(f);
                } else if (extensionNamedFolder(f)){
                    continue;
                }
                createFolderAddFiles(f, location, getExt(f));
            }
        }
    }

    protected void deleteDirectory(File directory) {
        System.out.println(directory.delete() ? directory.getName() + " Deleted Since Empty" : null);
    }

    protected boolean checkIfEmpty(File directory) {
        if (directory.listFiles() != null && Objects.requireNonNull(directory.listFiles()).length <= 0) {
            return true;
        }

        return false;
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
        System.out.println(b.mkdir() ? b.getName() + " Successfully Created" : b.getName() + " Already exist");
        path.renameTo(new File(b.getPath() + separator + path.getName()));
    }
}