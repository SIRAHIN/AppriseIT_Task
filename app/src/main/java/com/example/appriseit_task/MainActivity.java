package com.example.appriseit_task;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/mhasancse17/JsonFile/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<LeaderboardResponse> call = apiService.getLeaderboard();

        call.enqueue(new Callback<LeaderboardResponse>() {
            @Override
            public void onResponse(Call<LeaderboardResponse> call, Response<LeaderboardResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // -- Taking first top 3 user list -- //
                    List<LeaderboardResponse.User> users = response.body().data.host_daily.top3;
                    // -- Added All other user along with TP3 -- //
                    users.addAll(response.body().data.host_daily.all);
                    userAdapter = new UserAdapter(MainActivity.this, users);
                    recyclerView.setAdapter(userAdapter);
                }
            }

            @Override
            public void onFailure(Call<LeaderboardResponse> call, Throwable t) {
                // Handle the error
            }
        });
    }
}