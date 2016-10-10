// Joseph Harnage 
// Project 4
// Dr. Amlan Chatterjee
//CSC 311
// I did get some help pointing my code in the right direction from CSUDH LSAMP tutoring from tutor Lori Oliver
package boardingpass;

public class BPQueue
{
   PplBoarding data[];
   int maxItems,
      numberOfItems;
                 
   // I got a portion of this section of code from http://cs.bluecc.edu/java/CS260/Notes/Priority.htm with some editing from myself to make it work correctly. 
   public BPQueue(int size)
   {
      maxItems = size;
      data = new PplBoarding[maxItems];
      numberOfItems = 0;
   }
   
   public boolean isEmpty()
   {
      return numberOfItems == 0;
   }
   
   public void insert(PplBoarding item)
   {
      data[numberOfItems] = item;
      trickleUp(numberOfItems);
      ++numberOfItems;
   }
   
   private void trickleUp(int newPosition)
   {
      PplBoarding temp = data[newPosition];
      int parent = (newPosition-1)/2;
      while (newPosition > 0 && data[parent].getPriorty() > temp.getPriorty())
      {
         data[newPosition] = data[parent];
         newPosition = parent;
         parent = (newPosition-1)/2;
      }
      data[newPosition] = temp;
   }

   public PplBoarding delete()
   {
      PplBoarding temp = data[0];
      --numberOfItems;
      if (numberOfItems > 0)
      {
         data[0] = data[numberOfItems];
         trickleDown(0);
      }
      return temp;
   }

   private void trickleDown(int itemPosition)
   {
      int child;                        // Index of the larger child.
      if (2*itemPosition+1 >= numberOfItems)
      {
         child = itemPosition;          // Leaf node (no children).
      }
      else if (2*itemPosition+2 == numberOfItems)
      {
         child = 2*itemPosition+1;      // One child (at the left).
      }
      else if (data[2*itemPosition+1].getPriorty() < data[2*itemPosition+2].getPriorty())
      {
         child = 2*itemPosition+1;      // Two children w/ larger on the left.
      }
      else
      {
         child = 2*itemPosition+2;      // Two children w/ larger on the right.
      }
      if (data[itemPosition].getPriorty() > data[child].getPriorty())
      {
        PplBoarding temp = data[itemPosition];
         data[itemPosition] = data[child];
         data[child] = temp;
         trickleDown(child);
      }
   }
}
