package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int R, C;
	static int [] dr,dc;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		dr = new int [] {0,1,0,-1};
		dc = new int [] {1,0,-1,0};
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String row = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = row.charAt(c);
			}
		}

		int N = Integer.parseInt(br.readLine());
		String[] floor = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(floor[i]);
			if (i % 2 == 0) {
				play(now, 0);
			} else {
				play(now, 1);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void play(int now, int dir) {
		if (dir == 0) {// 왼
			for (int c = 0; c < C; c++) {
				if (map[R - now][c] == 'x') {
					map[R - now][c]='.';
					break;
				}
			}
		} else {// 오
			for (int c = C-1; c >=0; c--) {
				if (map[R - now][c] == 'x') {
					map[R - now][c]='.';
					break;
				}
			}
		}
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		check();
	}

	private static void check() {
		int [] [] cluster = new int [R][C];
		Queue<int[]> q = new LinkedList<>();
		int lowest = 101;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='x' && cluster[r][c]==0) {
					List<int[]> list = new ArrayList<>();
					q.add(new int[] {r,c});
					list.add(new int [] {r,c});
					cluster[r][c] =1;
					lowest = R-r;
					while(!q.isEmpty()) {
						int [] poll = q.poll();
						int i = poll[0];
						int j = poll[1];
						for(int k=0;k<4;k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							if(nr>=0&& nr<R && nc >=0 && nc<C &&map[nr][nc]=='x' && cluster[nr][nc]==0) {
								q.add(new int [] {nr,nc});
								list.add(new int [] {nr,nc});
								cluster[nr][nc]=1;
								lowest = Math.min(lowest, R-nr);
							}
						}
						
					}
					if(lowest!=1) {
						down(list);
						return;
					}
				}
			}
		}
		
	}

	private static void down(List<int[]> list) {
		
		for(int i=0; i<list.size();i++) {
			int [] now = list.get(i);
			int r = now[0];
			int c = now[1];
			map[r][c]='.';
		}
		
		
		int ans = Integer.MAX_VALUE;
		
		
		for(int i=0; i<list.size();i++) {
			int [] now = list.get(i);
			int r = now[0];
			int c = now[1];
			int tmp =1;
			while(true) {
				if(r+tmp==R||map[r+tmp][c]=='x') {
					tmp-=1;
					ans = Math.min(ans, tmp);
					break;
				}
				tmp++;
			}
		}
		for(int i=0; i<list.size();i++) {
			int [] now = list.get(i);
			int r = now[0];
			int c = now[1];
			map[r+ans][c]='x';
		}
		
	}

}
