import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*N개의 구역으로 나뉨 2~10
 *  구역의 인구수 1~100
 * 선거구는 무조건 2개 
 * */
public class Main {
	static StringBuilder sb;
	static int N;
	static int Min = Integer.MAX_VALUE;
	static int[] zone, district;
	static List<List<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 구역의 개수

		String[] zones = br.readLine().split(" ");
		zone = new int[N];//해당 구역의 인구수 저장장
		list = new ArrayList<List<Integer>>(); // 인접리스트 생성
		district = new int[N]; // 어떤 구역에 속할지 저장하는 배열
		
		
		for (int i = 0; i < N; i++) {
			zone[i] = Integer.parseInt(zones[i]);
			// zone의 i 인덱스에 i+1번 구역의 인구수가 들어감, 1 번구역의 인구수 5
			list.add(new ArrayList<Integer>());
			// N만큼 list 생성해서 넣음
		} // 구역의 인구수 입력

		for (int i = 0; i < N; i++) {
			String[] edge = br.readLine().split(" ");
			int size = Integer.parseInt(edge[0]);
			// i번 구역의 인접 정점
			for (int j = 1; j <= size; j++) {
				list.get(i).add(I수
					}
				}
				Min = Math.min(Min, Math.abs(a-b));
			}
			return;
		}

		district[depth] = 0;
		dfs(depth + 1);
		district[depth] = 1;
		dfs(depth + 1);

	}

	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		visited[idx] = true;
		q.add(idx);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0;i<list.get(now).size();i++) {
				if(district[list.get(now).get(i)-1]==district[now] && !visited[list.get(now).get(i)-1]) {
					visited[list.get(now).get(i)-1]=true;
					q.add(list.get(now).get(i)-1);
				}
			}
			
		}
		
	}

}
