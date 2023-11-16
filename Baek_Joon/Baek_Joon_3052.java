import java.util.*;

public class Baek_Joon_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int number = sc.nextInt();

            if(!arraylist.contains(number % 42)) arraylist.add(number % 42);
        }

        System.out.println(arraylist.size());
    }
}
