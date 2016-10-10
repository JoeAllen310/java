// Joseph Allen
package cardgame;


public class CircularQueue implements Queue{

	private Object[] Q;			// Array to hold the Queue elements
	private int front;			// To store the location of the front of the queue
	private int rear;			// To store the location of the rear of the queue
	private int count;			// How many elements in the queue
	private static final int capacity = 52;		// Default size of the queue
	
	public CircularQueue(){
		Q = new Object[capacity];
		front = 0;
		rear = 0;
		count  = 0;
	}
	
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public void offer(Object obj) {
		if(isFull()){
			System.out.println("Queue Overflow..!!");
			return;
		}
		Q[rear] = obj;
		rear = (rear + 1) % capacity;
		count++;
	}

	@Override
	public Object poll() {
		if(isEmpty()){
			System.out.println("Queue Underflow..!!");
			return null;
		}
		Object result = Q[front];
		Q[front] = null;			// Optional, might help the display method
		front = (front + 1) % capacity;
		count--;
		return result;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public boolean isFull() {
		return (count == capacity);
	}

	@Override
	public void display() {
		// If the queue is empty, then nothing to show
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		// Print the Queue elements in order
		for(int i = front; i < front+count; i++){
			System.out.print(Q[i%capacity]+ "|");
		}
		System.out.println();
		
	}

}
