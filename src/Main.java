import java.util.*;

public class Main {
    public static void main(String[] args) {
        DailyActiveUsers daily = new DailyActiveUsers();
        Map<String, LinkedHashSet<String>> dailyActiveUsers = daily.dailyUsers();
        String date = "01/01/2020";
        int dailyUsers = daily.dailyActiveUsers(date, dailyActiveUsers);
        System.out.println(dailyUsers);
    }
}
