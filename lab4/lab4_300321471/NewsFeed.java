/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	messages = new Post[MAX_SIZE];
    }

    public void add(Post message) {
		if (size < MAX_SIZE) {
			messages[size] = message;
			size++;
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

  	public NewsFeed getPhotoPost(){
  		NewsFeed news = new NewsFeed();
		for (Post pos: messages) {
			if (pos instanceof PhotoPost)
				news.add(pos);
		}
		return news;
  	}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed news = new NewsFeed();
		for (Post pos: messages) {
			if (pos != null) {
				news.add(pos);
			}
		}
		for (int x = 0; x<other.size(); x++) {
			news.add(other.get(x));
		}
		news.sort();
		return news;
  	}

}
