import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(m < 2) {
            sb.append("Before");
        } else if(m > 2) {
            sb.append("After");
        } else {
            if(n == 18) {
                sb.append("Special");
            } else if(n < 18) {
                sb.append("Before");
            } else {
                sb.append("After");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
