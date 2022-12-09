import java.io.IOException;
import java.util.Collections;

public class RockPaperScissors {

    Select select = new Select();

    private String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\RockPaperScissors\\RPSInput.txt";
    String move = null;
    String oMove = null;
    public void solution(){
        select.pullAndSaveFile(filePath);
        System.out.println(select.getAllData());
        for (int i = 0; i < select.getAllData().size(); i++){
            parseMove(i);
        }
    }

    private int sumGame(String move, String oMove){
        int result = 0;
        boolean draw = false;
        boolean playerWins = false;
        boolean opponentWins = false;



        return result;
    }

    private String getFullMove(char playerMove, char opponentMove){
        if (playerMove == 'A' || opponentMove == 'X'){
            move = "Stein";
        }else if (playerMove == 'B' || opponentMove == 'Y'){
            move = "Papier";
        } else if (playerMove == 'C' || opponentMove == 'Z') {
            move = "Schere";
        }
        return move;
    }

    private void parseMove(int index){
        String fullRound = select.getAllData().get(index).toString();

        char [] roundToChar = fullRound.toCharArray();
        char opponentMove = 0;
        char playerMove = 0;
        
        for (int i = 0; i < roundToChar.length; i++){
            if (roundToChar[i] == 'A' || roundToChar[i] == 'B' || roundToChar[i] == 'C'){
                opponentMove = roundToChar[i];
                oMove = getFullMove('0',opponentMove);

            } else if (roundToChar[i] == 'X' || roundToChar[i] == 'Y' || roundToChar[i] == 'Z') {
                playerMove = roundToChar[i];
                move = getFullMove(playerMove,'0');
            }
        }
        
        select.writeToFile("Spieler spielt:", 0,0, select.getIntAllData(), 0, 6, String.valueOf(move),String.valueOf(oMove));
    }

    public RockPaperScissors() throws IOException {
    }
}
