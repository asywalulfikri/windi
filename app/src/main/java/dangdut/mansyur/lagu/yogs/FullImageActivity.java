package dangdut.mansyur.lagu.yogs;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;


@SuppressLint("ClickableViewAccessibility")
public class FullImageActivity extends AppCompatActivity {
	
	String rawImage;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_fullscreen);
		
		TouchImageView mImageView = (TouchImageView) findViewById(R.id.ivFull);
		
		Intent im = getIntent();
		rawImage = im.getStringExtra("attachment");
		Picasso.with(FullImageActivity.this)
        .load((rawImage.equals("")) ? null : rawImage)
        .into(mImageView);
	}
}
