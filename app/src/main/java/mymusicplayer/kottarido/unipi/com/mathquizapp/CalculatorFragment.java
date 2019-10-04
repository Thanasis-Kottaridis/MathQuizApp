package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorFragment extends Fragment {

    // ta views tou fragment
    private TextView operationTextView;
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
    private Button buttonEqual;
    private Button button_add;
    private Button button_sub;
    private Button button_mul;
    private Button button_div;

    private Button button_clear;

    // listener gia ta koumpia apo to kompiouteraki
    private View.OnClickListener calculatorButtonsListener;

    // flags gia na ginonte oi pra3is
    private String operandX;
    private String operandY;
    // to -1 dixnei oti den exei anathethei akoma pra3i
    private int operator;

    //question obj to opoio tha ipologizei tis pra3is
    private Question quest;

    //flag
    private boolean newOperation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //arxikopoiei ta flags
        // to x me 0 kai to y me keno
        operandX = "0";
        operandY ="";
        // to -1 dixnei oti den exei anathethei akoma pra3i
        operator = -1;
        newOperation = true;

        View view = inflater.inflate(R.layout.test_calculator_fragment_layout,container,false);
        // vriskei ta views
        operationTextView = view.findViewById(R.id.operation_textView);
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
        buttonEqual = view.findViewById(R.id.test_button_equal);
        button_add = view.findViewById(R.id.test_button_add);
        button_sub = view.findViewById(R.id.test_button_sub);
        button_mul = view.findViewById(R.id.test_button_mul);
        button_div = view.findViewById(R.id.test_button_div);
        button_clear = view.findViewById(R.id.test_button_clear);

        //onclick listener gia ta calculator buttons
        calculatorButtonsListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.equals(button1)){
                    if(newOperation){
                        operandX = "1";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "1";
                            operationTextView.setText(operandX);
                        }
                        else {
                            operandY = operandY + "1";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button2)){
                    if(newOperation){
                        operandX = "2";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "2";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "2";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button3)){
                    if(newOperation){
                        operandX = "3";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "3";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "3";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button4)){
                    if(newOperation){
                        operandX = "4";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "4";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "4";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button5)) {
                    if(newOperation){
                        operandX = "5";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "5";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "5";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button6)){
                    if(newOperation){
                        operandX = "6";
                        newOperation = false;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "6";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "6";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button7)){
                    if(newOperation){
                        operandX = "7";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "7";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "7";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button8)){
                    if(newOperation){
                        operandX = "8";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "8";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "8";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button9)){
                    if(newOperation){
                        operandX = "9";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "9";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "9";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if (view.equals(button0)) {
                    if(newOperation){
                        operandX = "0";
                        newOperation = false;
                        operandY = "";
                        operator = -1;
                        operationTextView.setText(operandX);
                    }
                    else {
                        if (operator == -1) {
                            operandX = operandX + "0";
                            operationTextView.setText(operandX);
                        } else {
                            operandY = operandY + "0";
                            operationTextView.setText(operandY);
                        }
                    }
                }
                else if(view.equals(button_add)){
                    if(newOperation){
                        operator = 0;
                        newOperation = false;
                        operandY = "";
                    }
                    else {
                        if(operandY.equals("")){
                            operator = 0;
                        }
                        else {
                            quest = new Question(operandX,operandY,operator);
                            float temp = quest.getCorectAns();
                            if(temp == (int)temp)
                                operandX = String.valueOf((int)temp);
                            else
                                operandX = String.valueOf(temp);
                            operationTextView.setText(operandX);
                            operandY = "";
                        }
                    }

                }
                else if(view.equals(button_sub)){
                    if(newOperation){
                        operator = 1;
                        newOperation = false;
                        operandY = "";
                    }
                    else {
                        if(operandY.equals("")){
                            operator = 1;
                        }
                        else {
                            quest = new Question(operandX,operandY,operator);
                            float temp = quest.getCorectAns();
                            if(temp == (int)temp)
                                operandX = String.valueOf((int)temp);
                            else
                                operandX = String.valueOf(temp);
                            operationTextView.setText(operandX);
                            operandY = "";
                        }
                    }
                }
                else if(view.equals(button_mul)){
                    if(newOperation){
                        operator = 2;
                        newOperation = false;
                        operandY = "";
                    }
                    else {
                        if(operandY.equals("")){
                            operator = 2;
                        }
                        else {
                            quest = new Question(operandX,operandY,operator);
                            float temp = quest.getCorectAns();
                            if(temp == (int)temp)
                                operandX = String.valueOf((int)temp);
                            else
                                operandX = String.valueOf(temp);
                            operationTextView.setText(operandX);
                            operandY = "";
                        }
                    }
                }
                else if(view.equals(button_div)){
                    if(newOperation){
                        operator = 3;
                        newOperation = false;
                        operandY = "";
                    }
                    else {
                        if(operandY.equals("")){
                            operator = 3;
                        }
                        else {
                            quest = new Question(operandX,operandY,operator);
                            float temp = quest.getCorectAns();
                            if(temp == (int)temp)
                                operandX = String.valueOf((int)temp);
                            else
                                operandX = String.valueOf(temp);
                            operationTextView.setText(operandX);
                            operandY = "";
                        }
                    }
                }
                else if (view.equals(button_clear)) {
                    // an o telestis y den exei arxikopoiithei akoma
                    if(operandY.equals("")){
                       // kanei reset to X kai ton opperator
                        operandX = "0";
                        operator = -1;
                        newOperation = true;
                        operationTextView.setText(operandX);
                    }
                    else {
                        operandY = "";
                        operationTextView.setText("0");
                    }

                }
                else if(view.equals(buttonEqual)){
                    if(operator != -1){
                        if(operandY.equals("")){
                            quest = new Question(operandX,operandX,operator);
                            float temp = quest.getCorectAns();
                            if(temp == (int)temp)
                                operandX = String.valueOf((int)temp);
                            else
                                operandX = String.valueOf(temp);
                            operationTextView.setText(operandX);
                        }
                        else {
                            quest = new Question(operandX,operandY,operator);
                            float temp = quest.getCorectAns();
                            if(temp == (int)temp)
                                operandX = String.valueOf((int)temp);
                            else
                                operandX = String.valueOf(temp);
                            operationTextView.setText(operandX);
                            newOperation = true;
                        }
                    }
                }
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
        button_add.setOnClickListener(calculatorButtonsListener);
        button_sub.setOnClickListener(calculatorButtonsListener);
        button_mul.setOnClickListener(calculatorButtonsListener);
        button_div.setOnClickListener(calculatorButtonsListener);
        button_clear.setOnClickListener(calculatorButtonsListener);
        buttonEqual.setOnClickListener(calculatorButtonsListener);

        return view;
    }
}
