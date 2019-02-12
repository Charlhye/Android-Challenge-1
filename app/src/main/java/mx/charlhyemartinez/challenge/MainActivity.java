package mx.charlhyemartinez.challenge;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {// a thread in Android
            @Override
            public void run() {
                Intent intent = new Intent( MainActivity.this, ResultsActivity.class  );
                intent.putExtra("code", "06000");
                startActivity(intent); // Go, go, go
                finish(); // kill this activity
            }
        },3000); // time in milliseconds
    }
}
