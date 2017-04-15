package shakesplash.com.shake;

import android.content.Context;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnShake;
    private ConstraintLayout customLayout;

    private boolean m_isVibrator = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customLayout = (ConstraintLayout) findViewById(R.id.shake_layout);

        btnShake = (Button) findViewById(R.id.btn_shake);
        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shake doShake = new Shake(getApplicationContext());
                doShake.shakeView(customLayout);
                doShake.shakeView(btnShake);
                //customLayout.startAnimation(shake);
                //vibrator();
            }
        });
    }

    private void vibrator(){
        if(m_isVibrator){
            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {1000, 200, 1000, 2000, 1200};
            vibe.vibrate(pattern, 0);
            vibe.vibrate(1000);
        }
    }

}
