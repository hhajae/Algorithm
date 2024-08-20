import java.io.*;
import java.util.StringTokenizer;

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
    static int N;
    static boolean[] isSheep;
    static int[] amounts;
    static Node[] nodes;
    private static long dfs(int node) {
        if(nodes[node] == null) { // 리프노드
            if(!isSheep[node]) { // 리프노드가 늑대이면
                return 0;
            }
            return amounts[node];
        }
        long liveSheeps = 0;
        if(isSheep[node]) {
            liveSheeps += amounts[node];
        } else {
            liveSheeps -= amounts[node];
        }
        for(Node tmp = nodes[node]; tmp != null; tmp = tmp.next) {
            liveSheeps += dfs(tmp.to);
        }
        if(liveSheeps < 0) {
            return 0;
        }
        return liveSheeps;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        isSheep = new boolean[N+1];
        amounts = new int[N+1];
        nodes = new Node[N+1];
        for (int i = 2; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            String atype = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(atype.equals("S")) {
                isSheep[i] = true;
            }
            amounts[i] = a;
            nodes[p] = new Node(i, nodes[p]);
        }
        long res = dfs(1);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
