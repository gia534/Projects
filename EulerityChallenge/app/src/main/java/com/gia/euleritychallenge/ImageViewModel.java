package com.gia.euleritychallenge;

import android.graphics.Bitmap;

public class ImageViewModel {
    private Bitmap bitmap;

    public ImageViewModel(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
