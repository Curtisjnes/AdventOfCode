import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RucksackReorganization {
    Select s = new Select();
    String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\RucksackReorganization\\RRInput.txt";
    List<String> firstCompartment = new ArrayList<>();
    int addprio = 0;
    boolean exit = false;
    List<String> secondCompartment = new ArrayList<>();
    List <String> alphabet = Arrays.asList(" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
    public void start(){
        s.pullAndSaveFile(filePath);

        for(int i = 0; i < s.getAllData().size(); i++){
            if (i % 3 ==0 ) {
                char[] split = s.getAllData().get(i).toCharArray();
                for (int s = 0; s < split.length; s++) {
                    if (s < split.length / 2) {
                        firstCompartment.add(String.valueOf(split[s]));
                    } else if (s >= split.length / 2) {
                        secondCompartment.add(String.valueOf(split[s]));
                    }
                }
            }
            for (String value : secondCompartment) {

                if (secondCompartment.contains(String.valueOf(value)) && firstCompartment.contains(String.valueOf(value))) {
                    char c = value.charAt(0);
                    int index = firstCompartment.indexOf(String.valueOf(c));
                    boolean b = Character.isUpperCase(c) && Character.isUpperCase(firstCompartment.get(index).charAt(0)) && !exit;
                    boolean b1 = Character.isLowerCase(c) && Character.isLowerCase(firstCompartment.get(index).charAt(0)) && !exit;

                    if (b || b1) {
                        if (b) {
                            char l = Character.toLowerCase(c);
                            addprio = addprio + alphabet.indexOf(String.valueOf(l)) + 26;
                            exit = true;
                        } else {
                            int m = alphabet.indexOf(String.valueOf(c));
                            addprio = addprio + alphabet.indexOf(String.valueOf(c));
                            exit = true;
                        }
                    }


                }


            }


            firstCompartment.clear();
            secondCompartment.clear();

            exit = false;
        }
        System.out.println(addprio);

    }

    public RucksackReorganization() throws IOException {
    }
}
