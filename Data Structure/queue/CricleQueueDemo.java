package queue;

import java.util.Scanner;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 */
public class CricleQueueDemo {

	public static void main(String[] args) {
		CricleQueue circleQueue=new CricleQueue(3);
		char key=' ';//�����û�����
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("-----------------------------------------");
			System.out.println("- s(show):��ʾ����                                                 -");
			System.out.println("- e(exit):�˳�����                                                 -");
			System.out.println("- a(add):��Ӷ���β��                                           -");
			System.out.println("- g(get):�Ӷ���ͷȡ����                                       -");
			System.out.println("- h(head):�鿴��ͷ����                                         -");
			System.out.println("-----------------------------------------");
			key =scanner.next().charAt(0);
			switch (key) {
			case 's': {
				circleQueue.showQueue();
				break;
			}
			case 'e': {
				scanner.close();
				loop=false;
				break;
			}
			case 'a': {
				System.out.print("����һ�����ݣ�");
				int data=scanner.nextInt();
				circleQueue.addQueue(data);;
				break;
			}
			case 'g': {
				try {
					int res=circleQueue.getQueue();
					System.out.println("ȡ�������ݣ�"+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			}
			case 'h': {
				try {
					int res=circleQueue.headQueue();
					System.out.println("ȡ����ͷ���ݣ�"+res);
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
		System.out.println("�����˳���");
	
		
	}

}
class CricleQueue{
	private int MaxSize;
	private int front;
	private int rear;
	private int []arr;
	//�������й�����
	public CricleQueue(int maxsize) {
		MaxSize=maxsize;
		arr=new int [MaxSize];
	}
	//�ж϶����Ƿ���
	public boolean isFull() {
		return (rear+1)%MaxSize==front;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear==front;
	}
	
	//�������
	public void addQueue(int data) {
		if(isFull()) {
			System.out.println("queue is full,don't add data again!");
			return;
		}
		arr[rear]=data;
		rear=(rear+1)%MaxSize;
	}
	//ȡ������
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty,don't get data again!");
		}
		int data=arr[front];
		front=(front+1)%MaxSize;
		return data;
	}
	//��ʾ��ͷ����
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty,don't get data of queue!");
		}
		return arr[front];
	}
	//����
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("queue is full,don't show data!");
			return;
		}
		int len=(rear-front+MaxSize)%MaxSize;
		for(int i=front;i<front+len;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}