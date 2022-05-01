import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
public  class Characters {
	private String name;
	private int maxHP;
	private int currentHP;
	private int AP;
	private boolean isDead;
	
	

	public Characters(String name,int HP,int AP) {
		super();
		this.name = name;
		this.currentHP=HP;
		this.maxHP=HP;
		this.AP=AP;
		this.isDead=false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getAP() {
		return AP;
	}

	public void setAP(int aP) {
		AP = aP;
	}
	
	public void getDamage(int hit) {
		if (this.currentHP-hit<0) {
			this.currentHP=0;
			this.isDead=true;
		}
		else {
			this.currentHP=this.currentHP-hit;
		}
		
	}
	
	public void getHit(int AP) {
		this.currentHP=this.currentHP-AP;
	}
	
	public void heal(int healHP) {
		if (this.currentHP!=0) {
			this.currentHP=this.currentHP+healHP;
		}
		if (this.currentHP>this.maxHP) {
			this.currentHP=this.maxHP;
		}
	
	}
	
	public static ArrayList <int[]> returnMovesAsArrayList(String [] splitedMoves){
		int [] intArray= new int[splitedMoves.length];
		for (int i=0;i<intArray.length;i++) {
			intArray[i]=Integer.parseInt(splitedMoves[i]);
		
		}
		
		ArrayList <int[]> arraylist=new ArrayList<int[]>();
		for (int i=0;i<intArray.length;i=i+2) {
			int [] subArray=new int [2];
			subArray[0]=intArray[i];
			subArray[1]=intArray[i+1];
			arraylist.add(subArray);
		}
		
		return arraylist;
	}
	
	public void die() {
		this.currentHP=0;
	}
	
	public void move  (Board gameBoard,Dwarf dwarf,ArrayList <int[]> moves,PrintWriter pw) throws BoundaryException{
		
	}
	
	public void move  (Board gameBoard,Elf elf,ArrayList <int[]> moves,PrintWriter pw) throws BoundaryException{

		
	}
	
	public void move  (Board gameBoard,Goblin goblin,ArrayList <int[]> moves,PrintWriter pw) throws BoundaryException{
		
	}
	
	public void move  (Board gameBoard,Human human,ArrayList <int[]> moves,PrintWriter pw) throws BoundaryException{
		
	}
	
	public void move(Board gameBoard,Ork ork, String nextPosition,PrintWriter pw) throws BoundaryException{
		
	}
	
	public void move(Board gameBoard,Troll troll,String nextPosition,PrintWriter pw) throws BoundaryException{
	}

		

}
