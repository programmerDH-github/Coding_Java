import java.util.*;

public class Baek_Joon_2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arraylist = new ArrayList<>();

        int six = 1;
        arraylist.add(1);
        while(true) {
            if((arraylist.get(arraylist.size()-1) + (6*six)) > 1000000000) break;
            arraylist.add(arraylist.get(arraylist.size()-1) + (6*six));
            six++;
        }

        int answer = 1;
        for(int i = 0; i < arraylist.size(); i++) {
            if(N <= arraylist.get(i)) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
