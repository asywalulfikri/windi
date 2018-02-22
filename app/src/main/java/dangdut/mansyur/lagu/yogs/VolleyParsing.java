package dangdut.mansyur.lagu.yogs;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
/**
 * Created by asywalulfikri on 9/13/16.
 */
public class VolleyParsing {

    public static HewanWrapper conversationParsing(String response) throws Exception {
        HewanWrapper wrapper = null;
        JSONArray jsonArray = (JSONArray) new JSONTokener(response).nextValue();

        try {


            int size = jsonArray.length();

            if (size > 0) {
                wrapper = new HewanWrapper();

                wrapper.list = new ArrayList<Hewan>();

                for (int i = 0; i < size; i++) {
                    JSONObject itemJson = jsonArray.getJSONObject(i);

                    Hewan hewan = new Hewan();
                    hewan.gambar = (!itemJson.isNull("attachment")) ? itemJson.getString("attachment") : "";
                    Log.d("yog","xx"+hewan.gambar);

                    wrapper.list.add(hewan);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }

        return wrapper;
    }

}