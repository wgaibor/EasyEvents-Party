package ec.com.easyeventsparty.utils;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class Utils {
    private static final ImageLoader sImageLoader;
    static {
        sImageLoader = ImageLoader.getInstance();
    }

    public static void loadImage(final String imageUri, final ImageView imageView){
        if (imageUri != null) {
            sImageLoader.displayImage(imageUri, imageView);
        }
    }
}
