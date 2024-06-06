package com.example.appriseit_task;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("leaderboard.json")
    Call<LeaderboardResponse> getLeaderboard();
}
