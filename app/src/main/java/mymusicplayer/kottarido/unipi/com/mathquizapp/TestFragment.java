package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestFragment extends Fragment {
    public static final String EXTRA_TEST ="com.unipi.kottarido.mathquizapp.EXTRA_TEST";

    //o arxikos xronos pou exei o user gia kathe test se milliseconds (1:30 MIN)
    public static final long START_TIME_IN_MILLIS = 60000;

    // list me tis questions
    private List<Question> questions;
    // lista me tis apantisis tou user
    private List<Float> answers;

    // ta views tou fragment
    private TextView timerTextView;
    private TextView scoreTextView;
    private TextView questionTextView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonPoint;
    private Button buttonAC;
    private Button nextButton;

    //List me views pou periexei ola ta buttons
    private List<View> calculatorButtonsList;

    // listener gia ta koumpia apo to kompiouteraki
    private View.OnClickListener calculatorButtonsListener;

    // gia tton timer
    private CountDownTimer mCountDownTimer;

    //Flags
    private int currentPos; // krataei tin thesei tis erotisis pou vriskomaste
    private String currentQuestion; // karataei to string tis erotisis se morfi (operand_x operator operand_y)
    private String currentAnswer;
    private long currentScore;
    private boolean useCalculator;
    private boolean outOfTime;
    private boolean pointUse; //elenxei an exei xrisimopoiithei ipodiastoli

    private int scoreMultiplier; // se kathe sosti apantisi perneis 100 pontous (an apantisis sota polaplasiazete me ton multiplier)
    // leei posos xronos apomenei akoma ston timer
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_test_fragment_layout, container, false);

        // vriskei ta views
        timerTextView = view.findViewById(R.id.timer_text_view);
        scoreTextView = view.findViewById(R.id.score_text_view);
        questionTextView = view.findViewById(R.id.QuestionTextView);
        button1 = view.findViewById(R.id.test_button_1);
        button2 = view.findViewById(R.id.test_button_2);
        button3 = view.findViewById(R.id.test_button_3);
        button4 = view.findViewById(R.id.test_button_4);
        button5 = view.findViewById(R.id.test_button_5);
        button6 = view.findViewById(R.id.test_button_6);
        button7 = view.findViewById(R.id.test_button_7);
        button8 = view.findViewById(R.id.test_button_8);
        button9 = view.findViewById(R.id.test_button_9);
        button0 = view.findViewById(R.id.test_button_0);
        buttonPoint = view.findViewById(R.id.test_button_point);
        buttonAC = view.findViewById(R.id.test_button_clear);
        nextButton = view.findViewById(R.id.next_Button);

        //
        //FORTONEI TA ARGUMENTS APO TO BUNDLE
        //
        if (getArguments() != null) {
            // fortonei to json me ta questions apo ta arguments
            getQuestionsFromJson(getArguments().getString(TestActivity.TEST_QUESTIONS_KEY));

            //arxikopoiei tis answers
            answers = new ArrayList<>();

            // kanei initialise ta flags
            currentPos = 0;
            currentScore = 0;
            setQuestion();
            useCalculator = false;
            outOfTime = false;

            //arxizei ton timer
            mCountDownTimer = new CountDownTimer(90000, 1000) {
                @Override
                public void onTick(long l) {
                    mTimeLeftInMillis = l;

                    if (mTimeLeftInMillis / 1000 < 30)
                        timerTextView.setTextColor(ContextCompat.getColor(getActivity(), R.color.timerRed));
                    else if (mTimeLeftInMillis / 1000 < 60)
                        timerTextView.setTextColor(ContextCompat.getColor(getActivity(), R.color.timerOrange));

                    timerTextView.setText("" + (l / 1000) / 60 + ":" + (l / 1000) % 60);
                }

                @Override
                public void onFinish() {
                    // enimeronei to flag oti teliose o xronos tou
                    outOfTime = true;
                    timerTextView.setText("Time's Up!");
                }
            }.start();
        }

        //
        //FTIAXNEI TA ONCLICK EVENT GIA KATHE BUTTON
        //

        //onclick listener gia ta calculator buttons
        calculatorButtonsListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.equals(button1))
                    currentAnswer = currentAnswer + "1";
                else if (view.equals(button2))
                    currentAnswer = currentAnswer + "2";
                else if (view.equals(button3))
                    currentAnswer = currentAnswer + "3";
                else if (view.equals(button4))
                    currentAnswer = currentAnswer + "4";
                else if (view.equals(button5))
                    currentAnswer = currentAnswer + "5";
                else if (view.equals(button6))
                    currentAnswer = currentAnswer + "6";
                else if (view.equals(button7))
                    currentAnswer = currentAnswer + "7";
                else if (view.equals(button8))
                    currentAnswer = currentAnswer + "8";
                else if (view.equals(button9))
                    currentAnswer = currentAnswer + "9";
                else if (view.equals(button0))
                    currentAnswer = currentAnswer + "0";
                else if (view.equals(buttonPoint)) {
                    if (!pointUse) {
                        currentAnswer = currentAnswer + ".";
                        pointUse = true;
                    }
                }
                else if (view.equals(buttonAC)) {
                    currentAnswer = "";
                    pointUse = false;
                }


                questionTextView.setText(currentQuestion + currentAnswer);
            }
        };

        // vazei ton onclick listener sta calculator buttons
        button1.setOnClickListener(calculatorButtonsListener);
        button2.setOnClickListener(calculatorButtonsListener);
        button3.setOnClickListener(calculatorButtonsListener);
        button4.setOnClickListener(calculatorButtonsListener);
        button5.setOnClickListener(calculatorButtonsListener);
        button6.setOnClickListener(calculatorButtonsListener);
        button7.setOnClickListener(calculatorButtonsListener);
        button8.setOnClickListener(calculatorButtonsListener);
        button9.setOnClickListener(calculatorButtonsListener);
        button0.setOnClickListener(calculatorButtonsListener);
        buttonPoint.setOnClickListener(calculatorButtonsListener);
        buttonAC.setOnClickListener(calculatorButtonsListener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float userAns = Float.valueOf(currentAnswer);
                    // prosthetei tin apantisei stin lista me tis apantisis
                    answers.add(userAns);

                    if (currentPos + 1 < questions.size()) {
                        // checks if the answer is correct and calculates/ updates the score
                        if (userAns == questions.get(currentPos).getCorectAns() && !outOfTime) {
                            scoreMultiplier += 1;
                            currentScore = currentScore + (100 * scoreMultiplier);
                        } else {
                            scoreMultiplier = 0;
                        }

                        currentPos = currentPos + 1;
                        setQuestion();
                    } else {
                        // ftiaxnei to antikimeno tou test to opoio periexei ola ta
                        // apotelesmeta kai ta statistika pou xriazomaste
                        // elenxei an imaste ektos xronikou oriou i oxi
                        Test test;
                        if (!outOfTime) {
                            // au3anei to score prosthetontas ta milliseconds pou exoun minei / 100
                            currentScore = currentScore + mTimeLeftInMillis / 100;
                            long testTime = START_TIME_IN_MILLIS - mTimeLeftInMillis;

                            test = new Test(questions, answers, currentScore, "" + (testTime / 1000) / 60 + ":" + (testTime / 1000) % 60, useCalculator, !outOfTime);
                            //fortonei ola ta test pou einai kataxorimena


                        } else {
                            test = new Test(questions, answers, currentScore, "Time's Up!", useCalculator, !outOfTime);
                        }
                        List<Test> myTests = ShearedPreferencesHealper.loadMyTests(getActivity());

                        if (myTests != null) {
                            myTests.add(test);
                        } else {
                            myTests = new ArrayList<>();
                            myTests.add(test);
                        }

                        // apothikeuei ta myTests sta SP
                        ShearedPreferencesHealper.saveMyTest(getActivity(), myTests);
                        Toast.makeText(getActivity(), "test complete", Toast.LENGTH_LONG).show();

                        // kanei to test jason
                        Gson gson = new Gson();
                        String json = gson.toJson(test);

                        // vazei sto intent to test pou lisame molis
                        Intent intent = new Intent(getActivity(), ShowResultsActivity.class);
                        intent.putExtra(EXTRA_TEST, json);

                        startActivity(intent);
                        getActivity().finish();
                    }
                }
                catch (Exception e){
                    ShowMessage("You Have To Answer The Question");
                }
            }
        });

        return view;
    }

    private void setQuestion() {
        //fortonei tin erotisi se string format
        currentQuestion = questions.get(currentPos).getQuestionStringFormat();
        currentAnswer = ""; //arxikopoiei tin apantisi tou xristi me keno
        pointUse = false; // arxikopoiei tin point use me false
        // enimeronei to questionTextView
        questionTextView.setText(currentQuestion);
        // enimeronei to current score
        scoreTextView.setText(String.valueOf(currentScore));
    }

    public boolean isUseCalculator() {
        return useCalculator;
    }

    public void setUseCalculator(boolean useCalculator) {
        this.useCalculator = useCalculator;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    private void getQuestionsFromJson(String json) {
        //ftisxnei ena neo gson obj
        Gson gson = new Gson();
        //dilwnw ton tipo pou tha ginei metatropei to string pou diavasa
        Type type = new TypeToken<ArrayList<Question>>() {
        }.getType();
        //ftiaxnw to gason metatrepontas to string sto type pou orisa
        questions = gson.fromJson(json, type);
    }

    public void ShowMessage(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle("Wrong Answer!");
        builder.setMessage(s);
        builder.show();
    }
}
