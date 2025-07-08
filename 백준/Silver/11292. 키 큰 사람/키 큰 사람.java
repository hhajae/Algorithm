import java.io.*;
import java.util.*;

class Person implements Comparable<Person>{
    String name;
    double height;

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(o.height, this.height);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            List<Person> persons = new ArrayList<>();
            String s;
            for (int i = 0; i < N; i++) {
                s = br.readLine();
                st = new StringTokenizer(s, " ");
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                persons.add(new Person(name, height));
            }

            Collections.sort(persons);
            double maxHeight = persons.get(0).height;
            for (Person person : persons) {
                double height = person.height;
                if(height == maxHeight) {
                    sb.append(person.name).append(" ");
                } else {
                    break;
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}