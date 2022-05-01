import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
			
		
		//String authorFileName=args[0];
		//String authorFileName="author.txt";
		//String commandFileName="command.txt";
		//File authorFile=new File("C:\\Users\\atamk\\eclipse-workspace\\BBM104-Assignment 1\\src\\"+authorFileName);
		//File commandFile=new File("C:\\Users\\atamk\\eclipse-workspace\\BBM104-Assignment 1\\src\\"+commandFileName);
		File authorFile=new File(args[0]);
		File commandFile=new File(args[1]);
		File outputFile=new File("output.txt");
		FileWriter fw= new FileWriter(outputFile);
		PrintWriter pw=new PrintWriter(fw);
		Scanner scanner2=new Scanner(authorFile);
		Scanner scanner3=new Scanner(commandFile);
		ArrayList <Author> authors=new ArrayList <Author>();
		ArrayList <String> commands=new ArrayList <String>();
		ArrayList <Article>articles= new ArrayList <Article>();
		//creating author objects
		while (scanner2.hasNextLine()) {
			String [] authorParts=scanner2.nextLine().split(" ");
			
			int size= authorParts.length;
			
			
			if(size==2) {
				Author author=new Author(authorParts[1],"","","","","","","","","");
				authors.add(author);
			}
			
			if(size==3) {
				Author author=new Author(authorParts[1],authorParts[2],"","","","","","","","");
				authors.add(author);
			}
			if(size==4) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],"","","","","","","");
				authors.add(author);
			}
			
			if(size==5) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],"","","","","","");
				authors.add(author);
			}
			if (size==6) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],authorParts[5],"","","","","");
				authors.add(author);
			}
			if (size==7) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],authorParts[5],authorParts[6],"","","","");
				authors.add(author);
			}
			if (size==8) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],authorParts[5],authorParts[6],authorParts[7],"","","");
				authors.add(author);
			}
			if (size==9) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],authorParts[5],authorParts[6],authorParts[7],authorParts[8],"","");
				authors.add(author);
			}
			if (size==10) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],authorParts[5],authorParts[6],authorParts[7],authorParts[8],authorParts[9],"");
			authors.add(author);
			}
		    if (size==11) {
				Author author=new Author(authorParts[1],authorParts[2],authorParts[3],authorParts[4],authorParts[5],authorParts[6],authorParts[7],authorParts[8],authorParts[9],authorParts[10]);
			authors.add(author);
			}
					
		}
		
		while(scanner3.hasNextLine()) {
			commands.add(scanner3.nextLine());
		}
		
		for (String command:commands) {
			if (command.contains("read")) {
				String readArticleName=(command.substring(command.indexOf(" ")+1));
				File articleFile=new File(readArticleName);
				Scanner scanner= new Scanner(articleFile);
				while (scanner.hasNextLine()) {
					
					String [] parts= scanner.nextLine().split(" ");
					Article article= new Article (parts[1],parts[2],parts[3],parts[4]);
					articles.add(article);
					
				}
				
				//pw.println("*************************************Read Successful*************************************");
			}
			if (command.contains("list")) {
				pw.println("--------------------------------------List-------------------------------------");
				for (Author author:authors) {
					pw.println("Author:"+author.getId()+"\t"+author.getName()+"\t"+author.getUniversity()+"\t"+author.getDepartment()+"\t"+author.getEmail());
					int checkNumberOfArticles=0;
					int numberOfArticles=author.getNumberOfArticles();
					
					while (checkNumberOfArticles<=numberOfArticles) {
						if(checkNumberOfArticles==0) {
							
						}
						if(checkNumberOfArticles==1) {
							
							for (Article article:articles) {
								if (article.getPaperId().equals(author.getArticle1())) {
									pw.println("+"+author.getArticle1()+"\t"+article.getName()+"\t"+article.getPublisherName()+"\t"+article.getPublishYear());
									
								}
							}
							
						}
						
						if(checkNumberOfArticles==2) {
							for (Article article:articles) {
								if (article.getPaperId().equals(author.getArticle2())) {
									pw.println("+"+author.getArticle2()+"\t"+article.getName()+"\t"+article.getPublisherName()+"\t"+article.getPublishYear());
									
								}
								
							}
						}
						if(checkNumberOfArticles==3) {
							for (Article article:articles) {
								if (article.getPaperId().equals(author.getArticle3())) {
									pw.println("+"+author.getArticle3()+"\t"+article.getName()+"\t"+article.getPublisherName()+"\t"+article.getPublishYear());
									
								}
								
							}
							
						}
						if(checkNumberOfArticles==4) {
							for (Article article:articles) {
								if (article.getPaperId().equals(author.getArticle4())) {
									pw.println("+"+author.getArticle4()+"\t"+article.getName()+"\t"+article.getPublisherName()+"\t"+article.getPublishYear());
									
								}
								
							}
						}
						if(checkNumberOfArticles==5) {
							for (Article article:articles) {
								if (article.getPaperId().equals(author.getArticle5())) {
									pw.println("+"+author.getArticle5()+"\t"+article.getName()+"\t"+article.getPublisherName()+"\t"+article.getPublishYear());
									
								}
								
							}
						}
						
						checkNumberOfArticles++;
						
					}
					pw.println("");
				}
				pw.println("--------------------------------------End--------------------------------------");
				pw.flush();
				
			}
			
			if (command.contains("completeAll")) {
				for (Author author:authors) {
					ArrayList <String> allArticles=author.getAllArticles();
					for (Article article:articles) {
						if (author.getId().equals(article.getAuthorId())&& !allArticles.contains(article.getPaperId())) {
							if (author.getNumberOfArticles()==4) {
								author.setArticle5(article.getPaperId());
							}
							if (author.getNumberOfArticles()==3) {
								author.setArticle4(article.getPaperId());
							}
							if (author.getNumberOfArticles()==2) {
								author.setArticle3(article.getPaperId());
							}
							if (author.getNumberOfArticles()==1) {
								author.setArticle2(article.getPaperId());
							}
							if (author.getNumberOfArticles()==0) {
								author.setArticle1(article.getPaperId());
							}
						}
					}
				}
				pw.println("*****************************completeAll Successful****************************");
				pw.flush();
				
			}
			if (command.contains("sortedAll")) {
				for (Author author:authors) {
					ArrayList <String> authorArticles= new ArrayList <String>();
					if (!author.getArticle1().equals("")) {
						authorArticles.add(author.getArticle1());
						
					}
					if (!author.getArticle2().equals("")) {
						authorArticles.add(author.getArticle2());
						
					}
					if (!author.getArticle3().equals("")) {
						authorArticles.add(author.getArticle3());
						
					}
					if (!author.getArticle4().equals("")) {
						authorArticles.add(author.getArticle4());
						
					}
					if (!author.getArticle5().equals("")) {
						authorArticles.add(author.getArticle5());
						
					}
					
					Collections.sort(authorArticles);
					
					while (authorArticles.size()!=5) {
						authorArticles.add("");
					}
					
					author.setArticle1(authorArticles.get(0));
					author.setArticle2(authorArticles.get(1));
					author.setArticle3(authorArticles.get(2));
					author.setArticle4(authorArticles.get(3));
					author.setArticle5(authorArticles.get(4));	
				}
				pw.println("******************************SortedAll Successful*****************************");
				pw.flush();
				
			}
			if (command.contains("del")) {
				String delId=(command.substring(command.indexOf(" ")+1));
				authors.removeIf(abc-> abc.getId().equals(delId));
				pw.println("*********************************del Successful********************************");
				pw.flush();
			}

		}
		

		
	}

}
