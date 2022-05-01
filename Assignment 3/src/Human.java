import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Arrays;
public class Human extends CallianceCharacters {
	//hp=100
	//ap=30
	//attacks after the final step
	public static boolean attackAtEveryStep=false;
	public static boolean attacksAtFinalStep=true;
	private String name;
	public static int maxMoves=Constants.humanMaxMove;
	public Human(String name) {
		super(name,100,Constants.humanAP);
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
	public void move(Board gameBoard, Human human, ArrayList<int[]> moves,PrintWriter pw) throws BoundaryException {
		//try {
		boolean hadFightToDeath = false;
		for (int[] move : moves) {
			
			String currentPosition = gameBoard.getPosition(human.getName());
			int currentColumn = gameBoard.getColumn(human);
			int currentRow = gameBoard.getRow(human);
			String nextPosition = (currentColumn + move[0]) + "," + (currentRow + move[1]);

				if (!gameBoard.getPlaces().containsKey(nextPosition)) {
					if(moves.indexOf(move)!=0){
						pw.println("");
						gameBoard.printBoard(pw);
						pw.println("");
						gameBoard.printCharacterHealths(pw);
					}
					throw new BoundaryException();
				} else {
					Characters charAtNextPosition = gameBoard.getCharacterAtPosition(nextPosition);
					if (charAtNextPosition instanceof ZordeCharacters) {
						hadFightToDeath = true;
						charAtNextPosition.getHit(human.getAP());
						if (charAtNextPosition.getCurrentHP() > human.getCurrentHP()) {

							charAtNextPosition.getHit(human.getCurrentHP());
							human.die();
							gameBoard.removeCharAtPosition(currentPosition);
							gameBoard.deleteDeadCharacters();

						}
						if (charAtNextPosition.getCurrentHP() == human.getCurrentHP()) {
							gameBoard.removeCharAtPosition(currentPosition);
							gameBoard.removeCharAtPosition(nextPosition);
							human.die();
							charAtNextPosition.die();
						}
						if (charAtNextPosition.getCurrentHP() < human.getCurrentHP()) {
							if (charAtNextPosition.getCurrentHP() >= 0) {
								human.getHit(charAtNextPosition.getCurrentHP());
							}
							gameBoard.removeCharAtPosition(nextPosition);
							gameBoard.move(human, currentPosition, nextPosition);
							charAtNextPosition.die();
						}
						break;

					}
					if (charAtNextPosition instanceof CallianceCharacters) {
						//pw.println("hic bir sey yapma");
						// do nothing
						break;

					} else {
						gameBoard.move(human, currentPosition, nextPosition);
					}
					gameBoard.deleteDeadCharacters();

				}


			

		}

		if (!hadFightToDeath) {
			ArrayList<Characters> charsAround = gameBoard.getCharactersAround(human);
			for (Characters c : charsAround) {
				if (c instanceof ZordeCharacters) {
					c.getHit(human.getAP());
					gameBoard.deleteDeadCharacters();
				}
			}
		}

		//}catch(BoundaryException e) {
		//	pw.println(e.getMessage());}
		//}

}
}
