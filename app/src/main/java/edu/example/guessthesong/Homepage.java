package edu.example.guessthesong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Homepage extends AppCompatActivity {

    final static ArrayList<Integer> song_chosen = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button play_button = findViewById(R.id.play_button);
        Button exit_button = findViewById(R.id.exit_button);
        final String[] song = new String[1];


        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(getAssets().open("PhraseBank.txt"), "UTF-8"));

                    // do reading, usually loop until end of file reading
                    String mLine;
                    Random rand = new Random();
                    int chosen_song = rand.nextInt(19)+1;

                    //song_played.add(chosen_song);
                    while ((mLine = reader.readLine()) != null) {
                        //process line
                        for(int i=0; i<song_chosen.size();i++)
                        {
                            if(song_chosen.get(i)==chosen_song) {
                                while (song_chosen.get(i) == chosen_song)
                                    chosen_song = rand.nextInt(19)+1;
                            }
                        }

                        //System.out.println(mLine);
                        StringTokenizer st = new StringTokenizer(mLine,"|");
                        if(Integer.parseInt(st.nextToken())== chosen_song)
                            song[0] = mLine;
                    }
                    song_chosen.add(chosen_song);
                    //System.out.println(song_chosen);
                } catch (IOException e) {
                    Toast.makeText(Homepage.this,"File Can't be opened.\n Exiting",Toast.LENGTH_LONG).show();
                    finishAffinity();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            //log the exception
                        }
                        Intent intent = new Intent(Homepage.this,Game.class);
                        intent.putExtra("song_chosen", song_chosen);
                        String song1=song[0];
                        //System.out.println(song1);
                        intent.putExtra("song",song1);
                        startActivity(intent);
                        recreate();
                    }
                }
            }
        });

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Homepage.this,"Exiting",Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });
    }
}