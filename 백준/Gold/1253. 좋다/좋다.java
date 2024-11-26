import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String s = br.readLine();
        st = new StringTokenizer(s, " ");

        if(N <= 2) {
            sb.append(0);
            bw.flush();
            bw.close();
            System.exit(0);
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        Arrays.sort(arr);

        outer: for(int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            int cur = arr[i];
            while(start < end) {
                if(start == i) {
                    start++;
                    continue;
                }
                if(end == i) {
                    end--;
                    continue;
                }

                int sum = arr[start] + arr[end];
                if(cur == sum) {
                    res++;
                    continue outer;
                }
                if(cur > sum) {
                    start++;
                } else if (cur < sum) {
                    end--;
                }
            }
        }
        sb.append(res);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
