package leetcode;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月13日
 * @version "13.0.1"
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组最小值 {
	public static void main(String[] args) {
		int[] array1 = { 1, 1, 1, 0, 1 };
		int[] array2 = { 3, 4, 5, 1, 2 };

		int min1 = new 旋转数组最小值().minNumberInRotatearrayay(array1);
		System.out.println(min1);
		int min2 = new 旋转数组最小值().minNumberInRotatearrayay(array2);
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