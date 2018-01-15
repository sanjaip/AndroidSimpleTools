package com.brainfeaster.sanneo.simpletools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import com.brainfeaster.sanneo.simpletools.helper.db;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyAlarm";
    public static  db _DBConnect = null;
    WebSettings wSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitModules im = new InitModules(this);
        _DBConnect = im._db;

        WebView webView = new WebView(this);
        webView.setClickable(true);
        wSettings = webView.getSettings();
        wSettings.setAllowFileAccessFromFileURLs(true);
        wSettings.setAllowUniversalAccessFromFileURLs(true);
        wSettings.setAllowFileAccess(true);
        wSettings.setJavaScriptEnabled(true);
        wSettings.setDomStorageEnabled(true);
        WebClientClass webViewClient = new WebClientClass();
        webView.setWebViewClient(webViewClient);
        WebChromeClient webChromeClient = new WebChromeClient();
        webView.setWebChromeClient(webChromeClient);
        STJSInterface jsin  = new STJSInterface(this,_DBConnect);
        webView.addJavascriptInterface(jsin, "Android");
        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);

        String abcd ="";
    }


    public class WebClientClass extends WebViewClient {
        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            pd = new ProgressDialog(MainActivity.this);
            pd.setTitle("Please wait");
            pd.setMessage("Page is loading..");
            pd.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);


            //This place is kind of main class for this app. Everything happens from here.

            //1. Communication channel between webview and android like server and client
            //step 1: javascript sends a request
         // RSMBusiness curBus = new RSMBusiness();
           // curBus.getDataFromService(_DBConnect);

         //  String str = curBus.getDataFromSQL(_DBConnect);
          //  List<String> dividedResponse = JSProtocol.doRespond(str);
          //  int noOfbits = dividedResponse.size();
          //  boolean isNew = true;
         //   int currBit = 1;
         //   for (String iStr: dividedResponse) {
                /*if(isNew){
                    isNew = false;
                   // Log.d("call before","javascript:collectResponseBits('"+iStr+"',"+noOfbits+",true)");
                    view.loadUrl("javascript:collectResponseBits('"+iStr+"',14,"+currBit+",123)");
                    currBit++;
                }
                else{
                   // Log.d("call recurrece","javascript:collectResponseBits('"+iStr+"',"+noOfbits+",false)");
                    view.loadUrl("javascript:collectResponseBits('"+iStr+"',14,"+currBit+",321)");
                    currBit++;
                }*/

              //  view.loadUrl("javascript:collectResponseBits('"+iStr+"')");

                //view.loadUrl("javascript:sayBaba()");
           // }
            pd.dismiss();
        }
        private int modulo( int m, int n ){
            int mod =  m % n ;
            return ( mod < 0 ) ? mod + n : mod;
        }
    }

    public class WebChromeClass extends WebChromeClient {
    }


}


