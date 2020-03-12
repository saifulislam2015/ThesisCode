import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;


public class answered_ratio {
    public static void listProducts() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","1234");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            int memsize = 16;

            int [] answered = new int[memsize];
            int [] unanswered = new int[memsize];

            for(int i=0;i<memsize;i++){
                answered[i] = 0;
                unanswered[i] = 0;
            }


            File file = new File("hbase_answered_ratio.txt");
            PrintWriter pw = new PrintWriter(file);

            String query = "select Id,AcceptedAnswerId,features from duplicate_hbase order by id";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int feature = rs.getInt("features");
                int aid = rs.getInt("AcceptedAnswerId");


                if(aid!=0) answered[feature]++;
                else unanswered[feature]++;

            }


            pw.println("Feature#  "+"Ans  "+"Unans    "+"ans%");

            for(int i=0;i<memsize;i++){
                System.out.println(i+" "+answered[i] + " "+unanswered[i]);
                pw.println(i+"      "+answered[i] + "       "+unanswered[i]+"       "+answered[i]*100/(answered[i]+unanswered[i]));
            }
            pw.close();



        } catch (Exception e) {
            System.out.println("Exception in listProducts: " + e);
        }
    }


    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        listProducts();
        scanner.close();
    }
}

