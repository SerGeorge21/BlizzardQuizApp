package com.example.android.blizzardquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int rightAnswers;
    private static int NumOfQuestions = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        rightAnswers=0;
        RadioButton a1 = (RadioButton) findViewById(R.id.warcraft); //a1= answer1 etc.
        if(a1.isChecked()) rightAnswers++;

        EditText a2 = (EditText) findViewById(R.id.hearthstone_release_date);
        String Hyear = a2.getText().toString();//Hyear= hearthstone year(of release)
        if(Hyear.equals("2014")) rightAnswers++;

        RadioButton a3 = (RadioButton) findViewById(R.id.chars_27);
        if(a3.isChecked())rightAnswers++;

        CheckBox c1 = (CheckBox) findViewById(R.id.Brigitte_check_box);
        CheckBox c2 = (CheckBox) findViewById(R.id.Moira_check_box);
        CheckBox c3 = (CheckBox) findViewById(R.id.Doomfist_check_box);
        if(c1.isChecked()&&c2.isChecked()&&!c3.isChecked()) rightAnswers++;

        RadioButton a5 = (RadioButton) findViewById(R.id.exp_7);
        if(a5.isChecked())rightAnswers++;

        double percent = calculatePercent();
        display(percent);
    }

    public double calculatePercent(){
        return ((double)rightAnswers/(double)NumOfQuestions)*100;
    }

    public void display(double p){
        String message="";
        if(p==100) message = getString(R.string.congratulations)+getString(R.string.you_got) + p + getString(R.string.p_of_q_right);
        else if(p>=70&&p<100) message = p +getString(R.string.p_of_q_right)+getString(R.string.sweet);
        else if(p>=40&&p<70) message = getString(R.string.you_got) + p + getString(R.string.p_of_q_right)+getString(R.string.not_bad);
        else if(p<40) message = p + getString(R.string.p_unfortunate);
        TextView results = (TextView) findViewById(R.id.result_text_view);
        results.setText(message);
        results.setVisibility(View.VISIBLE);
        Context context = getApplicationContext();
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
