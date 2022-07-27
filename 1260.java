import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < graph.get(start).size(); i++) {
            int y = graph.get(start).get(i);
            if (!visited[y]) {
                dfs(y, visited);
            }
        }
    }

    public static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            for (int i = 0; i < graph.get(v).size(); i++) {
                int index = graph.get(v).get(i);
                if (!visited[index]) {
                    q.offer(index);
                    visited[index] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> integers : graph) {
            Collections.sort(integers);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(v, visited);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v, visited);
    }

}
