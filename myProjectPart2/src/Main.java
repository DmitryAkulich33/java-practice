import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static Robot robot = null;
    public static BufferedImage image = null;
    public static BufferedImage imageToFind = null;

    public static void main(String[] args) throws IOException {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        imageToFind = ImageIO.read(new File("D:\\Stormnet\\java-practice\\myProjectPart2\\test.png"));
        doScreenshot();
        doImageToGrey(image);

        findImage(image, imageToFind);

    }

    public static void doScreenshot() throws IOException {
        image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", new File("screenshot.png"));

    }

    public static void findImage(BufferedImage img, BufferedImage imgToFind){
        for (int x = 0; x < img.getWidth() - imgToFind.getWidth(); x++) {
            for (int y = 0; y < img.getHeight() - imgToFind.getHeight(); y++) {
                boolean invalid = false;
                int k = x;
                for (int a = 0; a < imgToFind.getWidth(); a++) {
                    int l = y;
                    for (int b = 0; b < imgToFind.getHeight(); b++) {
                        if (imgToFind.getRGB(a, b) != img.getRGB(k, l)) {
                            invalid = true;
                            break;
                        } else {
                            l++;
                        }
                    }
                    if (invalid) {
                        break;
                    } else {
                        k++;
                    }
                }
                if (!invalid) {
                    System.out.println("Image is found");
                    robot.mouseMove(x,y);
                }
            }
        }
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
