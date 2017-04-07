package Task6_Objects.List;

import java.util.Iterator;

/**
 *
 */
public class ArrayList implements List{
    int volume;// размер массива
    int num; //количество свободны мест
    Object [] object;

    public ArrayList (){

        Object[] object = new Object[this.volume];
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public Object remove(int index) {
        return object[index]=0;
    }

    @Override
    public Object get(int i) {
        return null;
    }



    private void MakeBigger(){


    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
