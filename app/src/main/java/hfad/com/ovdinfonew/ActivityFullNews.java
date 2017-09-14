package hfad.com.ovdinfonew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ActivityFullNews extends AppCompatActivity {

    public static final String NEWS_NUMBER = "newsNumber";
    public static final String NEWS_NUMBER2 = "newsNumber2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);



        int newsNumber = (Integer)getIntent().getExtras().get(NEWS_NUMBER);
        String text = getIntent().getExtras().getString(NEWS_NUMBER2);
        TextView textView = (TextView) findViewById(R.id.textVIew2);
        textView.setText(text);
    }
}
