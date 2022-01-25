import java.util.*;

public class Main {
    public static void main(String[] args) {
        DailyActiveUsers daily = new DailyActiveUsers();
        String date = "02/01/2020";
        int dailyUsers = daily.dailyActiveUsers(date);
        System.out.println(dailyUsers);
    }
}
