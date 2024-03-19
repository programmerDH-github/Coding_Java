import java.io.*;
import java.util.*;

public class Baek_Joon_10815 {
    static int[] have_card;
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] have_cards = br.readLine().split(" ");
        have_card = new int[N];
        for(int i = 0; i < N; i++) {
            have_card[i] = Integer.parseInt(have_cards[i]);
        }
        Arrays.sort(have_card);

        int M = Integer.parseInt(br.readLine());
        String[] compare_cards = br.readLine().split(" ");

        for(int i = 0; i < compare_cards.length; i++) {
            if(binarySearch(Integer.parseInt(compare_cards[i]),0,have_cards.length-1) == -1) System.out.print(0 + " ");
            else System.out.print(1 + " ");
        }
    }

    public static int binarySearch(int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;
            if(key == have_card[mid]) {
                return mid;
            }
            else if(key < have_card[mid]) {
                return binarySearch(key, low, mid-1);
            }
            else {
                return binarySearch(key, mid+1, high);
            }
        }

        return -1;
    }
}
