package com.example.appriseit_task;

import java.util.List;

public class LeaderboardResponse {
    public boolean status;
    public Data data;

    public class Data {
        public HostDaily host_daily;
    }

    public class HostDaily {
        public List<User> top3;
        public List<User> all;
    }

    public class User {
        public String userid;
        public String first_name;
        public String profile_pic;
        public String user_tag;
        public int giftcoin;
        public int position;
    }
}
