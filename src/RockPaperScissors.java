import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RockPaperScissors {

    Select select = new Select();

    private String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\RockPaperScissors\\RPSInput.txt";

    List <Character> allPlayerMoves = new ArrayList<>();
    List <Character> allOpponentMoves = new ArrayList<>();
    int line =0;
    CharSequence player = "XYZ";
    int result = 0;
    int schere = 3;
    int papier = 2;
    int stein = 1;
    int score = 0;
    int pScore = 0;
    int oScore = 0;

    CharSequence opponent = "ABC";
    public void solution(){
        select.pullAndSaveFile(filePath);
        for (int getRound = 0; getRound < select.getAllData().size(); getRound++) {
            char[] round = select.getAllData().get(getRound).toCharArray();
            for (int j = 0; j < round.length; j++) {
                System.out.println("Line:" + getRound);
                if (select.getAllData().get(getRound).charAt(j) == 'X' || select.getAllData().get(getRound).charAt(j) == 'Y' || select.getAllData().get(getRound).charAt(j) == 'Z') {
                    allPlayerMoves.add(select.getAllData().get(getRound).charAt(j));
                    evaluateScore(j, round);
                } else if (select.getAllData().get(getRound).charAt(j) == 'A' || select.getAllData().get(getRound).charAt(j) == 'B' || select.getAllData().get(getRound).charAt(j) == 'C' ) {
                    allOpponentMoves.add(select.getAllData().get(getRound).charAt(j));
                    evaluateScore(j, round);
                }
            }
            getResult();
            System.out.println(result);
        }

        System.out.println(result);

    }

    public void getResult(){

        if (pScore == stein && oScore == schere || pScore == papier && oScore == stein || pScore == schere && oScore == papier){
            result = result + pScore + 6;
            System.out.println("Current Score: " +score + " + " + pScore + " + " +"6" );
        } else if (oScore == stein && pScore == schere || oScore == papier && pScore == stein || oScore == schere && pScore == papier) {
            result = result + 1;
            System.out.println("Current Score: " +score + " + "  +"1" );
        } else if (oScore == pScore) {
            result = result + pScore + 3;
            System.out.println("Current Score: " + score  + " + " + pScore + " + " +"3" );
        }
        score = result;

    }
    public void evaluateScore(int getRound, char [] round){
        if (round[getRound] == 'X' || round[getRound] == 'A'){
            if (round[getRound] == 'X'){
                pScore = stein;
            }else {
                oScore = stein;
            }

        } else if (round[getRound] == 'Y' || round[getRound] == 'B') {
            if (round[getRound] == 'Y'){
             pScore = papier;
            }else {
                oScore = papier;
            }
        }else if (round[getRound] == 'Z' || round[getRound] == 'C'){
            if (round[getRound] == 'Z'){
                pScore = schere;
            }else {
                oScore = schere;
            }
        }
    }
    public RockPaperScissors() throws IOException {
    }
}
