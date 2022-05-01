
public class Item {
	private String name;
	private String kind;
	
	public Item(String name,String kind) {
		this.name=name;
		this.kind=kind;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.kind;
	}

}
