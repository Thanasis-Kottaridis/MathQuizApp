package mymusicplayer.kottarido.unipi.com.mathquizapp;

public class Question {
    // telesteos 1
    private float operand_x;
    // telesteos 2
    private float operand_y;
    // telestis (+,-,*,/)
    private int operator;

    // krataei tin sosti apantisi
    private float corectAns;

    public Question(String operand_x, String operand_y, int operator) {
        this.operand_x = Float.valueOf(operand_x);
        this.operand_y = Float.valueOf(operand_y);
        this.operator = operator;

        // an operator einai 0 tote kanei prosthesi
        if(operator == 0) {
            corectAns = this.operand_x + this.operand_y;
        }
        // kanei aferesi
        else if(operator == 1) {
            corectAns = this.operand_x - this.operand_y;
        }
        // kanei polaplasiasmo
        else if (operator == 2)
            corectAns = this.operand_x * this.operand_y;
            // kanei dieresi
        else
            corectAns = this.operand_x / this.operand_y;
    }

    public Question(float operand_x, float operand_y, int operator) {
        this.operand_x = operand_x;
        this.operand_y = operand_y;
        this.operator = operator;

        // an operator einai 0 tote kanei prosthesi
        if(operator == 0) {
            corectAns = operand_x + operand_y;
        }
        // kanei aferesi
        else if(operator == 1) {
            if (operand_x > operand_y) {
                corectAns = operand_x - operand_y;
            } else {
                this.operand_y = operand_x;
                this.operand_x = operand_y;
                corectAns = operand_y - operand_x;
            }
        }
        // kanei polaplasiasmo
        else if (operator == 2)
            corectAns = operand_x * operand_y;
        // kanei dieresi
        else
            corectAns = operand_x / operand_y;
    }

    public float getOperand_x() {
        return operand_x;
    }

    public void setOperand_x(int operand_x) {
        this.operand_x = operand_x;
    }

    public float getOperand_y() {
        return operand_y;
    }

    public void setOperand_y(int operand_y) {
        this.operand_y = operand_y;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public float getCorectAns() {
        return corectAns;
    }

    public String getQuestionStringFormat(){
        String x = String.valueOf((int)operand_x);
        String y = String.valueOf((int)operand_y);

        // kanei prosthesi
        if(operator == 0)
            return   x+" + "+y+" = ";
            // kanei aferesi
        else if(operator == 1)
            return   x+" - "+y+" = ";
            // kanei polaplasiasmo
        else if (operator == 2)
            return   x+" * "+y+" = ";
            // kanei dieresi
        else
            return   x+" / "+y+" = ";

    }
}
