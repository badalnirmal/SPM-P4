package edu.example.guessthesong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button play_button = findViewById(R.id.play_button);
        Button exit_button = findViewById(R.id.exit_button);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,Game.class);//AC1 is login activity page(change AC6 to AC1)
                //check for the activity name for login activity and replace AC1.class
                startActivity(intent);
                recreate();// this is for the reloading of AC1 page //recheck with TA
            }
        });

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Homepage.this,"Exiting",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}