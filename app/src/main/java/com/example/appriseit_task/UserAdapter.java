package com.example.appriseit_task;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private List<LeaderboardResponse.User> users;

    public UserAdapter(Context context, List<LeaderboardResponse.User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        LeaderboardResponse.User user = users.get(position);
        holder.tvPosition.setText(String.valueOf(user.position));
        holder.tvFirstName.setText(user.first_name);
        holder.tvUserTag.setText(user.user_tag);
        holder.tvGiftcoin.setText(String.valueOf(user.giftcoin));
        Glide.with(context).load(user.profile_pic).into(holder.ivProfilePic);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvPosition, tvFirstName, tvUserTag, tvGiftcoin;
        ImageView ivProfilePic;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvUserTag = itemView.findViewById(R.id.tvUserTag);
            tvGiftcoin = itemView.findViewById(R.id.tvGiftcoin);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
        }
    }
}

