package collection;
import java.util.*;
public class CustomList {
	private int size = 0;
    
    //Default capacity of list is 10
    private static final int DEFAULT_CAPACITY = 10;
     
    //This array will store all elements added to list
    private Object elements[];
 
    //Default constructor
    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
 
    //Add method
    public void add(Integer e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
     
    //Get method
    @SuppressWarnings("unchecked")
    public Integer get(Integer i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (Integer) elements[i];
    }
     
    //Remove method
    @SuppressWarnings("unchecked")
    public Integer remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (Integer) item;
    }
     
    //Get Size of list
    public int size() {
        return size;
    }
     
    //Print method
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}

