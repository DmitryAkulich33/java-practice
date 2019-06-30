import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Images {

    static BufferedImage image;
    static BufferedImage playBoardUpSide;
    static BufferedImage playBoardLeftSide;
    static BufferedImage key0;
    static BufferedImage key1;
    static BufferedImage key2;
    static BufferedImage key3;
    static BufferedImage key4;
    static BufferedImage key5;
    static BufferedImage key6;
    static BufferedImage key7;
    static BufferedImage key8;
    static BufferedImage key9;
    static BufferedImage boldLine;
    static BufferedImage thinLine;
    static int playBoardX1 = 0;
    static int playBoardY1 = 0;

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
