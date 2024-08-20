import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        st = new StringTokenizer(s);
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int mapSize = 0;
        int maxFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(end < N) {
//            System.out.println("start, end = " + start + ", " + end);
            mapSize = map.size();
            if(mapSize <= 2) {
                int fruit = fruits[end];
                map.put(fruit, map.getOrDefault(fruit, 0) + 1);
                if(map.size() <= 2) {
                    maxFruits = Math.max(maxFruits, end-start+1);
                }
                end++;
            } else {
                int fruit = fruits[start];
                map.replace(fruit, map.get(fruit) - 1);
                if(map.get(fruit) == 0) {
                    map.remove(fruit);
                }
                start++;
            }
        }
        sb.append(maxFruits).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
