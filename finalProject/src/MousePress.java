import java.awt.event.InputEvent;

class MousePress extends SudokuService {
    static void mouseMoveAndClick(int a, int b) {
        int step = thinLine.getHeight();
        int x = 0;
        int y = 0;
        switch (a) {
            case 0:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (step / 2);
                break;
            case 1:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + step + (step / 2);
                break;
            case 2:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (2 * step) + (step / 2);
                break;
            case 3:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (3 * step) + (step / 2);
                break;
            case 4:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (4 * step) + (step / 2);
                break;
            case 5:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (5 * step) + (step / 2);
                break;
            case 6:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (6 * step) + (step / 2);
                break;
            case 7:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (7 * step) + (step / 2);
                break;
            case 8:
                x = playBoardX1 + (step / 2) + (b * step);
                y = playBoardY1 + (8 * step) + (step / 2);
                break;
            default:
                break;
        }
        Sudoku.robot.mouseMove(x, y);
        Sudoku.robot.mousePress(InputEvent.BUTTON1_MASK);
    }
}
