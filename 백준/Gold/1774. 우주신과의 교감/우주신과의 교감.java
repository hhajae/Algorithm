import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
    int from, to;
    double weight;
    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    static int[] parents;
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        parents[b] = a;
    }
    private static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    private static double getLength(int a1, int b1, int a2, int b2) {
        return Math.sqrt(Math.pow(b2 - b1, 2) + Math.pow(a2 - a1, 2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] nodes = new int[N+1][2];
        for (int i = 1; i < N+1; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            nodes[i][0] = X;
            nodes[i][1] = Y;
        }
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            cnt++;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.weight, o2.weight);
            }
        });
        for (int i = 1; i < N; i++) {
            for (int j = i+1; j < N+1; j++) {
                double w = getLength(nodes[i][0], nodes[i][1], nodes[j][0], nodes[j][1]);
                pq.add(new Edge(i, j, w));
            }
        }
        double res = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(find(e.from) == find(e.to)) continue;
            union(e.from, e.to);
            res += e.weight;
//            if(++cnt == N-1) break;
        }
        System.out.printf("%.2f\n", res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
