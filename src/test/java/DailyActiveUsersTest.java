import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class DailyActiveUsersTest {

    private Map<String, LinkedHashSet<String>> mapDailyActiveUsers;
    private DailyActiveUsers daily;

    @org.junit.Test
    public void dailyUsers() {
        this.daily = new DailyActiveUsers();
        mapDailyActiveUsers = new HashMap<String, LinkedHashSet<String>>();
        LinkedHashSet<String> linkedset1 = new LinkedHashSet<String>();
        linkedset1.add("123");
        linkedset1.add("456");
        linkedset1.add("789");
        mapDailyActiveUsers.put("01/01/2020", linkedset1);
        LinkedHashSet<String> linkedset2 = new LinkedHashSet<String>();
        linkedset2.add("456");
        linkedset2.add("789");
        mapDailyActiveUsers.put("02/01/2020", linkedset2);
        LinkedHashSet<String> linkedset3 = new LinkedHashSet<String>();
        linkedset3.add("123");
        linkedset3.add("122");
        mapDailyActiveUsers.put("03/01/2020", linkedset3);

        //1. Test equal, ignore order
        assertThat(mapDailyActiveUsers, is(daily.dailyUsers()));

        //2. Test size
        assertThat(mapDailyActiveUsers.size(), is(3));

        //3. Test map entry, best!
        assertThat(mapDailyActiveUsers, IsMapContaining.hasEntry("01/01/2020", linkedset1));
    }

    @org.junit.Test
    public void dailyActiveUsers() {
        Assert.assertEquals(3, daily.dailyActiveUsers("01/01/2020"));
        Assert.assertEquals(2, daily.dailyActiveUsers("02/01/2020"));
        Assert.assertEquals(2, daily.dailyActiveUsers("03/01/2020"));
    }
}