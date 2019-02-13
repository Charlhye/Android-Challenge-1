package mx.charlhyemartinez.challenge;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mx.charlhyemartinez.challenge.adapters.ResultItemRecyclerAdapter;
import mx.charlhyemartinez.challenge.model.ResultItem;

public class ResultsActivity extends AppCompatActivity {
    private String JSON_URL = "https://nucita.mfprint.io/cultural-mx/?a=filter&code=";
    private JsonObjectRequest request;
    private RequestQueue requestQueue;
    private List<ResultItem> results;
    private RecyclerView recyclerView;

    public static final String TAG = "RESULTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String code = getIntent().getStringExtra("code");
        JSON_URL += code;
        Log.d(TAG, JSON_URL);

        results = new ArrayList<ResultItem>();
        recyclerView = findViewById(R.id.recyclerView);
        jsonRequest();
    }

    private void jsonRequest() {
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results_json = response.getJSONArray("activities");
                    if (results_json.length() > 0) {
                        for (int i = 0; i < results_json.length(); i++) {
                            Log.d(TAG, results_json.get(i).toString());
                        }
                        JSONObject obj = null;
                        for (int i = 0; i < results_json.length(); i++) {
                            obj = results_json.getJSONObject(i);
                            ResultItem resultItem = new ResultItem(obj.getString("title"),
                                    obj.getString("discipline"), obj.getString("venue"), obj.getString("price"),
                                    obj.getString("description"), obj.getString("date"), obj.getString("address"),
                                    obj.getString("url"), obj.getString("url"));
                            Log.d(TAG, resultItem.toString());
                            results.add(resultItem);
                        }
                    }
                    else {
                        Intent intent = new Intent();
                        intent.putExtra("failed", "yes");
                        setResult(Activity.RESULT_CANCELED, intent);
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                setRecyclerView(results);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Ocurrió un error. Inténtelo de nuevo más tarde.", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue = Volley.newRequestQueue(ResultsActivity.this);
        requestQueue.add(request);
    }

    private void setRecyclerView(List<ResultItem> results) {
        ResultItemRecyclerAdapter resultItemRecyclerAdapter = new ResultItemRecyclerAdapter(this, results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(resultItemRecyclerAdapter);
    }
}
