import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;


public class percentages {
    public static void listProducts() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","1234");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            File file = new File("posts_by_month.txt");
            FileWriter pw = new FileWriter(file,true);


            String [] db = {"redis_posts","cassandra_posts","duplicate_mongo","duplicate_neo4j","duplicate_hbase"};


            pw.write("\n2017 July\n");
            for(int i =0;i<db.length;i++){
                    String query = "select count(*) from "+ db[i] +" where CreationDate>'2017-6-31' and " +
                            "CreationDate<'2017-8-1' ";

                    //String q = "select count(*) from posts where CreationDate>'2009-12-31' and CreationDate<'2010-2-1'";
                    ResultSet rs = st.executeQuery(query);
                    // rs2 = st.executeQuery(q);

                    while(rs.next()) {
                        int c = rs.getInt(1);
                        //int d = rs2.getInt(1);
                        System.out.println(db[i]+"-> "+ c);
                        pw.write(db[i]+"-> "+ c+"\n");
                    }
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
