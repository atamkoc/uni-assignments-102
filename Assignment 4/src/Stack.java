import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Collections;
public class Stack<E> {
	private ArrayList <E> items;
	
	public Stack(){
		this.items=new ArrayList<E>();
	}
	
	public void pop() {
		int size=this.items.size();
		this.items.remove(size-1);
	}
	
	public void push(E element) {
		this.items.add(element);
	}
	
	public void print(PrintWriter pw) {
		pw.println(this.items.toString());
	}

	public ArrayList<E> getItems() {
		return items;
	}

	public void setItems(ArrayList<E> items) {
		this.items = items;
	}
	
	//method that prints items without sorting 
	//used it during the testing to check whether program works correctly
	public void printItems(PrintWriter pw) {
		for (E element:this.items) {
			pw.println(element);
		}
	}
	
	//method that prints items with sorting
	public void printItems2(PrintWriter pw) {
		ArrayList <E> reversed= this.items;
		Collections.reverse(reversed);
		for (E element:reversed) {
			pw.println(element);
		}
	}
}
