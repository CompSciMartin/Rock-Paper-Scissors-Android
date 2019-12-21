package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int[] choices = {0,1,2}; //0 is rock, 1 is paper, 2 is scissors

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//removes the status bar when running the app

        Button rockButton = (Button) findViewById(R.id.rockButton);
        Button paperButton = (Button) findViewById(R.id.paperButton);
        Button scissorsButton = (Button) findViewById(R.id.scissorsButton);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameLogic(0);
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameLogic(1);
            }
        });
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameLogic(2);
            }
        });

    }//end of onCreate method

    public void gameLogic(int choice){
        //variable declarations
        Random rand = new Random();
        int rand_index = rand.nextInt(3);
        String[] outputs = {"rock","paper","scissors"};

        //view objects declarations
        TextView compOutput = (TextView) findViewById(R.id.compOutputTextView);
        TextView result = (TextView) findViewById(R.id.resultTextView);

        compOutput.setText("Computer chose " + outputs[rand_index] + ".");
        result.setText("");
        if (rand_index == choice) {
            result.setText("Tie!");
        }else if (choice == 0){
            if (rand_index==1){
                result.setText("You lose.");
            }else {
                result.setText("You win!");
            }
        }else if(choice == 1){
            if (rand_index==2){
                result.setText("You lose.");
            }else{
                result.setText("You win!");
            }
        }else if (choice==2){
            if (rand_index==0){
                result.setText("You lose.");
            }else{
                result.setText("You win!");
            }
        }
    }

}
