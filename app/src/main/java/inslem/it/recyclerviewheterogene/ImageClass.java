package inslem.it.recyclerviewheterogene;

import android.graphics.drawable.Drawable;

class ImageClass {

    private Drawable iImage;

    ImageClass(Drawable img) {
        this.iImage = img;
    }

    Drawable getImage() {
        return iImage;
    }
}
