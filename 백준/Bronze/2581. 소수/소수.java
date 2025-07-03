import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        boolean[] arr = new boolean[10001];
        arr[1] = true;
        for (int i = 2; i <= 5000; i++) {
            if(arr[i]) continue;
            int tmp = i;
            while(true) {
                tmp = tmp + i;
                if(tmp > 10000) break;
                arr[tmp] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = N; i < M+1; i++) {
            if(!arr[i]) {
                sum += i;
                min = Math.min(i, min);
            }
        }

        if(sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}