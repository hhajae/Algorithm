import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] Arr = new int[N];
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        /// input end ///
        long[] accArr = new long[N];
        HashMap<Long, Integer> map = new HashMap<>();
        long cnt = 0;
        accArr[0] = Arr[0];
        if(accArr[0] == K) cnt++;
        map.put(accArr[0], 1);
        for (int i = 1; i < N; i++) {
            accArr[i] = Arr[i] + accArr[i - 1];
            if(accArr[i] == K) cnt++;
            long find = accArr[i] - K;
            cnt += map.getOrDefault(find, 0);
            map.put(accArr[i], map.getOrDefault(accArr[i], 0) + 1);
        }

        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
