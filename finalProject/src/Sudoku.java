import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku extends Images {

    static Robot robot = null;

    public static void main(String[] args) throws IOException {
        long timeBegin = System.currentTimeMillis();

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
        SudokuService.findImageUpSide(image, playBoardUpSide);
        SudokuService.findImageLeftSide(image, playBoardLeftSide);
        SudokuService.findAllImages(image, list, playBoardX1, playBoardY1, list2);
        SudokuService.findAllKey(result, list2);

        Solver.solveSudoku(result);
//        System.out.println(playBoardX1 + " " + playBoardY1);

        robot.mouseMove((playBoardX1 - thinLine.getHeight()), (playBoardY1 + thinLine.getHeight()));
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        long timeEnd = System.currentTimeMillis();
        System.out.println("Время работы программы: " + (timeEnd - timeBegin) + " мс");
    }
}
