package Stack_and_Calculator_Poland;
/**
 * 
 * @Description: <Function>����һ��ջ
 * @author  karlieswift
 * @date 2020��4��15��
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

//����һ��վ
class ArrayStack {
	private int MaxSize;// ջ���������
	private int[] stack;
	private int top = -1;// ջ��Ԫ��

	// ���캯��//����ջ�Ĵ�С
	public ArrayStack(int maxsize) {
		this.MaxSize = maxsize;
		stack = new int[MaxSize];

	}

	// �ж�stack��
	public boolean isFull() {
		return top == MaxSize - 1;
	}

	// �ж�stack��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��վ
	public void push(int data) {
		if (isFull()) {// ���ж�ջ�Ƿ��Ѿ���
			System.out.print("stack is full,don't push data into stack!");
			return;
		}
		top++;// ��Ϊtop=-1��ʼ���ȼӼ�
		stack[top] = data;
		// top++;//��top��0��ʼ���һ
	}

	// ��վ
	public int pop() {
		if (isEmpty()) {// ���ж�ջ�Ƿ��
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
