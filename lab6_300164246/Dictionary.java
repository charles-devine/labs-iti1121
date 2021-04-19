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
        /* Your code here */
        this.elems = new Pair[INITIAL_CAPACITY];
        count = 0; 
    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
        elems[count] = new Pair(key,value);
        count++;
 
        if(count == elems.length) {
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */

        Pair[] newArray = new Pair[elems.length + INCREMENT]; 
        for (int i = 0; i < elems.length; i++) { 
            newArray[i] = elems[i]; 
        }
        
        elems = newArray; 
    }

    @Override
    public boolean contains(String key) {
        /* Your code here. */
        
        for(int i = 0; i <elems.length; i++) {
            if(elems[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */

        boolean flag = false;
        int position = count -1;

        while((position >= 0) && (!flag)) {
            if(elems[position].getKey().equals(key)){
                flag = true;
            }else{
                position--;
            }
        }
        return elems[position].getValue();
        
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */

        boolean flag = false;
        int tmp = count -1;

        while((tmp >= 0) && (!flag)) {
            if(elems[tmp].getKey().equals(key)){
                flag = true;
            }else{
                tmp--;
            }
        }
        elems[tmp].setValue(value);
        
    }

    @Override
    public Integer remove(String key) {
        /* Your code here. */
        int tmp = 0; 
        int value = 0; 
        Pair[] newElems = new Pair[elems.length-1]; 

        for(int i = count-1; i > 0; i--) { 
            if(this.elems[i-1].getKey().equals(key)) { 
                tmp = i - 1; 
                value = elems[i-1].getValue(); 
                break; 
            }
        }

        for (int j = 0; j < newElems.length; j++) { 
            if (j != tmp) { 
                newElems[j] = elems[j]; 
            }
        }

        elems = newElems; 

        return value; 
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