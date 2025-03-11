import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int recommend = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        Student[] students = new Student[101];
        ArrayList<Student> photo = new ArrayList<>();
        for(int i = 0; i < recommend; i++) {
            int num = Integer.parseInt(input[i]);
            if(students[num] != null) {
                students[num].like++;
            }
            else { 

                Collections.sort(photo);

                if(photo.size() == N) {                   

                    students[photo.get(N-1).number] = null;
                    photo.remove(N-1);

                }

                students[num] = new Student(num, 1, i);
                photo.add(students[num]);

            }
        }

        Collections.sort(photo, (o1,o2) -> o1.number - o2.number);

        for(int i = 0; i < photo.size(); i++) {
            System.out.print(photo.get(i).number + " ");
        }

    }

    static class Student implements Comparable<Student>{
        int number;
        int like;
        int idx;

        public Student(int number, int like, int idx) {
            this.number = number;
            this.like = like;
            this.idx = idx;
        }

        @Override
        public int compareTo(Student s) {
            if(this.like == s.like) return s.idx - this.idx;
            else return s.like - this.like;
        }

    }
}
