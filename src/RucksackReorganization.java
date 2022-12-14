import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RucksackReorganization {
    Select s = new Select();
    char [] alphabet = "abcdefghijklmopqrstuvwxyz".toCharArray();
    String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\RucksackReorganization\\RRInput.txt";
    List<String> firstCompartment = new ArrayList<>();
    List<String> secondCompartment = new ArrayList<>();

    private boolean compareAsciiDez(int first, int second){
        boolean compareAscii = false;


        return compareAscii;
    }
    public void start(){
        s.pullAndSaveFile(filePath);

        for(int i = 0; i < s.getAllData().size(); i++){
            char [] split = s.getAllData().get(i).toCharArray();
            for(int s = 0; s < split.length; s++){
                if (s < split.length/2){
                    firstCompartment.add(String.valueOf(split[s]));
                } else if (s >= split.length/2) {
                    secondCompartment.add(String.valueOf(split[s]));
                }
            }

            for (int j = 0; j < firstCompartment.size(); j++){
                if (firstCompartment.contains(String.valueOf(secondCompartment.get(j)))){
                    char c = secondCompartment.get(j).charAt(0);
                    int index = firstCompartment.indexOf(String.valueOf(c));
                    char x = firstCompartment.get(index).charAt(0);
                    if (Character.isUpperCase(c) && Character.isUpperCase(x) || Character.isLowerCase(c) && Character.isLowerCase(x)){
                        System.out.println("beide listen haben " + c + " " + x + " gemeinsam");
                    }
                }
            }
            firstCompartment.clear();
            secondCompartment.clear();
            System.out.println("new Input");
        }
    }

    public RucksackReorganization() throws IOException {
    }
}
