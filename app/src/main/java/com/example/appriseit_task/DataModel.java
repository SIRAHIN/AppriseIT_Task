import java.util.List;

public class DataModel {
    public boolean status;
    public Data data;

    public class Data {
        public HostDaily host_daily;

        public class HostDaily {
            public List<User> top3;
            public List<User> all;

            public class User {
                public String userid;
                public String hive_id;
                public String username;
                public String first_name;
                public String last_name;
                public String profile_pic;
                public String user_tag;
                public int level;
                public String gender;
                public int giftcoin;
                public int position;
            }
        }
    }
}