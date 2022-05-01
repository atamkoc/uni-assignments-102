import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

public class VendingMachine {
	private ArrayList<Part> parts;
	private Queue<Token> tokens;
	public ArrayList<Part> getParts() {
		return parts;
	}
	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}
	public Queue<Token> getTokens() {
		return tokens;
	}
	public void setTokens(Queue<Token> tokens) {
		this.tokens = tokens;
	}
	public VendingMachine() {
		super();
		this.parts = new ArrayList<Part>();
		this.tokens = new Queue<Token>();
	}
	
	public void addPart(String name) {
		Part part=new Part(name);
		this.parts.add(part);
	}
	
	public void addItem(String itemName,String itemKind) {
		Item item=new Item(itemName, itemKind);
		for (Part p:this.parts) {
			if (p.getName().equals(itemKind)) {
				p.addItem(item);
			}
		}
	}
	

	
	public void printVendingMachine(PrintWriter pw) {
		for (Part p:parts) {
			pw.println(p.getName()+":");
			ArrayList <Item> items=p.getItems().getItems();
			Collections.reverse(items);
			if (items.size()==0) {
				pw.println("");
			}
			for (Item i:items) {
				pw.println(i.getName());
			}
			pw.println("---------------");
			
		}
		
		pw.println("Token Box:");
		ArrayList <Token> tokens=this.tokens.getItems();
		Collections.reverse(tokens);
		Collections.sort(tokens, Comparator.comparing(Token::getAmount));
		for (Token t:tokens) {
			pw.println(t.getName()+" "+t.getKind()+" "+t.getAmount());
		}
	}
	
	public void addToken(String tokenName, String tokenKind,String amount) {
		Token token=new Token(tokenName, tokenKind, Integer.parseInt(amount));
		this.tokens.insert(token);
	}
	
	public void deleteToken(Token token) {
		Iterator <Token> it=tokens.getItems().iterator();
		while(it.hasNext()) {
			if (token==it.next()) {
				it.remove();
			}
		}
	}
	
	
	public void sortTokens() {
		tokens.sort();
	}
	
	public Token getTokenWithHighestPriority(String itemKind) {
		Token tokenToReturn=new Token("Recaizade Mahmut Ekrem", itemKind, 0);
		
		for (Token t:this.getTokens().getItems()) {
			if (t.getKind().equals(itemKind)) {
				if (t.getAmount()>tokenToReturn.getAmount()) {
					tokenToReturn=t;
				}
				if (t.getAmount()==tokenToReturn.getAmount()) {
					if (t.getName().compareTo(tokenToReturn.getName())>0) {
						tokenToReturn=t;
					}
				}
			}
		}
		
		return tokenToReturn;
	}
	

	
	
	public void buyItem(String itemKind,int pieces) {
		Part partToOperate=null;
		for (Part part:this.parts) {
			if (part.getName().equals(itemKind)) {
				partToOperate=part;
			}
		}
		//pw.println("Item kind is:" +itemKind);
		int currentAmount=0;
		while (currentAmount<pieces) {
			Token tokenToUse=getTokenWithHighestPriority(itemKind);

			if (tokenToUse.getAmount()>pieces) {

				currentAmount=currentAmount+pieces;
				this.deleteToken(tokenToUse);
				this.addToken(tokenToUse.getName(), tokenToUse.getKind(), tokenToUse.getAmount()-pieces+"");
				break;
}
			
			if (tokenToUse.getAmount()==pieces) {
				currentAmount=currentAmount+pieces;
				deleteToken(tokenToUse);
				break;

			}
			
			if (tokenToUse.getAmount()<pieces) {
				currentAmount=currentAmount+tokenToUse.getAmount();

				deleteToken(tokenToUse);
			}	
		}
		
		for (int i=1;i<=pieces;i++) {

			partToOperate.pop();
		}
	}
	
	
	
	
	
	
	
	
	
}
