import java.util.ArrayList;
import java.util.Collections;
public class Queue<E extends Token> {
	private ArrayList <E> items;
	
	public Queue(){
		this.items=new ArrayList<E>();
	}
	
	public void insert(E element) {
		this.items.add(element);
	}
	
	public void remove() {
		this.items.remove(0);
	}
	
	public void delete(Token t) {
		this.items.remove(t);
	}

	public ArrayList<E> getItems() {
		return items;
	}

	public void setItems(ArrayList<E> items) {
		this.items = items;
	}
	
	
	//sorting tokens first with their priority and second with their name
	public void sort() {
		TokenComparator a=new TokenComparator();
		Collections.sort(this.items,a);
	}
	

	
	
	
	
	
	

}
