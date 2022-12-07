package Test;

public class Line_test3 {
	
	static boolean[][] fireArea;
	static boolean[][] iceArea;
	static int[][] fireArr;
	static int[][] iceArr;
	static int[][] fireMove = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1}};
	static int[][] iceMove = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		int n = 3; int m = 2; int[][] fires = {{1,1}}; int[][] ices = {{3,3}};
		long[][] answer = new long[n][n];
		fireArr = new int[n][n];
		iceArr = new int[n][n];
		fireArea = new boolean[n][n];
		iceArea = new boolean[n][n];
		
		for(int i = 0; i < ices.length; i++) {
			totem(0,m,fires,ices,ices[i][0]-1,ices[i][1]-1);
		}
		
		for(int i = 0; i < iceArr.length; i++) {
			for(int j = 0; j < iceArr[i].length; j++) {
				System.out.print(iceArr[i][j] +" ");
			}
			System.out.println();
		}
		

	}
	
	public static void totem(int t,int m,int[][] fireTotem,int[][] iceTotem,int x,int y) {
		if(t == m) {
			return;
		}
		
		iceArea[x][y] = true;
		iceArr[x][y] = m-t;
		for(int i = 0; i < 4; i++) {
			int nx = x + iceMove[i][0];
			int ny = y + iceMove[i][1];
			if(nx >= 0 && ny >= 0 && nx < iceArr.length && ny < iceArr.length) {
				if(!iceArea[nx][ny] && iceArr[nx][ny] == 0) {
					iceArr[nx][ny] = m-t+3;
					totem(t+1,m,fireTotem,iceTotem,nx,ny);
					iceArea[nx][ny] = false;
				}
			}
			
		}
	}
	
	

}
