package Stack_and_Calculator_Poland;
import java.util.*;
public class Calculator_Poland {
/**
 * 
 * @Description: <Function>定义一个栈
 * @author  karlieswift
 * @date 2020年4月15日
 * @version "13.0.1"
 * 通过后缀表达式 算结果
 * 逆波兰表达式=后缀表达式
 * 思路：  给定字符串---->将字符串转化为中缀ArrayList---->转化为后缀ArrayList--->传入calculator计算
 * 
 * 函数：
 * string_to_list(String str) ：将字符串转化为ArrayList 便于操作
 * in_to_post(List<String> list)  :将中缀转化为后缀
 * calculator(List<String> list) ：将后缀表达式 ArrayList类型传入 得出表达式结果
 * calculator(String str):直接传入字符串得出表达式结果
 * priority_operator(String str):操作符优先级大小比较
 * 
 * 结果：
 * 原表达式[中缀表达式]:1+((2+3)*4)-5
 * 将字符转化为ArrayList:[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
 * 后缀表达式:[1, 2, 3, +, 4, *, +, 5, -]
 * 表达式:1+((2+3)*4)-5=16
 * 16
 * 
 */ 
	public static void main(String[] args) {
		String expression = "1+((2+3)*4)-5";
		System.out.println("原表达式[中缀表达式]:" + expression);

		List<String> list = string_to_list(expression);
		System.out.println("将字符转化为ArrayList:" + list);
		// 中缀转化后缀
		list = in_to_post(list);
		System.out.println("后缀表达式:" + list);
		// 计算结果
		int result = calculator(list);
		System.out.println("表达式:" + expression + "=" + result);
		//直接传入 字符串"1+((2+3)*4)-5"
		System.out.println(calculator(expression));//16
	}

	// 将str转化为list 22+3-3转化为[22,+,3,-,3]
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
	 * 中缀表达式转后缀表达式
	 * [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]-------------[1, 2, 3, +, 4, *, +, 5, -]
	 * 
	 * 思路：
	 * 定义一个数字栈(这里直接用list)，一个符号栈(stack)，遇到数字进入list
	 * 当遇到字符，左括号直接进入stack,遇到运算符优先级小于等于栈顶的元素，栈顶的栈取出进去list
	 * 运算符优先级大于栈顶的元素，进入stack，如果遇到右括号则直接把stack的元素出站进入list,直到遇到左括号
	 * 当中缀表达式遍历完，如果stack还有元素，直接进入list，此时list从[索引0-length-1]就是后缀表达式
	 * @Function @param list
	 * @Function @return
	 */
	
	public static List<String> in_to_post(List<String> list) {
		List<String> list_1 = new ArrayList<String>();//数字栈
		Stack<String> stack = new Stack<String>();//符号栈
		for (String item : list) {
			//if (item.matches("\\d+")) {//正则表达式   匹配数字
			if(item.charAt(0)>=48 &&item.charAt(0)<=57) {//如果是数字进入list
				list_1.add(item);
			} else if (item.equals("(")) {//左括号直接进入stack
				stack.push(item);
			} else if (item.equals(")")) {//如果遇到右括号则直接把stack的元素出站进入list,直到遇到左括号
				while (!stack.peek().equals("(")) {//peek查看栈顶元素
					list_1.add(stack.pop());
				}
				stack.pop();//同时弹出")"左括号
			} else {//判断优先级问题
				//目前栈顶stack元素大于等于item的优先级，栈顶进入list
				while (stack.size() != 0 && priority_operator(stack.peek()) >= priority_operator(item)) {
					list_1.add(stack.pop());
				}
				stack.push(item);//当栈顶的元素没item优先级大，则item进入符号栈
			}
		}//for循环结束，中缀表达式遍历完

		while (stack.size() != 0) {//符号栈里剩余的元素压如list
			list_1.add(stack.pop());
		}
		return list_1;
	}

	/**
	 * 计算结果 ：将后缀表达式 ArrayList类型传入 得出表达式结果
	 * 后缀表达式:[1, 2, 3, +, 4, *, +, 5, -]
	 * 通过后缀表达式计算结果思路: 数字直接进入站，遇到操作符弹出2个数字，运算后的结果再进站
	 * 注意：后弹出来的减去先弹出来的，后弹出来的除去先弹出来的
	 * 
	 * 这里传入的是后缀表达式，也可以把上述函数封装在calculator函数里直接传入字符串calculator(String str)
	 * @Function @param list
	 * @Function @return
	 */
	public static int calculator(List<String> list) {
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			//if (item.matches("\\d+")) { // 正则表达式，如果是数字则入栈
			if(item.charAt(0)>=48 &&item.charAt(0)<=57) {
				stack.push(item);
			} else { // 是运算符则弹出两个数字进行运算
				int number_1 = Integer.parseInt(stack.pop());
				int number_2 = Integer.parseInt(stack.pop());
				int result = 0;
				if (item.equals("+")) {
					result = number_1 + number_2;
				} else if (item.equals("-")) {//后弹出来的减去先弹出来的
					result = number_2 - number_1;
				} else if (item.equals("/")) {//后弹出来的除去先弹出来的
					result = number_2 / number_1;
				} else if (item.equals("*")) {
					result = number_1 * number_2;
				} else {
					System.out.println("error");
				}
				stack.push("" + result);//得到的结果再进去栈
			}
		}//for循环结束
		return Integer.parseInt(stack.pop());
	}

	/**
	 * 把上述函数封装在calculator函数里直接传入字符串calculator(String str)
	 * @Function @param str
	 * @Function @return
	 */
	public static int calculator(String str) {
		List<String> list_1 = string_to_list(str);//将字符串转化为ArrayList 
		List<String> list=in_to_post(list_1);//将中缀转化为后缀
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			//if (item.matches("\\d+")) { // 正则表达式，如果是数字则入栈
			if(item.charAt(0)>=48 &&item.charAt(0)<=57) {
				stack.push(item);
			} else { // 是运算符则弹出两个数字进行运算
				int number_1 = Integer.parseInt(stack.pop());
				int number_2 = Integer.parseInt(stack.pop());
				int result = 0;
				if (item.equals("+")) {
					result = number_1 + number_2;
				} else if (item.equals("-")) {//后弹出来的减去先弹出来的
					result = number_2 - number_1;
				} else if (item.equals("/")) {//后弹出来的除去先弹出来的
					result = number_2 / number_1;
				} else if (item.equals("*")) {
					result = number_1 * number_2;
				} else {
					System.out.println("error");
				}
				stack.push("" + result);//得到的结果再进去栈
			}
		}//for循环结束
		return Integer.parseInt(stack.pop());
	}

	// 判断优先级
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
