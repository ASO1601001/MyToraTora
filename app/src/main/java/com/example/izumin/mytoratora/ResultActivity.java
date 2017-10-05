package com.example.izumin.mytoratora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    final int JANKEN_GU = 0;
    final int JANKEN_CHOKI = 1;
    final int JANKEN_PA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int myHand = 0;
        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_HAND",0);

        ImageView myHandImageView = (ImageView) findViewById(R.id.you_img);
        switch(id){
            case R.id.gu:
                myHandImageView.setImageResource(R.drawable.tiger);
                myHand = JANKEN_GU;
                break;
            case R.id.choki:
                myHandImageView.setImageResource(R.drawable.rouba);
                myHand = JANKEN_CHOKI;
                break;
            case R.id.pa:
                myHandImageView.setImageResource(R.drawable.kiyomasa);
                myHand = JANKEN_PA;
                break;
        }

        int comHand = (int)(Math.random() * 3);
        ImageView comHandImageView = (ImageView) findViewById(R.id.enemy_img);
        switch (comHand){
            case JANKEN_GU:
                comHandImageView.setImageResource(R.drawable.tiger);
                break;
            case JANKEN_CHOKI:
                comHandImageView.setImageResource(R.drawable.rouba);
                break;
            case JANKEN_PA:
                comHandImageView.setImageResource(R.drawable.kiyomasa);
                break;
        }

        TextView resultLabel = (TextView)findViewById(R.id.result_text);
        int gameResult = (comHand - myHand + 3) % 3;
        switch(gameResult){
            case 0:
                resultLabel.setText(R.string.result_draw);
                break;
            case 1:
                resultLabel.setText(R.string.result_win);
                break;
            case 2:
                resultLabel.setText(R.string.result_lose);
                break;
        }
    }

    public void onBackButtonTapped(View view){
        finish();
    }
}
