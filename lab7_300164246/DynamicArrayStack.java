import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        
        if (capacity < DEFAULT_INC)  { 
            capacity = DEFAULT_INC; 
        }

        elems = (E[]) new Object[capacity]; 
        this.top = 0; 
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        if (top - 1 <= 0) { 
            throw new EmptyStackException(); 
        } 
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {

        if (top - 1 <= 0) { 
            throw new EmptyStackException(); 
        }
        
        E removed = elems[top - 1]; 
        elems[top - 1] = null; 
        top--;
        resize(false); 
        return removed; 

    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push(E element) {

        try {
            elems[top] = element;
            top++;
        } catch (Exception e) {
            resize(true);
            elems[top] = element;
            top++;
        }
    }

    public void resize(boolean push) {
        if (top <= DEFAULT_INC && elems.length > DEFAULT_INC && elems[0] != null) {
            E[] tempArr = (E[]) new Object[DEFAULT_INC];
            tempArr = elems;

            elems = (E[]) new Object[DEFAULT_INC];
            for (int i = 0; i < tempArr.length; i++) {
                try {
                    elems[i] = tempArr[i];
                } catch (Exception a) {
                    break;
                }
            }

        } else if (push) {
            E[] tempArr = (E[]) new Object[elems.length];
            tempArr = elems;

            elems = (E[]) new Object[DEFAULT_INC + top];
            for (int i = 0; i < tempArr.length; i++) {
                try {
                    elems[i] = tempArr[i];
                } catch (Exception a) {
                    break;
                }

            }
        }

    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }

}