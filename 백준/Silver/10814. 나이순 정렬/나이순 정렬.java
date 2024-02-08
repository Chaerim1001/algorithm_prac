import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Person[] arr = new Person[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(age, name);
        }

        Arrays.sort(arr, (p1, p2) -> p1.age - p2.age);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Person p: arr) {
            bw.write(p.age + " " + p.name + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
