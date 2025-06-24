import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Team{
	int seq;
	Map<Integer, Integer> map = new HashMap<>();
	Team(int seq){
		this.seq= seq;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc =0; tc<T; tc++) {
			String[] nktm = br.readLine().split(" ");
			int n = Integer.parseInt(nktm[0]);//팀 수 
			int k = Integer.parseInt(nktm[1]);//문제 수
			int t = Integer.parseInt(nktm[2]);//팀 명
			int m = Integer.parseInt(nktm[3]);//로그 수
			
			List<Team> list = new ArrayList<>();
			
			for(int i=0; i<=n; i++) {
				list.add(new Team(i));
			}
			int [] submissionCounts  = new int[n+1];
			int [] submissionOrders = new int[n+1];
			int [] scores  = new int[n+1];
			for(int i = 0; i<m; i++) {
				String [] log = br.readLine().split(" ");
				int log_t = Integer.parseInt(log[0]);
				int log_k_num = Integer.parseInt(log[1]);
				int log_k_score = Integer.parseInt(log[2]);
				int score = list.get(log_t).map.getOrDefault(log_k_num, 0);
				if(score<log_k_score) {
					list.get(log_t).map.put(log_k_num, log_k_score);
				}
				submissionOrders[log_t]=i;
				submissionCounts[log_t]++;
			}
			for(Team now: list) {
				int score = 0;
				for(int i: now.map.values()) {
					score+=i;
				}
				scores[now.seq]=score;
			}
			int cnt =0;
			List<Integer> same = new ArrayList<>();
 			for(int i=1; i<=n; i++) {
				if(scores[i]>scores[t]) cnt++;
				else if(scores[i]==scores[t]) {
					same.add(i);
				}
			}
 			for(int i: same) {
 				if(submissionCounts[i]==submissionCounts[t]) {
 					if(submissionOrders[i]<submissionOrders[t]) {
 						cnt++;
 					}
 				}else if(submissionCounts[i]<submissionCounts[t]){
 					cnt++;
 				}
 			}
 			sb.append(cnt+1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
