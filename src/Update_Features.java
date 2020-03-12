import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Update_Features{
    public static void Update() {
        //MySQLConnect oc = new MySQLConnect("localhost", "stackoverflow", "root", "1234");

        int i= 1;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/stackoverflow","root","Saiful073!");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select Id,feature from redis_posts where feature = 3 order by id";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                //rs.updateInt("text_file_id",id);
                //rs.updateInt("feature",feature);
                int f = rs.getInt("feature");
                if(f==3){
                    rs.updateInt("feature",7);
                    rs.updateRow();
                }
                System.out.println(i);
                //rs.updateRow();
                i++;
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
