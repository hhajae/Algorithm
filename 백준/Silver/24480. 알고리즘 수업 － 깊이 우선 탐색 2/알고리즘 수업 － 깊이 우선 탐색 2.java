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
    static int cnt;
    private static void dfs(int n, int[] isvisited) {
        if(isvisited[n] > 0) return;
        isvisited[n] = cnt++;
        List<Integer> list = new ArrayList<>();
        for (Node tmp = nodes[n]; tmp != null; tmp = tmp.next) {
            list.add(tmp.to);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int tmp : list) {
            dfs(tmp, isvisited);
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
        cnt = 1;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, nodes[from]);
            nodes[to] = new Node(from, nodes[to]);
        }
        int[] isvisited = new int[N+1];
        dfs(R, isvisited);
        for (int i = 1; i < N + 1; i++) {
            sb.append(isvisited[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}