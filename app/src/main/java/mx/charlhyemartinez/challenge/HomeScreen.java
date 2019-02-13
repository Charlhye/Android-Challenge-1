package mx.charlhyemartinez.challenge;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    TextView cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        cp = findViewById(R.id.cp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null)
            if(requestCode == 500 & resultCode == RESULT_CANCELED & data.getStringExtra("failed").equals("yes")){
                Toast.makeText(this, "NO SE ENCONTRARON RESULTADOS PARA ESE CÓDIGO POSTAL",Toast.LENGTH_LONG).show();
            }

    }

    public void search(View view){
        if(cp.getText().toString().length() != 5){
            Toast.makeText(this, "EL CODIGO POSTAL NO ES VALIDO",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, ResultsActivity.class); //Aqui va la clase de Martn
            intent.putExtra("code", cp.getText().toString());
            startActivityForResult(intent, 500);
        }
    }
}
