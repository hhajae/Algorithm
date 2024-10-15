import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[] minutes = {3, 20, 120};
        int A = 0;
        int B = 0;
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < 3; i++) {
            A += minutes[i] * Integer.parseInt(st.nextToken());
        }

        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < 3; i++) {
            B += minutes[i] * Integer.parseInt(st.nextToken());
        }
        String res = A > B ? "Max" : (A == B ? "Draw" : "Mel");
        sb.append(res);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
