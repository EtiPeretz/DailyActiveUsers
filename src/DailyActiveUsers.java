import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class DailyActiveUsers implements IDAU {

    public Map<String, LinkedHashSet<String>> dailyUsers() {
        Map<String, LinkedHashSet<String>> dailyActiveUsers = new HashMap<>();

        try { //the file to be opened for reading
            FileInputStream fis = new FileInputStream("src/input.txt");
            //file to be scanned
            Scanner sc = new Scanner(fis);
            //returns true if there is another line to read
            while(sc.hasNextLine())
            {
                String[] arrOfData = sc.nextLine().split(",");
                String[] dateAndTime = arrOfData[1].split("\\s+");
                String date = dateAndTime[0];
                if(dailyActiveUsers.containsKey(date)) {
                    dailyActiveUsers.get(date).add(arrOfData[0]);
                } else { //if it is a new date
                    LinkedHashSet<String> linkedset
                            = new LinkedHashSet<String>();
                    linkedset.add(arrOfData[0]);
                    //associate the specified value with the specified key in this map
                    dailyActiveUsers.put(date, linkedset);
                }
            }
            //closes the scanner
            sc.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return dailyActiveUsers;
    }

    public int dailyActiveUsers(String date, Map<String, LinkedHashSet<String>> map) {
        if (map.containsKey(date)) {
            return map.get(date).size();
        } else {
            return 0;
        }
    }
}
