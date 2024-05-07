package com.example.fruitlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleBack = (Button)findViewById(R.id.title_back);
        Button titleNext = (Button)findViewById(R.id.title_next);
        titleBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getContext(),
                        "you clicked back Button",Toast.LENGTH_SHORT).show();
            }
        });
        titleNext.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getContext(),
                        "you clicked next Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
