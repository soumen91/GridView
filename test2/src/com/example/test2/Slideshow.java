package com.example.test2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class Slideshow extends Activity{
    //private TextView txtStatus;
    private ImageView imageView;
    int i=0;
    private Bitmap bitmap=null;
    String imgid[]={"http://www.hdwallpapersarena.com/wp-content/uploads/2013/03/HD-Wallpaper-Of-Nature-1.jpg","http://img.bbs.duba.net/forum/201205/16/205332hlb9ywtn6xi6yuxl.jpg","http://2.bp.blogspot.com/_N_mOB63qPaE/TTSdxa6S38I/AAAAAAAARs8/vZlHEX_VtW8/s1600/3d_nature_wallpaper_landscape.jpg","http://wallpapere.org/wp-content/uploads/2011/04/wallpaper-hd-vara.jpg"};
    /*int imgid[]={R.drawable.sample_0,R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7};*/
    private boolean flag = false;
    private  int currentInt;
    
    private Handler handler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    	    		super.handleMessage(msg);
    	    		switch (msg.what) {
					case 1:
						updateUI();
						break;

					default:
						break;
					}
    	}
    };
   // RefreshHandler refreshHandler=new RefreshHandler();
    
    /*class RefreshHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            Slideshow.this.updateUI();
        }
        public void sleep(long delayMillis){
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    };
    public void updateUI(){
        int currentInt=Integer.parseInt((String)txtStatus.getText())+10;
        if(currentInt<=100){
            refreshHandler.sleep(2000);
            txtStatus.setText(String.valueOf(currentInt));
            if(i<imgid.length){
                imageView.setImageResource(imgid[i]);
                
                // imageView.setPadding(left, top, right, bottom);
                i++;
            }
        }
    }*/
    
    public void updateUI(){
    	/*if(!flag){
    		currentInt=Integer.parseInt((String)txtStatus.getText())+10;
    	}else{
    		currentInt = currentInt+10;
    	}*/
       
        if(currentInt<=100){
            //refreshHandler.sleep(2000);
            //txtStatus.setText(String.valueOf(currentInt));
            if(i<imgid.length){
                //imageView.setImageResource(imgid[i]);
            	downloadImage(imgid[i]);
                // imageView.setPadding(left, top, right, bottom);
                i++;
            }else{
            	i=0;
            	  //currentInt=10;
            	  flag = true;
            }
        }
        handler.sendEmptyMessageDelayed(1, 8000);
       
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide);
       // this.txtStatus=(TextView)this.findViewById(R.id.textView1);
        this.imageView=(ImageView)this.findViewById(R.id.imageView);
        //updateUI();
        handler.sendEmptyMessageDelayed(1, 0000);
    }
    
    private void downloadImage(String urlStr) {
		final String url = urlStr;

		new Thread() {
			public void run() {
				InputStream in = null;
				Message msg = Message.obtain();
				msg.what = 1;
				try {
					in = openHttpConnection(url);
					bitmap = BitmapFactory.decodeStream(in);
					Bundle b = new Bundle();
					b.putParcelable("bitmap", bitmap);
					msg.setData(b);
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				messageHandler.sendMessage(msg);
			}
		}.start();
	}
	
	private InputStream openHttpConnection(String urlStr) {
		InputStream in = null;
		int resCode = -1;

		try {
			URL url = new URL(urlStr);
			URLConnection urlConn = url.openConnection();

			if (!(urlConn instanceof HttpURLConnection)) {
				throw new IOException("URL is not an Http URL");
			}

			HttpURLConnection httpConn = (HttpURLConnection) urlConn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			resCode = httpConn.getResponseCode();
			if (resCode == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	private Handler messageHandler = new Handler() {

		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				imageView.setImageBitmap((Bitmap) (msg.getData()
						.getParcelable("bitmap")));
				break;
			
			}
		
		}
	};
}