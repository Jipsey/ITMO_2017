/**
 * LazyAccumulator. Считает результат только при вызове метода int calculate().
 * В конструктор принимает интерфейс List, который будет использоваться для хранения промежуточных операций.
 Принцип следующий.
 Пользователь вызывает метод LazyAccumulator add(int a, Operation oper),
 который сохраняет аргументы и операцию в списке. При вызове calculate() возвращает вычисленный результат. Например:
 lazyAcc.add(1, new Plus());
 lazyAcc.add(3, new Minus();
 lazyAcc.calculate() == -2.
 */
package Task6_Objects.LazyAccum;


public class MainLazyAccum {

    public static void main(String[] args) {


      //  Accamulator accum = new Accamulator(3,list);


    }
}
