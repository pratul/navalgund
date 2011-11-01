package in.prtk.navalgund;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Navalgund extends Activity {

	private WebView wv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.main);

        wv = (WebView) findViewById(R.id.webview);
        wv.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;

        wv.setWebChromeClient(new WebChromeClient() {
          public void onProgressChanged(WebView view, int progress) {
            activity.setProgress(progress * 1000);
          }
        });

        wv.setWebViewClient(new WebViewClient() {
          public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
          }
        });

        wv.loadUrl("http://27.7.20.190/~prateeksaxena/game/");
    }

}