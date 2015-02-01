package com.mobilonix.spongebobsquarepet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.mobilonix.spongebobsquarepet.movie.GifView;

import java.io.IOException;
import java.io.InputStream;

public class SquarepetWatchActivity extends Activity {

    private TextView mTextView;
    Context context;
    GifImageView gifImageView;

    //Image Buttons
    Button feedButton
    Button playButton
    Button fitnessButton
    Button 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_squarepet_watch);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        context = this;
        
        //gifImageView = new GifImageView(context);
        //gifImageView.setBytes(bitmapData);
        //setContentView(gifImageView);
        
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                
            }
        });
        
        initUIListeners();
    }
    
    public void initUIListeners() {
        
    }
}
