import java.sql.SQLOutput;

public class CalorieCounting {
    Select select = new Select();
    private String filePath = "C:\\Users\\cjones\\IdeaProjects\\AdventOfCodePuzzles\\src\\PuzzleInput\\CalorieCounting.txt";

    public void start(){
        select.PullAndSaveFile(filePath);
        select.sumUntilCertainParameter(filePath, "", 0);
    }



}
