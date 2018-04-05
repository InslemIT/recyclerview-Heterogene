package inslem.it.recyclerviewheterogene;

import android.graphics.drawable.Drawable;

public class Image {

    private Drawable iImage;

    public Image( Drawable img) {
        this.iImage = img;
    }

    public Drawable getImage() {
        return iImage;
    }
}
