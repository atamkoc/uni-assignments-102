
public class Part {
	private Stack<Item> items;
	private String kind;

	
	public String getName() {
		return kind;
	}

	public void setName(String kind) {
		this.kind = kind;
	}

	public Stack<Item> getItems() {
		return items;
	}

	public void setItems(Stack<Item> items) {
		this.items = items;
	}

	public Part(String kind) {
		this.items = new Stack<Item>();
		this.kind=kind;
	}
	
	public void addItem(Item item) {
		this.items.push(item);
	}
	
	public void giveItem() {
		this.items.pop();
	}
	
	public void pop() {
		this.items.pop();
	}
	
	@Override
	public String toString() {
		return kind;
	}
	
	

}
