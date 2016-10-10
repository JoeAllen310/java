// Joseph Allen
package cardgame;

class ArrayList {
	
	private int size;
	private int capacity;
	
	private int[] myArray;
	
	// Default constructor
	public ArrayList(){
		myArray = new int[10];
		this.size = 0;			// This is how many elements in the array currently
		this.capacity = 10;		// This is the total space of the array
	}
	
	public ArrayList(int beginSize){
		myArray = new int[beginSize];
		this.size = 0;
		this.capacity = beginSize;
	}
	
	public void reallocate(){
		this.capacity *= 2;
		int[] temp = new int[this.capacity];	// This creates a new array double the size
		// Code to copy data from old to new array
		for(int i = 0; i < myArray.length; i++){
			temp[i] = myArray[i];
		}
		this.myArray = temp;
		
	}
	
	public void add(int a){
		// Method adds the data at the end
		if(size < capacity){
			myArray[size] = a;
			size++;
		}
		else{
//			System.out.println("Reallocate called");
			this.reallocate();
			myArray[size++] = a;
		}
		
	}
	
	public void add(int a, int index){
		// This method adds the data at the specified index
		if(index == size){		// If adding at the end
			this.add(a);
		}
		// else need to move data to accomodate
		else{
			if(size == capacity){
				this.reallocate();
			}
			// move the data
			for(int i = size; i > index; i--){
				this.myArray[i] = this.myArray[i-1]; 
			}
			this.myArray[index] = a;
			size++;
			
		}
	}
	
	public int remove(int index){
		// This method removes data from a specified index
		if(index < 0 || index > (size-1)){
			System.out.println("Invalid index. Data not deleted");
			return -1;
		}
		int temp = this.myArray[index];
		for(int i = index; i < size -1; i++){
			this.myArray[i] = this.myArray[i+1];
		}
		size--;
		
		return temp;
	}
	
	public int get(int index){
		// Check if the index is valid
		if(index >= 0 && index < size)
			return myArray[index];
		else
			return -1;		// Indicates invalid data
	}
	
	public int Size(){
		return this.size;
	}
	
	public int getCapacity(){
		return this.capacity;
	}

	public void display(){
		// This displays the contents of the arraylist
		System.out.print("The contents of the list: ");
		for(int i = 0; i < size; i++){
			System.out.print(myArray[i] + ", ");
		}
		System.out.println("");
	}
}
