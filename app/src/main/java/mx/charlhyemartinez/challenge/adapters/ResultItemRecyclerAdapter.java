package mx.charlhyemartinez.challenge.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import mx.charlhyemartinez.challenge.R;
import mx.charlhyemartinez.challenge.model.ResultItem;

public class ResultItemRecyclerAdapter extends RecyclerView.Adapter<ResultItemRecyclerAdapter.ResultRecordHolder> {

    private Context context;
    private List<ResultItem> results;
    RequestOptions options;

    public ResultItemRecyclerAdapter(Context context, List<ResultItem> results) {
        this.context = context;
        this.results = results;
        this.options = new RequestOptions().centerCrop().placeholder(R.drawable.load_result).error(R.drawable.load_result);
    }

    @NonNull
    @Override
    public ResultRecordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        view = inflater.inflate(R.layout.result_item, viewGroup, false);
        final ResultRecordHolder resultRecordHolder = new ResultRecordHolder(view);
        resultRecordHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultItem resultItem = results.get(resultRecordHolder.getAdapterPosition());
                Intent it = new Intent(context, null);
                it.putExtra("activity", resultItem);
                context.startActivity(it);
            }
        });

        return resultRecordHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultRecordHolder resultRecordHolder, int i) {
        resultRecordHolder.title.setText(results.get(i).getTitle());
        resultRecordHolder.discipline.setText(results.get(i).getDiscipline());
        resultRecordHolder.venue.setText(results.get(i).getVenue());
        resultRecordHolder.price.setText(results.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ResultRecordHolder extends RecyclerView.ViewHolder {
        TextView title, discipline, venue, price;

        public ResultRecordHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.result_title);
            discipline = itemView.findViewById(R.id.result_discipline);
            venue = itemView.findViewById(R.id.result_venue);
            price = itemView.findViewById(R.id.result_price);
        }
    }
}
