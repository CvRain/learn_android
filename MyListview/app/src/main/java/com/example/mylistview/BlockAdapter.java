package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class BlockAdapter extends ArrayAdapter<Block> {
    private final int resourceId;

    public BlockAdapter(Context context, int textViewResourceId, List<Block> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        Block block = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView blockTexture = view.findViewById(R.id.blockTexture);
        TextView blockName =  view.findViewById(R.id.blockName);
        assert block != null;
        blockName.setText(block.getBlockName());
        blockTexture.setImageResource((block.getImageId()));
        return view;
    }


}
