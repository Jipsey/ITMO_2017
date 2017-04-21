package Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Reactor {
    private List<TempController> answers = new ArrayList<>();

    public void addTempController(TempController tListener){
          answers.add(tListener);
    }

    public void delTempController (TempController tListener){
        answers.remove(tListener);
    }

    public void setTemp(int temp){
        System.out.println("Current temperature of the Reactor: " + temp);

        notifyControllers(temp);
    }


    private void  notifyControllers(int temp){
            for (TempController tControllers:answers  )
                tControllers.answer(temp);
            }
        }