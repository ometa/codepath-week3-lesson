package org.ometa.lesson3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by devin on 11/3/15.
 */
public class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {

    // onPreExecute   (on main thread)
    //     use this to communicate to the user that we're doing something.
    // doInBackground (async on different thread)
    //     perform our task
    // onPostExecute  (on main thread)
    //     set things like the imageView, communicate to user

    private ImageView ivPhoto;

    public MyAsyncTask(ImageView ivPhoto) {
        this.ivPhoto = ivPhoto;
    }

    // This is the method we can run on the UI thread
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        ivPhoto.setImageBitmap(bitmap);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    // This executes on the worker thread
    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            // 1. Declare a URL Connection
            URL url = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 2. Open InputStream to connection
            conn.connect();
            InputStream in = conn.getInputStream();

            // 3. assign to bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            in.close();

            // 4. return bitmap from async
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
