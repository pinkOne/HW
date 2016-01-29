package ua.di1.cmdCalcUI;

import java.util.Scanner;

/**
 * Created by I on 21.01.2016.
 */
public class CmdCalcUI {

    private String  title   = ""; // general title for whole context
    private String  header  = ""; // header line for current activity
    private String  message = ""; // message for each time you show/query smth

    protected String operand_A;
    protected String operand_B;
    private String operation;

    private boolean typeTitle   = true;

    private String  exitWord    = "quit";
    private String  usage   = "\tthis works in 3 steps: get A, get B, apply operand."
            + "\n\tyou will be prompted to enter values and operand. Type \"" + exitWord + "\" for exit.";

    public void setTitle(String title) {
        this.title  = "\n<<<\t" + title + "\t>>>\n";
        this.title  += usage;
    }

    public void setHeader(String header) {
        this.header = "Current stage: " + header;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  CmdCalcUI(String title, String header, String message){
        setTitle(title);
        setHeader(header);
        setMessage(message);
    }
    public  CmdCalcUI(String title){
        setTitle(title);
    }
    public  CmdCalcUI(){
    }
    public  void    say(){
        if(typeTitle) {
            System.out.println(title);
            typeTitle   = false;
        }
        System.out.println(header);
        System.out.println(message);
    }
    public  void sayResult(String message){
        setMessage("RESULT is:" + message);
        say();
    }
    public  void say(String message){
        setMessage(message);
        say();
    }
    public  void prepareMessage(CalcState calcState, String message){
        setMessage(this.message + "; " +  calcState.name() + " is: " + message);
    }

    public String askUser(){
        say();

        String  out;
        System.out.print(">");
        Scanner scanner = new Scanner(System.in);
        out = scanner.next();
        //scanner.close(); do not required as this is standard input which needs to be opened until program exit
        //System.out.println(out);
        return  out;
    }
    private enum    CalcState {
        INPUT_A,
        INPUT_B,
        INPUT_OPERATION
    }
    private void    prepareUI(CalcState calcState){
        //System.out.println(calcState);
        setHeader(calcState.name());
    }

    protected void processOperation(String operation){
        switch (operation){
            case "+": sayResult( operand_A + "+" + operand_B ); break;
            case "-": sayResult( operand_A + "-" + operand_B ); break;
            case "*": sayResult( operand_A + "*" + operand_B ); break;
            case "/": sayResult( operand_A + "/" + operand_B ); break;
            default:    break;
        }
    }
    public  void start(){
        String  uInput;
        setMessage("\t\t\t\t");
        for (CalcState calcState: CalcState.values()) {

            prepareUI(calcState);

            uInput = askUser();
            if (uInput.equals(exitWord))break;

            switch (calcState){
                case INPUT_A:
                    operand_A   = uInput;
                    prepareMessage(calcState, uInput);
                    break;
                case INPUT_B:
                    operand_B   = uInput;
                    prepareMessage(calcState, uInput);
                    break;
                case INPUT_OPERATION:
                    operation   = uInput;
                    processOperation(operation);
                    break;
            }

        }
    }

    public static void main(String[] args) {
        CmdCalcUI   cmdCalcUI   = new CmdCalcUI("Welcome to cmd calculator");
        cmdCalcUI.start();
    }
}
