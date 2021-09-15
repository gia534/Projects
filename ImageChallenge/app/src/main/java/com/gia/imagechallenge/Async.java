package com.gia.imagechallenge;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gia.imagechallenge.Adapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Async extends AsyncTask<Void, Void, List<Bitmap>> {
    private Context context;
    public String stringJsonUrl = "";
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    public List<String> image = new ArrayList<>();
    public List<Bitmap> bitmapList = new ArrayList<>();
    protected Adapter adapter;
    public RecyclerView recyclerView;
    private ProgressDialog dialog;
    private final String TAG = "arraylist";


    public Async (Context context, RecyclerView recyclerView){
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.show();
        dialog.setMessage("Retrieving images");
    }

    @Override
    protected List<Bitmap> doInBackground(Void... voids) {
        try{
            String website = "http://eulerity-hackathon.appspot.com/image";


            // Connecting to url link to retrieve data
            URL imageUrl = new URL(website);
            URLConnection connection = imageUrl.openConnection();
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Retrieving UR image links
            String line = reader.readLine();

            while (line != null){
                stringJsonUrl += line;
                line = reader.readLine();

                Log.i("while loop", stringJsonUrl);
            }

            // Looping through list of links and retrieving

            jsonArray = new JSONArray(stringJsonUrl);


            for(int i = 0; i < jsonArray.length(); i++){
                jsonObject = (JSONObject) jsonArray.get(i);

                String urlLink = jsonObject.getString("url"); // URL links for the images
                String created = jsonObject.getString("created");
                String updated = jsonObject.getString("updated");
                String imageInfo = urlLink + " created on " + created
                        + " updated on " + updated;

                image.add(urlLink); // Adding those links to the list

                Log.i(TAG, "image link: " + image);
                //  System.out.println(urlLink);

            }


            for(int j = 0; j < image.size(); j++){
                URL individualImage = new URL(image.get(j)); // Retrieving those links and converting strings to url
                Bitmap bitmap = BitmapFactory.decodeStream(individualImage.openConnection().getInputStream()); // Converting the urls to bitmap images
                bitmapList.add(bitmap); // adding those bitmaps to the Bitmap list
            }



            //System.out.println("BitmapList size " + bitmapList.size());
            reader.close();

            return bitmapList; // returning the bitmap list for post execute to receive
        } catch(Exception e){
            Log.e("Async", e.getMessage());
        }
        return bitmapList;

    }

    @Override
    protected void onPostExecute(List<Bitmap> bitmap) {
        super.onPostExecute(bitmap);
        dialog.dismiss();

        adapter = new Adapter(bitmap); // adding the images to the Recyclerview
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

    }
}
