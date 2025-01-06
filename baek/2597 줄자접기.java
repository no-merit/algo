import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		double N = Double.parseDouble(br.readLine());
		
		double [][] map = new double[3][2]; 
		for(int i=0; i<3; i++) {
			String [] color = br.readLine().split(" ");
			double num1 = Double.parseDouble(color[0]);
			double num2 = Double.parseDouble(color[1]);
			map[i][0] = num1;
			map[i][1] = num2;
		}
		for(int i=0; i<3; i++) {
			if(map[i][0]==map[i][1]) continue;
			double point = (map[i][0]+map[i][1])/2;
			N = Math.max(N-point, point);
			
			if(N==point) {
				for(int j=2; j>i;j--) {
					for(int k=0; k<2;k++) {
						if(map[j][k]>N)
							map[j][k] = point-(map[j][k]-point);
					}
				}
			}else {
				for(int j=2; j>i;j--) {
					for(int k=0; k<2;k++) {
							map[j][k] = Math.abs(map[j][k]-point);
					}
				}
			}
		}
		
		
		
		System.out.println(N);
		
	}

}
