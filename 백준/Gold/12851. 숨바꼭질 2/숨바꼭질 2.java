import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N == K) {
            System.out.println("0\n1"); return;
        } else if(N > K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }
        Queue<int[]> que = new ArrayDeque<int[]>();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);
        que.offer(new int[]{N, 0});
        dist[N] = 0;
        int minTime = Integer.MAX_VALUE;
        int resCnt = 0;
        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int cur = arr[0];
            int time = arr[1];
            if(time > minTime) continue;
            for (int i = 0; i < 3; i++) {
                int next = getPos(cur, i);
                if(next < 0 || next > 100000) continue;
                if(dist[next] >= 0 && (time+1) != dist[next]) continue;
                if(next == K) {
                    if(minTime == Integer.MAX_VALUE) {
                        minTime = time;
                        resCnt++;
                        continue;
                    }
                    if(time == minTime) {
                        resCnt++;
                        continue;
                    }
                }
                que.offer(new int[] {next, time + 1});
                dist[next] = dist[cur] + 1;
            }
        }
        sb.append(minTime+1).append("\n").append(resCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getPos(int cur, int i) {
        if(i == 0) {
            return cur * 2;
        } else if(i == 1) {
            return cur + 1;
        } else if(i == 2) {
            return cur - 1;
        }
        return -1;
    }
}
