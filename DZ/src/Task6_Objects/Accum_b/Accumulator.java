package Task6_Objects.Accum_b;
/**
 * б) Сделать аккумулятор, у которого в качестве значения массив, и такй же длины массив типа Operation[].
 * Каждой ячейке элемента массива значений соответствует операция из массива операций.
 При вызове метода calculate() для каждой ячейки применяется соответствующая ей операция.
 Например такие начальные значения в массивах (в вашем случае они должны задаваться конструктором):
 int[] values = {0, 0};
 Operation[] operations = {new Plus(), new Minus()};

 после вызова метода calculate(1) в values должны оказаться такие значения:
 |1|-1|
 При следующем вызове, например, calculate(5):
 |6|-6|

 Конструктор будет принимать два массива: int[] и Operation[].
 *
 */
public class Accumulator {
       double [] value; // поле хранящее вычисления
       private Operation[]  operation; // поле хранящее объекты типа Operation

      public Accumulator(double[] value, Operation [] operation){
          this.value = value;
          this.operation = operation;
      }

      public void calculate(double b){
          for (int i = 0; i < value.length ; i++) {
              if (i>1 && value[i] ==0){value[i]=1;}

              value[i] = operation[i].apply(value[i], b);
          }
      }
      double[] getValue(){
          return value;
    }
}
