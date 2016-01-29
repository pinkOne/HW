package ua.di1.uNumber;

/**
 * Created by I on 23.01.2016.
 */
public class CmdCalcUID extends ua.di1.cmdCalcUI.CmdCalcUI{

    public CmdCalcUID(String title) {
        super(title);
    }

    protected void processOperation(String operation){
        Number_D operandA   = new Number_D(Double.valueOf(operand_A));
        Number_D operandB   = new Number_D(Double.valueOf(operand_B));
        Double  result  = 0.0;
        switch (operation){
            case "-": result    = operandA.getValue() - operandB.getValue();break;
            case "*": result    = operandA.getValue() * operandB.getValue(); break;
            case "+": result    = operandA.getValue() + operandB.getValue(); break;
            case "/": result    = operandA.getValue() / operandB.getValue(); break;
            default:    break;
        }
        sayResult( result.toString() );
    }

    public static void main(String[] args) {
        CmdCalcUID   cmdCalcUID   = new CmdCalcUID("Welcome to cmd calculator");
        cmdCalcUID.start();
    }
}
