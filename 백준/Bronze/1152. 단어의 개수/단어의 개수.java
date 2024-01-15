import java.io.*;
     
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        if(arr.length != 0 && arr[0].equals("")) System.out.print(arr.length-1);
        else System.out.print(arr.length);

        br.close();
    }
}
