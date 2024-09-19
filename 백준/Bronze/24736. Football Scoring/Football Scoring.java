import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int a = 0;
        int[] score = {6,3,2,1,2};
        for (int i = 0; i < 5; i++) {
            a += Integer.parseInt(st.nextToken()) * score[i];
        }

        s = br.readLine();
        st = new StringTokenizer(s, " ");
        int b = 0;
        for (int i = 0; i < 5; i++) {
            b += Integer.parseInt(st.nextToken()) * score[i];
        }
        sb.append(a).append(" ").append(b);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
