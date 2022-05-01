import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		
		File initials=new File(args[0]);
		Scanner initialsScanner= new Scanner (initials);
		ArrayList <String> initialsLines=new ArrayList<String>();
		
		File commands=new File(args[1]);
		Scanner commandScanner= new Scanner(commands);
		ArrayList <String> commandFileLines= new ArrayList<String>();
		
		File outputFile=new File(args[2]);
		FileWriter fw= new FileWriter(outputFile);
		PrintWriter pw=new PrintWriter(fw);
		
		while (initialsScanner.hasNextLine()) {
			initialsLines.add(initialsScanner.nextLine());
		}
		
		
		String boardSize=(initialsLines.get(initialsLines.indexOf("BOARD")+1));
		int size=Integer.parseInt(boardSize.split("x")[0]);
		Board gameBoard=new Board(size);
		
		for (String line:initialsLines) {
			if (line.contains("HUMAN")) {
				//pw.println("HUMAN");
				String humanName=line.split(" ")[1];
				int humanColumn=Integer.parseInt(line.split(" ")[2]);
				int humanRow=Integer.parseInt(line.split(" ")[3]);
				Human human=new Human(humanName);
				gameBoard.putCharacters(humanColumn, humanRow, human);
			}
			
			if (line.contains("ELF")) {
				//pw.println("ELF");
				String elfName=line.split(" ")[1];
				int elfColumn=Integer.parseInt(line.split(" ")[2]);
				int elfRow=Integer.parseInt(line.split(" ")[3]);
				Elf elf=new Elf(elfName);
				gameBoard.putCharacters(elfColumn, elfRow, elf);
				
			}
			if (line.contains("DWARF")) {
				//pw.println("DWARF");
				String dwarfName=line.split(" ")[1];
				int dwarfColumn=Integer.parseInt(line.split(" ")[2]);
				int dwarfRow=Integer.parseInt(line.split(" ")[3]);
				Dwarf dwarf=new Dwarf(dwarfName);
				gameBoard.putCharacters(dwarfColumn, dwarfRow, dwarf);
				
			}
			
			if (line.contains("ORK")) {
				//pw.println("ORK");
				String orkName=line.split(" ")[1];
				int orkColumn=Integer.parseInt(line.split(" ")[2]);
				int orkRow=Integer.parseInt(line.split(" ")[3]);
				Ork ork=new Ork(orkName);
				gameBoard.putCharacters(orkColumn, orkRow, ork);
				
			}
			
			if (line.contains("TROLL")) {
				//pw.println("TROLL");
				String trollName=line.split(" ")[1];
				int trollColumn=Integer.parseInt(line.split(" ")[2]);
				int trollRow=Integer.parseInt(line.split(" ")[3]);
				Troll troll=new Troll(trollName);
				gameBoard.putCharacters(trollColumn, trollRow, troll);
				
			}
			
			if (line.contains("GOBLIN")) {
				//pw.println("GOBLIN");
				String goblinName=line.split(" ")[1];
				int goblinColumn=Integer.parseInt(line.split(" ")[2]);
				int goblinRow=Integer.parseInt(line.split(" ")[3]);
				Goblin goblin=new Goblin(goblinName);
				gameBoard.putCharacters(goblinColumn, goblinRow, goblin);
				
				
			}
		}
		
		gameBoard.printBoard(pw);
		pw.println("");
		gameBoard.printCharacterHealths(pw);
		pw.println("");
		

		while (commandScanner.hasNextLine()) {
			commandFileLines.add(commandScanner.nextLine());
		}
		for (String str: commandFileLines) {
			try {
			String charName=str.split(" ")[0];
			String seriesOfMoves=str.split(" ")[1];
			String [] splitedMoves= seriesOfMoves.split(";");
			Characters c=gameBoard.getCharacterAtPosition(gameBoard.getPosition(charName)); 
			int currentColumn=gameBoard.getColumn(c);
			int currentRow=gameBoard.getRow(c);
			if (c instanceof Ork) {
					if ((Ork.maxMoves)*2!=splitedMoves.length) {
						throw new MoveCountException();
					}
					else {
						String currentPosition=currentColumn+","+currentRow;
						//pw.println("ork moving");
						Ork ork=(Ork) c;
						ArrayList <Characters> charsAround= new ArrayList<Characters>();
						charsAround=gameBoard.getCharactersAround(ork);
						ork.heal(charsAround);
						//ork.healMyself();
						String nextPosition=(currentColumn+Integer.parseInt(splitedMoves[0]))+","+(currentRow+Integer.parseInt(splitedMoves[1]));
						ork.move(gameBoard, ork, nextPosition,pw);

						
						
					
				}


			}
			if (c instanceof Troll) {
				
					if ((Troll.maxMoves)*2!=splitedMoves.length) {
						throw new MoveCountException();
					}
					else {
						//pw.println("troll moving");
						Troll troll=(Troll) c;
						String nextPosition=(currentColumn+Integer.parseInt(splitedMoves[0]))+","+(currentRow+Integer.parseInt(splitedMoves[1]));
						troll.move(gameBoard, troll, nextPosition,pw);

					}

				
				
			}
			if (c instanceof Goblin) {

					if ((Goblin.maxMoves)*2!=splitedMoves.length) {
						throw new MoveCountException();
					}
					else {
						ArrayList<int[]> moves =Characters.returnMovesAsArrayList(splitedMoves);
						//pw.println("goblin moving");
						//pw.println(Arrays.toString(splitedMoves));
						Goblin goblin=(Goblin) c;
						//pw.println(goblin.getName());
						goblin.move(gameBoard, goblin, moves,pw);

					}

			
				
			}
			if (c instanceof Human) {

					if ((Human.maxMoves)*2!=splitedMoves.length) {
						throw new MoveCountException();
					}
					else {
						//pw.println("Human moving");
						ArrayList <int[]> moves=Characters.returnMovesAsArrayList(splitedMoves);
						Human human=(Human)c;
						//pw.println(human.getName());
						//pw.println(Arrays.toString(splitedMoves));
						human.move(gameBoard, human, moves,pw);

						
					}


				
			}
			
			if (c instanceof Elf) {

					if ((Elf.maxMoves)*2!=splitedMoves.length) {
						throw new MoveCountException();
					}
					else {
						//pw.println("elf moving");
						ArrayList <int[]> moves=Characters.returnMovesAsArrayList(splitedMoves);
						Elf elf= (Elf) c;
						elf.move(gameBoard, elf, moves,pw);

					}


				
			}
			if (c instanceof Dwarf) {

					if ((Dwarf.maxMoves)*2!=splitedMoves.length) {
						throw new MoveCountException();
					}
					else {
						//pw.println("dwarf moving");
						ArrayList <int []>moves=Characters.returnMovesAsArrayList(splitedMoves);
						Dwarf dwarf= (Dwarf)c;
						//pw.println(dwarf.getName());
						//pw.println(Arrays.toString(splitedMoves));
						dwarf.move(gameBoard, dwarf, moves,pw);

					}
					

				
			}
			gameBoard.printBoard(pw);
			pw.println("");
			gameBoard.printCharacterHealths(pw);
			pw.println("");
			if (!gameBoard.checkCallianceAlive()) {
				pw.println("Game Finished");
				pw.println("Zorde Wins");
				break;
			}
			if (!gameBoard.checkZordeAlive()) {
				pw.println("Game Finished");
				pw.println("Calliance Wins");
				break;
			}
				
			
			
		}catch (MoveCountException e) {
			pw.println(e.getMessage());
			pw.println("");
		} catch (BoundaryException e) {
			pw.println(e.getMessage());
			pw.println("");
		}
			
			
		}
		pw.close();
		
		
		
		
		
		
		


}
}
