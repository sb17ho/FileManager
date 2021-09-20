package FileManage;

import java.util.Scanner;

public class Main {

    Main() {
        System.out.println("Do you want to manage files recursively (Y/N)? ");
        String flag = new Scanner(System.in).toString();
        Manage m = new Manage("C:\\Users\\simar\\Documents\\Apple Photos", flag);
    }

    public static void main(String[] args) {
        new Main();
    }
}
