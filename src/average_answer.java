import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class average_answer {
    public static void Rank() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","Saiful073!");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            int memsize = 8;
            int idx = 0;


            int[] answers = new int[memsize];
            int[] count = new int[memsize];

            for (int i=0;i<memsize;i++) {
                count[i] = 0;
                answers[i] = 0;
            }

            File file = new File("redis_average_answers.txt");
            PrintWriter pw = new PrintWriter(file);

            String query = "select Id,AnswerCount,feature from redis_posts order by id";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int feature = rs.getInt("feature");
                answers[feature] += rs.getInt("AnswerCount");

                count[feature]++;
                idx++;

                System.out.println(idx);


            }


            pw.println("Topic "+"         answers  "+"    Totals");

            for(int i=0;i<memsize;i++){
                //double d = answers[i]/count[i];
                System.out.println(i+" "+answers[i] + " "+ count[i]);
                pw.println(i+" "+answers[i] + " "+ count[i]);
                //pw2.println(i+"  "+unanswered[i]+" "+count[i]);
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
