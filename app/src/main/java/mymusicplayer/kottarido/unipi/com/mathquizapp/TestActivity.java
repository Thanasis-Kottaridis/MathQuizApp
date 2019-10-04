package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    public static final String TEST_QUESTIONS_KEY = "test questions";

    private Intent intent;

    // list me ta questions
    private List<Question> questions;

    // metavlites gia diaxirisi ton fragment se auto to activity
    private SelectorPagerAdapter adapter;
    private ViewPager mViewPager;

    // bottomNavigationView
    private BottomNavigationView bottomNavigationView;

    // ta instance ton fragment pou tha provalei o viewPager
    private TestFragment testFragment;
    private CalculatorFragment calculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // kanei initialise ton adapter
        adapter = new SelectorPagerAdapter(getSupportFragmentManager());

        // vriskei to view pager
        mViewPager = findViewById(R.id.fragmentContainer);

        //vriskei to bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        intent = getIntent();
        // gets the questions from intent
        if(intent.hasExtra(MainActivity.EXTRA_TEST_QUESTIONS)){

            //kanei instantiate ta framgents
            testFragment = new TestFragment();
            calculatorFragment = new CalculatorFragment();

            // ftiaxnei ena bundle me tis questions kai to stelnei sto testFramgent
            // kai tou fortonei ta questions apo to intent
            Bundle bundle = new Bundle();
            bundle.putString(TEST_QUESTIONS_KEY, intent.getStringExtra(MainActivity.EXTRA_TEST_QUESTIONS));

            //kanei set to bundle san argument sto testFragment
            testFragment.setArguments(bundle);

        }


        //ti tha ginete kathe fora pou enas user epilegi ena item tou BNV
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // kanoume ena switch case gia na vroume poio item patithike
                switch (item.getItemId()){
                    case R.id.nav_test:
                        setViewPager(0);
                        break;
                    case R.id.nav_calculator:
                        setViewPager(1);
                        testFragment.setUseCalculator(true);
                        testFragment.setScoreMultiplier(0);
                        break;
                }
                //true simenei oti theloume na epistrepsoume to clicked item
                return true;
            }
        });

        // kanei setup ton viewPager
        setUpViewPager(mViewPager);
    }

    // method gia na kanei setup ton viewPager
    //i sira pou dilwnw ta fragment einai poli simantiki
    //gt to proto fragment pou dilwnw tha einai to default
    private void setUpViewPager(ViewPager viewPager){
        adapter.addFragment(testFragment, "Test Page");
        adapter.addFragment(calculatorFragment, "Calculator");
        viewPager.setAdapter(adapter);
    }

    //methodos gia na kanei set poio fragment trexei ston viewPager
    //einai pablic gia na mporoun na tin kalesoun ola ta fragment
    //prokimenou na mporw na paw apo to ena fragment sto alo
    public void setViewPager(int fragmentIndex){
        //tou lew poio apo ta fragment pou exw fortosei ston viewpager thelw
        // na metaferw (diladi thelw na emfanisw)
        mViewPager.setCurrentItem(fragmentIndex);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
