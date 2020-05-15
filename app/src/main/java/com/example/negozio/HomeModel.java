package com.example.negozio;

import android.graphics.Bitmap;

public class HomeModel {
    private int mImage;
    private int mText;

    public HomeModel(int image, int text){
        mImage=image;
        mText=text;
    }

    public int getImage(){
        return mImage;
    }

    public int getText(){
        return mText;
    }
}
