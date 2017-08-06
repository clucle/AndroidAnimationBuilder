package shakesplash.com.shake;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

public class Rotate {
    private final Animation rotate;
    private final Context context;

    private final int duration;
    private final int fromDegrees;

    private final boolean changePivot;
    private final float pivotX;
    private final float pivotY;
    private final int repeatCount;
    private final String repeatMode;
    private final int toDegrees;

    public static class Builder {
        // 필수 인자
        private Context context;
        private RotateAnimation rotate;

        // 선택 인자 (기본 값)
        private int duration = 100;

        private boolean changePivot = false;
        private float pivotX = 0;
        private float pivotY = 0;

        private int repeatCount = 5;
        private String repeatMode = "reverse";

        private int fromDegrees = -5;
        private int toDegrees = 5;

        public Builder(Context context) {
            this.context = context;

        }

        public <T extends View> void animView(T view) {

            //rotate = AnimationUtils.loadAnimation(context, R.anim.rotate);
            rotate = new RotateAnimation(fromDegrees, toDegrees, pivotX, pivotY);
            rotate.setDuration(duration);
            rotate.setRepeatCount(repeatCount);
            switch (repeatMode) {
                case "reverse":
                    rotate.setRepeatMode(Animation.REVERSE);
                    break;
            }

            view.startAnimation(rotate);
        }

        public Builder duration(int val) {
            duration = val;
            return this;
        }

        public Builder pivotX(float val) {
            changePivot = true;
            pivotX = val;
            return this;
        }

        public Builder pivotY(float val) {
            changePivot = true;
            pivotY = val;
            return this;
        }

        public Builder repeatCount(int val) {
            repeatCount = val;
            return this;
        }

        public Builder repeatMode(String val) {
            repeatMode = val;
            return this;
        }

        public Builder fromDegrees(int val) {
            fromDegrees = val;
            return this;
        }

        public Builder toDegrees(int val) {
            toDegrees = val;
            return this;
        }

        public Rotate build() {
            return new Rotate( this );
        }
    }

    private Rotate( Builder builder ) {
        context = builder.context;
        rotate = builder.rotate;

        duration = builder.duration;
        fromDegrees = builder.fromDegrees;

        changePivot = builder.changePivot;
        pivotX = builder.pivotX;
        pivotY = builder.pivotY;
        repeatCount = builder.repeatCount;
        repeatMode = builder.repeatMode;
        toDegrees = builder.toDegrees;
    }
}
