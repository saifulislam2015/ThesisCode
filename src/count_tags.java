import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class count_tags {
    public static void Merge() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","1234");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);



            File file = new File("mongo_tags.txt");
            PrintWriter pw = new PrintWriter(file);

            String query = "select Id,tags from mongo_posts order by id";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String s = rs.getString("tags") ;
                s = s.replace("<", "");
                s = s.replace(">", " ");
                String[] arrOfStr = s.split(" ");
                for (String a : arrOfStr) pw.print(a+"\n");
                //pw.println(s);
            }
            pw.close();


        } catch (Exception e) {
            System.out.println("Exception in listProducts: " + e);
        }
    }


    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Merge();
        scanner.close();
    }
}


