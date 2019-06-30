import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Images {


    private static BufferedImage playBoardUpSide;
    private static BufferedImage playBoardLeftSide;
    private static BufferedImage key0;
    private static BufferedImage key1;
    private static BufferedImage key2;
    private static BufferedImage key3;
    private static BufferedImage key4;
    private static BufferedImage key5;
    private static BufferedImage key6;
    private static BufferedImage key7;
    private static BufferedImage key8;
    private static BufferedImage key9;
    private static BufferedImage boldLine;
    private static BufferedImage thinLine;
    static BufferedImage image = null;
    static int playBoardX1 = 0;
    static int playBoardY1 = 0;


    static BufferedImage getPlayBoardUpSide() {
        return playBoardUpSide;
    }

    static BufferedImage getPlayBoardLeftSide() {
        return playBoardLeftSide;
    }

    static BufferedImage getKey0() {
        return key0;
    }

    static BufferedImage getKey1() {
        return key1;
    }

    static BufferedImage getKey2() {
        return key2;
    }

    static BufferedImage getKey3() {
        return key3;
    }

    static BufferedImage getKey4() {
        return key4;
    }

    static BufferedImage getKey5() {
        return key5;
    }

    static BufferedImage getKey6() {
        return key6;
    }

    static BufferedImage getKey7() {
        return key7;
    }

    static BufferedImage getKey8() {
        return key8;
    }

    static BufferedImage getKey9() {
        return key9;
    }

    static BufferedImage getBoldLine() {
        return boldLine;
    }

    static BufferedImage getThinLine() {
        return thinLine;
    }

    static {
        try {
            playBoardUpSide = ImageIO.read(new File("D:\\FilesForProject\\playBoardUpSide.png"));
            playBoardLeftSide = ImageIO.read(new File("D:\\FilesForProject\\playBoardLeftSide.png"));
            key0 = ImageIO.read(new File("D:\\FilesForProject\\key0.png"));
            key1 = ImageIO.read(new File("D:\\FilesForProject\\key1.png"));
            key2 = ImageIO.read(new File("D:\\FilesForProject\\key2.png"));
            key2 = ImageIO.read(new File("D:\\FilesForProject\\key2.png"));
            key3 = ImageIO.read(new File("D:\\FilesForProject\\key3.png"));
            key4 = ImageIO.read(new File("D:\\FilesForProject\\key4.png"));
            key5 = ImageIO.read(new File("D:\\FilesForProject\\key5.png"));
            key6 = ImageIO.read(new File("D:\\FilesForProject\\key6.png"));
            key7 = ImageIO.read(new File("D:\\FilesForProject\\key7.png"));
            key8 = ImageIO.read(new File("D:\\FilesForProject\\key8.png"));
            key9 = ImageIO.read(new File("D:\\FilesForProject\\key9.png"));
            boldLine = ImageIO.read(new File("D:\\FilesForProject\\boldLine.png"));
            thinLine = ImageIO.read(new File("D:\\FilesForProject\\thinLine.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

