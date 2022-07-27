import java.util.*;

public class Main {

    public static int n;
    public static int[][] graph;
    public static int count;

    public static int dfs(int x, int y) {
        if (x < 0 || n <= x || y < 0 || n <= y) {
            return -1;
        }
        if (graph[x][y] == 1) {
            graph[x][y] = 0;
            count++;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }

        int total = 0;
        List<Integer> cnt = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                count = 0;
                if (dfs(x, y) != -1) {
                    total++;
                    cnt.add(count);
                }
            }
        }

        Collections.sort(cnt);
        
        System.out.println(total);
        for (Integer num : cnt) {
            System.out.println(num);
        }
    }
}
