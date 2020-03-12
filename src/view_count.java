import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class view_count {
    public static void Rank() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","1234");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            int memsize = 9;


            int[] count = new int[memsize];
            int[] view = new int[memsize];

            for(int i=0;i<memsize;i++){
                count[i] = 0;
                view[i] = 0;
            }

            File file = new File("mongo.txt");
            PrintWriter pw = new PrintWriter(file);

            String query = "select Id,ViewCount,final_feature from mongo_posts order by id";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int feature = rs.getInt("final_feature");
                int vc = rs.getInt("ViewCount");

                count[feature]++;
                view[feature]+=vc;
            }


            pw.println("Topic  "+"Ques  "+"View     "+"views/Ques");

            for(int i=0;i<memsize;i++){
                //System.out.println(i+" "+means[i] + " "+medians[i]);
                pw.println(i+"     "+count[i] + "  "+view[i]+"   "+view[i]/count[i]);
            }
            pw.close();



        } catch (Exception e) {
            System.out.println("Exception in listProducts: " + e);
        }
    }


    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Rank();
        scanner.close();
    }
}