import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.ObjectInputStream.GetField;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.LinkedHashMap;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		File peopleFile = new File(args[0]);
		Scanner scannerPeople = new Scanner(peopleFile);
		
		//creating arraylist objects to keep information
		ArrayList<String> peopleTxtLines = new ArrayList<String>();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		ArrayList<ChildActor> childActors = new ArrayList<ChildActor>();
		ArrayList<StuntPerformer> stuntPerformers = new ArrayList<StuntPerformer>();
		ArrayList <Performer> performers=new ArrayList <Performer>();
		ArrayList<Director> directors = new ArrayList<Director>();
		ArrayList<Writer> writers = new ArrayList<Writer>();
		ArrayList<User> users = new ArrayList<User>();
		ArrayList <String> performerIDs= new ArrayList <String>();
		ArrayList <String> directorIDs=new ArrayList <String>();
		ArrayList <String> writerIDs=new ArrayList <String>();
		ArrayList <String> featureFilmIDs=new ArrayList<String>();
		ArrayList <String> shortFilmIDs=new ArrayList<String>();
		ArrayList <String> tvSeriesIDs=new ArrayList<String>();
		ArrayList <String> documentaryIDs=new ArrayList<String>();
		ArrayList <Artist> allArtist=new ArrayList<Artist>();

		// managing people file and creating people with their specified class
		while (scannerPeople.hasNextLine()) {
			peopleTxtLines.add(scannerPeople.nextLine());
		}

		for (String line : peopleTxtLines) {
			String[] lineItems = line.split("\t");
			if (lineItems[0].equals("Actor:")) {
				Actor actor = new Actor(lineItems[1], lineItems[2], lineItems[3], lineItems[4],
						Integer.parseInt(lineItems[5]));
				actors.add(actor);
				performerIDs.add(actor.getId());
				performers.add(actor);
				allArtist.add(actor);


			}
			if (lineItems[0].equals("ChildActor:")) {
				ChildActor childActor = new ChildActor(lineItems[1], lineItems[2], lineItems[3], lineItems[4],
						Integer.parseInt(lineItems[5]));
				childActors.add(childActor);
				performerIDs.add(childActor.getId());
				performers.add(childActor);
				allArtist.add(childActor);


			}
			if (lineItems[0].equals("StuntPerformer:")) {
				StuntPerformer stuntPerformer = new StuntPerformer(lineItems[1], lineItems[2], lineItems[3],
						lineItems[4], Integer.parseInt(lineItems[5]), lineItems[6]);
				stuntPerformers.add(stuntPerformer);
				performerIDs.add(stuntPerformer.getId());
				performers.add(stuntPerformer);
				allArtist.add(stuntPerformer);


			}
			if (lineItems[0].equals("Director:")) {
				Director director = new Director(lineItems[1], lineItems[2], lineItems[3], lineItems[4], lineItems[5]);
				directors.add(director);
				directorIDs.add(director.getId());
				allArtist.add(director);
				

			}
			if (lineItems[0].equals("Writer:")) {
				Writer writer = new Writer(lineItems[1], lineItems[2], lineItems[3], lineItems[4], lineItems[5]);
				writers.add(writer);
				writerIDs.add(writer.getId());
				allArtist.add(writer);

			}

			if (lineItems[0].equals("User:")) {
				User user = new User(lineItems[1], lineItems[2], lineItems[3], lineItems[4]);
				users.add(user);

			}

		}

		

		// managing film files and adding them to the arraylists

		File filmFile = new File(args[1]);
		Scanner scannerFilms = new Scanner(filmFile);
		ArrayList<FeatureFilm> featureFilms = new ArrayList<FeatureFilm>();
		ArrayList<ShortFilm> shortFilms = new ArrayList<ShortFilm>();
		ArrayList<Documentary> documentaries = new ArrayList<Documentary>();
		ArrayList<TvSeries> tvSeries = new ArrayList<TvSeries>();
		ArrayList<String> filmsTxtLines = new ArrayList<String>();
		ArrayList<Films> allFilms = new ArrayList<Films>();

		while (scannerFilms.hasNextLine()) {
			filmsTxtLines.add(scannerFilms.nextLine());
		}

		for (String line : filmsTxtLines) {
			String[] filmFileLineItems = line.split("\t");
			if (line.contains("FeatureFilm")) {
				
				
					
				
				FeatureFilm featureFilm = new FeatureFilm(filmFileLineItems[1], filmFileLineItems[2],
						filmFileLineItems[3], filmFileLineItems[4].split(","), Integer.parseInt(filmFileLineItems[5]),
						filmFileLineItems[6], filmFileLineItems[7].split(","), filmFileLineItems[8].split(","),
						filmFileLineItems[9], filmFileLineItems[10].split(","),
						Integer.parseInt(filmFileLineItems[11]));
					featureFilms.add(featureFilm);
					allFilms.add(featureFilm);
					featureFilmIDs.add(featureFilm.getId());
				
				

			}
			if (line.contains("ShortFilm")) {
				if (Integer.parseInt(filmFileLineItems[5])>40) {
					System.out.println("ShortFilms must be less than 40 minutes.");
				}
				else {
				ShortFilm shortFilm = new ShortFilm(filmFileLineItems[1], filmFileLineItems[2], filmFileLineItems[3],
						filmFileLineItems[4].split(","), Integer.parseInt(filmFileLineItems[5]), filmFileLineItems[6],
						filmFileLineItems[7].split(","), filmFileLineItems[8].split(","), filmFileLineItems[9],
						filmFileLineItems[10].split(","));
				shortFilms.add(shortFilm);
				allFilms.add(shortFilm);
				shortFilmIDs.add(shortFilm.getId());
				}
			}
			if (line.contains("Documentary")) {
				Documentary documentary = new Documentary(filmFileLineItems[1], filmFileLineItems[2],
						filmFileLineItems[3], filmFileLineItems[4].split(","), Integer.parseInt(filmFileLineItems[5]),
						filmFileLineItems[6], filmFileLineItems[7].split(","), filmFileLineItems[8]);
				documentaries.add(documentary);
				allFilms.add(documentary);
				documentaryIDs.add(documentary.getId());
			}
			if (line.contains("TV")) {
				TvSeries tvSerie = new TvSeries(filmFileLineItems[1], filmFileLineItems[2], filmFileLineItems[3],
						filmFileLineItems[4].split(","), Integer.parseInt(filmFileLineItems[5]), filmFileLineItems[6],
						filmFileLineItems[7].split(","), filmFileLineItems[8].split(","),
						filmFileLineItems[9].split(","), filmFileLineItems[10], filmFileLineItems[11],
						Integer.parseInt(filmFileLineItems[12]), Integer.parseInt(filmFileLineItems[13]));
				tvSeries.add(tvSerie);
				allFilms.add(tvSerie);
				tvSeriesIDs.add(tvSerie.getId());

			}

		}
		
		//creating allFilms arraylist to check whether a film exists or not.
		ArrayList <String> allFilmIDs=new ArrayList <String> ();
		for (Films film: allFilms) {
			allFilmIDs.add(film.getId());
		}


		// Commands part
		
		File outputFile=new File(args[3]);
		FileWriter fw= new FileWriter(outputFile);
		PrintWriter pw=new PrintWriter(fw);
		
		
		
		
		
		
		
		File commandsFile = new File(args[2]);
		Scanner scannerCommands = new Scanner(commandsFile);
		ArrayList<String> commandLines = new ArrayList<String>();
		while (scannerCommands.hasNextLine()) {
			commandLines.add(scannerCommands.nextLine());
		}

		for (String line : commandLines) {
			pw.println(line);
			pw.println("");
			String[] lineItems = line.split("\t");
			
			
			
			//RATE COMMAND
			if (lineItems[0].equals("RATE")) {
				String userID = lineItems[1];
				String filmID = lineItems[2];
				String filmTitle="";
				User userToRate=null;
				Films filmToRate=null;
				boolean userExists=false;
				boolean filmExists=false;
				boolean isFeatureFilm=false;
				boolean isTvSeries=false;
				boolean isShortFilm=false;
				boolean isDocumentary=false;
				int ratingPoint = Integer.parseInt(lineItems[3]);
				
				if (ratingPoint<1 || ratingPoint>10) {
					System.out.println("Rating must be between 1-10!");
				}
				else {
					
				
				for (User user:users) {
					if (userID.equals(user.getId())) {
						userExists=true;
						userToRate=user;
						
					}
				}
				
				for (Films film:allFilms) { 
					if (filmID.equals(film.getId())){
						filmExists=true;
						filmTitle=film.getTitle();
						filmToRate=film;
					}
				}
				
				if (filmExists && userExists) {
					for (FeatureFilm film:featureFilms) {
						if (film.getId().equals(filmID)) {
							isFeatureFilm=true;
						}
					}
					
					for (ShortFilm film:shortFilms) {
						if (film.getId().equals(filmID)) {
							isShortFilm=true;
						}
					}
					
					for (TvSeries film:tvSeries) {
						if (film.getId().equals(filmID)) {
							isTvSeries=true;
						}
					}
					
					for (Documentary film:documentaries) {
						if (film.getId().equals(filmID)) {
							isDocumentary=true;
						}
					}
					
					
					
					
					if (userToRate.chechIfAlreadyRated(filmTitle)) {
						pw.println("This film was earlier rated");
					}
					else {
						userToRate.rate(filmTitle,ratingPoint);
						filmToRate.rateFilm(ratingPoint);
						pw.println("Film rated successfully");
						if (isFeatureFilm) {
							pw.println("Film type: FeatureFilm");
						}
						if (isShortFilm) {
							pw.println("Film type: ShortFilm");
							
						}
						if (isDocumentary) {
							pw.println("Film type: Documentary");
							
						}
						if (isTvSeries) {
							pw.println("Film type: TVSeries");
							
						}
						pw.println("Film title: "+filmTitle);
					}
					
					
				}
				else {
					pw.println("Command Failed");
					pw.println("User ID: "+userID);
					pw.println("Film ID: "+filmID);
				}
				

				}

			}
			
			
			//ADD FEATUREFILM COMMAND
			if (line.contains("ADD\tFEATUREFILM")) {
				String filmID=(lineItems[2]);
				String filmTitle=(lineItems[3]);
				String language=(lineItems[4]);
				String [] directorIDs2=(lineItems[5].split(","));
				int runTime=(Integer.parseInt(lineItems[6]));
				String country=lineItems[7];
				String [] cast=(lineItems[8].split(","));
				String [] genres=lineItems[9].split(",");
				String releaseDate=lineItems[10];
				String [] writersOfFeatureFilm=(lineItems[11].split(","));
				int budget=Integer.parseInt(lineItems[12]);
				
				boolean isEligable=true;
				for (String directorid:directorIDs2) {
					if (!directorIDs.contains(directorid)) {
						isEligable=false;
					}
				}

				
				for (String performerid: cast) {
					if (!performerIDs.contains(performerid)) {
						isEligable=false;
					}
				}

				
				for (String writerid: writersOfFeatureFilm) {
					if (!writerIDs.contains(writerid)) {
						isEligable=false;
					}
				}

				
				if (allFilmIDs.contains(filmID)) {
					isEligable=false;
				}

				
				
				
				if (isEligable) {
				FeatureFilm newFeatureFilm= new FeatureFilm(filmID, filmTitle, language, directorIDs2, runTime, country, cast, genres, releaseDate, writersOfFeatureFilm, budget);
				featureFilms.add(newFeatureFilm);
				allFilms.add(newFeatureFilm);
				allFilmIDs.add(filmID);
				pw.println("FeatureFilm added successfully");
				pw.println("Film ID: "+filmID);
				pw.println("Film title: "+filmTitle);
				
					
				}
				else {
					pw.println("Command Failed");
					pw.println("Film ID: "+filmID);
					pw.println("Film title: "+filmTitle);
					
				}

				
				
				
				
				
			//VIEWFILM COMMAND
				
			}
			if (line.contains("VIEWFILM")) {
				String id=lineItems[1];
				boolean isEligable=false;
				Films filmToView=null;
				
				for (Films film:allFilms) {
					if (id.equals(film.getId())) {
						isEligable=true;
						filmToView=film;
					}
				}
				
				if (isEligable) {
					boolean isFeatureFilm=false;
					boolean isShortFilm=false;
					boolean isDocumentary=false;
					boolean isTVSeries=false;
					FeatureFilm ffToPrint=null;
					ShortFilm sfToPrint=null;
					Documentary docToPrint=null;
					TvSeries tvToPrint=null;
					
					for (FeatureFilm film:featureFilms) {
						if (filmToView.getId().equals(film.getId())) {
							isFeatureFilm=true;
							ffToPrint=film;
						}
					}
					for (ShortFilm film:shortFilms) {
						if (filmToView.getId().equals(film.getId())) {
							isShortFilm=true;
							sfToPrint=film;
						}
					}
					for (Documentary film:documentaries) {
						if (filmToView.getId().equals(film.getId())) {
							isDocumentary=true;
							docToPrint=film;
						}
					}
					for (TvSeries film:tvSeries) {
						if (filmToView.getId().equals(film.getId())) {
							isTVSeries=true;
							tvToPrint=film;
						}
					}
					
					if (isFeatureFilm) {
						ffToPrint.print(writers, directors, performers,pw);
					}
					if (isShortFilm) {
						sfToPrint.print(writers, directors, performers,pw);
					}
					
					if (isDocumentary) {
						docToPrint.print(directors, performers,pw);
					}
					
					if (isTVSeries) {
						tvToPrint.print(directors, performers, writers,pw);
					}
					
				}
				else {
					pw.println("Command Failed");
					pw.println("Film ID: "+id);
				}
			//LIST USER RATES COMMAND
				
			}
			if (line.contains("LIST\tUSER")) {
				String userID=(lineItems[2]);
				User userToList=null;
				boolean isEligable=false;
				for (User user:users) {
					if (user.getId().equals(userID)) {
						isEligable=true;
						userToList=user;
					}
					
				}
				
				if (isEligable) {
					userToList.printRatedFilms(pw);
					
				}
				else {
					pw.println("Command Failed");
					pw.println("User ID: "+userID);
				}
				
			//EDIT RATE COMMAND
			}

			if (line.contains("EDIT\tRATE")) {
				String userID=lineItems[2];
				String filmID=lineItems[3];
				String filmTitle="";
				boolean userExists=false;
				boolean filmExists=false;
				User userToChangeRate=null;
				Films filmToChangeRate=null;
				int newRating=Integer.parseInt(lineItems[4]);
				for (User user:users) {
					if (userID.equals(user.getId())) {
						userExists=true;
						userToChangeRate=user;
					}
				}
				
				for (Films film:allFilms) {
					if (filmID.equals(film.getId())) {
						filmExists=true;
						filmToChangeRate=film;
						filmTitle=film.getTitle();
					}
				}
				
				

				if (userExists&& filmExists) {
					boolean alreadyRated=userToChangeRate.chechIfAlreadyRated(filmTitle);
					if (!alreadyRated) {
						pw.println("Command Failed");
						pw.println("User ID: "+userID);
						pw.println("Film ID: "+filmID);
						
					}
					else {
						int previousRating=userToChangeRate.returnCurrentRate(filmTitle);
						userToChangeRate.editRate(newRating, filmTitle);
						filmToChangeRate.updateRating(previousRating, newRating);
						pw.println("New ratings done successfully");
						pw.println("");
						pw.println("Film title: "+filmTitle);
						pw.println("Your rating: "+newRating);
						
					}
					
				}
				else {
					pw.println("Command Failed");
					pw.println("User ID: "+userID);
					pw.println("Film ID: "+filmID);
				}
				
				
				
			//REMOVE RATE COMMAND
			
			}
			if (line.contains("REMOVE\tRATE")) {
				String userID=lineItems[2];
				String filmID=lineItems[3];
				String filmTitle="";
				User userToRemoveRating=null;
				Films filmToRemoveRating=null;
				boolean filmExists=false;
				boolean userExists=false;
				

				
				for(Films film:allFilms) {
					if (filmID.equals(film.getId())) {
						filmExists=true;
						filmTitle=film.getTitle();
						filmToRemoveRating=film;
					}
				}
				for (User user:users) {
					if(userID.equals(user.getId())) {
						userExists=true;
						userToRemoveRating=user;
					}
				}
				
				if (filmExists && userExists) {
					if (userToRemoveRating.chechIfAlreadyRated(filmTitle)) {
						int previousRating=userToRemoveRating.returnCurrentRate(filmTitle);
						userToRemoveRating.removeRating(filmTitle);
						filmToRemoveRating.removeRating(previousRating);
						pw.println("Your film rating was removed successfully");
						pw.println("Film title: "+filmTitle);
					}
					else {
						pw.println("Command Failed");
						pw.println("User ID: "+userID);
						pw.println("Film ID: "+filmID);
						
					}

				}
				else {
					pw.println("Command Failed");
					pw.println("User ID: "+userID);
					pw.println("Film ID: "+filmID);
				}
				
			//LIST ALL TV SERIES COMMAND
			}
			if (line.contains("LIST\tFILM\tSERIES")) {
				if (tvSeries.size()==0) {
					pw.println("No result");
				}
				else {
					
				
				for (TvSeries tvSerie:tvSeries) {
					tvSerie.listTVSeries(pw);
					pw.println("");
					}
				}
				
			//LIST FILMS FROM A SPECIFIED COUNTRY COMMAND

			}

			if (line.contains("LIST\tFILMS\tBY\tCOUNTRY")) {
				String country=lineItems[4];
				ArrayList <Films> filmsFromACountry= new ArrayList<Films>();
				for (Films film:allFilms) {
					if (film.getCountry().contentEquals(country)) {
						filmsFromACountry.add(film);
					}
				}
				
				if (filmsFromACountry.size()==0) {
					pw.println("No result");
				}
				else {
					for (Films film:filmsFromACountry) {
						pw.println("Film title: "+film.getTitle());
						pw.println(film.getRunTime()+" min");
						pw.println("Language: "+film.getLanguage());
						pw.println("");
					}
				}
				
			}
			
			//LIST FEATUREFILMS BEFORE A SPECIFIED YEAR COMMAND
			if (line.contains("LIST\tFEATUREFILMS\tBEFORE")) {
				int filmsBeforeYear=Integer.parseInt(lineItems[3]);
				ArrayList <FeatureFilm> featureFilmsToPrint=new ArrayList<FeatureFilm>();
					for (FeatureFilm ff:featureFilms) {
						if (ff.returnFilmYear()<filmsBeforeYear) {
							featureFilmsToPrint.add(ff);
						}
						
					}
					
					if (featureFilmsToPrint.size()!=0) {
						for (FeatureFilm ff:featureFilmsToPrint) {
							pw.println("Film title: "+ff.getTitle()+" ("+ff.returnFilmYear()+")");
							pw.println(ff.getRunTime()+" min");
							pw.println("Language: "+ff.getLanguage());
						}
					}
					else {
						pw.println("No result");
					}
			}
			
			
			//LIST FEATUREFILMS AFTER A SPECIFIED YEAR COMMAND
			if (line.contains("LIST\tFEATUREFILMS\tAFTER")) {
				int filmsAfterYear=Integer.parseInt(lineItems[3]);
				ArrayList <FeatureFilm> featureFilmsToPrint=new ArrayList<FeatureFilm>();
					for (FeatureFilm ff:featureFilms) {
						if (ff.returnFilmYear()>=filmsAfterYear) {
							featureFilmsToPrint.add(ff);
						}
						
					}
					
					if (featureFilmsToPrint.size()!=0) {
						for (FeatureFilm ff:featureFilmsToPrint) {
							pw.println("Film title: "+ff.getTitle()+" ("+ff.returnFilmYear()+")");
							pw.println(ff.getRunTime()+" min");
							pw.println("Language: "+ff.getLanguage());
						}
					}
					else {
						pw.println("No result");
					}

			//LIST FILMS BY DESCENDING DEGREE COMMAND
			}

			if (line.contains("LIST\tFILMS\tBY\tRATE\tDEGREE")) {
				ArrayList <FeatureFilm> sortedFF=featureFilms;
				ArrayList <ShortFilm> sortedSF=shortFilms;
				ArrayList <Documentary> sortedDOC=documentaries;
				ArrayList <TvSeries> sortedTV=tvSeries;
				
				sortedFF.sort((film1,film2) -> Double.compare(film2.getAverageRating(), film1.getAverageRating()));
				sortedSF.sort((film1,film2) -> Double.compare(film2.getAverageRating(), film1.getAverageRating()));
				sortedDOC.sort((film1,film2) -> Double.compare(film2.getAverageRating(), film1.getAverageRating()));
				sortedTV.sort((film1,film2) -> Double.compare(film2.getAverageRating(), film1.getAverageRating()));
				
				pw.println("FeatureFilm:");
				if (sortedFF.size()!=0) {
					for (FeatureFilm ff:sortedFF) {
						double averageRating=ff.getAverageRating();
						if (averageRating%1==0) {
							pw.println(ff.getTitle()+" ("+ff.returnFilmYear()+") Ratings: "+(int) averageRating+"/10 from "+ff.getPeopleVoted()+" users");
						}
						else {
							String stringAvg=Math.round(ff.getAverageRating()*10)/10.0+"";
							stringAvg=stringAvg.replace(".", ",");
							pw.println(ff.getTitle()+" ("+ff.returnFilmYear()+") Ratings: "+stringAvg+"/10 from "+ff.getPeopleVoted()+" users");
						}
						
					}
					pw.println("");
				}
				else {
					pw.println("No result");
					pw.println("");
				}
				
				pw.println("ShortFilm:");
				if (sortedSF.size()!=0) {
					for (ShortFilm sf:sortedSF) {
						double averageRating=sf.getAverageRating();
						if (averageRating%1==0) {
							pw.println(sf.getTitle()+" ("+sf.returnFilmYear()+") Ratings: "+(int) averageRating+"/10 from "+sf.getPeopleVoted()+" users");
						}
						else {
							String stringAvg=Math.round(sf.getAverageRating()*10)/10.0+"";
							stringAvg=stringAvg.replace(".", ",");
							pw.println(sf.getTitle()+" ("+sf.returnFilmYear()+") Ratings: "+stringAvg+"/10 from "+sf.getPeopleVoted()+" users");
						}
						
					}
					pw.println("");
				}
				else {
					pw.println("No result");
					pw.println("");
				}
				
				
				pw.println("Documentary:");
				if (sortedDOC.size()!=0) {
					for (Documentary doc: sortedDOC) {
						double averageRating=doc.getAverageRating();
						if (averageRating%1==0){
							pw.println(doc.getTitle()+" ("+doc.returnYear()+") Ratings: "+(int) averageRating+"/10 from "+doc.getPeopleVoted()+" users");
						}
						else {
							String stringAvg=Math.round(doc.getAverageRating()*10)/10.0+"";
							stringAvg=stringAvg.replace(".", ",");
							pw.println(doc.getTitle()+" ("+doc.returnYear()+") Ratings: "+stringAvg+"/10 from "+doc.getPeopleVoted()+" users");
						}
					}
					pw.println("");
					pw.flush();
				}
				else {
					pw.println("No result");
					pw.println("");
					pw.flush();
				}
				
				pw.println("TVSeries:");
				if (sortedTV.size()!=0) {
					for (TvSeries tv:sortedTV) {
						double averageRating=tv.getAverageRating();
						if (averageRating%1==0) {
							pw.println(tv.getTitle()+" ("+tv.returnStartYear()+"-"+tv.returnEndYear()+") Ratings: "+(int) averageRating+"/10 from "+tv.getPeopleVoted()+" users");
						}
						else {
							String stringAvg=Math.round(tv.getAverageRating()*10)/10.0+"";
							stringAvg=stringAvg.replace(".", ",");
							pw.println(tv.getTitle()+" ("+tv.returnStartYear()+"-"+tv.returnEndYear()+") Ratings: "+stringAvg+"/10 from "+tv.getPeopleVoted()+" users");
						}
						pw.flush();
					}
					pw.println("");
					pw.flush();
				}
				else {
					pw.println("No result");
					pw.println("");
					pw.flush();
				}
				
				
				
				
			//LIST ARTISTS FROM A SPECIFIED COUNTRY COMMAND
				
			}

			if (line.contains("LIST\tARTISTS\tFROM")) {
				String artistFromCountry=lineItems[3];
				ArrayList <Director> directorsToPrint=new ArrayList<Director>();
				ArrayList <Writer> writersToPrint= new ArrayList<Writer>(); 
				ArrayList <Actor> actorsToPrint=new ArrayList<Actor>();
				ArrayList <ChildActor> childActorsToPrint= new ArrayList<ChildActor>();
				ArrayList <StuntPerformer> stuntPerformersToPrint= new ArrayList<StuntPerformer>();
				
				for (Director director:directors) {
					if (artistFromCountry.equals(director.getCountry())){
						directorsToPrint.add(director);
					}
				}
				
				pw.println("Directors:");
				pw.flush();
				if (directorsToPrint.size()!=0) {
					for (Director director:directorsToPrint) {
						pw.println(director.getName()+" "+director.getSurname()+" "+director.getAgent());
						pw.flush();
					}
					pw.println("");
				}
				else {
					pw.println("No result");
					pw.println("");
					pw.flush();
				}
				
				
				
				for (Writer writer:writers) {
					
					if (artistFromCountry.equals(writer.getCountry())) {
						writersToPrint.add(writer);
						pw.flush();
					}
				}
				pw.println("Writers:");
				if (writersToPrint.size()!=0) {
					for (Writer writer: writersToPrint) {
						pw.println(writer.getName()+" "+writer.getSurname()+" "+writer.getWritingStyle());
					}
					pw.println("");
				}
				else {
					pw.println("No result");
					pw.println("");
				}
				pw.flush();
				for (Actor actor:actors) {
					
					if (artistFromCountry.equals(actor.getCountry())) {
						actorsToPrint.add(actor);
					}
				}
				pw.println("Actors:");
				if (actorsToPrint.size()!=0) {
					for (Actor actor:actorsToPrint) {
						pw.println(actor.getName()+" "+actor.getSurname()+" "+actor.getHeight()+" cm");
					}
					pw.println("");
				}
				else {
					pw.println("No result");
					pw.println("");
					
				}
				pw.flush();
				for (ChildActor childActor:childActors) {
					if (artistFromCountry.equals(childActor.getCountry())) {
						childActorsToPrint.add(childActor);
					}
				}
				pw.println("ChildActors:");
				if (childActorsToPrint.size()!=0) {
					for (ChildActor childActor:childActorsToPrint) {
						pw.println(childActor.getName()+" "+childActor.getSurname()+" "+childActor.getAge());
					}
				}
				else {
					pw.println("No result");
					pw.println("");
				}
				
				for (StuntPerformer stuntPerformer:stuntPerformers) {
					
					if (artistFromCountry.equals(stuntPerformer.getCountry())) {
						stuntPerformersToPrint.add(stuntPerformer);
					}
					
				}
				pw.flush();
				pw.println("StuntPerformers:");
				if (stuntPerformersToPrint.size()!=0) {
					for (StuntPerformer stuntPerformer:stuntPerformersToPrint) {
						pw.println(stuntPerformer.getName()+" "+stuntPerformer.getSurname()+" "+stuntPerformer.getHeight()+" cm");
					}
				}
				else {
					pw.println("No result");
				}
			}
			

			pw.println("-----------------------------------------------------------------------------------------------------");
		}
		pw.close();

	}

}



