package shakesplash.com.shake;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Shake {
    private Animation shake;
    public Shake(Context context) {
        shake = AnimationUtils.loadAnimation(context, R.anim.shake);
    }
    public <T extends View> void shakeView(T view) {
        view.startAnimation(shake);
    }

}
