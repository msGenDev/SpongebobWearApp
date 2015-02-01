package com.mobilonix.spongebobsquarepet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.mobilonix.spongebobsquarepet.callbacks.AnimationCallback;
import com.mobilonix.spongebobsquarepet.movie.GifView;
import com.mobilonix.spongebobsquarepet.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import pl.droidsonroids.gif.GifDrawable;

public class SquarepetWatchActivity extends Activity {

    private TextView mTextView;
    GifImageView gifImageView;

    //Image Buttons
    Button feedButton;
    Button playButton;
    Button fitnessButton;
    Button teachButton;
    
    LinkedHashMap<String,Button> uiMap;
    
    //Activity Related
    Context context;
    Handler handler;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_squarepet_watch);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        context = this;
        uiMap = new LinkedHashMap<String,Button>();
        handler = new Handler();

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                initUI();
                initUIListeners();
            }
        });
        
    }
    
    public void initUI() {

        gifImageView = (GifImageView)findViewById(R.id.android_gif_drawable);
        
        feedButton = (Button)findViewById(R.id.feed_button);
        uiMap.put(feedButton.toString(),feedButton);
        playButton = (Button)findViewById(R.id.play_button);
        uiMap.put(playButton.toString(),playButton);
        fitnessButton = (Button)findViewById(R.id.walk_button);
        uiMap.put(fitnessButton.toString(),fitnessButton);
        teachButton = (Button)findViewById(R.id.teach_button);
        uiMap.put(teachButton.toString(),teachButton);

    }
    
    public void initUIListeners() {
        feedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Util.flashButton(feedButton,10,250, new AnimationCallback() {
                        @Override
                        public void onComplete() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    toggleOtherButtonsVisibility(feedButton, true);
                                }
                            });
                        }
                    });
                    toggleOtherButtonsVisibility(feedButton,false);
                    gifImageView.setImageDrawable(new GifDrawable(getAssets(), "sponge0.gif"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });   
        
        playButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    Util.flashButton(playButton,10,250,new AnimationCallback() {
                        @Override
                        public void onComplete() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    toggleOtherButtonsVisibility(playButton, true);
                                }
                            });
                        }
                    });
                    toggleOtherButtonsVisibility(playButton,false);
                    gifImageView.setImageDrawable(new GifDrawable(getAssets(), "sponge1.gif"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        fitnessButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    Util.flashButton(fitnessButton,10,250, new AnimationCallback() {
                        @Override
                        public void onComplete() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    toggleOtherButtonsVisibility(fitnessButton, true);
                                }
                            });
                        }
                    });
                    toggleOtherButtonsVisibility(fitnessButton,false);
                    gifImageView.setImageDrawable(new GifDrawable(getAssets(), "sponge2.gif"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        teachButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    Util.flashButton(teachButton,10,250,new AnimationCallback() {
                        @Override
                        public void onComplete() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    toggleOtherButtonsVisibility(teachButton, true);
                                }
                            });
                        }
                    });
                    toggleOtherButtonsVisibility(teachButton,false);
                    gifImageView.setImageDrawable(new GifDrawable(getAssets(), "sponge3.gif"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    
    public void toggleOtherButtonsVisibility(Button nonHidingButton,boolean state) {
        
        //use the entry set to get th ecomplete list of entries which you can iterate through
        //like an associative array
        for (Map.Entry<String, Button> entry : uiMap.entrySet()) {
            String key = entry.getKey();
            Button value = entry.getValue();
            if(!value.equals(nonHidingButton)) {
                if(state) {
                    value.setVisibility(View.VISIBLE);
                } else {
                    value.setVisibility(View.GONE);
                }
            }
        }
        
    }
    
}
