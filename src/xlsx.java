import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class xlsx {
    public static void main(String[] args) throws IOException {
        File file = new File("tutorial_composition_cassandra.txt");
        Scanner input = new Scanner(file);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        PrintWriter out=null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("cassandra.txt", false)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id ;
        int n = input.nextInt();

        for (int j=0;j<=n;j++){
            id = input.nextInt();
            String s = input.next();
            double [] arr = new double[50];

            for(int i=0;i<50;i++){
                arr[i] = input.nextDouble();
            }

            /*double ruby = arr[0];
            double data_type = arr[1]+arr[3]+arr[4]+arr[21]+arr[26];
            double commands = arr[2]+arr[14];
            double web = arr[5]+arr[24]+arr[37]+arr[41]+arr[47];
            double query = arr[6]+arr[12];
            double soci_net = arr[7];
			double java = arr[10]+arr[11]+arr[13]+arr[17]+arr[31]+arr[46];
            double rails = arr[15];
            double persitence = arr[16];
            double django = arr[19]+arr[34];
            double hiroku = arr[22];
            double lua = arr[23];
            double spring = arr[25]+arr[40]+arr[43]+arr[48];
            double cpp = arr[49]+arr[27];
            double php = arr[29];
            double server = arr[30]+arr[32];
            double session = arr[33];
            double js = arr[35];
            double test = arr[38];
            double cache = arr[44];
			double install = arr[45];*/
			
			double driver = arr[0]+arr[2]+arr[27]; //3
			double java = arr[1]+arr[3]+arr[16]+arr[20]+arr[33]+arr[34]; //6
			double spark = arr[4]+arr[22]+arr[24]; //3
			double cluster = arr[5]+arr[9]+arr[26]+arr[28]+arr[35]+arr[48]; //6
			double server = arr[6]+arr[49]; //2
			double errors = arr[7]+arr[25]; //2
			double cf = arr[8]+arr[44]; //2
			double table = arr[10]+arr[13]+arr[14]+arr[15]+arr[39]+arr[46]+arr[47]; //7
			double query = arr[11]+arr[12]+arr[29]+arr[36]+arr[43]; //5
			double datastax = arr[18]; //1
			double conn = arr[19]+arr[23]; //2
			double data_access = arr[21]; //1
			double kundera = arr[27]; //1
			double spring = arr[30]+arr[40]+arr[42]; //3
			double data_monitor = arr[31]; //1
			double data_type = arr[32]; //1
			double data_storage = arr[37]; //1
			double import_ = arr[38]; //1
			double install = arr[41]; //1
			double python = arr[45]; //1
            

            out.println(id+" "+s+ " "+df.format(driver)+ " " + df.format(java) +" "+df.format(spark)+" "+df.format(cluster)+" "+df.format(server)+" "+
                    df.format(errors)+" "+df.format(cf)+" "+df.format(table)+" "+df.format(query)+" "+df.format(datastax)+" "+df.format(conn)+" "+df.format(data_access)+" "+
					df.format(kundera) +" "+ df.format(spring)+" "+df.format(data_monitor)+" "+
                    df.format(data_type)+" "+df.format(data_storage)+" "+df.format(import_)+" "+df.format(install)+" "+df.format(python));
            System.out.println(id);
        }

        out.close();
    }
}
