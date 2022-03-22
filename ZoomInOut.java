import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class ZoomInAndOut extends Applet
{
    int x,y,r;
    static int cx,cy,cr;
    Image picture;
    @Override
    public void init()
    {
        x=10;
        y=10;
        r=300;
        setSize(350,350);
        String link = "https://cn.i.cdn.ti-platform.com/content/869/showpage/oggy-and-the-cockroaches/in/oggy.png";
        picture = getImage(getDocumentBase(),link);

    }

    @Override
    public void paint(Graphics g)
    {
        paint1(g);
//        paint2(g);
    }

    private void paint2(Graphics g)
    {
        g.setColor(Color.white);
        for (int i=0;i<=75;i+=5)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int x = cx;
            int y = cy;
            int r = cr;
            g.fillRect(0,0,500,500);
            g.drawImage(picture,x-i,y-i,r+(i*2),r+(i*2),this);
        }
        paint1(g);
    }

    private void paint1(Graphics g)
    {
        g.setColor(Color.white);
        for (int i=0;i<=75;i+=5)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cx = x+i;
            cy = y+i;
            cr = r-(i*2);
            g.fillRect(0,0,500,500);
            g.drawImage(picture,x+i,y+i,r-(i*2),r-(i*2),this);
        }

        paint2(g);
//        repaint();
    }
}
