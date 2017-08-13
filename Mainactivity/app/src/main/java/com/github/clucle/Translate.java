package com.github.clucle;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class Translate {
    private final Animation translate;
    private final Context context;

    private final float fromXDelta;
    private final float toXDelta;
    private final float fromYDelta;
    private final float toYDelta;

    private final int duration;
    private final int repeatCount;
    private final TYPE repeatMode;

    public static enum TYPE {
        ABSOLUTE,
        INFINITE,
        RELATIVE_TO_PARENT,
        RELATIVE_TO_SELF,
        RESTART,
        REVERSE,
        START_ON_FIRST_FRAME,
        ZORDER_BOTTOM,
        ZORDER_NORMAL,
        ZORDER_TOP
    }

    public static class Builder {
        // 필수 인자
        private Context context;
        private TranslateAnimation translate;

        // 선택 인자 (기본 값)
        private float fromXDelta = 0;
        private float toXDelta = 100;
        private float fromYDelta = 0;
        private float toYDelta = 100;

        private int duration = 100;
        private int repeatCount = 0;
        private TYPE repeatMode = TYPE.ABSOLUTE;


        public Builder(Context context) {
            this.context = context;
        }

        public <T extends View> void animView(T view) {
            translate = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
            translate.setDuration(duration);
            translate.setRepeatCount(repeatCount);
            switch (repeatMode) {
                case ABSOLUTE:
                    translate.setRepeatMode(Animation.ABSOLUTE);
                    break;
                case INFINITE:
                    translate.setRepeatCount(Animation.INFINITE);
                    break;
                case RELATIVE_TO_PARENT:
                    translate.setRepeatMode(Animation.RELATIVE_TO_PARENT);
                    break;
                case RELATIVE_TO_SELF:
                    translate.setRepeatMode(Animation.RELATIVE_TO_SELF);
                    break;
                case RESTART:
                    translate.setRepeatMode(Animation.RESTART);
                    break;
                case REVERSE:
                    translate.setRepeatMode(Animation.REVERSE);
                    break;
                case START_ON_FIRST_FRAME:
                    translate.setRepeatMode(Animation.START_ON_FIRST_FRAME);
                    break;
                case ZORDER_BOTTOM:
                    translate.setRepeatMode(Animation.ZORDER_BOTTOM);
                    break;
                case ZORDER_NORMAL:
                    translate.setRepeatMode(Animation.ZORDER_NORMAL);
                    break;
                case ZORDER_TOP:
                    translate.setRepeatMode(Animation.ZORDER_TOP);
                    break;

                default:
                    break;
            }

            view.startAnimation(translate);
        }

        public Builder fromXDelta(float val) {
            fromXDelta = val;
            return this;
        }
        public Builder toXDelta(float val) {
            toXDelta = val;
            return this;
        }
        public Builder fromYDelta(float val) {
            fromYDelta = val;
            return this;
        }
        public Builder toYDelta(float val) {
            toYDelta = val;
            return this;
        }
        public Builder XYDelta(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
            this.fromXDelta = fromXDelta;
            this.toXDelta = toXDelta;
            this.fromYDelta = fromYDelta;
            this.toYDelta = toYDelta;
            return this;
        };

        public Builder duration(int val) {
            duration = val;
            return this;
        }

        public Builder repeatCount(int val) {
            repeatCount = val;
            return this;
        }

        public Builder repeatMode(TYPE val) {
            repeatMode = val;
            return this;
        }

        public Translate build() {
            return new Translate(this);
        }
    }

    private Translate(Builder builder) {
        context = builder.context;
        translate = builder.translate;

        fromXDelta = builder.fromXDelta;
        toXDelta = builder.toXDelta;
        fromYDelta = builder.fromYDelta;
        toYDelta = builder.toYDelta;

        duration = builder.duration;
        repeatCount = builder.repeatCount;
        repeatMode = builder.repeatMode;
    }
}
