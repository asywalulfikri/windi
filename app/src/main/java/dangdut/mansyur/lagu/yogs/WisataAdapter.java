package dangdut.mansyur.lagu.yogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WisataAdapter extends BaseAdapter {


    private ArrayList<Hewan> mWisataList = new ArrayList<Hewan>();
  private DataValueOpen mDataValueOpen;
    private ArrayList<Hewan> mDataList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ViewHolder holder;
    String useridd;

    public WisataAdapter(Context context) {
        init(context);
    }

    public WisataAdapter(Context context, DataValueOpen value) {
        init(context);

        this.mDataValueOpen = value;
    }

    private void init(Context context) {
        mContext = context;

        if (context != null) {

            mInflater = LayoutInflater.from(context);


        }

    }

    public void setData(ArrayList<Hewan> list) {
        mDataList = list;
    }


    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return (mDataList == null) ? 0 : mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View itemView, ViewGroup parent) {

        if (itemView == null) {
            itemView = mInflater.inflate(R.layout.list_item_hewan, null);

            holder = new ViewHolder();
            holder.tvContent = (ImageView) itemView.findViewById(R.id.iv_hewan);

            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        final Hewan hewan = mDataList.get(position);

        Picasso.with(mContext) //
                .load(hewan.gambar)
                .into(holder.tvContent);


        return itemView;
    }


    public interface DataValueOpen {
        public void setValueOpen(String id, String value);
    }

    public interface LikeQuestion {
        public abstract void OnLikeClickQuestion(View view, int position);
    }

    public interface LikeArticle {
        public abstract void OnLikeClickArticle(View view, int position);
    }
    public interface MoreQuestion {
        public abstract void OnMoreClickQuestion(View view, int position);
    }
    public interface ProfileUser {
        public abstract void OnClickProfile(View view, int position);
    }

    static class ViewHolder {

        ImageView tvContent;

    }
}