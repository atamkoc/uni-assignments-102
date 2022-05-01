import java.util.ArrayList;
import java.io.PrintWriter;
public class Elf extends CallianceCharacters{
	//hp=70
	//hp=15
	//attacks at every step
	//special : makes a ranged attack instead of the final attack.
	public static boolean attackAtEveryStep=true;
	public static boolean attacksAtFinalStep=false;
	
	private String name;
	private int elfRangedAP;
	public static int maxMoves=Constants.elfMaxMove;
	public Elf(String name) {
		super(name,70, Constants.elfAP);
		this.name=name;
		this.elfRangedAP=Constants.elfRangedAP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getElfRangedAP() {
		return elfRangedAP;
	}
	public void setElfRangedAP(int elfRangedAP) {
		this.elfRangedAP = elfRangedAP;
	}
	public int getElfMaxMoves() {
		return maxMoves;
	}

	@Override
	public void move(Board gameBoard,Elf elf,ArrayList<int[]> moves,PrintWriter pw) throws BoundaryException{
		//try {
		boolean hadFightToDeath=false;
		boolean wasInterrupted=false;
		for (int [] move:moves) {
			int currentColumn=gameBoard.getColumn(elf);
			int currentRow=gameBoard.getRow(elf);
			String currentPosition=currentColumn+","+currentRow;
			String nextPosition=(currentColumn+move[0])+","+(currentRow+move[1]);
				if (!gameBoard.getPlaces().containsKey(nextPosition)) {
					if(moves.indexOf(move)!=0){
						pw.println("");
						gameBoard.printBoard(pw);
						pw.println("");
						gameBoard.printCharacterHealths(pw);
					}
					throw new BoundaryException();
				}
				else {
					Characters charAtNextPosition=gameBoard.getCharacterAtPosition(nextPosition);
					if (charAtNextPosition instanceof ZordeCharacters) {
						charAtNextPosition.getHit(elf.getAP());
						if (charAtNextPosition.getCurrentHP()>elf.getCurrentHP()) {
							charAtNextPosition.getHit(elf.getCurrentHP());
							gameBoard.removeCharAtPosition(currentPosition);
							elf.die();
						}
						if (charAtNextPosition.getCurrentHP()==elf.getCurrentHP()) {
							gameBoard.removeCharAtPosition(currentPosition);
							gameBoard.removeCharAtPosition(nextPosition);
							elf.die();
							charAtNextPosition.die();
						}
						if (charAtNextPosition.getCurrentHP()<elf.getCurrentHP()) {
							if (charAtNextPosition.getCurrentHP()>=0) {
							elf.getHit(charAtNextPosition.getCurrentHP());
							}
							gameBoard.removeCharAtPosition(nextPosition);
							gameBoard.move(elf, currentPosition, nextPosition);
							charAtNextPosition.die();
						}
						gameBoard.deleteDeadCharacters();
						hadFightToDeath=true;
						wasInterrupted=true;
						break;
					}
					if (charAtNextPosition instanceof CallianceCharacters) {
						//do nothing
						wasInterrupted=true;
						gameBoard.deleteDeadCharacters();
						break;
					}
					else {
						gameBoard.move(elf, currentPosition, nextPosition);
						String newCurrentPosition=gameBoard.getPosition(elf.getName());
						ArrayList <Characters> charactersAround= new ArrayList<Characters>();
						charactersAround=gameBoard.getCharactersAround(elf);
						for (Characters c:charactersAround) {
							if (c instanceof ZordeCharacters) {
								c.getHit(elf.getAP());
							}
						}
						gameBoard.deleteDeadCharacters();
					}
				gameBoard.deleteDeadCharacters();
				}
				
			
		}
		
		if (!hadFightToDeath) {
			int newColumn=gameBoard.getColumn(elf);
			int newRow=gameBoard.getRow(elf);
			String newPosition=newColumn+","+newRow;
			ArrayList <Characters> charsForRangedAttack=gameBoard.getCharsForElfRangedAttack(elf);
			for (Characters c: charsForRangedAttack) {
				//pw.println(c.getName());
			}
			charsForRangedAttack=gameBoard.getCharsForElfRangedAttack(elf);
			for (Characters c:charsForRangedAttack) {
				if (c instanceof ZordeCharacters) {
					c.getHit(elf.elfRangedAP);
					gameBoard.deleteDeadCharacters();
				}
			}
		}
		
		
		
		
		gameBoard.deleteDeadCharacters();
		
		
		
		//}			catch(BoundaryException e){
		//	pw.println(e.getMessage());
		//	
		//}
	}
	
	
	
	

}
