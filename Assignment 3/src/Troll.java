import java.util.ArrayList;
import java.io.PrintWriter;

public class Troll extends ZordeCharacters{
	//hp=150
	//ap=20
	//attacks after the final step
	public static boolean attackAtEveryStep=false;
	public static boolean attacksAtFinalStep=true;
	private String name;
	public static int maxMoves=Constants.trollMaxMove;
	public Troll(String name) {
		super(name,150,Constants.trollAP);
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

	
	public void move(Board gameBoard,Troll troll,String nextPosition,PrintWriter pw) throws BoundaryException{
		String currentPosition=gameBoard.getPosition(troll.getName());
		//try {
			if (!gameBoard.getPlaces().containsKey(nextPosition)) {
				throw new BoundaryException();
			}
			else {
				Characters charAtNextPosition=gameBoard.getCharacterAtPosition(nextPosition);
				if (charAtNextPosition instanceof CallianceCharacters) {
					charAtNextPosition.getHit(troll.getAP());
					if (charAtNextPosition.getCurrentHP()>troll.getCurrentHP()) {
						charAtNextPosition.getHit(troll.getCurrentHP());
						gameBoard.removeCharAtPosition(currentPosition);
						troll.die();
					}
					if (charAtNextPosition.getCurrentHP()==troll.getCurrentHP()) {
						gameBoard.removeCharAtPosition(currentPosition);
						gameBoard.removeCharAtPosition(nextPosition);
						troll.die();
						charAtNextPosition.die();
					}
					else {
						if (charAtNextPosition.getCurrentHP()>=0) {
						troll.getHit(charAtNextPosition.getCurrentHP());
						}
						gameBoard.removeCharAtPosition(nextPosition);
						gameBoard.move(troll, currentPosition, nextPosition);
						charAtNextPosition.die();
					}
				}
				if (charAtNextPosition instanceof ZordeCharacters) {
					//do nothing ignore the step
				}
				else {
					gameBoard.move(troll, currentPosition, nextPosition);
					String newCurrentPosition=gameBoard.getPosition(troll.getName());
					ArrayList <Characters> charactersAround= new ArrayList<Characters>();
					charactersAround=gameBoard.getCharactersAround(troll);
					for (Characters c:charactersAround) {
						if (c instanceof CallianceCharacters) {
							c.getHit(troll.getAP());
						}
					}
				}
			gameBoard.deleteDeadCharacters();
			}
		//}
		//catch(BoundaryException e){
		//	pw.println(e.getMessage());
		//}
		
		
	}
	
	
	
	
	
	
	
	
}
