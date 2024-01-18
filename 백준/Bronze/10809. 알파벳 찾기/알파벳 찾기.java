import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        int idx = 97; // a
        while(idx<97+26) {
            System.out.print(target.indexOf((char)idx) + " ");
            idx++;
        }
    }
}
