import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Node {
    int to;
    Node next;
    public Node(int to, Node next) {
        super();
        this.to = to;
        this.next = next;
    }
    public Node(int to) {
        super();
        this.to = to;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
         
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] students = new Node[N+1];
        Node[] students_in = new Node[N+1]; // 진입 차수
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            students[from] = new Node(to, students[from]); // 너보단 내가 크다
            students_in[to] = new Node(from, students_in[to]);
        }
        /// input end ///
        int[] studentCnt = new int[N+1]; // 키작+키큰 합쳐서 N-1이면 너는 될놈이다
        // 진입차수가 0인 얘들을 시작점으로 돌면서 갈 수 있는애들이 있다 -> 
        // 나보다 키 큰 놈들이다 -> 카운트+1
        // 갈 수 있는 애들은 키 작은 놈이 있으니까 카운트+1
         
        Queue<Integer> inDegreeZeroQue = new ArrayDeque<>();
        // 진입차수 세자
        int[] inDegree = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            int cnt = 0;
            for (Node tmp = students_in[i]; tmp != null; tmp = tmp.next) cnt++;
            inDegree[i] = cnt;
            if(cnt == 0) inDegreeZeroQue.offer(i); // 진입차수 0인 놈 큐에 넣기
        }
        // 진입차수 다 세아림
         
        // 진입차수 0인 놈부터 가자
        while(!inDegreeZeroQue.isEmpty()) {
            int inDegreeZeroStudent = inDegreeZeroQue.poll();
            Queue<Integer> bfsQue = new ArrayDeque<>();
            boolean[] isvisited = new boolean[N+1];
            bfsQue.offer(inDegreeZeroStudent);
            isvisited[inDegreeZeroStudent] = true;
            while(!bfsQue.isEmpty()) {
                int cur = bfsQue.poll();
                if(cur != inDegreeZeroStudent) studentCnt[cur]++;
                for (Node tmp = students[cur]; tmp != null; tmp = tmp.next) {
                    if(isvisited[tmp.to]) continue;
                    bfsQue.offer(tmp.to);
                    studentCnt[inDegreeZeroStudent]++;
                    isvisited[tmp.to] = true;
                    if(cur == inDegreeZeroStudent) { // 진입 끊어주기
                        inDegree[tmp.to]--;
                        if(inDegree[tmp.to] == 0) {
                            inDegreeZeroQue.offer(tmp.to);
                        }
                    }
                }
            }
        }
        int resCnt = 0;
        for (int i = 1; i < N+1; i++) {
            if(studentCnt[i] == N-1) resCnt++;
        }
             
        bw.write(resCnt + "\n");
         
        bw.flush();
        bw.close();
        br.close();
    }
}