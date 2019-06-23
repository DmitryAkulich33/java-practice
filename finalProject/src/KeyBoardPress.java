import java.awt.event.KeyEvent;

class KeyBoardPress {
    static void pressNumber(int a){
        switch (a){
            case 1:
                Sudoku.robot.keyPress(KeyEvent.VK_1);
                break;
            case 2:
                Sudoku.robot.keyPress(KeyEvent.VK_2);
                break;
            case 3:
                Sudoku.robot.keyPress(KeyEvent.VK_3);
                break;
            case 4:
                Sudoku.robot.keyPress(KeyEvent.VK_4);
                break;
            case 5:
                Sudoku.robot.keyPress(KeyEvent.VK_5);
                break;
            case 6:
                Sudoku.robot.keyPress(KeyEvent.VK_6);
                break;
            case 7:
                Sudoku.robot.keyPress(KeyEvent.VK_7);
                break;
            case 8:
                Sudoku.robot.keyPress(KeyEvent.VK_8);
                break;
            case 9:
                Sudoku.robot.keyPress(KeyEvent.VK_9);
                break;
        }
    }
}

