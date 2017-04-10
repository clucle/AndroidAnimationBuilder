package shakesplash.com.shake;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Animation shake;

    private Button btnShake;
    private ConstraintLayout customLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customLayout = (ConstraintLayout) findViewById(R.id.shake_layout);

        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        btnShake = (Button) findViewById(R.id.btn_shake);
        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customLayout.startAnimation(shake);
            }
        });
    }

}
