import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int decimal = Integer.parseInt(s, 16);
        sb.append(decimal);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
