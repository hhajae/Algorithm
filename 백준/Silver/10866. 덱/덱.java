import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // 이름 바꾸기 //
	public static int MX = 1000005;
	 public static int[] dat = new int[MX*2+1];
	 public static int head = MX;
	 public static int tail = MX;
	 public static void push_front (int x) {
	     dat[--head] = x;
	 }
	 public static void push_back (int x) {
	     dat[tail++] = x;
	 }
	 public static int pop_front () {
	     return dat[head++];
	 }

	 public static int pop_back () {
	     return dat[--tail];
	 }
	 public static int front () {
	     return dat[head];
	 }
	 public static int back () {
	     return dat[tail-1];
	 }
	 public static void main(String[] args) throws IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st = null;

	     int N = Integer.parseInt(br.readLine());
	     for (int i = 0; i < N; i++) {
	         String s = br.readLine();
	         if (s.equals("front")) {
	        	 if (head != tail) {
	        		 bw.write(front() + "\n");
	        	 }
	        	 else bw.write(-1 + "\n");
	         } 
	         else if (s.equals("back")) {
	        	 if (head != tail) {
	        		 bw.write(back() + "\n");
	        	 }
	        	 else bw.write(-1 + "\n");
	         } 
	         else if (s.equals("size")) {
	        	 bw.write(tail-head + "\n");
	         } 
	         else if (s.equals("empty")) {
	        	 if (head == tail) bw.write(1 + "\n");
	        	 else bw.write(0 + "\n");
	         } 
	         else if (s.contains("pop")) {
	        	 if (s.contains("front")) {
	        		 if (head != tail) bw.write(pop_front() + "\n");
	        		 else bw.write(-1 + "\n");
	        	 }
	        	 else {
	        		 if (head != tail) bw.write(pop_back() + "\n");
	        		 else bw.write(-1 + "\n");
	        	 }
	         } 
	         else if (s.contains("push")) {
	        	 st = new StringTokenizer(s, " ");
	        	 String s_ = st.nextToken();
	        	 int n = Integer.parseInt(st.nextToken());
	    	 if (s.contains("front")) {
	    		 if (head <= tail) push_front(n);
	    	 }
	    	 else {
	    		 if (tail >= head) push_back(n);
	    	 }
	         }
	     }

	     bw.flush();
	     bw.close();
	     br.close();
	 }
}