package com.qidu.lin.xiaojiahe;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.simpleroad.R;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
				.execute(getUrl1());
		new DownloadImageTask((ImageView) findViewById(R.id.imageView2))
				.execute(getUrl2());
		new DownloadImageTask((ImageView) findViewById(R.id.imageView3))
				.execute(getUrl3());

	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon11 = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private String getUrl1() {
		long time = System.currentTimeMillis();
		long timeKey = time / 10000; // qq map use unit of 10-seconds.

		// seems timeKey useless?
		String urlString = "http://rtt2.map.qq.com/live/15/2696/1240/26968_12403.png?timeKey="
				+ timeKey;
		return urlString;
	}

	private String getUrl2() {
		long time = System.currentTimeMillis();
		long timeKey = time / 10000; // qq map use unit of 10-seconds.

		// seems timeKey useless?
		String urlString = "http://rtt2.map.qq.com/live/15/2696/1240/26969_12403.png?timeKey="
				+ timeKey;
		return urlString;
	}

	private String getUrl3() {
		long time = System.currentTimeMillis();
		long timeKey = time / 10000; // qq map use unit of 10-seconds.

		// seems timeKey useless?
		String urlString = "http://rtt2.map.qq.com/live/15/2696/1240/26968_12404.png?timeKey="
				+ timeKey;
		return urlString;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			;
			return rootView;
		}

	}

}
