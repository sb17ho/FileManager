package FileManage;

import java.util.Scanner;

public class Main {

    //TODO: Make sure to check if the directory is OS supported or matches it pattern
    Main() {
        System.out.println("Provide a directory to apply cleanup: ");
        String path = new Scanner(System.in).nextLine();
        while (path.contains(".")) {
            System.out.println("Error: Not a directory.\nPlease provide a valid directory: ");
            path = new Scanner(System.in).nextLine();
        }

        System.out.println("Do you wish to apply cleanup to all folders within the provided directory? (Y/N): ");
        String flag = new Scanner(System.in).nextLine();
        while (!(flag.toLowerCase().equals("n") || flag.toLowerCase().equals("y"))) {
            System.out.println("Not a valid input.\nExpected (Y/N): ");
            flag = new Scanner(System.in).nextLine();
        }

        Manage m = new Manage(path, flag, System.getProperty("os.name").toLowerCase());
    }

    public static void main(String[] args) {
        new Main();
    }
}
