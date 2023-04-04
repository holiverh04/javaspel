import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class spel{
    static JFrame f = new JFrame("Pong");

   public static void main(String[] args) {
    //spelet avslutat när man klickar på "exit" knappen
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // spelets dimensioner
        f.setSize(650, 495);

        PongSpel spel = new PongSpel();
        
        f.add(spel);
       //ser till att fönstret syns
        f.setVisible(true);
        //skapar en timer som återställer fönstret ca 30 gånger per sekund
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                spel.spelLogik();
                spel.repaint();
            }
        });

        timer.start();
    }
}
    

