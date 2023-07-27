package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameDisplay extends AppCompatActivity {

    private TicTacToeGame ticTacToeGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);


        Button playAgainBTN = findViewById(R.id.play_again);
        Button homeBTN = findViewById(R.id.home_button);
        TextView playerTurn = findViewById(R.id.player_display);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);


        String[] playerNames = getIntent().getStringArrayExtra("Player_names");

        if (playerNames != null){
            playerTurn.setText(playerNames[0]+"'s Turn");
        }

        ticTacToeGame = findViewById(R.id.ticTacToeGame);
        ticTacToeGame.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);


    }
    public void homeCLick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void playAgainCLick(View view){
        ticTacToeGame.resetGame();
        ticTacToeGame.invalidate();
    }
}