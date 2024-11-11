package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			map[i][0] = x + 1001;
			map[i][1] = y + 1001;

		}

		int whole = 0;
		int before = 0;
		for (int j = 1; j < N; j++) {
			whole += Math.abs(map[j][0] - map[before][0]) + Math.abs(map[j][1] - map[before][1]);
			before = j;
		}
		int max = 0;
		before = 0;
		for (int i = 1; i < N - 1; i++) {
			int tmp = (Math.abs(map[i][0] - map[before][0]) + Math.abs(map[i][1] - map[before][1])
					+ Math.abs(map[i+1][0] - map[i][0]) + Math.abs(map[i+1][1] - map[i][1]))
					- (Math.abs(map[i + 1][0] - map[before][0]) + Math.abs(map[i + 1][1] - map[before][1]));
			max = Math.max(max, tmp);
//			System.out.println(Math.abs(map[i][0] - map[before][0]) + Math.abs(map[i][1] - map[before][1]));
//			System.out.println(Math.abs(map[i+1][0] - map[i][0]) + Math.abs(map[i+1][1] - map[i][1]));
//			System.out.println(Math.abs(map[i + 1][0] - map[before][0]) + Math.abs(map[i + 1][1] - map[before][1]));
//			System.out.println(tmp);
			before = i;
		}
		int ans = whole - max;
		
		System.out.println(ans);

	}

}
