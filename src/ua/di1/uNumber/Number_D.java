package ua.di1.uNumber;

/**
 * Created by I on 21.01.2016.
 */
public class Number_D {

    private Double value;

    public Number_D(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    // - сложение
    public Number_D add(Number_D number) {
        Double  result;
        result    = this.getValue() + number.getValue();
        return new Number_D(result);
    }

    // - вычитание
    public Number_D subtract(Number_D number) {
        Double  result;
        result    = this.getValue() - number.getValue();
        return new Number_D(result);
    }

    // - умножение
    public Number_D multiply(Number_D number) {
        Double  result;
        result    = this.getValue() * number.getValue();
        return new Number_D(result);
    }

    // - деление
    public Number_D divide(Number_D number) {
        Double  result;
        result    = this.getValue() / number.getValue();
        return new Number_D(result);
    }

    // - возведение в степень
    public Number_D power(Number_D number) {
        Double  result;
        result    = Math.pow(this.getValue(), number.getValue());
        return new Number_D(result);
    }

    // - вычисление факториала - not applicable to Double
    public int factorial(Number_D number) throws Throwable{
        String  message = "Factorial is not applicable to Double. "
            + "You cannot get factorial for this Number_D type. "
            + "Use Number_I instead.";
        throw (new Throwable(message));
    }

    // - вычисление остатка от деления
    public Number_D reminder(Number_D number) {
        Double  result;
        result    = this.getValue() % number.getValue();
        return new Number_D(result);
    }

    // - метод который сравнивает два числа
    public Number_D compare(Number_D number) {
        Double  result;
        result    = this.getValue() - number.getValue();
        return new Number_D(result);
    }
}
