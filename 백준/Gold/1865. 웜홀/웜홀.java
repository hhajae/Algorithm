import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        if(this.from == o.from) {
            if(this.to == o.to) {
                return Integer.compare(this.weight, o.weight);
            } else {
                return Integer.compare(this.to, o.to);
            }
        } else {
            return Integer.compare(this.from, o.from);
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        final int INF = 500*10000+5;
        int T = Integer.parseInt(br.readLine());
        outer: for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                s = br.readLine();
                st = new StringTokenizer(s);
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, weight));
                edges.add(new Edge(to, from, weight));
            }
            for (int i = 0; i < W; i++) {
                s = br.readLine();
                st = new StringTokenizer(s);
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(from, to, -weight));
            }
            // edge sort
            Collections.sort(edges);
            int tmpFrom = edges.get(0).from;
            int tmpTo = edges.get(0).to;
            List<Integer> removeLst = new ArrayList<>();
            for (int i = 1; i < edges.size(); i++) {
                Edge e = edges.get(i);
                if(e.from == tmpFrom && e.to == tmpTo) {
                    removeLst.add(i);
                } else {
                    tmpFrom = e.from;
                    tmpTo = e.to;
                }
            }
            for (int i = removeLst.size()-1; i >= 0; i--) {
                edges.remove(removeLst.get(i));
            }
//            for (int i = 1; i < N+1; i++) { // 출발지 선택
                int[] dist = new int[N+1];
                Arrays.fill(dist, INF);
                dist[1] = 0;
                for (int j = 0; j < N-1; j++) {
                    for (Edge e : edges) {
//                        if (dist[e.from] != INF &&
//                                dist[e.to] > dist[e.from] + e.weight) {
//                            dist[e.to] = dist[e.from] + e.weight;
//                        }
                        if (dist[e.to] > dist[e.from] + e.weight) {
                            dist[e.to] = dist[e.from] + e.weight;
                        }
                    }
                }
                for (int j = 0; j < N-1; j++) {
                    for (Edge e : edges) {
//                        if (dist[e.from] != INF &&
//                                dist[e.to] > dist[e.from] + e.weight) {
//                            sb.append("YES\n");
//                            continue outer;
//                        }
                        if (dist[e.to] > dist[e.from] + e.weight) {
                            sb.append("YES\n");
                            continue outer;
                        }
                    }
                }
//            }
            sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
