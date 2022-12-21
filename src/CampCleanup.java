import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class CampCleanup {
    Select s = new Select();
    String file = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\CampCleanup\\CCInput.txt";
    List<String> workload = new ArrayList<>();
    List<String> workload1 = new ArrayList<>();


    int startElf = 0;

    int endElf = 0;

    int counter = 0;

    int startElf1= 0;

    int endElf1 = 0;
    public CampCleanup() throws IOException {
    }

    public void start(){
        s.pullAndSaveFile(file);

        //Jeder String in meinem Input wird am Komma getrennt und einer Liste zugewiesen Vorher:"XX-XX , XX-XX" Nachher: List1: "XX-XX" List2: "XX-XX"
        for (String check : s.getAllData()){
            char [] input = check.toCharArray();
            for(int j = 0; j < input.length; j++){
                if (input[j] == ','){
                    workload.add(check.substring(0, j));
                    workload1.add(check.substring(j+1, check.length()));;
                }

            }

            //Der erste Eintrag einer Liste wird in einem Char Array gespeichert und am Minus getrennt und der dementsprechenden Liste zugeaordnet ## Vorher Liste1 :"XX-XX" Liste2: "Von-Bis" Nacher Liste1: ""

            for(int k = 0; k < 2; k++) {
                if (k == 1) {
                    String split = workload1.get(0).toString();
                    for (int u = 0; u < split.length(); u++){
                        if (split.charAt(u) == '-'){
                            String start = split.substring(0, u);
                            String end = split.substring(u+1, split.length());
                            startElf1 = Integer.parseInt(start);
                            endElf1 = Integer.parseInt(end);
                        }

                    }
                }else {
                    String split = workload.get(0).toString();
                    for (int u = 0; u < split.length(); u++){
                        if (split.charAt(u) == '-'){
                            String start = split.substring(0, u);
                            String end = split.substring(u+1, split.length());
                            startElf = Integer.parseInt(start);
                            endElf = Integer.parseInt(end);
                        }

                    }

                }

            }
            System.out.println();
            workload.clear();
            workload1.clear();
            List <Integer> range = new ArrayList<>();
            List <Integer> range1 = new ArrayList<>();
            for (int i = startElf; i <= endElf; i++ ){
                range.add(i);
            }
            for (int j = startElf1; j <= endElf1; j++){
                range1.add(j);

            }

            if (!Collections.disjoint(range, range1)){
                counter++;
            }

            System.out.print(range);
            range.clear();
            range1.clear();

        }

        System.out.println(counter);



    }
}
