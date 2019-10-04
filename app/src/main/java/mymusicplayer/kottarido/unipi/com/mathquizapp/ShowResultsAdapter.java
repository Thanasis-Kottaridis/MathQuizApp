package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ShowResultsAdapter extends RecyclerView.Adapter<ShowResultsAdapter.ShowResultsViewHolder> {

    private List<Question> questions;
    private List<Float> answers;

    public ShowResultsAdapter(Test test) {
        questions = test.getQuestions();
        answers = test.getAnswers();
    }

    public void setTest(Test test) {
        questions = test.getQuestions();
        answers = test.getAnswers();
    }

    @NonNull
    @Override
    public ShowResultsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.question_results_item,viewGroup,false);
        return new ShowResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowResultsViewHolder holder, int i) {
        // gets the question and users answer
        Question question = questions.get(i);
        float ans = answers.get(i);

        holder.question.setText(question.getQuestionStringFormat());
        holder.correctAns.setText(String.valueOf(question.getCorectAns()));
        holder.userAns.setText(String.valueOf(ans));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class ShowResultsViewHolder extends RecyclerView.ViewHolder{

        private TextView question;
        private TextView userAns;
        private TextView correctAns;


        public ShowResultsViewHolder(@NonNull View view) {
            super(view);

            question = view.findViewById(R.id.question_text_view);
            userAns = view.findViewById(R.id.userAnswer_text_view);
            correctAns = view.findViewById(R.id.corectAnswer_text_view);

        }
    }

}
