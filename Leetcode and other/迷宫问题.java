package leetcode;

/**
 * @Description: �Թ�����
 * @author karlieswift
 * @date 2020��4��7��
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

 *          ������ ����һ��map[10][10],setway�ķ�������Boolean,[i,j]�ֱ�������
 *          �涨����:��->��->-��->��,��������==0·����==1�����壬==2�������յ�·����==3�����·��ͨ
 */
public class �Թ����� {
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
 * @Description: �Թ��������
 * @author karlieswift
 * @date 2020��4��7��
 * @version "13.0.1"
 * 
 *          ������ ����һ��map[10][10],setway�ķ�������Boolean,[i,j]�ֱ�������
 *          �涨����:��->��->-��->��,��������==0·����==1�����壬==2�������յ�·����==3�����·��ͨ
 */
class Recursion {
	public boolean setway(int[][] map, int i, int j) {
		if (map[6][5] == 2) { // �����Ѿ��ҵ�
			return true;
		} else {
			if (map[i][j] == 0) {// ��������·��û��
				map[i][j] = 2;
				if (setway(map, i + 1, j)) {// ������
					return true;
				} else if (setway(map, i, j + 1)) {// ������
					return true;
				} else if (setway(map, i, j - 1)) {// ������
					return true;
				} else if (setway(map, i - 1, j)) {// ������
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