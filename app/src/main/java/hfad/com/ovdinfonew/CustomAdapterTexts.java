package hfad.com.ovdinfonew;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class CustomAdapterTexts extends RecyclerView.Adapter<CustomAdapterTexts.ViewHolder> {

    private Context context;
    private List<MyDataTexts> my_data;

    public CustomAdapterTexts(Context context, List<MyDataTexts> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_activity_txts, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(my_data.get(position).getTitle());
        Glide.with(context).load(my_data.get(position).getPicture()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
