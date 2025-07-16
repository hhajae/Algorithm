import java.io.*;
import java.util.*;

class Node {
    int to;
    Node next;

    public Node(int to, Node next) {
        this.to = to;
        this.next = next;
    }

    public Node(int to) {
        this.to = to;
    }

}
public class Main {
    static Node[] nodes;
    private static void dfs(int r, int[] depth, int preDepth) {
        if(depth[r] >= 0) return;
        depth[r] = preDepth + 1;

        List<Integer> list = new ArrayList<>();
        for (Node tmp = nodes[r]; tmp != null; tmp = tmp.next) {
            if(depth[tmp.to] >= 0) continue;
            list.add(tmp.to);
        }
        Collections.sort(list);

        for(int tmp : list) {
            dfs(tmp, depth, depth[r]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        nodes = new Node[N+1];
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, nodes[from]);
            nodes[to] = new Node(from, nodes[to]);
        }
        int[] depth = new int[N+1];
        Arrays.fill(depth, -1);
        dfs(R, depth, -1);

        for (int i = 1; i < N+1; i++) {
            sb.append(depth[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}