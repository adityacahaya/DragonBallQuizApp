package com.wordpress.kadekadityablog.dragonballquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    String messageScore = "";
    String answer1 = "";
    String answer2 = "";
    String answer3 = "";
    String answer4 = "";
    int score = 0;
    String commentScore = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAnswer1(){
        RadioButton rb_goku = (RadioButton)findViewById(R.id.rb_question1_goku);
        RadioButton rb_gohan = (RadioButton)findViewById(R.id.rb_question1_gohan);
        if(rb_goku.isChecked()){
            answer1 = "Son Goku";
        }else if(rb_gohan.isChecked()){
            answer1 = "Son Gohan";
        }else{
            answer1 = "Son Goten";
        }
    }

    public void setAnswer2(){
        CheckBox cb_frieza = (CheckBox)findViewById(R.id.cb_question2_frieze);
        CheckBox cb_cell = (CheckBox)findViewById(R.id.cb_question2_cell);
        CheckBox cb_bhu = (CheckBox)findViewById(R.id.cb_question2_bhu);
        CheckBox cb_shenron = (CheckBox)findViewById(R.id.cb_question2_shenron);
        if(cb_frieza.isChecked()){
            answer2 += "Frieza ";
        }
        if(cb_cell.isChecked()){
            answer2 += "Cell ";
        }
        if(cb_bhu.isChecked()){
            answer2 += "Bhu ";
        }
        if(cb_shenron.isChecked()){
            answer2 += "Omega Shenron ";
        }
    }

    public void setAnswer3(){
        EditText ed_quest3 = (EditText)findViewById(R.id.ed_question3);
        answer3 = ed_quest3.getText().toString();
    }

    public void setAnswer4(){
        EditText ed_quest4 = (EditText)findViewById(R.id.ed_question4);
        answer4 = ed_quest4.getText().toString();
    }

    public int calculateScore(String answer1, String answer2, String answer3, String answer4){
        int score = 0;
        if(answer1.equals("Son Goku")){
            score += 25;
        }
        if(answer2.equals("Frieza Cell Bhu ")){
            score += 25;
        }
        if(answer3.equals("Vegito") || answer3.equals("Super Vegito")){
            score += 25;
        }
        if(!answer4.equals("")){
            score +=25;
        }
        return score;
    }

    public void setCommentScore(int score){
        if(score > 100){
            commentScore = "You're Master of Dragon Ball !!!";
        }else if(score >70){
            commentScore = "You're can use Kamehameha this time !";
        }else if(score >40){
            commentScore = "Your power level is to weak !";
        }else{
            commentScore = "You can try again latter ^^";
        }
    }

    public void submitAnswer(View view){
        EditText ed_name = (EditText)findViewById(R.id.ed_name);
        EditText ed_email = (EditText)findViewById(R.id.ed_email);
        TextView txt_score = (TextView)findViewById(R.id.txt_score);
        messageScore = "";

        setAnswer1();
        setAnswer2();
        setAnswer3();
        setAnswer4();
        score = calculateScore(answer1,answer2,answer3,answer4);
        setCommentScore(score);

        if(ed_email.getText().toString().equals("") || ed_name.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"You must fill name and email",3).show();
        }else{
            messageScore += "Hello "+ed_name.getText().toString();
            messageScore += "\nYour answe is : ";
            messageScore += "\n1. "+answer1;
            messageScore += "\n2. "+answer2;
            messageScore += "\n3. "+answer3;
            messageScore += "\n4. "+answer4;
            messageScore += "\nCongratulation ! Your score is "+score;
            messageScore += "\n"+commentScore;
        }

        txt_score.setText(messageScore);
    }

}
