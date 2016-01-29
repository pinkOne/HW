package ua.di1.uNumber;

import com.sun.istack.internal.NotNull;

/**
 * Created by I on 21.01.2016.
 */
public class Number_I {
    private Integer value;

    public Number_I(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    
    // - сложение
    public Number_I add(Number_I number) {
        Integer  result;
        result    = this.getValue() + number.getValue();
        return new Number_I(result);
    }

    // - вычитание
    public Number_I subtract(Number_I number) {
        Integer  result;
        result    = this.getValue() - number.getValue();
        return new Number_I(result);
    }
    
    // - умножение
    public Number_I multiply(Number_I number) {
        Integer  result;
        result    = this.getValue() * number.getValue();
        return new Number_I(result);
    }

    // - деление
    public Number_I divide(Number_I number) {
        Integer  result;
        result    = this.getValue() / number.getValue();
        return new Number_I(result);
    }

    // - возведение в степень
    public Number_I power(Number_I number) {
        Integer  result = 0;
        if (number.getValue() == 0) result = 1;
        if (number.getValue() >= 1) result = this.getValue();

        for (int i = 2; i <= number.getValue() ; i++){
            result  *= result;
        }
        return new Number_I(result);
    }

    // - вычисление факториала
    @NotNull
    private Integer factorial(Integer number) {
        return (number == 0) ? 1 : number * factorial(number - 1);
    }
    public Number_I factorial(Number_I number) {
        Integer  result;
        result    = factorial(number.getValue());
        return new Number_I(result);
    }

    // - вычисление остатка от деления
    public Number_I reminder(Number_I number) {
        Integer  result;
        result    = this.getValue() % number.getValue();
        return new Number_I(result);
    }

    // - метод который сравнивает два числа
    public Number_I compare(Number_I number) {
        Integer  result;
        result    = this.getValue() - number.getValue();
        return new Number_I(result);
    }
}
