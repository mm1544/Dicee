package com.app.dicee.marty.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;
        rollButton = (Button) findViewById(R.id.rollButton);

        // why do we need final in here???
        final ImageView leftDice = (ImageView) findViewById(R.id.image_left_dice);
        final ImageView righttDice = (ImageView) findViewById(R.id.image_right_dice);

        // for listener we have to assure that this array will not change somewhere in the other
        // part of the app. Therefore we need "final" keyword.
        // now diceArray variable can't change any more. We made a constant.
        final int[] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        //setting OnClick listenner on the button, THEN we are reating listenner
        // itself with keyword "new"
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //prints things to the console. d stands for debug
                Log.d("Dee", "Ze button has been pressed");

                // creating a Random OBJECT
                Random randomNumberGenerator = new Random();

                // we will use Random nr generator to generate the value. nextInt()
                // will generate the integer. And provided upper bound is 6.
                // variable "number" will store a rand nr between 0 and 5.
                int numberLeft = randomNumberGenerator.nextInt(6);
                int numberRight = randomNumberGenerator.nextInt(6);

                Log.d("Dicee", "The random nr for left dice is: " + numberLeft);

                //setting an image of leftDice inside onclick listener
                leftDice.setImageResource(diceArray[numberLeft]);
                righttDice.setImageResource(diceArray[numberRight]);
            }
        });

    }
}
