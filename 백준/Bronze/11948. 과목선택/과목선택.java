import java.io.*;
        import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        list1.add(A);
        list1.add(B);
        list1.add(C);
        list1.add(D);
        int E = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        List<Integer> list2 = new ArrayList<>();
        list2.add(E);
        list2.add(F);

        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());

        sb.append(list1.get(0) + list1.get(1) + list1.get(2) + list2.get(0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
