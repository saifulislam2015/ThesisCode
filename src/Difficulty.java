import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Difficulty {
    public static void Rank() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","Saiful073!");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            // memsize = 8;
            int idx = 0;

            /*Vector<Vector<Integer>> storage = new Vector<Vector<Integer>>(memsize);
            for(int i=0;i<memsize;i++){
                Vector<Integer> v = new Vector<>();
                storage.add(v);
            }
            int[] means = new int[memsize];
            int[] medians = new int[memsize];
            int[] count = new int[memsize];
            int[] unanswered = new int[memsize];

            for (int i=0;i<memsize;i++) {
                count[i] = 0;
                unanswered[i] = 0;
            }

            File file = new File("redis_difficulty.txt");
            File file2 = new File("redis_ans_ratio.txt");
            PrintWriter pw = new PrintWriter(file);
            PrintWriter pw2 = new PrintWriter(file2);*/

            String query = "select Id,AcceptedAnswerId,CreationDate from questions where AcceptedAnswerId is not null order by id";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int id = rs.getInt("Id");
                int aid = rs.getInt("AcceptedAnswerId");
                Timestamp ts = rs.getTimestamp(3);
                java.sql.Date D = new Date(ts.getTime());
                java.sql.Date d = null;
                //count[feature]++;
                idx++;

                System.out.println(idx +": "+id);
                
				//if(aid!=0){
                    String q = "select CreationDate from answers where Id="+aid;
                    ResultSet r = st2.executeQuery(q);
                    while (r.next()){
                        Timestamp t = r.getTimestamp(1);
                        d = new Date(t.getTime());
                    }

                    //System.out.println(d);
                    //System.out.println(D);
                    long diff = d.getTime() - D.getTime();
                    long diffM = (diff / (60 * 1000));
                    //System.out.println(diffM);
                    //storage.elementAt(feature).add((int)diffM);
					
					String sql = "INSERT INTO time_for_answers(Id,Delay) "+"VALUES('"+idx+"','"+diffM+"')";
					st3.executeUpdate(sql);

					
                //}

            }

            /*for(int i=0;i<storage.size();i++){
                Collections.sort(storage.elementAt(i));
                int sum = 0;
                int s = storage.elementAt(i).size();
                for(int j=0;j<storage.elementAt(i).size();j++) sum+=storage.elementAt(i).get(j);
                if(s!=0){
                    means[i] = sum/storage.elementAt(i).size();

                    if(s%2==1) medians[i] = storage.elementAt(i).get((s-1)/2);
                    else medians[i] = storage.elementAt(i).get((s/2)+1);
                }
            }
            pw.println("Topic    "+"         Mean(minutes)  "+"Median(minutes)");

            for(int i=0;i<storage.size();i++){
                System.out.println(i+" "+means[i] + " "+medians[i]);
                pw.println(i+"   "+means[i] + "    "+medians[i]);
                pw2.println(i+"  "+unanswered[i]+" "+count[i]);
            }
            pw.close();
            pw2.close();*/



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
