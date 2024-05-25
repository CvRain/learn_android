package com.example.base_exp_3;

public class UserInfo {
    private final String name;
    private final String score;
    private final String className;

    public UserInfo(String name, String score, String className)
    {
        this.name = name;
        this.score = score;
        this.className = className;
    }

    public String getName()
    {
        return name;
    }

    public String getScore()
    {
        return score;
    }

    public String getClassName()
    {
        return className;
    }
}
