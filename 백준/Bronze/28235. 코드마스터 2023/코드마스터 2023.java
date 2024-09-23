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
        if(s.equals("SONGDO")) sb.append("HIGHSCHOOL");
        else if(s.equals("CODE")) sb.append("MASTER");
        else if(s.equals("2023")) sb.append("0611");
        else if(s.equals("ALGORITHM")) sb.append("CONTEST");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
