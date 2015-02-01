package com.mobilonix.spongebobsquarepet.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.Button;

import com.mobilonix.spongebobsquarepet.callbacks.AnimationCallback;

/**
 * Created by quoraiss on 2/1/15.
 */
public class Util {
    
    public static void flashButton(final Button button, final int duration, final int period, final AnimationCallback callback) {

            if(duration < 0) {
                throw new IllegalArgumentException("Duration must be positive!");
            }
        
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                     int count = 0;
                     while(count < duration) {
                         try {
                             Thread.sleep(period);
                             button.post(new Runnable() {
                                 @Override
                                 public void run() {

                                     if(((ColorDrawable)button.getBackground()).getColor() == android.R.color.darker_gray) {
                                         button.setBackgroundColor(android.R.color.white);
                                     } else {
                                         button.setBackgroundColor(android.R.color.darker_gray);
                                     }

                                 }
                             });
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         count++;
                     }
                     callback.onComplete();
                }
            }).start();

    }
    
}
