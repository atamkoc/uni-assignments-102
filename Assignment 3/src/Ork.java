import java.util.ArrayList;
import java.io.PrintWriter;
public class Ork extends ZordeCharacters{
	//hp=200
	//ap=30
	//attacksafterfinalstep
	//heals friendly neigbours before every move sequence
	public static boolean attackAtEveryStep=false;
	public static boolean attacksAtFinalStep=true;
	private String name;
	public static int maxMoves=Constants.orkMaxMove;
	private int orkHealPoints;
	public Ork(String name) {
		super(name,200,Constants.orkAP);
		this.name=name;
		this.orkHealPoints=Constants.orkHealPoints;
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

	public int getOrkHealPoints() {
		return orkHealPoints;
	}
	public void setOrkHealPoints(int orkHealPoints) {
		this.orkHealPoints = orkHealPoints;
	}
	
	public void attack() {
		
	}
	
	public void heal(ArrayList<Characters> characters) {
		for (Characters c:characters) {
			if (c instanceof ZordeCharacters) {
				c.heal(10);
			}
		}
		this.healMyself();
	}
	
	public void healMyself() {
		super.heal(10);
	}
	
	@Override
	public void move(Board gameBoard,Ork ork, String nextPosition,PrintWriter pw) throws BoundaryException {
		String currentPosition=gameBoard.getPosition(ork.getName());
		
		//try {
			if (!gameBoard.getPlaces().containsKey(nextPosition)) {
				throw new BoundaryException();
			}
			else {
				Characters charAtNextPosition=gameBoard.getCharacterAtPosition(nextPosition);
				if (charAtNextPosition instanceof CallianceCharacters) {
					charAtNextPosition.getHit(ork.getAP());
					if (charAtNextPosition.getCurrentHP()>ork.getCurrentHP()) {
						charAtNextPosition.getHit(ork.getCurrentHP());
						gameBoard.removeCharAtPosition(currentPosition);
						ork.die();
					}
					if (charAtNextPosition.getCurrentHP()==ork.getCurrentHP()) {
						gameBoard.removeCharAtPosition(currentPosition);
						gameBoard.removeCharAtPosition(nextPosition);
						ork.die();
						charAtNextPosition.die();
					}
					else {
						if (charAtNextPosition.getCurrentHP()>=0) {
						ork.getHit(charAtNextPosition.getCurrentHP());
						}
						gameBoard.removeCharAtPosition(nextPosition);
						gameBoard.move(ork, currentPosition, nextPosition);
						charAtNextPosition.die();
					}
				}
				if (charAtNextPosition instanceof ZordeCharacters) {
					//do nothing
				}
				else {
					gameBoard.move(ork, currentPosition, nextPosition);
					String newCurrentPosition=gameBoard.getPosition(ork.getName());
					ArrayList <Characters> charsAround= new ArrayList<Characters>();
					charsAround=gameBoard.getCharactersAround(ork);
					for (Characters c:charsAround) {
						if (c instanceof CallianceCharacters) {
							c.getHit(ork.getAP());
						}
					}
				}
				gameBoard.deleteDeadCharacters();
			}
		//}catch(BoundaryException e) {
		//	pw.println(e.getMessage());
		//}
		
	}
	
	
	

}
