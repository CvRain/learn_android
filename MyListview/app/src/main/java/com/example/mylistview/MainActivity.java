package com.example.mylistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private BlockAdapter blockAdapter;
    private String[] blockData = {"1","2","3"};
    private List<Block> blockList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.list_view_block);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, blockData);
        listView.setAdapter(adapter);

        initBlocks();
        blockAdapter = new BlockAdapter(MainActivity.this, R.layout.minecraft_block, blockList);
        listView = findViewById(R.id.list_view_block);
        listView.setAdapter(blockAdapter);
    }

    private void initBlocks(){
        blockList.add(new Block("coal_ore", R.drawable.coal_ore));
        blockList.add(new Block("diamond_ore", R.drawable.diamond_ore));
        blockList.add(new Block("emerald_ore", R.drawable.emerald_ore));
        blockList.add(new Block("gold_ore", R.drawable.gold_ore));
        blockList.add(new Block("iron_ore", R.drawable.iron_ore));
        blockList.add(new Block("lapis_lazuli_ore", R.drawable.lapis_lazuli_ore));
        blockList.add(new Block("redstone_ore", R.drawable.redstone_ore));
    }
}