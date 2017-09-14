package hfad.com.ovdinfonew;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActivityTexts extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapterTexts customAdapter;
    private List<MyDataTexts> data_list_texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        data_list_texts = new ArrayList<>();
        new ParseTask().execute();

        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        customAdapter = new CustomAdapterTexts(this, data_list_texts);
        recyclerView.setAdapter(customAdapter);
    }

    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... params) {
            // получаем данные с внешнего ресурса
            try {
                URL url = new URL("https://ovdinfo.org/mobile/json");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);

            JSONObject dataJsonObj = null;

            try {
                dataJsonObj = new JSONObject(strJson);
                JSONArray texts = dataJsonObj.getJSONArray("texts");

                for (int i = 0; i < texts.length(); i++) {
                    JSONObject textsObjest = texts.getJSONObject(i);

                    MyDataTexts data = new MyDataTexts(textsObjest.getInt("nid"), textsObjest.getString("title"),
                            textsObjest.getString("created"), textsObjest.getString("path"), textsObjest.getString("text"),
                            "https://ovdinfo.org/"+textsObjest.getString("cover"));

                    data_list_texts.add(data);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            customAdapter.notifyDataSetChanged();
        }
    }
}
