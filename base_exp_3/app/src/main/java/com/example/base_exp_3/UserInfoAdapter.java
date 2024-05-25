package com.example.base_exp_3;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserInfoAdapter extends ArrayAdapter<UserInfo> {

    private final int resourceId;

    public UserInfoAdapter(@NonNull Context context, int resource, @NonNull List<UserInfo> objects) {
        super(context, resource, objects);
        resourceId =  resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserInfo userInfo = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView user_name = view.findViewById(R.id.stu_name);
        TextView user_score = view.findViewById(R.id.stu_score);
        TextView user_class = view.findViewById(R.id.stu_class);

        user_name.setText(userInfo.getName());
        user_score.setText(userInfo.getScore());
        user_class.setText(userInfo.getClassName());
        return view;
    }
}
