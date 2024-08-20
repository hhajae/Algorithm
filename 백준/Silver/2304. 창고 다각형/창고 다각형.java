import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        int[] squares = new int[1001];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			squares[L] = H; 
			if(H > maxHeight) maxHeight = H;
		}
        /// input end ///
        Deque<int[]> deq = new LinkedList<>();
        List<int[]> maxHeightLst = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
        	if(squares[i] == 0) continue;
			deq.addLast(new int[] {i, squares[i]});
			// 최고높이 여러개 인것도 찾자
			if(squares[i] == maxHeight) {
				maxHeightLst.add(new int[] {i, squares[i]});
			}
		}
        int leftMaxHeightPos = maxHeightLst.get(0)[0];
        int rightMaxHeightPos = maxHeightLst.get(maxHeightLst.size()-1)[0];
        int polyArea = 0;
        // 좌 (최고 높이에 도달할 때 까지)
        int[] leftStart = deq.pollFirst();
        int cur_ind = leftStart[0];
        int cur_height = leftStart[1];
        if(cur_height == maxHeight) {
        	polyArea += maxHeight * (rightMaxHeightPos - leftMaxHeightPos + 1);
    		if(deq.size() != 0 && deq.peekLast()[0] == rightMaxHeightPos) {
    			if(maxHeightLst.size() != 1) deq.clear();
    		}
        }
        else {
        	while(!deq.isEmpty()) {
            	leftStart = deq.pollFirst();
            	if(leftStart[1] == maxHeight) {
            		if(cur_height == maxHeight) {
            			polyArea += maxHeight * (rightMaxHeightPos - leftMaxHeightPos + 1);
                		if(deq.size() != 0 && deq.peekLast()[0] == rightMaxHeightPos) {
                			if(maxHeightLst.size() != 1) deq.clear();
                		}
            		}
            		else {
            			polyArea += cur_height * (leftStart[0] - cur_ind);
                		polyArea += maxHeight * (rightMaxHeightPos - leftMaxHeightPos + 1);
                		if(deq.size() != 0 && deq.peekLast()[0] == rightMaxHeightPos) {
                			if(maxHeightLst.size() != 1) deq.clear();
                		}
            		}
            		break;	
            	}
            	if(leftStart[1] <= cur_height) continue;
            	polyArea += cur_height * (leftStart[0] - cur_ind);
            	cur_ind = leftStart[0];
            	cur_height = leftStart[1];
            }
        }
        // 최고 높이 더해주기
        if(maxHeightLst.size() == 1) {
        	deq.addFirst(new int[] {leftMaxHeightPos, maxHeight});
        }
        
        // 우 (최고 높이에 도달할 때 까지)
        if(deq.size() > 1) {
            int[] rightStart = deq.pollLast();
            cur_ind = rightStart[0]; // 4
            cur_height = rightStart[1]; // 3
            if(cur_height == maxHeight) {
            	polyArea += maxHeight;
            }
            else {
                while(!deq.isEmpty()) {
                	rightStart = deq.pollLast();
                	if(rightStart[1] == maxHeight) {
                		polyArea += cur_height * (cur_ind - rightStart[0]);
                		break;	
                	}
                	if(rightStart[1] <= cur_height) continue;
            		polyArea += cur_height * (cur_ind - rightStart[0]);
                	cur_ind = rightStart[0];
                	cur_height = rightStart[1];
                }
            }
        }

        bw.write(polyArea + "\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}
