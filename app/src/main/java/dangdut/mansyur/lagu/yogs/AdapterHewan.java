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
    private PindahHalaman  mPindahHalaman;


    public AdapterHewan(Context context,ArrayList<Hewan> android) {
        this.android = android;
        this.context= context;

        //yang susah??  wait

    }

    public void pindahHalaman(PindahHalaman pindahalaman) {
        mPindahHalaman= pindahalaman;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_hewan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {

        Hewan hewan = android.get(i);

        Picasso.with(context) //
                .load(hewan.gambar)
                .into(viewHolder.attachment);

        viewHolder.attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPindahHalaman.OnLikeClickPindahHalaman(v,i);
            }
        });
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

    public interface PindahHalaman {
        public abstract void OnLikeClickPindahHalaman(View view, int position);
    }

}
