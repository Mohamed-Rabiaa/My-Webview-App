package com.development.mywebviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;

    WebViewClient mywebViewClient;

    int progress = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myWebView = new WebView(this);

        setContentView(myWebView);

        if(savedInstanceState != null)
        {
            myWebView.loadUrl(savedInstanceState.getString("URL"));

        }

        else
        {
            myWebView.loadUrl("https://fantasy.premierleague.com");
        }

        myWebView.getSettings().setJavaScriptEnabled(true);

        mywebViewClient = new WebViewClient();

        myWebView.setWebViewClient(mywebViewClient);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack())
        {
            myWebView.goBack();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);

        String url = myWebView.getUrl();

        progress = myWebView.getProgress();

        outState.putString("URL",url);
    }
}
