import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class frequency {
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void countFrequencies(Vector<String> list) throws Exception
    {
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        Map<String, Integer> sortedMapDesc = sortByComparator(hm, false);

        File file = new File("redis_tag_count.txt");
        PrintWriter pw = new PrintWriter(file);
        int i=0;
        int size = 13842;

        for (Map.Entry<String, Integer> val : sortedMapDesc.entrySet()) {
            if(!val.getKey().contains("redis")){
                pw.println(val.getKey() + "       " + val.getValue()+"        "+val.getValue()*100/size);
                i++;
            }
            if(i==50) break;
        }
        pw.close();
    }


    public static void main(String[] args) throws Exception {
        File file = new File("redis_tags.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Scanner input = new Scanner(file);
        Vector<String> tags = new Vector<>();
        String s;

        while ((s = br.readLine()) != null) {
            //System.out.println(s);
            tags.add(s);
        }
        countFrequencies(tags);
    }
}
