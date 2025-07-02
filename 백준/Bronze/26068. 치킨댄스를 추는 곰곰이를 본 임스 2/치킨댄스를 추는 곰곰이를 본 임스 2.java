import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            int d = Integer.parseInt(s.substring(2));
            if(d <= 90) cnt++;
        }
        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}