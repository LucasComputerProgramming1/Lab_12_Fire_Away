import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class Fire_Away {
    public static void main(String[] args) throws IOException {

        //Declaring Variables
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String[] dataElementsWC;
        String[] dataElementsCC;
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        String fileName = "";

        try {
            if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int line = 0;

                while (reader.ready()) {
                    rec = reader.readLine();
                    System.out.printf("\nLine %4d %-60s ", line, rec);
                    //For File Name Output
                    fileName = selectedFile.getName();
                    //For Line Output
                    line++;
                    lineCount = line;
                    //For Word Count Output
                    dataElementsWC=rec.split(" ");
                    wordCount= wordCount+dataElementsWC.length;
                    //For Character Count Output
                    dataElementsCC=rec.split("");
                    charCount= charCount+dataElementsCC.length;
                }
                reader.close();
                System.out.println("\n\nData file read!");
                System.out.println();
            }
            else
            {
                System.out.println("Please select a file and try again");
                System.exit(0);
            }
        }
        finally {
            //Output
            System.out.println("The name of this file is: "+fileName);
            System.out.println("The line count of this file is: "+lineCount);
            System.out.println("The word count of this file is: "+wordCount);
            System.out.println("The character count of this file is: "+charCount);
        }

    }
}