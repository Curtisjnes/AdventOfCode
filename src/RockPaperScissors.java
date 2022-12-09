import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RockPaperScissors {

    Select select = new Select();

    private String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\RockPaperScissors\\RPSInput.txt";

    List <Character> allPlayerMoves = new ArrayList<>();
    List <Character> allOpponentMoves = new ArrayList<>();
    String player = "XYZ";
    int j = 0;
    String opponent = "ABC";
    public void solution(){
        select.pullAndSaveFile(filePath);

        for (int i = 0; i < select.getAllData().size(); i++){
            if(select.getAllData().get(i).contains(player.charAt(j))){
                int findIndexOfMove = select.getAllData().get(i).indexOf(player.charAt(j));
                allPlayerMoves.add(select.getAllData().get(i).charAt(findIndexOfMove));
            } else if (select.getAllData().get(i).contains(opponent.charAt(j))) {
                int findIndexOfMove = select.getAllData().get(i).indexOf(opponent.charAt(j));
                allOpponentMoves.add(select.getAllData().get(i).charAt(findIndexOfMove));
            }
            j++;
        }
        System.out.println(allPlayerMoves);
        System.out.println(allOpponentMoves);
    }
    public RockPaperScissors() throws IOException {
    }
}
