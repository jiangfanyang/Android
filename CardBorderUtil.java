package com.fan.wozaizhe.bm.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by fan on 2017/3/25.
 * Add a border around the image,let it looks like a card
 */

public class CardBorderUtil {

    public static Bitmap addCardBorder(Bitmap imgBitmap){
        int imgWidth = imgBitmap.getWidth();
        int imgHeight = imgBitmap.getHeight();

        //Add a white border
        Bitmap bitmap = Bitmap.createBitmap(
                imgWidth + 50,
                imgHeight + 50,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0f, 0f, imgWidth + 10, imgHeight + 10, paint);

        //Add gray shadow border
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawRect(0f, 0f, imgWidth + 10, imgHeight + 10, paint);

        //Draw the original image
        paint.setStyle(Paint.Style.FILL);
        canvas.drawBitmap(imgBitmap, 5f, 5f, paint);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();

        return bitmap;
    }
}
