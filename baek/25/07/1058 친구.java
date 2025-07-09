
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int [][] dist = new int [N][N];
        for(int i=0;i<N; i++) {
        	String human = br.readLine();
        	for(int j=0;j<N;j++) {
        		if(human.charAt(j)=='Y') {
        			dist[i][j]=1;
        		}else if(i==j){
        			dist[i][j]=0;
        		}else {
        			dist[i][j] = 1001;
        			
        		}
        	}
        }
        
        for(int k=0;k<N;k++){
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			if(dist[i][j]>dist[i][k]+dist[k][j]) {
        				dist[i][j]=dist[i][k]+dist[k][j];
        			}
        		}
        	}
        }
        int most_pop =0;
         for(int i=0;i<N;i++) {
        	 int tmp =0;
        	 for(int j=0; j<N; j++) {
        		 if(i!=j && dist[i][j]<=2) {
        			 tmp++;
        		 }
        	 }
        	 if(tmp>most_pop) most_pop=tmp;
         }
        
    System.out.println(most_pop);
    }
}
