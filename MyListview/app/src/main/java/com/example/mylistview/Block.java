package com.example.mylistview;

public class Block {
    private final String blockName;
    private final int imageId;

    public Block(String name, int id){
        blockName = name;
        imageId = id;
    }

    public String getBlockName(){
        return blockName;
    }

    public int getImageId(){
        return imageId;
    }
}
