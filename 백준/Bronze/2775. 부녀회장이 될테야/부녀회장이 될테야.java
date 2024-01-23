import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int  i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apartment = new int[k+1][n+1];
            
            for(int j=1; j<n+1; j++) {
                apartment[0][j] = j;
            }

            for(int j=1; j<k+1; j++) {
                for(int l=1; l<n+1; l++) {
                    apartment[j][l] = apartment[j-1][l] + apartment[j][l-1];
                }
            }

            System.out.println(apartment[k][n]);
        }

        br.close();
    }
}