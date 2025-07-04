import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder resSb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s, " ");
        int[] arr = new int[M + 2];
        for (int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[M+1] = N;
        Arrays.sort(arr);
        boolean[] res = new boolean[N+1];
        for (int i = 0; i < M + 1; i++) {
            int num = arr[i];
            for (int j = i+1; j < M + 2; j++) {
                int sub = arr[j] - num;
                res[sub] = true;
            }
        }

        for (int i = 1; i < N+1; i++) {
            if(res[i]) resSb.append(i).append(" ");
        }

        bw.write(resSb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}