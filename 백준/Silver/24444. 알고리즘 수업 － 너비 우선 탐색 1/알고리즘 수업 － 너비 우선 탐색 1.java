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

    @Override
    public String toString() {
        return "Node{" +
                "to=" + to +
                ", next=" + next +
                '}';
    }
}
public class Main {
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

        Node[] nodes = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, nodes[from]);
            nodes[to] = new Node(from, nodes[to]);
        }

        int[] isVisited = new int[N+1];
        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> resLst = new ArrayList<>();
        resLst.add(R);
        que.offer(R);
        isVisited[R] = 1;
        int cnt = 2;
        while(!que.isEmpty()) {
            int cur = que.poll();
            List<Integer> lst = new ArrayList<>();
            for (Node tmp = nodes[cur]; tmp != null; tmp = tmp.next) {
                if(isVisited[tmp.to] > 0) continue;
                lst.add(tmp.to);
            }
            Collections.sort(lst);
            for(int tmp : lst) {
                resLst.add(tmp);
                que.offer(tmp);
                isVisited[tmp] = cnt++;
            }
        }
        if(cnt == 2) {
            sb.append(0);
        } else {
            for (int i = 1; i < N+1; i++) {
                sb.append(isVisited[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}