package Challenge_200_Easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Jonathan on 26/08/2015.
 * Java 1.8
 * Created for r/dailyProgrammer challenge 200 [Easy]
 */
public class FloodFill {

    int width;
    int height;
    char[][] grid;
    char replacement;

    public static void main(String[] args) {

        new FloodFill().ff("input.txt");

    }

    /**
     * Does the stuff as specified in problem description
     *
     * @param fileToFill input file
     */
    public void ff(String fileToFill) {
        int xPos = -1;
        int yPos = -1;

        URL url = getClass().getResource(fileToFill);
        File inputFile = new File(url.getPath());
        try {
            Scanner fileReader = new Scanner(inputFile);
            width = fileReader.nextInt();
            height = fileReader.nextInt();
            grid = new char[width][height];
            for (int rows = 0; rows < height; rows++) {
                String line = fileReader.next();
                for (int cols = 0; cols < width; cols++) {
                    grid[cols][rows] = line.charAt(cols);
                }
            }
            xPos = fileReader.nextInt();
            yPos = fileReader.nextInt();
            replacement = fileReader.next().charAt(0);
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        fill(xPos, yPos, grid[xPos][yPos]);

        try {
            for (int rows = 0; rows < height; rows++) {
                for (int cols = 0; cols < width; cols++) {
                    System.out.print(grid[cols][rows]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Recursively fills all spaces
     *
     * @param xPos x co-ordinate of position to fill
     * @param yPos y co-ordinate of position to fill
     */
    private void fill(int xPos, int yPos, char toReplace) {
        if ((0 <= xPos && xPos < width) && (0 <= yPos && yPos < height)) {
            if (grid[xPos][yPos] == toReplace) {
                grid[xPos][yPos] = replacement;
                fill(xPos + 1, yPos, toReplace);
                fill(xPos - 1, yPos, toReplace);
                fill(xPos, yPos + 1, toReplace);
                fill(xPos, yPos - 1, toReplace);
            }
        }

    }

}
