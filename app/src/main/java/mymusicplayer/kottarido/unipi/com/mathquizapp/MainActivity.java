package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEST_QUESTIONS = "com.unipi.kottarido.mathquizapp.EXTRA__TEST_QUESTIONS";

    // lista pou krataei tis apantisis ton test pou einai kataxorimenes sto sistima
    private List<Test> testAnswers;

    // lista pou tha periexei tis dinamikes erotisis
    private List<Question> questions;

    // view tou button
    private Button startTestButton;

    //gia to RecycleView
    private RecyclerView mView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    // random generator pou tha xrisimopoiithoun gia tin dimiourgia ton erotiseon
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fortonei ta tests apo SP
        testAnswers = ShearedPreferencesHealper.loadMyTests(this);
        //elenxei an to test Answers einai null
        if (testAnswers == null){
            testAnswers = new ArrayList<>();
        }

        // vriskei to view tou button
        startTestButton = findViewById(R.id.start_test_button);
        mView = findViewById(R.id.Best_scores_view);

        // kanei setup to recycler view
        mlayoutManager = new LinearLayoutManager(this);
        mView.setLayoutManager(mlayoutManager);

        //kanoume instantiate ton adapter pou dimiourgisame
        //kai pername ton adapter sto view
        //me auton ton tropo leme pos na xiristei ta items
        mAdapter = new ScoreHistoryAdapter(findTop10Scores());
        mView.setAdapter(mAdapter);

        //ftiaxnei to event sto onClick tou kathe item tou recycler view
        ((ScoreHistoryAdapter) mAdapter).setOnItemClickListener(new ScoreHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Test test) {

                // kanei to test jason
                Gson gson = new Gson();
                String json = gson.toJson(test);

                // vazei sto intent to test pou lisame molis
                Intent intent = new Intent(getApplicationContext(), ShowResultsActivity.class);
                intent.putExtra(TestFragment.EXTRA_TEST, json);

                startActivity(intent);

            }
        });


        // on click listener sto button
        // ftiaxnei dinamika 10 erotisis (questions) gia to test
        // kai tis pernaei sto Test activity
        startTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kanei initialise tin list me tis questions
                questions = new ArrayList<>();
                // kanei initialise ton random generator
                random = new Random();

                // ftiaxnei dinamika ta 10 tests
                for (int i = 0; i < 10; i++){
                    // telesteos 1 (0 - 99)
                    int operand_x = random.nextInt(100);
                    // telesteos 2 (0 - 99)
                    int operand_y = random.nextInt(100);
                    // telestis (+,-,*,/) apo (0 - 3)
                    int operator = random.nextInt(4);

                    // ftiaxnei tin erotisi kai tin vazei stin questions
                    questions.add(new Question((float) operand_x,(float) operand_y,operator));
                }
                // metatrepei tin questions se json
                Gson gson = new Gson();
                String json = gson.toJson(questions);

                //stelnei to json me intent sto Test Activity
                Intent intent = new Intent(getApplicationContext(),TestActivity.class);
                intent.putExtra(EXTRA_TEST_QUESTIONS,json);
                startActivity(intent);


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // fortonei ta tests apo SP
        testAnswers = ShearedPreferencesHealper.loadMyTests(this);
        //elenxei an to test Answers einai null
        if (testAnswers == null){
            testAnswers = new ArrayList<>();
        }

        // kanei setup ton adapter
        ((ScoreHistoryAdapter)mAdapter).setMyTests(findTop10Scores());
        mView.setAdapter(mAdapter);
    }

    private List<Test> findTop10Scores(){
        Collections.sort(testAnswers);
        Collections.reverse(testAnswers);
        if(testAnswers.size()>10)
            return testAnswers.subList(0,9);
        else
            return testAnswers;
    }
}
