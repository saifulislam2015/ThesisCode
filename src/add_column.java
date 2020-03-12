import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class add_column {
    public static void Update() {
        //MySQLConnect oc = new MySQLConnect("localhost", "stackoverflow", "root", "1234");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","Saiful073!");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select Id,text_file_id,feature from mongo_posts order by id";
            ResultSet rs = st.executeQuery(query);


            Scanner input = new Scanner(new File("serialized//final_mongo.txt"));
            int id,feature;
            while(rs.next()) {
                id = input.nextInt();
                feature = input.nextInt();

                //rs.updateInt("text_file_id",id);
                rs.updateInt("feature",feature);
                System.out.println(id);
                rs.updateRow();
            }
        } catch (Exception e) {
            System.out.println("Exception in add_column: " + e.getMessage());
        }
    }


    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Update();
        scanner.close();
    }
}
