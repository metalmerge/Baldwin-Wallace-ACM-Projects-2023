import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1}; // directions: N, S, W, E
    static int[] dy = {-1, 1, 0, 0};
    static char[][] grid;
    static boolean[][][][][][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        for (int i = 1; i <= t; i++) {
            int h = sc.nextInt(); // height of grid
            int w = sc.nextInt(); // width of grid
            grid = new char[h][w];
            visited = new boolean[h][w][h][w][h][w][4][51];
            int startX = -1, startY = -1; // starting position of Slippy
            int openX = -1, openY = -1; // location of cave opening
            for (int y = 0; y < h; y++) {
                String line = sc.next();
                for (int x = 0; x < w; x++) {
                    char c = line.charAt(x);
                    grid[y][x] = c;
                    if (c == 'S') {
                        startX = x;
                        startY = y;
                    } else if (c == 'O') {
                        openX = x;
                        openY = y;
                    }
                }
            }
            int k = sc.nextInt(); // number of slides
            String dirs = sc.next(); // directions of slides
            int fish = 0;
            int x = startX;
            int y = startY;
            boolean escaped = false;
            for (int j = 0; j < k; j++) {
                char dir = dirs.charAt(j);
                int newX = x + dx[dirToIndex(dir)];
                int newY = y + dy[dirToIndex(dir)];
                while (newX >= 0 && newY >= 0 && newX < w && newY < h && grid[newY][newX] != 'R') {
                    if (newX == openX && newY == openY) {
                        escaped = true;
                        break;
                    } else if (grid[newY][newX] == 'F') {
                        fish++;
                    }
                    x = newX;
                    y = newY;
                    newX += dx[dirToIndex(dir)];
                    newY += dy[dirToIndex(dir)];
                }
                if (escaped) {
                    break;
                }
            }
            System.out.printf("Case %d: %s %d\n", i, escaped ? "Yes" : "No", fish);
        }
    }

    static int dirToIndex(char dir) {
        switch (dir) {
            case 'N':
                return 0;
            case 'S':
                return 1;
            case 'W':
                return 2;
            case 'E':
                return 3;
            default:
                return -1; // should not happen
        }
    }
}
