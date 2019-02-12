package mx.charlhyemartinez.challenge;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.calaverita).into(imageView);



        new Handler().postDelayed(new Runnable() {// a thread in Android
            @Override
            public void run() {
                Intent intent = new Intent( SplashScreen.this  ,  MainActivity.class  );
                startActivity(intent); // Go, go, go
                finish(); // kill this activity
            }
        },3000); // time in milliseconds

    }
}
