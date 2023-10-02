import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static StringBuilder sb;
	static int[] cp;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
  //사용한 색종이의 최소값을 담을 ans
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		cp = new int[] { 0, 5, 5, 5, 5, 5 }; 
    // 1~5번 인덱스에 각 인덱스에 해당하는 크기를 가진 색종이의 개수를 셀 것
		map = new int[10][10]; 
    // 크기 10의 map 생성

		for (int i = 0; i < 10; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		} // map에 값 입력

		search(0,0,0);
    //x,y,cnt 에 대해 dfs를 수행
		
		if(ans==Integer.MAX_VALUE) {
			sb.append(-1);//ans에 변화가 없으면
		}else {
			sb.append(ans);
		}

    
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void search(int x, int y, int cnt) {
		if(x>= 9 && y>9) { //마지막 행의 마지막 열을 지났으면  
			ans = Math.min(ans, cnt);
			return;
		}
    
		if(ans<=cnt) {
			return;
		}//이전에 나왔던 ans보다 지금의 cnt가 크다면 return
    
		if(y>9) {
			search(x+1,0,cnt);
			return;
		}//마지막 열을 탐색했으면 행을 바꿈꿈
		
		if(map[x][y]==1) {//색종이를 붙여야하면
			for(int i=5;i>=1;i--) {//큰 색종이부터 붙여봄
				if(cp[i]>0 &&check(x,y,i) ) {//해당하는 색종이를 붙일 수 있으면 
					change(x,y,i,0);//붙였음을 표시
					cp[i]--;//해당 색종이를 붙였음을 배열에 저장
					search(x,y+1,cnt+1);//다음 열부터 다시 dfs
					//원상복귀
          change(x,y,i,1);
					cp[i]++;
				}
			}
		}else {
			search(x,y+1,cnt);//색종이를 붙일 수 없으면 다음 행 탐색
		}
	}

	private static void change(int x, int y, int size, int num) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = num;
			}
		}//num에 해당하는 값 map에 입력
		
	}

	private static boolean check(int x, int y, int size) {//갈 수 있는지 없는지 판별
		for(int i=x; i<x+size;i++) {//탐색한 x y를 기준으로 i였던 size만큼 탐색해서 판별
			for(int j=y; j<y+size; j++) {
				if(i<0 || i>=10 || j<0 || j >=10) {	// 범위 벗어남
					return false;
				}//범위를 벗어나는 값이 하나라도 있으면 false return
				
				if(map[i][j] != 1) {	// 1이 아님
					return false;
				}
			}
		}
		return true; //범위 내에 모든 값이 1이면 
	}

}
