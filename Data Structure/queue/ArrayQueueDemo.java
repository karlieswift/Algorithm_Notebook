package queue;

import java.util.Scanner;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue arrayQueue=new ArrayQueue(3);
		char key=' ';//接收用户输入
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("-----------------------------------------");
			System.out.println("- s(show):显示队列                                                 -");
			System.out.println("- e(exit):退出队列                                                 -");
			System.out.println("- a(add):添加队列尾部                                           -");
			System.out.println("- g(get):从队列头取数据                                       -");
			System.out.println("- h(head):查看对头数据                                         -");
			System.out.println("-----------------------------------------");
			key =scanner.next().charAt(0);
			switch (key) {
			case 's': {
				arrayQueue.showQueue();
				break;
			}
			case 'e': {
				scanner.close();
				loop=false;
				break;
			}
			case 'a': {
				System.out.print("输入一个数据：");
				int data=scanner.nextInt();
				arrayQueue.addQueue(data);;
				break;
			}
			case 'g': {
				try {
					int res=arrayQueue.getQueue();
					System.out.println("取出的数据："+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			}
			case 'h': {
				try {
					int res=arrayQueue.headQueue();
					System.out.println("取出对头数据："+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			}
			
			default:
				break;
			}		
		}
		System.out.println("程序退出！");
	}

}
//使用数组
class ArrayQueue{
	private int MaxSize;
	private int front;
	private int rear;
	private int []arr;
	//创建队列构造器
	public ArrayQueue(int maxsize) {
		MaxSize=maxsize;
		arr=new int [MaxSize];
		front=-1;//队列头部
		rear=-1;//队列尾部
	}
	//判断队列是否满
	public boolean isFull() {
		return rear==MaxSize-1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear==front;
	}
	
	//添加数据
	public void addQueue(int data) {
		if(isFull()) {
			System.out.println("queue is full,don't add data again!");
			return;
		}
		rear++;
		arr[rear]=data;
	}
	//取出数据
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty,don't get data again!");
		}
		front++;
		return arr[front];
	}
	//显示对头数据
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty,don't get data of queue!");
		}
		return arr[front+1];
	}
	//遍历
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("queue is full,don't show data!");
			return;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}