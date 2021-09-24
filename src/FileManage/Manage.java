package FileManage;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Manage {
    private String separator;
    private final List<String> extensions;
    private File databaseFile;
    private final String databaseFileName = "extDatabase.txt";

    Manage(String location, String flag, String OS) {
        extensions = new ArrayList<>();
        if (OS.contains("linux")) {
            separator = "/";
        } else if (OS.contains("win") || OS.contains("windows")) {
            separator = "\\";
        }
        File f = new File(location);

        try {
            mkdirDatabaseFile(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!(databaseFile.length() == 0)) readFromDatabaseFile();
        manage(f, flag);
        writeToDatabaseFile();
    }

    protected void mkdirDatabaseFile(File location) throws IOException {
        databaseFile = new File(location + separator + databaseFileName);
        boolean mkdir = databaseFile.createNewFile();
        if (mkdir) System.out.println("Database File created");
        else System.out.println("Database File exists");
    }

    protected void readFromDatabaseFile() {
        try (Scanner readFile = new Scanner(databaseFile)) {
            while (readFile.hasNextLine()) {
                extensions.add(readFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void writeToDatabaseFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFile))) {
            extensions.stream().distinct().collect(Collectors.toList()).forEach((x) -> {
                try {
                    writer.write(x.toUpperCase());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void manage(File location, String flag) {
        File[] files = location.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.getName().endsWith(databaseFileName)) continue;
                if (Objects.equals(flag, "y") && f.isDirectory() && checkIfEmpty(f)) deleteDirectory(f);
                if (Objects.equals(flag, "y") && f.isDirectory() && !extensionNamedFolder(f)) {
                    manage(f, flag);
                } else if (extensionNamedFolder(f)) {
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
        String[] directoryName = directory.toString().split(separator);
        boolean ans = extensions.contains(directoryName[directoryName.length - 1]);
        return ans;
    }

    protected String getExt(File filename) {
        String[] ext = filename.toString().split("\\.");
        if (!filename.isDirectory()) extensions.add(ext[ext.length - 1]);
        return ext[ext.length - 1];
    }

    protected void createFolderAddFiles(File path, File location, String ext) {
        File b = new File(location.toString() + separator + ext.toUpperCase());
        System.out.println(b.mkdir() ? b.getName() + " Successfully Created" : b.getName() + " Already exist");
        path.renameTo(new File(b.getPath() + separator + path.getName()));
    }
}