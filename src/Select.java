import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;

public class Select {
    private int length = 0;
    public File myObj = null;
    private  FileWriter myWriter = new FileWriter("PushToArray.txt");

    public Select() throws IOException {
    }

    public List<String> getAllData() {
        return allData;
    }

    private List<String> allData = new ArrayList<String>();

    public List<Integer> getIntAllData() {
        return intAllData;
    }

    private List<Integer> intAllData = new ArrayList<>();


    //Zieht den Input aus der .txt datei und speichert alles in einer Liste
    public void pullAndSaveFile(String file) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(file));

            allData.addAll(allLines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeToFile(String action, int index, int sum, List<Integer> intAllData, int i, int indicator, String playerMove, String opponentMove){
        try {
            if (indicator == 1) {
                myWriter.write("Folgendes Ergebnis wurde Berechnet: " + String.valueOf(sum) + " + " + String.valueOf(intAllData.get(i)) + " = ");
            } else if (indicator == 3) {
                myWriter.write( action + String.valueOf(index) + " to ArrayIndex:" + String.valueOf(i));
                myWriter.write(System.getProperty( "line.separator" ));
            } else if (indicator == 4) {
                myWriter.write(action + String.valueOf(sum) + " from ArrayIndex: " + String.valueOf(i));
                myWriter.write(System.getProperty( "line.separator" ));
            } else if (indicator == 5) {
                myWriter.write(action + " Cache " + String.valueOf(index) + " sum " + String.valueOf(sum)  + " topThree[i] " + String.valueOf(i));
                myWriter.write(System.getProperty( "line.separator" ));
            } else if (indicator == 6 ) {
                myWriter.write(action + " " + playerMove + "Gegner Spielt: " + opponentMove);
                myWriter.write(System.getProperty( "line.separator" ));
            } else {
                myWriter.write( " " + String.valueOf(sum));
                myWriter.write(System.getProperty( "line.separator" ));
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    //Falls die Werte Zahlen sind, die man zusammenrechnen muss, kann man mithilfe dieser Methode den Input in eine Int-Liste schreiben
    public void parseToIntegerList(){
        Collections.replaceAll(allData, "", "0");
        intAllData = allData.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
