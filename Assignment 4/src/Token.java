
public class Token {
	//describing the token class with the given priorities in assignment manual
	private String name;
	private String kind;
	private int amount;
	
	
	public Token(String name, String kind, int amount) {
		this.name = name;
		this.kind = kind;
		this.amount = amount;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void decreaseAmount(int amount) {
		this.amount=this.amount-amount;
	}
	
	

}
