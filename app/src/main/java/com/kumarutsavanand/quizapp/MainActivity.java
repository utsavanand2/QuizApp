package com.kumarutsavanand.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int totalQuestions = 5;
    private TextView questionTextView1;
    private TextView questionTextView2;
    private TextView questionTextView3;
    private TextView questionTextView4;
    private TextView questionTextView5;
    private ArrayList<AppCompatCheckBox> checkBoxes = new ArrayList<>();
    private ArrayList<TextView> questions = new ArrayList<>();
    private static int checkBoxCount = 0;
    private AppCompatCheckBox checkBox1;
    private AppCompatCheckBox checkBox2;
    private AppCompatCheckBox checkBox3;
    private AppCompatCheckBox checkBox4;
    private Button submit;
    QuestionAndResponses questionAndResponses;

    private static final int ANSWER1 = 0;
    private static final int ANSWER2 = 1;
    private static final int ANSWER3 = 2;
    private static final int ANSWER4 = 3;
    private static final int ANSWER5 = 4;
    private static int correctResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionAndResponses = new QuestionAndResponses();
        final int radioGroup = R.id.radio_group;
        final int radioGroup5 = R.id.radio_group5;
        final int editTextViewRes2 = R.id.edit_text_for_answer2;
        final int editTextViewRes3 = R.id.edit_text_for_answer3;
        questionTextView1 = findViewById(R.id.question);
        questionTextView2 = findViewById(R.id.question2);
        questionTextView3 = findViewById(R.id.question3);
        questionTextView4 = findViewById(R.id.question4);
        questionTextView5 = findViewById(R.id.question5);
        submit = findViewById(R.id.submit);
        questions.add(questionTextView1);
        questions.add(questionTextView2);
        questions.add(questionTextView3);
        questions.add(questionTextView4);
        questions.add(questionTextView5);
        checkBox1 = findViewById(R.id.checkbox4_1);
        checkBox2 = findViewById(R.id.checkbox4_2);
        checkBox3 = findViewById(R.id.checkbox4_3);
        checkBox4 = findViewById(R.id.checkbox4_4);
        checkBoxes = new ArrayList<>();
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);
        checkBoxes.add(checkBox4);

        int index = 0;

        for(TextView question : questions) {
            question.setText(questionAndResponses.getQuestion(index));
            index++;
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResponseForCheckBoxes();
                checkResponseForEditText(editTextViewRes2);
                 checkResponseForEditText(editTextViewRes3);
                checkResponseForRadioButton(radioGroup);
                checkResponseForRadioButton(radioGroup5);

                if(correctResponses == totalQuestions) {
                    Toast.makeText(MainActivity.this, "You answered all questions correctly!", Toast.LENGTH_SHORT).show();
                }

                else {
                    String message = "You answered " + String.valueOf(correctResponses) + " questions correctly out of " + String.valueOf(totalQuestions) + " questions";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
                correctResponses = 0;
            }
        });

    }


    private void checkResponseForRadioButton(int radioGroupId) {
        RadioGroup radioGroup = findViewById(radioGroupId);
        if(!(radioGroup.getCheckedRadioButtonId() == -1)) {
            RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            String res = radioButton.getText().toString();
            if(res.equals(questionAndResponses.getAnswer(ANSWER1)) || res.endsWith(questionAndResponses.getAnswer(ANSWER5))) {
                correctResponses++;
            }
        }

    }


    private void checkResponseForEditText(int editTextId) {
        EditText editText = findViewById(editTextId);
        if(!editText.getText().toString().equals("")){
            String response = editText.getText().toString();
            if(response.equals(questionAndResponses.getAnswer(ANSWER2)) || response.equals(questionAndResponses.getAnswer(ANSWER3))) {
                correctResponses++;
            }
        }

    }

    private void checkResponseForCheckBoxes() {
        for(AppCompatCheckBox checkBox : checkBoxes) {
            if(checkBox.isChecked() &&
                    checkBox.getText().
                            toString().
                            matches(questionAndResponses.getAnswer(ANSWER4))) {
                checkBoxCount++;
            }
        }

        if(checkBoxCount == questionAndResponses.getAnswer(ANSWER4).split("\\|").length) {
            correctResponses++;
        }
        checkBoxCount = 0;

    }
}
