package com.geektach.lovecalculator.network;

import com.google.gson.annotations.SerializedName;

public class LoveModel {

    @SerializedName("fname")
    public String firstName;
    @SerializedName("sname")
    public String secondName;
    public String percentage;
    public String result;
}
