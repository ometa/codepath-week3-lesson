package org.ometa.lesson3;

import android.widget.ImageView;

/**
 * Created by devin on 11/3/15.
 */
public class Scarecrow {

    public static void load(String imageUrl, ImageView imageView) {
        // 1. check if there is internet
        // 2. create a url object
        // 3. create a request
        // 4. send request
        // 5. read the response
        // 6.


        MyAsyncTask task = (MyAsyncTask) new MyAsyncTask(imageView).execute(imageUrl);




    }
}