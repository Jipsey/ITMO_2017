package Patterns.Observer;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        Reactor reactor = new Reactor();


        reactor.addTempController(new TempController() {
            @Override
            public void answer(int temperature) {
                if (temperature >=1500)
                System.err.println("Warning! Reactor in the RED ZONE!" );
            }
        });

        reactor.addTempController(new TempController() {
            @Override
            public void answer(int temperature) {
                if (temperature < 1500 && temperature >= 750)
                System.out.println("Warning! Reactor in the YELLOW ZONE!");
            }
        });

        reactor.addTempController(new TempController() {
            @Override
            public void answer(int temperature) {
                if (temperature < 750)
                System.out.println("All OK, Reactor in the GREEN ZONE!");
            }
        });

        reactor.setTemp(2000);
    }
}
