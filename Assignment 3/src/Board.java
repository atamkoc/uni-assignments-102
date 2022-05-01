import java.util.LinkedHashMap;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;

public class Board {
	private LinkedHashMap <String,Characters> places;
	private int size;
	
	public Board(int size){
		this.size=size;
		this.places= new LinkedHashMap<String, Characters>();
		for (int i=0;i<size;i++) {
			for  (int k=0;k<size;k++) {
				String column=i+"";
				String row= k+"";
				this.places.put((column+","+row), null);
			}
		}
	}
	
	



	public LinkedHashMap<String, Characters> getPlaces() {
		return places;
	}


	public void setPlaces(LinkedHashMap<String, Characters> places) {
		this.places = places;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	public void printBoard(PrintWriter pw) {
		for (int i=0;i<(this.size*2)+2;i++) {
			pw.print("*");
		}
		pw.println("");
		
		for (int i=0;i<this.size;i++) {
			pw.print("*");
			for (int k=0;k<this.size;k++) {
				String str=k+","+i;
				
				if (this.places.get(str)==null) {
					pw.print("  ");
				}
				else {
					pw.print(this.places.get(str).getName());
				}
			}
			pw.print("*");
			pw.print("\n");
		}
		
		for (int i=0;i<(this.size*2)+2;i++) {
			pw.print("*");
		}
		pw.println("");
		pw.flush();
		
	}
	
	public void putCharacters(int column, int row, Characters c) {
		String key=column+","+row;
		this.places.put(key, c);
	}
	
	public String getPosition(String name) {
		for (String key:this.places.keySet()) {
			Characters c=this.places.get(key);
			if (c!=null) {
			if (c.getName().equals(name)) {
				return key;
			}
			}
		}
		return "cannot find it";
	}
	
	public void printCharacterHealths(PrintWriter pw) {
		ArrayList <Characters> charsToPrint= new ArrayList<Characters>();
		for (String a:this.places.keySet()) {
			Characters c=this.places.get(a);
			if (c!=null) {
				charsToPrint.add(c);
			}
			pw.flush();
		}
		
		charsToPrint.sort((char1,char2) -> char1.getName().compareTo(char2.getName()));
		for (Characters c: charsToPrint) {
			pw.println(c.getName()+"\t"+c.getCurrentHP()+"\t("+c.getMaxHP()+")");
		}
	}
	
	public Characters getCharacterAtPosition(String position) {
		return this.places.get(position);
		
	}
	
	public int getColumn(Characters c) {
		String key="";
		for (String a:this.places.keySet()) {
			if (this.places.get(a)!=null) {
				
			
			if(this.places.get(a).getName().equals(c.getName())) {
				key=a;
				return Integer.parseInt(key.split(",")[0]);
			}
			}
		}
		return -99;
		
	}
	
	public int getRow(Characters c)  {
		String key="";
		for (String a:this.places.keySet()) {
			if (this.places.get(a)!=null) {
			if(this.places.get(a).getName().equals(c.getName())) {
				key=a;
				return Integer.parseInt(key.split(",")[1]);
			}
		}
		}
		return -99;
		
	}
	
	public  Characters checkLeft(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String left=(column-1)+","+row;

			if (!this.places.containsKey(left)) {
				return new Characters("Out Of Bounds",1,1);
			}

			else {
				return getCharacterAtPosition(left);
			}
			
		
		
	}
	
	public Characters checkRight(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String right=(column+1)+","+row;
		
			if (!this.places.containsKey(right)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(right);
			}	
	}
	
	
	public Characters checkDown(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String down=column+","+(row+1);
		
			if (!this.places.containsKey(down)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(down);
			}
			
		
		
	}
	
	public Characters checkUp(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String up=(column)+","+(row-1);
		
			if (!this.places.containsKey(up)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(up);
			}
			
		
		
	}
	
	public Characters checkUpRight(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String upRight=(column+1)+","+(row-1);
		
			if (!this.places.containsKey(upRight)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(upRight);
			}
			
		
		
	}
	
	public Characters checkUpLeft(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String upLeft=(column-1)+","+(row-1);
		
			if (!this.places.containsKey(upLeft)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(upLeft);
			}
			
		
		
	}
	
	public Characters checkDownLeft(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String downLeft=(column-1)+","+(row+1);
		
			if (!this.places.containsKey(downLeft)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(downLeft);
			}
			
		
		
	}
	
	public Characters checkDownRight(Characters c){
		int column=getColumn(c);
		int row=getRow(c);
		String downRight=(column+1)+","+(row+1);
		
			if (!this.places.containsKey(downRight)) {
				return new Characters("Out Of Bounds",1,1);
			}
			else {
				return getCharacterAtPosition(downRight);
			}	
	}
	
	public ArrayList<Characters> getCharactersAround(Characters c) {
		ArrayList <Characters> charsAround=new ArrayList<Characters>();
		if (checkDown(c)!=null && !checkDown(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkDown(c));
		}
		if (checkUp(c)!=null && !checkUp(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkUp(c));
		}
		if (checkLeft(c)!=null && !checkLeft(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkLeft(c));
		}
		if (checkRight(c)!=null && !checkRight(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkRight(c));
		}
		if (checkUpRight(c)!=null && !checkUpRight(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkUpRight(c));
		}
		if (checkUpLeft(c)!=null && !checkUpLeft(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkUpLeft(c));
		}
		if (checkDownRight(c)!=null && !checkDownRight(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkDownRight(c));
		}
		if (checkDownLeft(c)!=null && !checkDownLeft(c).getName().equals("Out Of Bounds")) {
			charsAround.add(checkDownLeft(c));
		}
		
		return charsAround;
	
		
		
		
		
	}
	
	public void removeCharAtPosition(String position) {
		this.places.replace(position,null);
	}
	
	public void move (Characters c, String nextPosition) {
		String previousPosition=getPosition(c.getName());
		this.places.replace(previousPosition, null);
		this.places.replace(nextPosition, c);
	}
	
	public void move(Characters c,String previousPosition, String nextPosition) {
		this.places.replace(previousPosition, null);
		this.places.replace(nextPosition, c);
		
	}
	
	public void deleteDeadCharacters() {
		for (String position:this.places.keySet()) {
			if (this.places.get(position)!=null) {
				Characters c= this.places.get(position);
				if (c.getCurrentHP()<=0) {
					removeCharAtPosition(position);
				}
			}
		}
	}
	
	public ArrayList<Characters> getCharsForElfRangedAttack(Elf elf){
		//ArrayList <Characters> chars=getCharactersAround(elf);
		ArrayList <Characters> chars=new ArrayList<Characters>();
		ArrayList <String> positions=new ArrayList<String>();
		int column=getColumn(elf);
		int row=getRow(elf);
		String upUp=column+","+(row-2);
		positions.add(upUp);
		String downDown=column+","+(row+2);
		positions.add(downDown);
		String leftLeft=(column-2)+","+row;
		positions.add(leftLeft);
		String rightRight=(column+2)+","+row;
		positions.add(rightRight);
		String upRightupRight=(column+2)+","+(row-2);
		positions.add(upRightupRight);
		String upLefUpLeft=(column-2)+","+(row-2);
		positions.add(upLefUpLeft);
		String downLeftDownLeft=(column-2)+","+(row+2);
		positions.add(downLeftDownLeft);
		String downRightDownRight=(column+2)+","+(row+2);
		positions.add(downRightDownRight);
		String a=(column-2)+","+(row-1);
		positions.add(a);
		String b=(column-2)+","+(row+1);
		positions.add(b);
		String c=(column-1)+","+(row+2);
		positions.add(c);
		String d=(column+1)+","+(row+2);
		positions.add(d);
		String e=(column+2)+","+(row+1);
		positions.add(e);
		String f=(column+2)+","+(row-1);
		positions.add(f);
		String g=(column+1)+","+(row-2);
		positions.add(g);
		String h=(column-1)+","+(row-2);
		
		
		for(String position:positions) {
			if (!this.places.containsKey(position)) {
				//chars.add(new Characters("Out Of Bounds",1,1));
			}
			else {
				if (getCharacterAtPosition(position)!=null) {
					chars.add(getCharacterAtPosition(position));
				}
			}
		}
		
		return chars;
		
		
		
	}
	
	
	public boolean checkZordeAlive() {
		for (String key:this.places.keySet()) {
			if (this.places.get(key) instanceof ZordeCharacters) {
				return true;
			}
		}
		return false;
	}
	public boolean checkCallianceAlive() {
		for (String key:this.places.keySet()) {
			if (this.places.get(key) instanceof CallianceCharacters) {
				return true;
			}
		}
		return false;
	}
	
	
	
	

}
