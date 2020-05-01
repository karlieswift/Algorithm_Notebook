package Stack_and_Calculator_Poland;
/**
 * 
 * @Description: <Function>定义一个栈
 * @author  karlieswift
 * @date 2020年4月15日
 * @version "13.0.1"
 */
public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.showstack();//3 2 1 
		int data=stack.pop();
		System.out.println(data);//3
		stack.showstack();//2 1
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.showstack();//3 2 1 2 1 
	}

}

//定义一个站
class ArrayStack {
	private int MaxSize;// 栈的最大容量
	private int[] stack;
	private int top = -1;// 栈顶元素

	// 构造函数//定义栈的大小
	public ArrayStack(int maxsize) {
		this.MaxSize = maxsize;
		stack = new int[MaxSize];

	}

	// 判断stack满
	public boolean isFull() {
		return top == MaxSize - 1;
	}

	// 判断stack空
	public boolean isEmpty() {
		return top == -1;
	}

	// 进站
	public void push(int data) {
		if (isFull()) {// 先判断栈是否已经满
			System.out.print("stack is full,don't push data into stack!");
			return;
		}
		top++;// 因为top=-1开始，先加加
		stack[top] = data;
		// top++;//当top从0开始后加一
	}

	// 出站
	public int pop() {
		if (isEmpty()) {// 先判断栈是否空
			throw new RuntimeException("stack is empty,don't pop from stack! ");
		}
		int data = stack[top];
		top--;
		return data;
	}

	public void showstack() {
		if (isEmpty()) {
			System.out.println("stack is empty!");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
