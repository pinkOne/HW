package ua.di1.algo.rec.intro;

/**
 * Created by serhii on 07.02.16.
 */
public class RecIntro {

    public static void main(String[] args) {
        int res = fibb(6);
    }


    public static void foo(){
        foo();
    }

    public static int iter(int i){
        if(i == 11){
            return i;
        } else {
            return i + iter(i);
        }
    }


    public static int fibb(int num){
        if(num == 1 || num == 2){
            return 1;
        }

        int prev1 = fibb(num - 1);
        int prev2 = fibb(num - 2);

        return prev1 + prev2;

    }
}
