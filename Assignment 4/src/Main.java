import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		//creating a vending machine object
		VendingMachine vendingMachine= new VendingMachine();
		File partsFile= new File (args[0]);
		Scanner partsScanner=new Scanner(partsFile);
		//adding parts
		while (partsScanner.hasNextLine()) {
			String partName=(partsScanner.nextLine());
			vendingMachine.addPart(partName);
		}
		//adding items to which part they belong
		File itemsFile=new File (args[1]);
		Scanner itemsScanner= new Scanner(itemsFile);
		
		while (itemsScanner.hasNextLine()) {
			String [] asd;
			asd=itemsScanner.nextLine().split(" ");
			vendingMachine.addItem(asd[0], asd[1]);
		}

		File tokensFile= new File (args[2]);
		Scanner tokensScanner= new Scanner(tokensFile);
		while (tokensScanner.hasNextLine()) {
			String [] tokensSplit;
			tokensSplit=tokensScanner.nextLine().split(" ");
			vendingMachine.addToken(tokensSplit[0], tokensSplit[1], tokensSplit[2]);
		}
		//sorting tokens to not to cause problems
		vendingMachine.sortTokens();

		
		File outputFile=new File(args[4]);
		FileWriter fw= new FileWriter(outputFile);
		PrintWriter pw=new PrintWriter(fw);
		
		
		//managing buy and put tasks
		File tasksFile= new File (args[3]);
		Scanner tasksScanner= new Scanner(tasksFile);
		ArrayList <String> taskLines=new ArrayList<String>();
		while (tasksScanner.hasNextLine()) {
			taskLines.add(tasksScanner.nextLine());
		}
		
		for (String s:taskLines) {
			String [] lineItems=s.split("\t");

			if (lineItems[0].equals("BUY")) {
				for (int i=1;i<lineItems.length;i++) {
					String itemKind=lineItems[i].split(",")[0];
					int itemAmount=Integer.parseInt((lineItems[i].split(",")[1]));
					vendingMachine.buyItem(itemKind, itemAmount);				
				}
			}
			if (lineItems[0].equals("PUT")){
				for (int i=1;i<lineItems.length;i++) {
					String [] putItems=lineItems[i].split(",");
					String itemKind=(putItems[0]);
					ArrayList <String> itemNames= new ArrayList<String>();
					for (int k=1;k<putItems.length;k++) {
						itemNames.add(putItems[k]);
					}
					
					for (String x:itemNames) {
						vendingMachine.addItem(x, itemKind);
					}	
				}
		}	
	}
		//printing the situation of the vending machine after put and buy commands
		vendingMachine.printVendingMachine(pw);
		itemsScanner.close();
		partsScanner.close();
		tasksScanner.close();
		tokensScanner.close();
		pw.close();
	
	}
}
