import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class PongSpel extends JPanel implements MouseMotionListener{

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Paddel användarPaddel, pcPaddel;
    private int användarMusY;
    private Boll spelBoll;
    private int användarPoäng, pcPoäng;
    private int studsRäknare;

   @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

      spelBoll.paint(g);
      användarPaddel.paint(g);
      pcPaddel.paint(g);

      //updatera poäng
      g.setColor(Color.WHITE);

      g.drawString("Poäng - Användare [ " + användarPoäng + " ]   PC [ " + pcPoäng + " ]", 250, 20   );

    }
   
   
    public PongSpel(){
        spelBoll = new Boll(300, 200, 3, 3, 3, 10, Color.YELLOW);
        användarPaddel = new Paddel(10, 200, 75, 3, Color.BLUE);
        pcPaddel = new Paddel(610, 200, 75, 3, Color.RED);
        användarMusY = 0;
        användarPoäng = 0; pcPoäng = 0;
        addMouseMotionListener(this);
    }
   
    public void spelLogik(){
        spelBoll.moveBoll();
        spelBoll.studsaAvKanterna(0, WINDOW_HEIGHT);
        användarPaddel.åkMot(användarMusY);
        pcPaddel.åkMot(spelBoll.getY());

        //kolla om bollen kolliderar med paddlarna
        if(pcPaddel.Kollision(spelBoll) || användarPaddel.Kollision(spelBoll)){
            //ändra bollen riktning i x-led
            spelBoll.reverseX();
            studsRäknare++;
        }
        if(studsRäknare == 5){
            studsRäknare=0;

            spelBoll.ökaHastighet();
        }

        if(spelBoll.getX()<0){
            //användare har förlorat
            pcPoäng++;
            reset();
        }
        else if(spelBoll.getX()>WINDOW_WIDTH){
            //pc har förlorat
            användarPoäng++;
            reset();
        }

    }
    public void reset(){
        //pausa i en sekund
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //återställ bollen
    spelBoll.setX(300);
    spelBoll.setY(200);
    spelBoll.setCx(3);
    spelBoll.setCy(3);
    spelBoll.setSpeed(3);
    studsRäknare = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
      användarMusY = e.getY();
    }
    
}
