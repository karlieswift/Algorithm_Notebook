package leetcode;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��13��
 * @version "13.0.1"
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class ��ת������Сֵ {
	public static void main(String[] args) {
		int[] array1 = { 1, 1, 1, 0, 1 };
		int[] array2 = { 3, 4, 5, 1, 2 };

		int min1 = new ��ת������Сֵ().minNumberInRotatearrayay(array1);
		System.out.println(min1);
		int min2 = new ��ת������Сֵ().minNumberInRotatearrayay(array2);
		System.out.println(min2);
	}

	public int minNumberInRotatearrayay(int[] array) {
		int index1 = 0;
		int index2 = array.length - 1;
		int midindex = index1;
		while (array[index1] >= array[index2]) {
			if (index2 - index1 == 1) {
				midindex = index2;
				break;
			}
			midindex = (index1 + index2) / 2;
			if (array[index1] == array[index2] && array[index1] == array[midindex]) {
				for (int i = index1 + 1; i < index2; i++) {
					if (array[i] < array[midindex]) {
						midindex = i;
					}
				}
				break;
			}
			if (array[index1] <= array[midindex]) {
				index1 = midindex;
			}
			if (array[index2] >= array[midindex]) {
				index2 = midindex;
			}

		}
		return array[midindex];
	}
}