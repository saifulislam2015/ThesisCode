import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
	public static void listbodies() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","1234");
			Statement st = con.createStatement();
			String query = "select body from cassandra_posts order by id";
			//ResultSet rs = oc.searchDB(query);
			ResultSet rs = st.executeQuery(query);
			int i = 1;
			while(rs.next()) {
				String post = rs.getString("body");
				String s = Integer.toString(i);
				String file = "C:\\mallet\\sample-data\\web\\cassandra\\"+ s +".txt";
				PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				//System.out.println(i);
				post = post.replaceAll("<code>[\\s\\S]*?</code>","");
				post = post.replaceAll("<img[\\s\\S]*?>","");
				post = post.replaceAll("\\<.*?\\>", "");
				post = post.replace("&#xA;","");
				post = post.replace("&nbsp;", " ");
				post = post.replace("&amp;", "&");
				post = post.replaceAll("&.*?;", "");
				w.println(post);
				w.close();
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception in listbodies: " + e);
		}
	}

	
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		listbodies();
		scanner.close();
	}
}

	