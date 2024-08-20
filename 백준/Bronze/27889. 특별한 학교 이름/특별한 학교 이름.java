import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        if(s.equals("NLCS")) sb.append("North London Collegiate School");
        else if(s.equals("BHA")) sb.append("Branksome Hall Asia");
        else if(s.equals("KIS")) sb.append("Korea International School");
        else if(s.equals("SJA")) sb.append("St. Johnsbury Academy");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
