import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class DailyActiveUsers implements IDAU {

    private Map<String, LinkedHashSet<String>> mapDailyActiveUsers;

    public DailyActiveUsers() {
        this.mapDailyActiveUsers = new HashMap<String, LinkedHashSet<String>>();
    }

    public Map<String, LinkedHashSet<String>> getMapDailyActiveUsers() {
        return mapDailyActiveUsers;
    }

    public Map<String, LinkedHashSet<String>> dailyUsers() {

        try { //the file to be opened for reading
            FileInputStream fis = new FileInputStream("src/main/java/input.txt");
            //file to be scanned
            Scanner sc = new Scanner(fis);
            //returns true if there is another line to read
            while(sc.hasNextLine())
            {
                String[] arrOfData = sc.nextLine().split(",");
                String[] dateAndTime = arrOfData[1].split("\\s+");
                String date = dateAndTime[0];
                if(mapDailyActiveUsers.containsKey(date)) {
                    mapDailyActiveUsers.get(date).add(arrOfData[0]);
                } else { //if it is a new date
                    LinkedHashSet<String> linkedset
                            = new LinkedHashSet<String>();
                    linkedset.add(arrOfData[0]);
                    //associate the specified value with the specified key in this map
                    mapDailyActiveUsers.put(date, linkedset);
                }
            }
            //closes the scanner
            sc.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return this.mapDailyActiveUsers;
    }

    public int dailyActiveUsers(String date) {
        //If there is information on daily users on this date
        if (mapDailyActiveUsers.containsKey(date)) {
            return mapDailyActiveUsers.get(date).size();
            //and if there is not
        } else {
            System.out.println("There is no data on this date");
            return 0;
        }
    }
}
