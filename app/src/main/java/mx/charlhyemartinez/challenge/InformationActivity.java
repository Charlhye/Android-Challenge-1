package mx.charlhyemartinez.challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import android.net.Uri;

import mx.charlhyemartinez.challenge.model.ResultItem;

public class InformationActivity extends AppCompatActivity {
    private String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ResultItem activity =  (ResultItem) getIntent().getSerializableExtra("activity");
        loadActivity(activity);
    }

    private void loadActivity(ResultItem activity){
        TextView title, address, price, date, description;
        ImageView image;
        title=findViewById(R.id.title);
        address= findViewById(R.id.address);
        description= findViewById(R.id.description);
        price = findViewById(R.id.price);
        date = findViewById(R.id.date);
        image = findViewById(R.id.image);
        link = activity.getUrl();
        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.load_result).error(R.drawable.load_result);
        title.setText(activity.getTitle());
        address.setText(activity.getAddress() + "\n"+activity.getVenue());
        description.setText(activity.getDescription());
        price.setText(activity.getPrice());
       date.setText(activity.getDate());
       // date.setText(link);
        Glide.with(this).load(activity.getImg()).apply(options).into(image);
    }

    public void link(View view){
        Uri page = Uri.parse(link);
        Intent web = new Intent(Intent.ACTION_VIEW, page);
        startActivity(web);
    }
}
