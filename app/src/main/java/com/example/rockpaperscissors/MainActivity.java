package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button btn_rock, btn_paper, btn_scissors;
    TextView tv_score;
    ImageView img_human, img_computer;
    int humanScore, computerScore= 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_rock = findViewById(R.id.btn_rock);
        btn_paper = findViewById(R.id.btn_paper);
        btn_scissors = findViewById(R.id.btn_scissors);

        tv_score= findViewById(R.id.tv_score);

        img_human = findViewById(R.id.img_human);
        img_computer = findViewById(R.id.img_computer);

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_human.setImageResource(R.drawable.r1);
                String message =play_turn("rock");
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score : Human: " +Integer.toString(humanScore)+ " Computer: " +Integer.toString(computerScore));

            }


        });
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_human.setImageResource(R.drawable.r2);
               String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score : Human: " +Integer.toString(humanScore)+ " Computer: " +Integer.toString(computerScore));

            }
        });
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_human.setImageResource(R.drawable.r3);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score : Human: " +Integer.toString(humanScore)+ " Computer: " +Integer.toString(computerScore));

            }
        });

    }
    public String play_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();
        //choose from 1,2 or 3
        int computer_choice_number =r.nextInt(3)+1;

        if (computer_choice_number==1){
            computer_choice="rock";
        }
        else if (computer_choice_number==2) {
                computer_choice = "paper";
            }
            else if (computer_choice_number==3){
                    computer_choice="scissors";
            }
            // set image to the choice
        if (computer_choice== "rock"){
            img_computer.setImageResource(R.drawable.r1);
        }
        else
        if (computer_choice== "paper"){
            img_computer.setImageResource(R.drawable.r2);
        }else
        if (computer_choice== "scissors"){
            img_computer.setImageResource(R.drawable.r3);
        }
        // compute Human choice and Computer choice and who will
        if(computer_choice== player_choice){
            return "Draw Nobody Won";
        }
        else
            if(player_choice=="rock" && computer_choice=="scissors"){
                humanScore++;
                return "Rock crushes scissors Yay You Win!";
            }
            else
            if(player_choice=="rock" && computer_choice=="paper"){
                computerScore++;
                return "Paper covers rock Computer Win!";
            }
            else
            if(player_choice=="scissors" && computer_choice=="rock"){
                computerScore++;
                return "Rock crushes scissors Yay Computer Win!";
            }
            else
            if(player_choice=="scissors" && computer_choice=="paper"){
                humanScore++;
                return "Scissors cut papers. Yay You Win!";
            }
            else
            if(player_choice=="paper" && computer_choice=="rock"){
                humanScore++;
                return "Paper covers rock. You Win!!";
            }
            else
            if(player_choice=="paper" && computer_choice=="scissors"){
                computerScore++;
                return "Scissors cut Papers. Computer Win!";
            }
             else return  "Not Sure";





        }

    }

