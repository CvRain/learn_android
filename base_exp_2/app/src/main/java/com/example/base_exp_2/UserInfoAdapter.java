package com.example.base_exp_2;

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
        ImageView imageView = view.findViewById(R.id.user_icon);
        TextView textView = view.findViewById(R.id.user_data);

        textView.setText(userInfo.getData());
        imageView.setImageResource(userInfo.getIcon());
        return view;
    }
}
