import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static Robot robot = null;
    public static BufferedImage image = null;

    public static void main(String[] args) throws IOException {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            doScreenshot();
            System.out.println("Сделан скриншот " + (i + 1));
            doImageToGrey(image);
            robot.delay(1000);
        }
    }

    public static void doScreenshot() throws IOException {
        image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", new File("screenshot.png"));

    }

    public static void doImageToGrey(BufferedImage img) throws IOException {

        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int rgb = img.getRGB(i, j);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int k = (int) (.2126 * r + .7152 * g + .0722 * b);
                img.setRGB(i, j, (k << 16) | (k << 8) | k);
            }
        }
        ImageIO.write(img, "png", new File("screenshot1.png"));
    }
}
