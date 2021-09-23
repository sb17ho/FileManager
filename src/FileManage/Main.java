package FileManage;

import java.util.Scanner;

public class Main {

    Main() {
//        System.out.println("Do you want to manage files recursively (Y/N)? ");
//        String flag = new Scanner(System.in).toString();
//        /media/simar/TestFolder
//        C:\Users\simar\Documents\Apple photos
        Manage m = new Manage("/media/simar/TestFolder", "N", System.getProperty("os.name").toLowerCase());
    }

    public static void main(String[] args) {
        new Main();
    }
}
