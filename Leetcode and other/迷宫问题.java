package leetcode;

/**
 * @Description: 迷宫问题
 * @author karlieswift
 * @date 2020年4月7日
 * @version "13.0.1"
1 1 1 1 1 1 1 
1 0 0 0 0 0 1 
1 0 0 0 0 0 1 
1 1 1 0 0 0 1 
1 0 0 0 0 0 1 
1 0 0 0 0 0 1 
1 0 0 0 0 0 1 
1 1 1 1 1 1 1 

1 1 1 1 1 1 1 
1 * 0 0 0 0 1 
1 * * * 0 0 1 
1 1 1 * 0 0 1 
1 0 0 * 0 0 1 
1 0 0 * 0 0 1 
1 0 0 * * * 1 
1 1 1 1 1 1 1  

 *          分析： 定义一个map[10][10],setway的方法返回Boolean,[i,j]分别代表起点
 *          规定方向:下->右->-左->上,定义数组==0路径，==1代表挡板，==2代表最终的路径，==3代表此路不通
 */
public class 迷宫问题 {
	public static void main(String[] args) {
		int[][] map = new int[8][7];
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
//		map[2][2]=1;
//		map[1][2]=1;

		Recursion r = new Recursion();
		r.showmap(map);
		System.out.println();

		r.setway(map, 1, 1);
		r.showmap(map);
	}
}

/**
 * @Description: 迷宫问题回溯
 * @author karlieswift
 * @date 2020年4月7日
 * @version "13.0.1"
 * 
 *          分析： 定义一个map[10][10],setway的方法返回Boolean,[i,j]分别代表起点
 *          规定方向:下->右->-左->上,定义数组==0路径，==1代表挡板，==2代表最终的路径，==3代表此路不通
 */
class Recursion {
	public boolean setway(int[][] map, int i, int j) {
		if (map[6][5] == 2) { // 代表已经找到
			return true;
		} else {
			if (map[i][j] == 0) {// 代表这条路还没走
				map[i][j] = 2;
				if (setway(map, i + 1, j)) {// 向下走
					return true;
				} else if (setway(map, i, j + 1)) {// 向右走
					return true;
				} else if (setway(map, i, j - 1)) {// 向左走
					return true;
				} else if (setway(map, i - 1, j)) {// 向上走
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {// map[i][j]!=0 1,2,3
				return false;
			}
		}
	}

	public void showmap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]==2) {
					System.out.print("*"+" ");
				}
				else {
				 System.out.print(map[i][j] + " ");
				}
					
			}
			System.out.println();
		}
	}
}