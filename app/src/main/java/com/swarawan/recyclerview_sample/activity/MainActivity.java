package com.swarawan.recyclerview_sample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.swarawan.recyclerview_sample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.vertical).setOnClickListener(onVerticalClicked);
        findViewById(R.id.horizontal).setOnClickListener(onHorizontalClicked);
        findViewById(R.id.multi).setOnClickListener(onMultiClicked);
    }

    private View.OnClickListener onVerticalClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, VerticalListActivity.class));
        }
    };

    private View.OnClickListener onHorizontalClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, HorizontalListActivity.class));
        }
    };

    private View.OnClickListener onMultiClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, MultiViewActivity.class));
        }
    };
}
