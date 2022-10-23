package edu.sunyulster.mywebview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.sunyulster.mywebview.databinding.ActivityMainBinding;
import android.content.Intent;
import android.net.Uri;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handleIntent();
    }

    public void handleIntent() {
        Intent intent = getIntent();
        Uri data = intent.getData();
        URL url = null;
        try {
            url = new URL(data.getScheme(), data.getHost(), data.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (url != null)
            binding.webView.loadUrl(url.toString());
        else // go to this site by default
            binding.webView.loadUrl("https://www.google.com"); // change after testing to ulster website
    }

}
