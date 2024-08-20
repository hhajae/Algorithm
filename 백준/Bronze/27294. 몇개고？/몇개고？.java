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
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        if(S == 1 || T <= 11 || T >= 17) sb.append("280");
        else sb.append("320");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
