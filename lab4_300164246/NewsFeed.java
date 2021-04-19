/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	// Your code here.
		this.messages = new Post[MAX_SIZE];
		this.size = 0; 
    }

    public void add(Post message) {
      // Your code here.
		int i = 0; 
		while (i < MAX_SIZE) { 
			if (this.get(i) == null) { 
				break; 
			} else {
				i++; 
			}
		} if (i < MAX_SIZE) { 
			size++; 
			messages[i] = message; 
		}
    }

    public Post get(int index) {
	    return messages[index];
    }

    public int size() {
	    return size;
    }

	public void sort(){
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}

  		tmp = messages[argMin];
  		messages[argMin] = messages[i];
  		messages[i] = tmp;
		}
	}

  	public NewsFeed getPhotoPost() { 

		NewsFeed msg_post = new NewsFeed(); 

		for (int i = 0; i < size; i++) { 
			if (messages[i] instanceof PhotoPost) { 
				msg_post.add(messages[i]); 
			}
		}
		return msg_post; 

  	}

  	public NewsFeed plus(NewsFeed other){

		NewsFeed mp = new NewsFeed();

		for (int i = 0; i < size; i++) { 
			mp.add(messages[i]); 
		}

		for (int j = 0; j < size; j ++) { 
			mp.add(messages[j]); 
		}

		mp.sort(); 
		return mp; 

  	}

}
