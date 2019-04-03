package coletor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Coletor {
	private Twitter twitter;
	private File    file; 
	private String  cNameFile;
	private String  cQuery;

	public Coletor() {
		this.twitter  = TwitterFactory.getSingleton();
		this.cNameFile= "";
		this.cQuery   = "";
	}

	private void buscaTweets(String cQuery) {
		this.cQuery = cQuery;


	}

	private void exec() {
		System.out.println("Digite o nome do arquivo:");
		Scanner input = new Scanner(System.in);
		this.cNameFile = input.nextLine();

		System.out.println("Digite a pesquisa:");
		input = new Scanner(System.in);
		this.cQuery = input.nextLine();

		this.file = new File(cNameFile);

		FileWriter fileW;

		try {
			fileW = new FileWriter (file);
			BufferedWriter buffW = new BufferedWriter (fileW);


			Query query = new Query(this.cQuery);
			query.setCount(100);
			
			QueryResult result = twitter.search(query);
			List<Status> tweets = result.getTweets();

			for (Status tweet : tweets) {

				buffW.write("@" + tweet.getUser().getScreenName() + ":" + tweet.getText().toUpperCase() + "\n");

			}

			buffW.flush();
			buffW.close();
		} catch ( IOException | TwitterException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Status> getDiscussion(Status status, Twitter twitter) {
		ArrayList<Status> replies = new ArrayList<>();

		ArrayList<Status> all = null;

		try {
			long id = status.getId();
			String screenname = status.getUser().getScreenName();

			Query query = new Query("@" + screenname + " since_id:" + id);

			System.out.println("query string: " + query.getQuery());

			try {
				query.setCount(100);
			} catch (Throwable e) {
				// enlarge buffer error?
				query.setCount(30);
			}

			QueryResult result = twitter.search(query);
			System.out.println("result: " + result.getTweets().size());

			all = new ArrayList<Status>();

			do {
				System.out.println("do loop repetition");

				List<Status> tweets = result.getTweets();

				for (Status tweet : tweets)
					if (tweet.getInReplyToStatusId() == id)
						all.add(tweet);

				if (all.size() > 0) {
					for (int i = all.size() - 1; i >= 0; i--)
						replies.add(all.get(i));
					all.clear();
				}

				query = result.nextQuery();

				if (query != null)
					result = twitter.search(query);

			} while (query != null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		return replies;
	}

	public static void main(String[] args) throws TwitterException {

		Coletor c = new Coletor();
		System.out.println("Iniciando rotina de coleta de Tweets ... ");

		c.exec();

		System.out.println("Finalizando rotina de coleta de Tweets ...");
	}
}
