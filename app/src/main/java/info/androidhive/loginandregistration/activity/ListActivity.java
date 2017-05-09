package info.androidhive.loginandregistration.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.adapter.RecyclerAdapter;
import info.androidhive.loginandregistration.app.AppConfig;
import info.androidhive.loginandregistration.model.Entity;

/**
 * Created by Anis on 07/05/2017.
 */

public class ListActivity  extends AppCompatActivity{

    RecyclerView recyclerView;
    Context context = this;
    ArrayList<Entity>produits= new ArrayList<>();
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

/*
        ArrayList <Entity> entities = new ArrayList<>();

        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
        entities.add(new Entity("test3","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
        entities.add(new Entity("test1","http://www.saintdenisenval.com/wp-content/uploads/ECOLE-CHAMPDOUX-3-St-Denis-en-Val.jpg","dlsfdjfkslfsf"));
*/




        //Layout manager for Recycler view
        new HttpAsyncTask().execute(AppConfig.URL_ECOLES);
       // Log.d("rrrrr",produits.size()+"");

    }



    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            try {
                JSONObject json = new JSONObject(result);

                String str = "";

                JSONArray articles = json.getJSONArray("result");
                str += "articles length = "+json.getJSONArray("result").length();
                //etResponse.setText(str);
                //etResponse.setText(json.toString(1));

                for (int i = 0; i < articles.length(); i++) {

                    JSONObject e = articles.getJSONObject(i);
                    String nom_ecole = e.getString("nom_ecole");
                    String image = e.getString("image");
                    String info = e.getString("info");

                           produits.add(new Entity(nom_ecole,image, info));

                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
            RecyclerAdapter adapter=new RecyclerAdapter(ListActivity.this,produits);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }
}