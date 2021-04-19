public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        this.count = 0; 
        elems = new Pair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Integer value) throws NullPointerException {

        if (key == null || value == null) { 
            throw new NullPointerException("key not here loser"); 
        }
        if (count == elems.length) { 
            increaseCapacity();
        }

        elems[count] = new Pair(key, value); 
        count++;

    }

    private void increaseCapacity() {

        if (count >= getCapacity()) { 
            Pair[] tempElems = elems;  
            elems = new Pair[tempElems.length + INCREMENT];
            for (int i = 0; i < tempElems.length; i++) {
                elems[i] = tempElems[i]; 
            }   
        }
    }

    @Override
    public boolean contains(String key) throws NullPointerException {

        if (key == null) { 
            throw new NullPointerException("key not here loser"); 
        }

        for (int i = 0; i < elems.length; i++) { 
            if (elems[i] != null && elems[i].getKey().equals(key)) { 
                return true; 
            }
        }
        return false; 
    }

    @Override
    public Integer get(String key) throws java.util.NoSuchElementException, NullPointerException {

        if (key == null) { 
            throw new NullPointerException("key not here loser"); 
        }
        
        if (count == 0) { 
            throw new java.util.NoSuchElementException("Stack is empty loser"); 
        }

        int tmp = -1; 

        for (int i = 0; i < elems.length; i++) { 
            if (elems[i] != null && elems[i].getKey().equals(key)) { 
                tmp = elems[i].getValue(); 
            }
        }
    
        if (tmp == -1) { 
            throw new java.util.NoSuchElementException("Element isnt here loser"); 
        }

        return tmp; 
    }

    @Override
    public void replace(String key, Integer value) throws NullPointerException, java.util.NoSuchElementException {

        if (key == null || value == null) { 
            throw new NullPointerException("key not there loser"); 
        }

        int tmp = -1; 
        
        for (int i = 0; i < elems.length; i++) { 
            if (elems[i] != null && elems[i].getKey().equals(key)) { 
                tmp = i; 
            }
        }

        if (tmp == -1) { 
            throw new java.util.NoSuchElementException("Element isnt here loser"); 
        }

        elems[tmp] = new Pair(key, value); 

    }

    @Override
    public Integer remove(String key) throws NullPointerException, java.util.NoSuchElementException {

        if (key == null) { 
            throw new NullPointerException("key not there loser"); 
        }

        if (count == 0) {
            throw new java.util.NoSuchElementException("Nothing to remove here"); 
        }
        
        replace(null, null); 
        count--; 
        return get(key); 
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}
