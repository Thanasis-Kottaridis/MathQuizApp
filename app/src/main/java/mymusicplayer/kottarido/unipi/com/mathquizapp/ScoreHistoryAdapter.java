package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ScoreHistoryAdapter extends RecyclerView.Adapter<ScoreHistoryAdapter.ScoreHistoryViewHolder> {

    private List<Test> myTests;

    private OnItemClickListener listener;

    public ScoreHistoryAdapter(List<Test> myTests) {
        this.myTests = myTests;
    }

    public void setMyTests(List<Test> myTests) {
        this.myTests = myTests;
    }

    @NonNull
    @Override
    public ScoreHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.best_scores_item,viewGroup,false);
        return new ScoreHistoryViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull ScoreHistoryViewHolder holder, int i) {
        Test test = myTests.get(i);
        holder.scoreTextView.setText(String.valueOf(test.getScore()));
    }

    @Override
    public int getItemCount() {
        return myTests.size();
    }

    class ScoreHistoryViewHolder extends RecyclerView.ViewHolder{

        private TextView scoreTextView;

        public ScoreHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            scoreTextView = itemView.findViewById(R.id.score_score);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener != null && pos != RecyclerView.NO_POSITION) {
                        listener.onItemClick(myTests.get(pos));
                    }
                }
            });
        }
    }

    //gia na ftia3oume event sto onClick tou kathe item tou recycle view
    //prepei na ftia3oume enan listener(interface)

    public interface OnItemClickListener{
        void onItemClick(Test song);
    }

    // episis dimiourgoume kai tin methodo setOnItemClickListener
    // i opoia dexete ena instance pou kanei implement to onItemClickListener
    // gia na ipoxreosoume opoion to kalei na kanei implement to interface mas

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
