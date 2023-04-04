import java.awt.*;
public class Paddel {
    private int höjd, x, y, hastighet;
    private Color color;

    static final int PADDLE_WIDTH=15;
    public Paddel(int x, int y, int höjd, int hastighet, Color color) {
        this.x = x;
        this.y = y;
        this.höjd = höjd;
        this.hastighet = hastighet;
        this.color = color;
    }
    public void paint(Graphics g){

        //måla rektangeln för paddeln
        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, höjd);
    
    }
    public void åkMot(int åkMotY){
        int centerY = y + höjd/2;
        if(Math.abs(centerY-åkMotY) > hastighet){
        if(centerY > åkMotY){
            y-=hastighet;
        }
        if(centerY< åkMotY){
            y += hastighet;
        }
        }
   }
   public boolean Kollision(Boll b){
       int rightX = x + PADDLE_WIDTH;
       int bottomY = y + höjd;
       //kolla om bollen är mellan x värden
       if(b.getX() > (x - b.getSize()) && b.getX() < rightX){
        //kolla om bollen är mellan y värden
        if(b.getY() > y && b.getY() < bottomY){
            //vid kollision
            return true;
        }
    }

    //kollision har ej skett
    return false;
   }
}
