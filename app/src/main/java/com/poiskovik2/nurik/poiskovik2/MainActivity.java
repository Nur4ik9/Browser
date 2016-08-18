package com.poiskovik2.nurik.poiskovik2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void poisk(View v) {

        EditText et = (EditText) findViewById(R.id.urlString);
        WebView wv = (WebView) findViewById(R.id.webPage);

        String s = et.getText().toString();

        if (s.equals("")) {
            Toast.makeText(MainActivity.this, "Введите данные", Toast.LENGTH_SHORT).show();

        }

        else {

            if (s.startsWith("http://") || s.startsWith("https://")) {

                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());
                wv.setWebChromeClient(new WebChromeClient());
                wv.loadUrl(s);

            }

            else {

                String sUrl = "http://" + s;//
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());
                wv.setWebChromeClient(new WebChromeClient());
                wv.loadUrl(sUrl);
            }
        }
    }
}
