package shakesplash.com.shake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShake = (Button) findViewById(R.id.btn_rotate);
        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Rotate
                        .Builder(getApplicationContext())
                        .duration(100)
                        .repeatCount(5)
                        .repeatMode("reverse")
                        .animView(findViewById(R.id.btn_rotate));
            }
        });
    }
}
