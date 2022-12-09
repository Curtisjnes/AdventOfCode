import java.sql.SQLOutput;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
public class CalorieCounting {
    Select select = new Select();

    List <Integer> sums = new ArrayList<>();
    private String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\CalorieCounting.txt"; //Ordnerpfad des Inputs

    public CalorieCounting() throws IOException {
    }

    public void start(){
        select.pullAndSaveFile(filePath); //Ruft die Methode auf, die den Input in einer Liste speichert und  gibt den Ordnerpfad mit
        select.parseToIntegerList(); //Weil dieses Puzzle das verrechnen von Zahlen benötigt brauche ich eine Integer-Liste
        System.out.println(select.getIntAllData()); //Output, um zu checken, ob die Methoden funktionieren
        solution();
        //solutionExtra();
    }

    private void solution(){ //meine Lösung für das Problem
        /*
        Meine Lösungs-Idee:
        Ich ziehe mir die Integer-Liste und rechne alle Zahlen zusammen bis zur ersten Null. Speicher das Ergebnis in einer Integer-Liste.
        Und dann kann ich im Idealfall einfach die max() funktion verwenden um mir den größten Wert auszugeben, damit sollte ich dann die Lösung für das Puzzle haben.
         */

        int index = 0;
        int sum = 0;
        for ( int i  = 0; i < select.getIntAllData().size(); i++){
            select.writeToFile( "",index, sum, select.getIntAllData(),i, 1);
            sum = sum + select.getIntAllData().get(i);
            select.writeToFile("",index, sum, select.getIntAllData(),i, 2);
            if (select.getIntAllData().get(i) == 0 ) { //Wenn in der liste Null steht, nimmt die Liste einfach die Null auf, weil null unmöglich das höchste Ergebnis sein kann
                index = sum;
                sum = 0;
                sums.add(index);
                System.out.println(index);
            } else if (select.getIntAllData().get(i) == 0 && index > sum) {
                sum = 0;
            }
        }
        int max = Collections.max(sums);
        Collections.sort(sums);
        Collections.reverse(sums);
        index = sums.get(0) + sums.get(1) + sums.get(2);
        System.out.println(index + " " + max);

    }

    private void solutionExtra(){ //meine Lösung für das Problem
        int [] topThree = new int[3];
        boolean pushed = false;
        int index = 0;
        int sum = 0;
        for ( int i  = 0; i < select.getIntAllData().size(); i++){
            sum = sum + select.getIntAllData().get(i);
            int indexArray = 0;
            int cache = 0;
            if (select.getIntAllData().get(i) == 0 && index < sum) {
                for (int j = 0; j < topThree.length; j++){
                    if (topThree[j] < sum && pushed == false){
                        indexArray = j;
                        cache = topThree[j];
                        topThree[j] = sum;
                        pushed = true;
                        select.writeToFile("Pushed: ", sum, 0 , select.getIntAllData(), j, 3);
                        if (topThree[j] != 0 ){
                            select.writeToFile("Popped: ", indexArray, cache, select.getIntAllData(), j, 4);
                            pushed = true;
                            break;
                        }
                        break;
                    }else {
                        //select.writeToFile(" Nothing happened current values: " + " j: " + String.valueOf(j),cache, sum, select.getIntAllData(), topThree[j], 5 );

                    }
                    pushed = false;
                }
                sum = 0;
            }
        }
        index = topThree[0] + topThree[1] + topThree[2];
        System.out.println(index);

    }



}
