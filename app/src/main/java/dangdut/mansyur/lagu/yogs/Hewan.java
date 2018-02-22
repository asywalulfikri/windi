package dangdut.mansyur.lagu.yogs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rurygaddafi on 2/22/18.
 */

public class Hewan  implements Parcelable{

    String gambar;


    public Hewan(){}

    public Hewan(Parcel in){
        gambar = in.readString();
    }

    public static final Creator<Hewan> CREATOR = new Creator<Hewan>() {
        @Override
        public Hewan createFromParcel(Parcel parcel) {
            return new Hewan(parcel);
        }

        @Override
        public Hewan[] newArray(int i) {
            return new Hewan[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void  writeToParcel(Parcel out,int flags){
        out.writeString(gambar);
    }
}
