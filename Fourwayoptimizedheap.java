

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Fourwayoptimizedheap {
	 
    /** The number of children each node has **/
    private static final int d = 4;
    private int heapSize;
    private Node[] heap;
 
    
    public Fourwayoptimizedheap(int capacity){
        heapSize = 0;
        heap = new Node[capacity + 1];
        Node node = new Node("",-1);
        Arrays.fill(heap, node);
    }
    
    @Override
    public String toString(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(heapSize +  " " );
    	for(Node heapElement : heap){
    		buffer.append(heapElement + " ");
    	}
    	return buffer.toString();
    }
 
    public boolean isEmpty( ){
        return heapSize == 0;
    }
 
    /** Check if heap is full **/
    public boolean isFull( ){
        return heapSize == heap.length;
    }
 
    /** Clear heap */
    public void makeEmpty( ){
        heapSize = 0;
    }
 
    private int parent(int i) {
        return (i - 1)/d;
    }
 
    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }
 
    /** Function to insert element */
    public void insert(Node node){
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = node;
        heapifyUp(heapSize - 1);
    }
 
    /** Function to find least element **/
    public Node findMin( ){
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[0];
    }
 
    /** Function to delete min element **/
    public Node deleteMin(){
        Node keyItem = heap[0];
        delete(0);
        return keyItem;
    }
 
    /** Function to delete element at an index **/
    public Node delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);        
        return keyItem;
    }
 
    /** Function heapifyUp  **/
    private void heapifyUp(int childInd)
    {
        Node tmp = heap[childInd];    
        while (childInd > 0 && tmp.getFrequency() < heap[parent(childInd)].getFrequency())
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }
 
    /** Function heapifyDown **/
    private void heapifyDown(int ind)
    {
        int child;
        Node tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child].getFrequency() < tmp.getFrequency())
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }
 
    /** Function to get smallest child **/
    private int minChild(int ind) 
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d+1) && (pos < heapSize)) 
        {
            if (heap[pos].getFrequency() < heap[bestChild].getFrequency()) 
                bestChild = pos;
            pos = kthChild(ind, k++);
        }    
        return bestChild;
    }
 
    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
}

