package com.siddiqui.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckinActivity extends AppCompatActivity {

    private String[] questions = new String[]{"How have you been feeling lately","" +
            "Describe your apetite through this time","What has been the cause of your discomfort"};

    private String[] titleColors = new String[]{"#3352BA","#FF9885","#8fe1f5"};
    private String[] noteColors = new String[]{"#708BD7","#FFBE22"};

    private String[] noteText = new String[]{"We ask you this because we care",
            "Don't worry, rouph patches are only temporary",
            "Happiness can be found even in the darkest of times, if one only remembers to turn on the light"};

    TextView question, note;
    int counter=0;

    //Question1
    Button q1_btn1,q1_btn2,q1_btn3,q1_btn4;
    TextView q1_text1,q1_text2,q1_text3,q1_text4;

    //q2
    private Button q2_btn1,q2_btn2,q2_btn3;
    private ImageView q2_img;

    //q3
    private Button q3_btn1,q3_btn2,q3_btn3,q3_btn4;
    private ImageView q3_picture;

    //final
    private TextView finalTextView;
    private ImageView finalImageViewl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        //q1 pick the emoji that best describes you today: (the 4)
        //q2 how has your apetite been for the past couple of days
        //q3 What has been the cause of your discomfort: sick of home, falling out with family,
        // disagreement with friends, study stress, other
        // summarise at the end.

        question = findViewById(R.id.question);
        note = findViewById(R.id.note);

        //question 1
        question.setText(questions[counter]);
        question.setBackgroundColor(Color.parseColor(titleColors[counter]));
        note.setText(noteText[counter]);
        note.setBackgroundColor(Color.parseColor(noteColors[counter]));

        q1_btn1=findViewById(R.id.q1_choice1);
        q1_btn2=findViewById(R.id.q1_choice2);
        q1_btn3=findViewById(R.id.q1_choice3);
        q1_btn4=findViewById(R.id.q1_choice4);
        q1_text1=findViewById(R.id.q1_text1);
        q1_text2=findViewById(R.id.q1_text2);
        q1_text3=findViewById(R.id.q1_text3);
        q1_text4=findViewById(R.id.q1_text4);

        //setting visibility
        q1_btn1.setVisibility(View.VISIBLE);
        q1_btn2.setVisibility(View.VISIBLE);
        q1_btn3.setVisibility(View.VISIBLE);
        q1_btn4.setVisibility(View.VISIBLE);
        q1_text1.setVisibility(View.VISIBLE);
        q1_text2.setVisibility(View.VISIBLE);
        q1_text3.setVisibility(View.VISIBLE);
        q1_text4.setVisibility(View.VISIBLE);

        q1_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter+=1;
                q1_btn1.setVisibility(View.INVISIBLE);
                q1_btn2.setVisibility(View.INVISIBLE);
                q1_btn3.setVisibility(View.INVISIBLE);
                q1_btn4.setVisibility(View.INVISIBLE);
                q1_text1.setVisibility(View.INVISIBLE);
                q1_text2.setVisibility(View.INVISIBLE);
                q1_text3.setVisibility(View.INVISIBLE);
                q1_text4.setVisibility(View.INVISIBLE);

                question.setText(questions[counter]);
                question.setBackgroundColor(Color.parseColor(titleColors[counter]));
                note.setText(noteText[counter]);
                note.setBackgroundColor(Color.parseColor(noteColors[counter]));


                q2_btn1 = findViewById(R.id.q2_option1);
                q2_btn2 = findViewById(R.id.q2_option2);
                q2_btn3 = findViewById(R.id.q2_option3);
                q2_img = findViewById(R.id.q2_img);

                q2_img.setVisibility(View.VISIBLE);
                q2_btn1.setVisibility(View.VISIBLE);
                q2_btn2.setVisibility(View.VISIBLE);
                q2_btn3.setVisibility(View.VISIBLE);

                q2_btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counter+=1;
                        q2_img.setVisibility(View.INVISIBLE);
                        q2_btn1.setVisibility(View.INVISIBLE);
                        q2_btn2.setVisibility(View.INVISIBLE);
                        q2_btn3.setVisibility(View.INVISIBLE);

                        question.setText(questions[counter]);
                        question.setBackgroundColor(Color.parseColor(titleColors[counter]));
                        note.setText(noteText[counter]);
                        note.setBackgroundColor(Color.parseColor(noteColors[counter-1]));

                        q3_btn1 = findViewById(R.id.q3_option1);
                        q3_btn2 = findViewById(R.id.q3_option2);
                        q3_btn3 = findViewById(R.id.q3_option3);
                        q3_btn4 = findViewById(R.id.q3_option4);

                        q3_picture = findViewById(R.id.q3_picture);

                        q3_picture.setVisibility(View.VISIBLE);
                        q3_btn1.setVisibility(View.VISIBLE);
                        q3_btn2.setVisibility(View.VISIBLE);
                        q3_btn3.setVisibility(View.VISIBLE);
                        q3_btn4.setVisibility(View.VISIBLE);
                        q3_btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q3_picture.setVisibility(View.INVISIBLE);
                                q3_btn1.setVisibility(View.INVISIBLE);
                                q3_btn2.setVisibility(View.INVISIBLE);
                                q3_btn3.setVisibility(View.INVISIBLE);
                                q3_btn4.setVisibility(View.INVISIBLE);
                                question.setText("");

                                finalTextView=findViewById(R.id.finalTextView);
                                finalImageViewl = findViewById(R.id.imageView7);
                                finalImageViewl.setVisibility(View.VISIBLE);
                                finalTextView.setVisibility(View.VISIBLE);
                            }
                        });

                    }
                });

            }
        });
    }
}
