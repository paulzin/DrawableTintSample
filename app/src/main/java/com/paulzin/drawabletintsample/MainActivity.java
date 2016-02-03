package com.paulzin.drawabletintsample;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        findViewById(R.id.setTintButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.escobar);
                drawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTint(drawable, ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                DrawableCompat.setTintMode(drawable, PorterDuff.Mode.MULTIPLY);
                imageView.setImageDrawable(drawable);
                imageView.setEnabled(false);
            }
        });

        findViewById(R.id.clearTintButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = imageView.getDrawable();
                DrawableCompat.setTintList(drawable, null);
                imageView.setImageDrawable(drawable);
                imageView.setEnabled(true);
            }
        });
    }
}
