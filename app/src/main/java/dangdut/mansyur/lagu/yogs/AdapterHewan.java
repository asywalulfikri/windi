package dangdut.mansyur.lagu.yogs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterHewan extends RecyclerView.Adapter<AdapterHewan.ViewHolder> {
    private ArrayList<Hewan> android;
    private Context context;


    public AdapterHewan(Context context,ArrayList<Hewan> android) {
        this.android = android;
        this.context= context;

        //yang susah??  wait

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_hewan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Hewan hewan = android.get(i);

        Picasso.with(context) //
                .load(hewan.gambar)
                .into(viewHolder.attachment);

    }

    @Override
    public int getItemCount() {
        return android.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView attachment;

        public ViewHolder(View view) {
            super(view);

            attachment = view.findViewById(R.id.iv_hewan);

        }
    }

}
