package Task6_Objects.List_new;

/**
 *
 */

public class MyLinkedList implements List{

    Item head;// первое значение списка заносим в поле типа Item
    Item previus;
    Item next;

    @Override
    public void add(Object val) {
       if(head == null ){ head = new Item(val); return; }


       for(Item prev = head ;;){
           Item next = prev.next;

           if(next == null){ prev.next = new Item(val); return; }

           prev = next;
       }

    }


    @Override
    public Object get(int i) {
        if (head == null){return null;}

        if (i==0){return head.val;}


        int counter =1;
        for (Item prev = head;;){
             Item next = prev.next;

             if(next.next == null){return null;}

             if(counter == i){ return next.val; }
             counter++;

             prev = next;
        }

    }



    @Override
    public Object remove(int i) {
          if (head == null){return null;}

          if (i== 0){Item temp = head;
              head = head.next;
              return temp.val;
          }

          int counter =1;

         for(Item prev = head;;){
             Item next = prev.next;

             if(counter == i){
                 if (next.next != null){ prev.next = next.next; return next.val;}
                 else
                       return prev.val ;}
             counter++;
             prev = next;

         }
    }



    public Object remove (Object object){
        if (head == null){ return null;}
       if (head.next == null){ return head;}

        int counter =1;

       // for ( ){ ;}

        return object;
    }



    public class Item{
        Object val;

        Item next;

        public Item(Object val){
        this.val = val;
        }

    }

}
