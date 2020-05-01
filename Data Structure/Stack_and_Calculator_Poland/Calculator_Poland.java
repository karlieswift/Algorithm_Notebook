package Stack_and_Calculator_Poland;
import java.util.*;
public class Calculator_Poland {
/**
 * 
 * @Description: <Function>����һ��ջ
 * @author  karlieswift
 * @date 2020��4��15��
 * @version "13.0.1"
 * ͨ����׺���ʽ ����
 * �沨�����ʽ=��׺���ʽ
 * ˼·��  �����ַ���---->���ַ���ת��Ϊ��׺ArrayList---->ת��Ϊ��׺ArrayList--->����calculator����
 * 
 * ������
 * string_to_list(String str) �����ַ���ת��ΪArrayList ���ڲ���
 * in_to_post(List<String> list)  :����׺ת��Ϊ��׺
 * calculator(List<String> list) ������׺���ʽ ArrayList���ʹ��� �ó����ʽ���
 * calculator(String str):ֱ�Ӵ����ַ����ó����ʽ���
 * priority_operator(String str):���������ȼ���С�Ƚ�
 * 
 * �����
 * ԭ���ʽ[��׺���ʽ]:1+((2+3)*4)-5
 * ���ַ�ת��ΪArrayList:[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
 * ��׺���ʽ:[1, 2, 3, +, 4, *, +, 5, -]
 * ���ʽ:1+((2+3)*4)-5=16
 * 16
 * 
 */ 
	public static void main(String[] args) {
		String expression = "1+((2+3)*4)-5";
		System.out.println("ԭ���ʽ[��׺���ʽ]:" + expression);

		List<String> list = string_to_list(expression);
		System.out.println("���ַ�ת��ΪArrayList:" + list);
		// ��׺ת����׺
		list = in_to_post(list);
		System.out.println("��׺���ʽ:" + list);
		// ������
		int result = calculator(list);
		System.out.println("���ʽ:" + expression + "=" + result);
		//ֱ�Ӵ��� �ַ���"1+((2+3)*4)-5"
		System.out.println(calculator(expression));//16
	}

	// ��strת��Ϊlist 22+3-3ת��Ϊ[22,+,3,-,3]
	// "1+((2+3)*4)-5"=============[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
	public static List<String> string_to_list(String str_1) {
		List<String> list = new ArrayList<String>();
		char[] str_2 = str_1.toCharArray();
		for (char item : str_2) {
			list.add("" + item);
		}
		return list;
	}

	/**
	 * ��׺���ʽת��׺���ʽ
	 * [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]-------------[1, 2, 3, +, 4, *, +, 5, -]
	 * 
	 * ˼·��
	 * ����һ������ջ(����ֱ����list)��һ������ջ(stack)���������ֽ���list
	 * �������ַ���������ֱ�ӽ���stack,������������ȼ�С�ڵ���ջ����Ԫ�أ�ջ����ջȡ����ȥlist
	 * ��������ȼ�����ջ����Ԫ�أ�����stack�����������������ֱ�Ӱ�stack��Ԫ�س�վ����list,ֱ������������
	 * ����׺���ʽ�����꣬���stack����Ԫ�أ�ֱ�ӽ���list����ʱlist��[����0-length-1]���Ǻ�׺���ʽ
	 * @Function @param list
	 * @Function @return
	 */
	
	public static List<String> in_to_post(List<String> list) {
		List<String> list_1 = new ArrayList<String>();//����ջ
		Stack<String> stack = new Stack<String>();//����ջ
		for (String item : list) {
			//if (item.matches("\\d+")) {//������ʽ   ƥ������
			if(item.charAt(0)>=48 &&item.charAt(0)<=57) {//��������ֽ���list
				list_1.add(item);
			} else if (item.equals("(")) {//������ֱ�ӽ���stack
				stack.push(item);
			} else if (item.equals(")")) {//���������������ֱ�Ӱ�stack��Ԫ�س�վ����list,ֱ������������
				while (!stack.peek().equals("(")) {//peek�鿴ջ��Ԫ��
					list_1.add(stack.pop());
				}
				stack.pop();//ͬʱ����")"������
			} else {//�ж����ȼ�����
				//Ŀǰջ��stackԪ�ش��ڵ���item�����ȼ���ջ������list
				while (stack.size() != 0 && priority_operator(stack.peek()) >= priority_operator(item)) {
					list_1.add(stack.pop());
				}
				stack.push(item);//��ջ����Ԫ��ûitem���ȼ�����item�������ջ
			}
		}//forѭ����������׺���ʽ������

		while (stack.size() != 0) {//����ջ��ʣ���Ԫ��ѹ��list
			list_1.add(stack.pop());
		}
		return list_1;
	}

