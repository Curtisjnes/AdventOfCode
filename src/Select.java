import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.*;

public class Select {
    private int length = 0;
    public List<String> allData = new ArrayList<String>();

    private String [] lastIndexBeforeInput = new String[10000];

    String lastInputBevoreParam = null;
    int j = 0;
    private String fileAsString = null;

    public void PullAndSaveFile(String file){
        try {
            List<String> allLines = Files.readAllLines(Paths.get(file));

            for (String line : allLines) {
                //System.out.println(line);
                allData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sumUntilCertainParameter(String file, String character, int number) {
            int index = 0;
        if (number == 0 && character != null) {
            for (String i : allData) {
                j++;
                if (i.equals(character)) {
                    lastInputBevoreParam = String.valueOf(allData.get(j - 2));
                    lastIndexBeforeInput[index] = allData.get(j-2);
                    System.out.println(lastIndexBeforeInput[index]);
                    index++;
                }
            }
        } else {
            System.out.println("Wird sich drum gekümmert");
        }


    }

}
