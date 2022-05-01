import java.util.ArrayList;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Films {
	private String id;
	private String title;
	private String language;
	private int runTime;
	private String country;
	private String [] directorIDs;
	private String [] cast;
	private int peopleVoted;
	private int totalVote;
	
	
	
	
	public Films(String id, String title, String language, String[] directorIDs, int runTime, String country,
			String[] cast) {
		super();
		this.id = id;
		this.title = title;
		this.language = language;
		this.runTime = runTime;
		this.country = country;
		this.directorIDs = directorIDs;
		this.cast = cast;
		this.peopleVoted = 0;
		this.totalVote = 0;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getRunTime() {
		return runTime;
	}
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	//helps print command
	public String printDirectorIDs() {
		String directors="";
		for (String id: this.directorIDs) {
			directors=directors+id+", ";
		}
		return directors;
	}
	
	public void setDirectorIDs(String[] directorIDs) {
		this.directorIDs = directorIDs;
	}
	//helps print command
	public String printCast() {
		String casts="";
		for (String a: this.cast) {
			casts=casts+a+" ,";
			
		}
		return casts;
	}
	
	public String[] getDirectorIDs() {
		return directorIDs;
	}
	public String[] getCast() {
		return cast;
	}
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	public int getPeopleVoted() {
		return peopleVoted;
	}
	public void setPeopleVoted(int peopleVoted) {
		this.peopleVoted = peopleVoted;
	}
	public int getTotalVote() {
		return totalVote;
	}
	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}
	


	
	public void rateFilm(int ratePoint) {
		this.totalVote=this.totalVote+ratePoint;
		this.peopleVoted++;
	}
	
	//helps print command
	public void printDirectorNames (ArrayList <Director> directors, PrintWriter pw) {
		ArrayList <String> directorNames=new ArrayList<String>();
		String firstName;
		String secondName;
		for (String directorID:this.getDirectorIDs()) {
			for (Director director:directors) {
				if (directorID.equals(director.getId())) {
					firstName=director.getName();
					secondName=director.getSurname();
					directorNames.add(firstName+" "+secondName);
				}
			}
		}
		pw.print("Directors: ");
		pw.print(directorNames.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
		//for (String name:directorNames) {
		//	pw.print(name+" ,");
		//}
	}
	
	//helps print command
	public void printCastNames(ArrayList <Performer> performers,PrintWriter pw) {
		ArrayList <String> performerNames= new ArrayList <String>();
		String firstName;
		String secondName;
		for (String performerID:this.getCast()) {
			for (Performer performer:performers) {
				if (performerID.equals(performer.getId())) {
					firstName=performer.getName();
					secondName=performer.getSurname();
					performerNames.add(firstName+" "+secondName);
				}
			}
		}
		pw.print("Stars: ");
		pw.print(performerNames.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
		//for (String name:performerNames) {
		//	pw.print(name+", ");
		//}
		
	}
	//helps print command
	public void printRatings(PrintWriter pw) {
		double average=(double)this.getTotalVote()/(double)this.getPeopleVoted();
		if (this.getPeopleVoted()==0) {
			pw.println("Awaiting for votes");
		}
		else {
			if (average%1==0) {
				pw.println("Ratings: "+(int) average+"/10 from "+this.getPeopleVoted()+" users");
			}
			else {
				average=Math.round(average*10)/10.0;
				String avgString=average+"";
				avgString=avgString.replace(".", ",");
				pw.println("Ratings: "+avgString+"/10 from "+this.getPeopleVoted()+" users");
				
			}
			
		}
	}
	
	
	public void updateRating(int previousRating,int newRating) {
		this.totalVote=this.totalVote-previousRating;
		this.totalVote=this.totalVote+newRating;
		
	}
	
	public double getAverageRating() {
		double average=(double) this.totalVote/ (double)this.peopleVoted;
		if (Double.isNaN(average)) {
			return 0;
		}
		else {
			return average;
		}
		
		
		
	}
	
	public void removeRating(int previousRating) {
		this.totalVote=this.totalVote-previousRating;
		this.peopleVoted--;
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
	
	
	