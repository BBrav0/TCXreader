package TCXreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {



    public static void main(String[] args) {
        File f = new File(args[0]);
        Scanner file;
        try {
             file = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }
        
        int avgHR = 0;
        int count = 0;
        int maxHR = 0;
        int minHR = 300;
        int hr = 0;

        while (file.hasNextLine()) {
            String cur = file.nextLine();
            if (cur.contains("Value")) {
                String numericPart = cur.replaceAll("[^0-9]", "");
                if (!numericPart.isEmpty()) {
                    hr = Integer.parseInt(numericPart);
                    avgHR += hr;
                    count++;
                    if (maxHR < hr) {maxHR=hr;}
                    if (minHR > hr) {minHR=hr;}
                }
            }
        }
        file.close();
        avgHR = avgHR/count;
        System.out.println("Max HR: "+maxHR+" BPM");
        System.out.println("Min HR: "+minHR+" BPM");
        System.out.println("Avg HR: "+avgHR+" BPM");
    }
}