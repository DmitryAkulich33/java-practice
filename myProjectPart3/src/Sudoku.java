import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku extends Images {

    static Robot robot = null;

    public static void main(String[] args) throws IOException {
        ArrayList<BufferedImage> list = new ArrayList<>(Arrays.asList(key0, key1, key2, key3,
                key4, key5, key6, key7, key8, key9));
        ArrayList<BufferedImage> list2 = new ArrayList<>();
        int[][] result = new int[9][9];

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        SudokuService.doScreenshot();
        SudokuService.doImageToGrey(image);

        playBoardX1 = (int)SudokuService.findPoint(image, playBoardUpSide).getX();
        playBoardY1 = (int)SudokuService.findPoint(image, playBoardLeftSide).getY();

        for(int i = 0; i < 3; i++){
            SudokuService.findAllImages(image, list, playBoardX1, playBoardY1, list2);
            SudokuService.findAllKey(result, list2);
            SudokuService.printModel(result);
            robot.delay(1000);
        }
    }
}
