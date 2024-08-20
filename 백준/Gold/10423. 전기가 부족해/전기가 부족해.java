import java.io.*;
import java.util.*;

class Edge {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    static int[] parents;
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        parents[b] = a;
    }
    public static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        s = br.readLine();
        st = new StringTokenizer(s);
        boolean[] generators = new boolean[N+1];
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(st.nextToken());
            generators[n] = true;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(N, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e1.weight, e2.weight);
            }
        });
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(from, to, weight));
        }
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        int weights = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(find(e.from) == find(e.to)) continue;
            if(generators[e.from] && generators[e.to]) continue;
            if(generators[e.from] || generators[e.to]) { // 둘 다 켜면되는데, 안켜진얘는 딸린애들 다 켜주기
                if(!generators[e.from]) { // from이 아직 안켜졌다
                    generators[e.from] = true;
                    if(map.containsKey(e.from)) {
                        Queue<Integer> que = new ArrayDeque<>();
                        List<Integer> tmpLst = map.get(e.from);
                        for(int tmp : tmpLst) {
                            if(!generators[tmp]) que.offer(tmp);
                            generators[tmp] = true;
                        }
                        while(!que.isEmpty()) {
                            int cur = que.poll();
                            generators[cur] = true;
                            List<Integer> intmpLst = map.get(cur);
                            for(int tmp : intmpLst) {
                                if(!generators[tmp]) que.offer(tmp);
                                generators[tmp] = true;
                            }
                        }

                    }
                } else if(!generators[e.to]) {
                    generators[e.to] = true;
                    if(map.containsKey(e.to)) {
                        Queue<Integer> que = new ArrayDeque<>();
                        List<Integer> tmpLst = map.get(e.to);
                        for(int tmp : tmpLst) {
                            if(!generators[tmp]) que.offer(tmp);
                            generators[tmp] = true;
                        }
                        while(!que.isEmpty()) {
                            int cur = que.poll();
                            generators[cur] = true;
                            List<Integer> intmpLst = map.get(cur);
                            for(int tmp : intmpLst) {
                                if(!generators[tmp]) que.offer(tmp);
                                generators[tmp] = true;
                            }
                        }
                    }
                }
            }
            if (!generators[e.from] && !generators[e.to]) {
                if(map.containsKey(e.from)) {
                    map.get(e.from).add(e.to);
                } else {
                    map.put(e.from, new ArrayList<>());
                    map.get(e.from).add(e.to);
                }
                if(map.containsKey(e.to)) {
                    map.get(e.to).add(e.from);
                } else {
                    map.put(e.to, new ArrayList<>());
                    map.get(e.to).add(e.from);
                }
            }
            weights += e.weight;
            union(e.from, e.to);
        }
        sb.append(weights);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
