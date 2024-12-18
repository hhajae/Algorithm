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
        st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int A = list.get(0) + list.get(3);
        int B = list.get(1) + list.get(2);
        int res = A > B ? A-B : B-A;
        sb.append(res);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
