import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int stringLength = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int answer = 0;

        for(int i=1; i<stringLength-1;) {
            if(str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                count++;
                if(count == N) {
                    if(str.charAt(i-(count*2-1)) == 'I') answer++;
                    count--;
                }
                i += 2;
            } else {
                count = 0;
                i++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
