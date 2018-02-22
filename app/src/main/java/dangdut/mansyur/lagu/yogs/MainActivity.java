package dangdut.mansyur.lagu.yogs;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ExpandableHeightListView recyclerView;
    private AdapterHewan adapterHewan;
    private ArrayList<Hewan> hewan1;
    WisataAdapter mAdapter;
    private ArrayList<Hewan> mWisataList = new ArrayList<Hewan>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (ExpandableHeightListView) findViewById(R.id.recyclerview);


        loadTask2();

    }

    /*public void loadJson(){


        Call<ResponseBody> toke_request;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dhiva.16mb.com/rest_server/index.php/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        toke_request = apiService.getHewan("rekomendasi?category=1");

        toke_request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){

                    HewanWrapper wrapper = null;
                    Debug.i("Response " + response);
                    try {
                        VolleyParsing parsing = new VolleyParsing();
                        wrapper = parsing.conversationParsing(response.body().string());

                        hewan1.add();
                        adapterHewan = new AdapterHewan(MainActivity.this,hewan1);
                        recyclerView.setAdapter(adapterHewan);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                   *//* try {

                        Log.d("yoogs",response.body().string());
                        JSONArray jsonArray = new JSONArray(response.body().string());

                        for(int i = 0; i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            Hewan hewan = new Hewan();
                            hewan.gambar   = (jsonObject.has("attachment")) ? jsonObject.getString("attachment") : "";
                            hewan1.add(hewan);
                            adapterHewan = new AdapterHewan(MainActivity.this,hewan1);
                            recyclerView.setAdapter(adapterHewan);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }*//*
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }// yooooooo*/

    public void loadTask2() {
        String url = "http://dhiva.16mb.com/rest_server/index.php/api/rekomendasi?category=1";
        Log.d("urlnya", url);
        StringRequest mRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //System.out.println("response of resend code is:" + response);

                        HewanWrapper wrapper = null;
                        Log.d("pantex",response);
                        try {
                            VolleyParsing parsing = new VolleyParsing();
                            wrapper = parsing.conversationParsing(response);
                            Log.d("pantex",wrapper.list.get(0).gambar);

                            updateList(wrapper);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        mRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(mRequest);
    }

    private void updateList(HewanWrapper wrapper) {

        int i = wrapper.list.size();
        int j = 0;
        do {
            if (j >= i) {
                mAdapter = new WisataAdapter(MainActivity.this);

                mAdapter.setData(mWisataList);
                mAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(mAdapter);


                return;
            }
            mWisataList.add((Hewan) wrapper.list.get(j));

            j++;
        } while (true);
    }

}
