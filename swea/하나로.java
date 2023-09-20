import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	static int N;
	static Double E;
	static double [][] island;
	static List<double[]> edge;
	static int [] parent;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		//테케수
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			
			N = Integer.parseInt(br.readLine());
			
			String [] Xs = br.readLine().split(" ");
			String [] Ys = br.readLine().split(" ");
			island = new double[N+1][2];
			edge = new ArrayList<>();
			parent = new int[N+1];
			visited = new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				island[i][0] = Integer.parseInt(Xs[i-1]);
				island[i][1] = Integer.parseInt(Ys[i-1]);
//				System.out.println("island[i][0]: "+island[i][0]+ "  island[i][1] :"+island[i][1]);
			}
		
			E= Double.parseDouble(br.readLine());
			
			dfs(0, 1);
			
//			System.out.println("정렬전");
//			for(int i=0; i<edge.size(); i++) {
//				System.out.println("edge.get(i)[0]: "+ edge.get(i)[0]+" edge.get(i)[1]: "+ edge.get(i)[1]+"edge.get(i)[2]: "+edge.get(i)[2]);
//			}
			Collections.sort(edge, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1[2],o2[2]);
				}
			});
//			System.out.println("정렬후");
//			for(int i=0; i<edge.size(); i++) {
//				System.out.println("edge.get(i)[0]: "+ edge.get(i)[0]+" edge.get(i)[1]: "+ edge.get(i)[1]+"edge.get(i)[2]: "+edge.get(i)[2]);
//			}
			for(int i=1; i<=N; i++) {
				parent[i]=i;
			}
			
			int cnt=0;
			
			double ans=0;
			
			for(int i=0; i<edge.size(); i++) {
				int x =(int)edge.get(i)[0];
				int y =(int)edge.get(i)[1];
				if(find(x)!=find(y)) {
//					System.out.println("Union : "+(int)edge.get(i)[0] + " "+(int)edge.get(i)[1] );
					union(x,y);
//					for(int j=1; j<=N; j++) {
//						System.out.print(parent[j]+" ");
//					}
//					System.out.println();
					cnt++;
					ans+=edge.get(i)[2];
//					System.out.println(i+"더해지는 값 : "+edge.get(i)[2]+" "+i+" 번째 반복  ans: "+ans);
				}
				if(cnt>=N-1) break;
			}
			
			sb.append( Math.round(ans)).append("\n");
		} // tc 반복

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}// main

	static void dfs(int depth, int idx) {
		if(depth==2) {
			double [] vi =new double [3];
			for(int i=1; i<=N; i++) {
				if(visited[i]) {
					if(vi[0]!=0) {
						vi[1]=i;
					}else {
						vi[0]=i;
					}
				}
			}
			double x =island[(int)vi[0]][0]- island[(int)vi[1]][0];
			double y =island[(int)vi[0]][1]- island[(int)vi[1]][1];
			double dis =(Math.pow(x, 2)+Math.pow(y, 2))*E;
			vi[2] = dis;
			edge.add(vi);
			return;
		}// 기저 
		if(idx>N) return;
		
		visited[idx] =true;
		dfs(depth+1,idx+1);
		visited[idx] =false;
		dfs(depth,idx+1);
		
	}
	
	static int find (int idx) {
		if(parent[idx]!=idx) {
			parent[idx]=find(parent[idx]);
		}
		return parent[idx];
	}
	
	static void union(int A, int B) {
		if(find(A)!=find(B))
			parent[find(B)]=parent[A];
	}

	
}
