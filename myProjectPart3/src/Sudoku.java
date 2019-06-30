import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku extends Images {

    static Robot robot = null;

    public static void main(String[] args) throws IOException {
        ArrayList<BufferedImage> list = new ArrayList<>(Arrays.asList(getKey0(), getKey1(), getKey2(), getKey3(),
                getKey4(), getKey5(), getKey6(), getKey7(), getKey8(), getKey9()));
        ArrayList<BufferedImage> list2 = new ArrayList<>();
        int[][] result = new int[9][9];

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        SudokuService.doScreenshot();
        SudokuService.doImageToGrey(image);

        playBoardX1 = (int)SudokuService.findPoint(image, getPlayBoardUpSide()).getX();
        playBoardY1 = (int)SudokuService.findPoint(image, getPlayBoardLeftSide()).getY();

        for(int i = 0; i < 3; i++){
            SudokuService.findAllImages(image, list, playBoardX1, playBoardY1, list2);
            SudokuService.findAllKey(result, list2);
            SudokuService.printModel(result);
            robot.delay(1000);
        }
    }
}
