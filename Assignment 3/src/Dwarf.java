import java.util.ArrayList;
import java.io.PrintWriter;
public class Dwarf extends CallianceCharacters{
	//hp=120
	//ap=20
	public static boolean attackAtEveryStep=true;
	public static boolean attacksAtFinalStep=false;
	public  static int maxMoves=Constants.dwarfMaxMove;
	private String name;
	public Dwarf(String name) {
		super(name,120, Constants.dwarfAP);
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxMoves() {
		return maxMoves;
	}

	
	@Override
	public void move(Board gameBoard,Dwarf dwarf,ArrayList <int[]> moves,PrintWriter pw) throws BoundaryException {
		//try {
		for (int [] move:moves) {
			//gameBoard.printBoard();
			//gameBoard.printCharacterHealths();
			int currentColumn=gameBoard.getColumn(dwarf);
			int currentRow=gameBoard.getRow(dwarf);
			String currentPosition=currentColumn+","+currentRow;
			String nextPosition=(currentColumn+move[0])+","+(currentRow+move[1]);
			//pw.println("Dwarf next position"+nextPosition);
			
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
						charAtNextPosition.getHit(dwarf.getAP());
						if (charAtNextPosition.getCurrentHP()>dwarf.getCurrentHP()) {
							charAtNextPosition.getHit(dwarf.getCurrentHP());
							gameBoard.removeCharAtPosition(currentPosition);
							dwarf.die();
							
						}
						if (charAtNextPosition.getCurrentHP()==dwarf.getCurrentHP()) {
							gameBoard.removeCharAtPosition(currentPosition);
							gameBoard.removeCharAtPosition(nextPosition);
							dwarf.die();
							charAtNextPosition.die();
						}
						if (charAtNextPosition.getCurrentHP()<dwarf.getCurrentHP()) {
							if (charAtNextPosition.getCurrentHP()>=0) {
							dwarf.getHit(charAtNextPosition.getCurrentHP());
							}
							gameBoard.removeCharAtPosition(nextPosition);
							gameBoard.move(dwarf, currentPosition, nextPosition);
							charAtNextPosition.die();
						}
						gameBoard.deleteDeadCharacters();
						break;
					}
					if (charAtNextPosition instanceof CallianceCharacters) {
						//do nothing
						break;
					}
					else {
						gameBoard.move(dwarf, currentPosition, nextPosition);
						String newCurrentPosition=gameBoard.getPosition(dwarf.getName());
						ArrayList <Characters> charactersAround= new ArrayList<Characters>();
						charactersAround=gameBoard.getCharactersAround(dwarf);
						for (Characters c:charactersAround) {
							if (c instanceof ZordeCharacters) {
								c.getHit(dwarf.getAP());
								gameBoard.deleteDeadCharacters();
							}
						}
					}
				gameBoard.deleteDeadCharacters();
				}
				
			

		}
		//}			catch(BoundaryException e){
		//	pw.println(e.getMessage());
		//	
		//}
		
	}
	
	
	
	
	
	
}
