import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) throws IOException {
        File file = new File("merged//output.txt");
        Scanner input = new Scanner(file);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        int features = 27;

        PrintWriter out=null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("mongo_remerged.txt", false)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id ;
        int n = input.nextInt();

        for (int j=0;j<=n;j++){
            id = input.nextInt();
            String s = input.next();
            double [] arr = new double[features];

            for(int i=0;i<features;i++){
                arr[i] = input.nextDouble();
            }

            double install = arr[20];
            double err = arr[5];
            double issues = arr[2]+arr[10]+arr[13];
            double data = arr[7]+arr[11]+arr[14]+arr[21];
            double control = arr[3]+arr[6]+arr[16]+arr[22];
            double structure = arr[0]+arr[9]+arr[15]+arr[25];
            double web = arr[24];
            double comp = arr[19];
            double Integration = arr[1]+arr[4]+arr[8]+arr[12]+arr[17]+arr[18]+arr[23]+arr[26];


            out.println(id+" "+s+ " "+df.format(install)+ " " +
                df.format(err)+" "+ df.format(issues)+" "+
                df.format(data)+" "+ df.format(control)+" "+
                df.format(structure)+" "+ df.format(web)+" "+
                df.format(comp)+" "+ df.format(Integration));
            System.out.println(id);
        }

        out.close();
    }
}
