import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
	HashMap<Character, Node> child;
	boolean isEnd;
	public Node() {
		super();
		this.child = new HashMap<>();
		this.isEnd = false;
	}
	@Override
	public String toString() {
		return "Node [child=" + child + ", isEnd=" + isEnd + "]";
	}
}
class Trie {
	Node root;

	public Trie() {
		this.root = new Node();
	}
	
	public boolean insert(String str) {
		Node curNode = this.root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			curNode.child.putIfAbsent(c, new Node());
			curNode = curNode.child.get(c);
			if(curNode.isEnd) return false;
		}
		curNode.isEnd = true;
		return true;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		outer: for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] strs = new String[n];
			Trie trie = new Trie();
			for (int i = 0; i < n; i++) {
				strs[i] = br.readLine();
			}
			Arrays.sort(strs);
			for (int i = 0; i < n; i++) {
				if(!trie.insert(strs[i])) {
					sb.append("NO\n");
					continue outer;
				}
			}
			sb.append("YES\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
