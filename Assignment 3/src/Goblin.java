import java.util.ArrayList;
import java.io.PrintWriter;
public class Goblin extends ZordeCharacters {
	//hp=80
	//ap=10
	//attacks at every step
	public static boolean attackAtEveryStep=true;
	public static boolean attacksAtFinalStep=false;
	private String name;
	public static int maxMoves=Constants.goblinMaxMove;
	public Goblin(String name) {
		super(name,80,Constants.goblinAP);
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
	public void move(Board gameBoard, Goblin goblin,ArrayList <int[]> moves,PrintWriter pw) throws BoundaryException{
		//try {
		for (int [] move:moves) {
			int currentColumn=gameBoard.getColumn(goblin);
			int currentRow=gameBoard.getRow(goblin);
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
					if (charAtNextPosition instanceof CallianceCharacters) {
						charAtNextPosition.getHit(goblin.getAP());
						if (charAtNextPosition.getCurrentHP()>goblin.getCurrentHP()) {
							charAtNextPosition.getHit(goblin.getCurrentHP());
							gameBoard.removeCharAtPosition(currentPosition);
							goblin.die();
							
						}
						if (charAtNextPosition.getCurrentHP()==goblin.getCurrentHP()) {
							gameBoard.removeCharAtPosition(currentPosition);
							gameBoard.removeCharAtPosition(nextPosition);
							goblin.die();
							charAtNextPosition.die();
						}
						if (charAtNextPosition.getCurrentHP()<goblin.getCurrentHP()) {
							if (charAtNextPosition.getCurrentHP()>=0) {
							goblin.getHit(charAtNextPosition.getCurrentHP());
							}
							gameBoard.removeCharAtPosition(nextPosition);
							gameBoard.move(goblin, currentPosition, nextPosition);
							charAtNextPosition.die();
							
						}
						break;
					}
					if (charAtNextPosition instanceof ZordeCharacters) {
						//do nothing
						break;
					}
					else {
						gameBoard.move(goblin, currentPosition, nextPosition);
						String newCurrentPosition=gameBoard.getPosition(goblin.getName());
						ArrayList <Characters> charactersAround= new ArrayList<Characters>();
						charactersAround=gameBoard.getCharactersAround(goblin);
						for (Characters c:charactersAround) {
							if (c instanceof CallianceCharacters) {
								c.getHit(goblin.getAP());
							}
						}
					}
				gameBoard.deleteDeadCharacters();
				}
				

		}
		//}catch(BoundaryException e){
			//pw.println(e.getMessage());
		//	
		//}
	}
	
}
