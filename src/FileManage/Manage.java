package FileManage;

import java.io.File;

public class Manage {

    File file;

    Manage(String location) {

        file = new File(location);
        manage(location);
        /*for (File f : file.listFiles()) {
            if (f.getName().equals("desktop.ini")) {
            } else {
                System.out.println(f.getName());
            }
        }
*/
    }
// left files spreadsheet file , internet files, executable files, few data files and compressed files

    void manage(String location) {
        if (file.listFiles() != null && file.listFiles().length > 0) {
            for (File f : file.listFiles()) {
                String filename = f.getPath();
                //Documents
                if (filename.contains("txt")) {
                    File b = new File(location + "\\Txt_Files");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                } else if (filename.contains("pdf")) {
                    File b = new File(location + "\\PDF_Files");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                } else if (filename.contains("doc") || filename.contains("docx") || filename.contains("wps")) {
                    File b = new File(location + "\\DocFiles");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                } // PowerPoint
                else if (filename.contains("ppt") || filename.contains("pptx") || filename.contains("pps")) {
                    File b = new File(location + "\\PowerPointFiles");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                }  //Image files
                else if (filename.contains("png") || filename.contains("jpg") || filename.contains("jpeg") || filename.contains("gif") || filename.contains("ico")) {
                    File b = new File(location + "\\ImageFiles");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                }
                //Audio Files  and Video Files
                else if (filename.contains("mp3") || filename.contains("mid") || filename.contains("midi") || filename.contains("mpa") || filename.contains("wav")) {
                    File b = new File(location + "\\AudioFiles");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                }
                // Video Files
                else if (filename.contains("wma") || filename.contains("3gp") || filename.contains("3g2") || filename.contains("wmv") || filename.contains("mpg") || filename.contains("mpeg") || filename.contains("m4v") || filename.contains("flv") || filename.contains("h264") || filename.contains("mp4")) {
                    File b = new File(location + "\\VideoFiles");
                    System.out.println(b.mkdir());
                    System.out.println(f.renameTo(new File(b.getPath() + "\\" + f.getName())));
                } else {
                    manage(location + "\\" + f.getName());
                }
            }
        }
    }
}
