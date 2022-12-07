package Algorithm;

public class DFS {

	static boolean[][] check;
	static int count = 0;
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,1,1},{0,1,0,1,1},{1,0,0,1,0},{1,1,0,0,1}};
		check = new boolean[arr.length][arr[0].length];
		
		// ��ü üũ�� ���� 2�� ����
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(!check[i][j] && arr[i][j] == 1) {
					dfs(i,j,arr);
					count++;
				}
			}
		}
		
		System.out.println(count);		

	}
	
	public static void dfs(int x, int y, int[][] arr) {
		// �湮 üũ
		check[x][y] = true;
		
		// �����¿� ��ǥ
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		
		for(int index = 0; index < dx.length; index++) {
			int nx = x + dx[index];
			int ny = y + dy[index];
			
			// ��ǥ�� ��� �ȿ� �־�� ��
			if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
				if(!check[nx][ny] && arr[nx][ny] == 1) {
					dfs(nx,ny, arr);
				}					
			}
		}
	}

}
