package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ShowResultsActivity extends AppCompatActivity {

    // to test pou theloume na doume ta apotelesmata tou
    private Test test;

    private TextView scoreTextView;
    private TextView timeTextView;
    private Button menuButton;

    // gia to recycler view ton apantiseon tou user
    private RecyclerView mView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        // vriskei ta views
        scoreTextView = findViewById(R.id.show_results_score);
        timeTextView = findViewById(R.id.show_results_time);
        menuButton = findViewById(R.id.menu_button);

        // elenxoume an to intent exei extras
        Intent intent = getIntent();
        if(intent.hasExtra(TestFragment.EXTRA_TEST)){
            // tote diavazei to test apo to intent
            String json = intent.getStringExtra(TestFragment.EXTRA_TEST);
            //ftisxnei ena neo gson obj
            Gson gson = new Gson();
            //dilwnw ton tipo pou tha ginei metatropei to string pou diavasa
            Type type = new TypeToken<Test>() {
            }.getType();
            //ftiaxnw to gason metatrepontas to string sto type pou orisa
            test = gson.fromJson(json, type);
        }

        // kanei set up ta text views
        scoreTextView.setText(String.valueOf(test.getScore()));
        timeTextView.setText(test.getTime());

        // sto onclick tou menu button
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // kanei setUp to recycler View
        mView = findViewById(R.id.questions_results_view);

        // kanei setup to recycler view
        mlayoutManager = new LinearLayoutManager(this);
        mView.setLayoutManager(mlayoutManager);

        //kanoume instantiate ton adapter pou dimiourgisame
        //kai pername ton adapter sto view
        //me auton ton tropo leme pos na xiristei ta items
        mAdapter = new ShowResultsAdapter(test);
        mView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
