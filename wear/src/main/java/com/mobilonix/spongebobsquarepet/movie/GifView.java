package com.mobilonix.spongebobsquarepet.movie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;

import java.io.InputStream;

/**
 * Created by quoraiss on 1/29/15.
 */
public class GifView extends View {

    private Movie mMovie;
    private InputStream stream;
    private long mMoviestart = 0;
    
    public GifView(Context context,InputStream stream) {
        super(context);

        this.stream = stream;
        mMovie = Movie.decodeStream(stream);
    }

    @Override protected void onDraw(Canvas canvas) { 
        canvas.drawColor(Color.TRANSPARENT); 
        super.onDraw(canvas); 
        final long now = SystemClock.uptimeMillis(); 
        if (mMoviestart == 0) { 
            mMoviestart = now; 
        } 
        final int relTime = (int)((now - mMoviestart) % mMovie.duration()); 
        mMovie.setTime(relTime);
        mMovie.draw(canvas, 10, 10); 
        this.invalidate(); 
    }
}
