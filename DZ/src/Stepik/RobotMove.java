package Stepik;

/**
 *
 */
public class RobotMove {
    public static void main(String[] args) {

    Robot robot = new Robot(0,0,Direction.DOWN);

        robot.moveRobot(robot,- 6,7);
        robot.moveRobot(robot,3,3);
       // robot.moveRobot(robot,-26,26);

        System.out.printf("%s\t %s\t %s\t",robot.getX(),robot.getY(), robot.getDirection());
    }
    public enum Direction {UP, DOWN, LEFT, RIGHT}

    public static class Robot {
         int x;
         int y;
         Direction dir;

         public Robot(int x,int y, Direction dir){
             this.x = x;
             this.y = y;
             this.dir = dir;

         }
        public Direction getDirection() {
                 return dir;      // текущее направление взгляда
        }

        public int getX() {
                 return x;        // текущая координата X
        }

        public int getY() {
                 return y;       // текущая координата Y
        }

        public void turnLeft() { // повернуться на 90 градусов против часовой стрелки
          switch (dir){
            case  UP: dir = Direction.LEFT;
                break;
            case DOWN: dir = Direction.RIGHT;
                break;
            case LEFT: dir = Direction.DOWN;
                break;
            case RIGHT: dir = Direction.UP;
                break;}
          }

        public void turnRight() {  // повернуться на 90 градусов по часовой стрелке
            switch (dir){
                case  UP: dir = Direction.RIGHT;
                    break;
                case DOWN: dir = Direction.LEFT;
                    break;
                case LEFT: dir = Direction.UP;
                    break;
                case RIGHT: dir = Direction.DOWN;
                    break;}
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
            switch (dir){
                case  UP: y++ ;
                    break;
                case DOWN: y--;
                    break;
                case LEFT: x--;
                    break;
                case RIGHT: x++;
                    break;}
         }

        public static void moveRobot(Robot robot, int toX, int toY) {
//            robot.stepForward(); // your implementation here
                  int xMove = Math.abs(robot.getX()-toX);
                  int yMove = Math.abs(robot.getY()-toY);

            switch (robot.getDirection()){
                case  UP: robot.turnRight();
                          robot.turnRight();
                    break;
                case DOWN: // исходное направление робота вниз, то вращать его не надо и все ОК :)
                    break;
                case LEFT: robot.turnLeft();
                    break;
                case RIGHT: robot.turnRight();
                    break;}


                if (xMove!=0){
                  if (toX>robot.getX()){
                      robot.turnLeft();
                      for (int i=0; i < xMove ;i++){robot.stepForward(); }
                      robot.turnRight();// в исходное положение, робот смотрит вниз
                  }
                  if (toX<robot.getX()){
                  robot.turnRight();
                  for (int i=0; i < xMove ;i++){robot.stepForward(); }
                      robot.turnLeft();// в исходное положение, робот смотрит вниз
                  }
                }
                 if (yMove!=0){
                      if (toY>robot.getY()){
                       robot.turnLeft(); robot.turnLeft();
                       for (int i=0; i < yMove ;i++){robot.stepForward();}
                       robot.turnLeft(); // в исходное положение, робот смотрит вниз
                       robot.turnLeft();
                  }
                      else {
                          for (int i=0; i < yMove ;i++){robot.stepForward();}
                   }
                  }
         }
    }
}






