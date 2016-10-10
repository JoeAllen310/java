// Joseph Allen
package cardgame;


public interface Queue {	
	public int size();						// How many elements in the queue?
	public void offer(Object obj);			// Adding data, also called enqueue
	public Object poll();					// Removing, also called dequeue
	public boolean isEmpty();				// To check if we can delete data
	public boolean isFull();					// To check if we can add data
	public void display();					// Show the content of the queue
}