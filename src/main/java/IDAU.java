import java.util.LinkedHashSet;
import java.util.Map;

interface IDAU {

    Map<String, LinkedHashSet<String>> dailyUsers();

    int dailyActiveUsers(String date);
}
