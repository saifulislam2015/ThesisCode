import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class serialize {
    public static void main(String[] args) throws IOException {
        File file = new File("mongo_remerged.txt");
        Scanner input = new Scanner(file);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        int size = 86807;
        int [] max_arr = new int[size];

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("final_mongo.txt", false)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < size; j++) {
            int id = input.nextInt();
            String s = input.next();
            String intValue = s.replaceAll("[^0-9]", "");
            int index = Integer.parseInt(intValue);
            //System.out.println(s+" "+index);

            double[] arr = new double[9];

            for (int i = 0; i < 9 ;i++) {
                arr[i] = input.nextDouble();
            }
            int max = 0;

            for(int i=1;i<9;i++){
                if(arr[i]>arr[max]) max = i;
            }
            max_arr[index-1] = max;
        }

        for(int i=0;i<size;i++){
            System.out.println((i+1)+" "+max_arr[i]);
            out.println((i+1)+" "+max_arr[i]);
        }
    }
}
