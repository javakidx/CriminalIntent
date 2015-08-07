package ciminalintent.android.jk.idv.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.widget.ImageView;

/**
 * Created by bioyang on 15/8/7.
 */
public class PictureUtils
{
    @SuppressWarnings("deprecation")
    public static BitmapDrawable getScaledDrawble(Activity a, String path)
    {
        Display display = a.getWindowManager().getDefaultDisplay();
        float destWidth = display.getWidth();
        float destHeight = display.getHeight();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;

        if(srcWidth > destWidth || srcHeight > destHeight)
        {
            if(srcWidth > destHeight)
            {
                inSampleSize = Math.round(srcHeight / destHeight);
            }
            else
            {
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        Bitmap bitmap = BitmapFactory.decodeFile(path, options);

        return new BitmapDrawable(a.getResources(), bitmap);
    }

    public static void cleanImageView(ImageView imageView)
    {
        if(!(imageView.getDrawable() instanceof BitmapDrawable))
        {
            return;
        }

        BitmapDrawable b = (BitmapDrawable)imageView.getDrawable();
        b.getBitmap().recycle();
        imageView.setImageDrawable(null);
    }
}
