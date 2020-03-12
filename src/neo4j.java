import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class neo4j {
    public static void main(String[] args) throws IOException {
        File file = new File("tutorial_composition_neo4j.txt");
        Scanner input = new Scanner(file);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        PrintWriter out=null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("neo4j.txt", false)));
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

            double spring = arr[0]+arr[3]+arr[5]+arr[11]+arr[36]+arr[43]+arr[44];
            double drivers = arr[1]+arr[9];
            double nodes_relation = arr[2]+arr[7]+arr[16]+arr[19]+arr[20]+arr[26]+arr[29]+arr[35]
                    +arr[8]+arr[18];
            double csv = arr[4];
            double platform = arr[6];
            double index = arr[10];
            double model = arr[12]+arr[27];
            double server = arr[13]+arr[33];
            double java = arr[14]+arr[24]+arr[47]+arr[48];
            double error = arr[15]+arr[25];
            double cluster = arr[17];
            double time = arr[21];
            double python = arr[22];
            double exception = arr[23];
            double query = arr[28]+arr[30]+arr[32]+arr[34]+arr[37]+arr[39]+arr[40]+arr[42]+
                    arr[46]+arr[49];
            double tree = arr[31];
            double client = arr[38];
            double others = arr[41];
            double db = arr[45];

            out.println(id+" "+s+ " "+df.format(spring)+ " " + df.format(drivers) +" "+df.format(nodes_relation)+" "+df.format(csv)+" "+df.format(platform)+" "+
                    df.format(index)+" "+df.format(model)+" "+df.format(server)+" "+df.format(java)+" "+df.format(error)+" "+df.format(cluster)+" "+df.format(time)+" "+df.format(python)+" "+df.format(exception)+" "+
                    df.format(query)+" "+df.format(tree)+" "+df.format(client)+" "+df.format(others)+" "+df.format(db));
            System.out.println(id);
        }

        out.close();
    }
}
