import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static Robot robot = null;

    public static void main(String[] args) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Сделан скриншот " + (i + 1));
            doScreenshot();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void doScreenshot() {

        BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        try {
            ImageIO.write(image, "png", new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        double width = image.getWidth();
        double height = image.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int k = (int) (.2126 * r + .7152 * g + .0722 * b);
                image.setRGB(i, j, (k << 16) | (k << 8) | k);
            }
        }
        try {
            ImageIO.write(image, "png", new File("screenshot1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
