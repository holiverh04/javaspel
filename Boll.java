import java.awt.Color;
import java.awt.Graphics;

public class Boll {
    static final int MAX_SPEED =9;
     private int x,y,cx,cy,hastighet,storlek;
     private Color color;

     public Boll(int x, int y, int cx, int cy, int hastighet, int storlek, Color color){
        this.x=x;
        this.y=y;
        this.cx=cx;
        this.cy=cy;
        this.hastighet=hastighet;
        this.storlek=storlek;
        this.color=color;

     }
     public void ökaHastighet(){
        if(hastighet<MAX_SPEED){
            //uppdatera hastigheterna
            hastighet++;

            cx= (cx/Math.abs(cx)*hastighet);
            cy = (cy/ Math.abs(cy)*hastighet);
        }
     }
     public int getSize(){
        return storlek;
     }
     public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setCy(int cy){
        this.cy = cy;
    }

    public void setCx(int cx){
        this.cx = cx;
    }
    public void setSpeed(int hastighet){
        this.hastighet = hastighet;
    }

     public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, storlek, storlek);
     }
     public void moveBoll(){
        x += cx;
        y += cy;
     }
     public void studsaAvKanterna(int top, int botten){
        //if the y value is at the bottom of the screen
        if (y > botten - storlek){
            reverseY();
        }
        //if y value is at top of screen
        else if(y < top){
            reverseY();
        }

     }

     public void reverseY(){
        cy*=-1;
     }
     
     public void reverseX(){
        cx*=-1;
     }
}
