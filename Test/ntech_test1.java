package Test;
import java.util.Arrays;
import java.util.Comparator;

public class ntech_test1 {
	public static void main(String[] args) {
		int[][] arr = {{1,4}, {3,5}, {8,10}};
		int answer = 0;
		
		//2���� �迭 ����
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					//ex) arr[0][0] == arr[1][0] �̸� arr[0][1] �� arr[1][1] ��
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});

		/* 2���� �迭 ����
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1]; 
			}
			else {
				return o1[0] - o2[0];
			}
		});
		*/
		
		int s = arr[0][0];
		int e = arr[0][1];
		for(int i = 0; i < arr.length; i++) {
			if(i+1 >= arr.length) {
				answer += e - s;
				break;
			}
			
			if(e < arr[i+1][0]) {
				answer += e - s;
				s = arr[i+1][0];
				e = arr[i+1][1];
				
			}
			else if(e >= arr[i+1][1]) {
				continue;
			}
			else {
				e = arr[i+1][1];
				continue;
			}
		}
		
		System.out.println(answer);
		
	}

}

/*	���� 1
  	{1,4}, {3,5}, {8,10}
  
  	6
*/
/*	���� 2
	{1,2}, {3,4}

	2
*/
/*	���� 3
	{1,10}, {2,8}, {3,5}

	9
*/
/*	���� 4
	{200,300}, {100,200}

	200
*/
