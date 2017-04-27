package Patterns.Singleton;
import static Patterns.Singleton.Factory.Reg.*;
/**
 *
 */

public abstract class Factory implements Car {
    enum Reg{RU,JP,GE}

    private static final Factory VAZ = new Factory() {

        @Override
        public boolean drive(int speed) {
            if (speed<175) return true;
            return false;
        }
    };

    private static final Factory TOYOTA = new Factory() {
        @Override
        public boolean drive(int speed) {
            if (speed<195) return true;
            return false;
        }
    };

    private static final Factory BavariaMotors = new Factory() {
        @Override
        public boolean drive(int speed) {
            if (speed<230) return true;
            return false;
        }
    };

    private Factory(){
    }


   public static Factory getFactory(Reg region){
       if (region.equals(RU)) return VAZ;
       if (region.equals(JP)) {return TOYOTA;}
       else if (region.equals(GE)) return BavariaMotors;
       return null;
    }

}

