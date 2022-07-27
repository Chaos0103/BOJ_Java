import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] graph;

    public static boolean dfs(int x, int y) {
        if (x < 0 || m <= x || y < 0 || n <= y) {
            return false;
        }
        if (graph[x][y] == 1) {
            graph[x][y] = 0;
            dfs(x + 1, y);
            dfs(x, y + 1);
            dfs(x - 1, y);
            dfs(x, y - 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            graph = new int[m][n];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = 1;
            }

            int count = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (dfs(x, y)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