	/**
	 * ������ ������׺���ʽ ArrayList���ʹ��� �ó����ʽ���
	 * ��׺���ʽ:[1, 2, 3, +, 4, *, +, 5, -]
	 * ͨ����׺���ʽ������˼·: ����ֱ�ӽ���վ����������������2�����֣������Ľ���ٽ�վ
	 * ע�⣺�󵯳����ļ�ȥ�ȵ������ģ��󵯳����ĳ�ȥ�ȵ�������
	 * 
	 * ���ﴫ����Ǻ�׺���ʽ��Ҳ���԰�����������װ��calculator������ֱ�Ӵ����ַ���calculator(String str)
	 * @Function @param list
	 * @Function @return
	 */
	public static int calculator(List<String> list) {
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			//if (item.matches("\\d+")) { // ������ʽ���������������ջ
			if(item.charAt(0)>=48 &&item.charAt(0)<=57) {
				stack.push(item);
			} else { // ��������򵯳��������ֽ�������
				int number_1 = Integer.parseInt(stack.pop());
				int number_2 = Integer.parseInt(stack.pop());
				int result = 0;
				if (item.equals("+")) {
					result = number_1 + number_2;
				} else if (item.equals("-")) {//�󵯳����ļ�ȥ�ȵ�������
					result = number_2 - number_1;
				} else if (item.equals("/")) {//�󵯳����ĳ�ȥ�ȵ�������
					result = number_2 / number_1;
				} else if (item.equals("*")) {
					result = number_1 * number_2;
				} else {
					System.out.println("error");
				}
				stack.push("" + result);//�õ��Ľ���ٽ�ȥջ
			}
		}//forѭ������
		return Integer.parseInt(stack.pop());
	}

	/**
	 * ������������װ��calculator������ֱ�Ӵ����ַ���calculator(String str)
	 * @Function @param str
	 * @Function @return
	 */
	public static int calculator(String str) {
		List<String> list_1 = string_to_list(str);//���ַ���ת��ΪArrayList 
		List<String> list=in_to_post(list_1);//����׺ת��Ϊ��׺
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			//if (item.matches("\\d+")) { // ������ʽ���������������ջ
			if(item.charAt(0)>=48 &&item.charAt(0)<=57) {
				stack.push(item);
			} else { // ��������򵯳��������ֽ�������
				int number_1 = Integer.parseInt(stack.pop());
				int number_2 = Integer.parseInt(stack.pop());
				int result = 0;
				if (item.equals("+")) {
					result = number_1 + number_2;
				} else if (item.equals("-")) {//�󵯳����ļ�ȥ�ȵ�������
					result = number_2 - number_1;
				} else if (item.equals("/")) {//�󵯳����ĳ�ȥ�ȵ�������
					result = number_2 / number_1;
				} else if (item.equals("*")) {
					result = number_1 * number_2;
				} else {
					System.out.println("error");
				}
				stack.push("" + result);//�õ��Ľ���ٽ�ȥջ
			}
		}//forѭ������
		return Integer.parseInt(stack.pop());
	}

	// �ж����ȼ�
	public static int priority_operator(String str) {
		int p = 0;
		if (str.equals("+"))
			p = 1;
		if (str.equals("-"))
			p = 1;
		if (str.equals("*"))
			p = 2;
		if (str.equals("/"))
			p = 2;

		return p;
	}

}
