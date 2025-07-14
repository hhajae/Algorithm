import java.io.*;
import java.util.*;

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
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        boolean[][] isVisited = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isVisited[i][j]) continue;
                isVisited[i][j] = true;
                cnt++;
                char c = arr[i][j];
                int curX = i;
                int curY = j;
                if(c == '-') {
                    while(true) {
                        int nx = curX;
                        int ny = curY + 1;
                        if(ny >= M) break;
                        if(arr[nx][ny] == '-' && !isVisited[nx][ny]) {
                            isVisited[nx][ny] = true;
                            curY = ny;
                        } else {
                            break;
                        }
                    }
                } else if (c == '|'){
                    while(true) {
                        int nx = curX + 1;
                        int ny = curY;
                        if(nx >= N) break;
                        if(arr[nx][ny] == '|' && !isVisited[nx][ny]) {
                            isVisited[nx][ny] = true;
                            curX = nx;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}