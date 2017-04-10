package shakesplash.com.shake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Animation shake;

    private Button btnShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        btnShake = (Button)findViewById(R.id.btn_shake);
        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnShake.startAnimation(shake);
            }
        });
    }

}
