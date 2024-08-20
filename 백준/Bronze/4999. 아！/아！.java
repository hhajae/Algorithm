import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String b = br.readLine();
        if(a.length() < b.length()) sb.append("no");
        else sb.append("go");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
