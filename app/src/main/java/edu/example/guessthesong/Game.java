package edu.example.guessthesong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        //Song ID that are already chosen and Song that is currently picked.
        ArrayList <Integer> song_chosen = (ArrayList<Integer>) intent.getSerializableExtra("song_chosen");
        String song = intent.getStringExtra("song");
        System.out.println(song_chosen + song);



        Button back_button =findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this,Homepage.class);
                startActivity(intent);
            }
        });
    }
}