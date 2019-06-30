import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

class SudokuService extends Images {


    static void doScreenshot() throws IOException {
        Sudoku.image = Sudoku.robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    static void doImageToGrey(BufferedImage img) throws IOException {
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
    }

    static void findPoint(BufferedImage img, BufferedImage imgToFind) {
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
                    tempX1 = x;
                    tempY1 = y;
                }
            }
        }
    }

    private static void addFoundImages(BufferedImage img, BufferedImage imgToFind, int x1, int x2, int y1, int y2,
                                       ArrayList<BufferedImage> arrayList) {
        for (int x = x1; x <= x2 - imgToFind.getWidth(); x++) {
            for (int y = y1; y <= y2 - imgToFind.getWidth(); y++) {
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
                    arrayList.add(imgToFind);
                }
            }
        }
    }

    static void findAllImages(BufferedImage img, ArrayList<BufferedImage> arrayList, int x1, int y1,
                              ArrayList<BufferedImage> arrayList2) {
        int a = thinLine.getHeight();
        int b = thinLine.getWidth();
        int c = boldLine.getWidth();
        int e = 9 * a + 6 * b + 3 * c;

        for (int z = 0; z < e; z = z + 3 * a + 2 * b + c) {
            for (int w = z; w < 3 * a + 3 + z; w = w + a + b) {
                for (int q = 0; q < e; q = q + a * 3 + 2 * b + c) {
                    for (int d = x1 + q; d < (x1 + 3 * a + 2 * b + q); d = (d + a + b)) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            addFoundImages(img, arrayList.get(i), d, (d + a), y1 + w, y1 + a + w,
                                    arrayList2);
                        }
                    }
                }
            }
        }
    }

    static void findAllKey(int[][] array, ArrayList<BufferedImage> arraylist) {

        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arraylist.get(count) == key0) {
                    array[i][j] = 0;
                } else if (arraylist.get(count) == key1) {
                    array[i][j] = 1;
                } else if (arraylist.get(count) == key2) {
                    array[i][j] = 2;
                } else if (arraylist.get(count) == key3) {
                    array[i][j] = 3;
                } else if (arraylist.get(count) == key4) {
                    array[i][j] = 4;
                } else if (arraylist.get(count) == key5) {
                    array[i][j] = 5;
                } else if (arraylist.get(count) == key6) {
                    array[i][j] = 6;
                } else if (arraylist.get(count) == key7) {
                    array[i][j] = 7;
                } else if (arraylist.get(count) == key8) {
                    array[i][j] = 8;
                } else if (arraylist.get(count) == key9) {
                    array[i][j] = 9;
                }
                count++;
            }
        }
    }
    static void printModel(int[][] array){
        System.out.println("Модель игры:");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

