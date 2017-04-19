package Task6_Objects.List_new;

/** в данном интерфейсе указываем методы add() get() и remove()
 *
 */
public interface List {

    void add(Object val);

    Object get(int i) throws Exception;

    Object remove(int i);

    int size();


}
