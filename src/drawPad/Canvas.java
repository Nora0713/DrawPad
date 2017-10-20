package drawPad;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author 10151590121 赵宁 计算机图形学第一次作业
 */

public class Canvas extends JPanel
{
    DrawPad rDrawPad = null;
    DrawAction[] drawActionList = new DrawAction[60000];
    private int currentId = 0;
    int index = 0;
    private Color color = Color.BLACK;
    int R, G, B;
    int stroke = 1;

    public Canvas(DrawPad drawPad)
    {
        rDrawPad = drawPad;
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setBackground(Color.WHITE);
        addMouseListener(new drawMouseListen());
        addMouseMotionListener(new drawMotionAdapter());

        createNewItem();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;// 定义随笔画
        int j = 0;
        while (j <= index)
        {
            draw(g2d, drawActionList[j]);
            j++;
        }

    }

    void draw(Graphics2D graphics2d, DrawAction i)
    {
        i.paint(graphics2d);// 将画笔传到个各类的子类中，用来完成各自的绘图
    }

    void createNewItem()
    {
        switch (currentId)
        {
        case 0:
            drawActionList[index] = new pen();
            break;
        case 1:
            drawActionList[index] = new Line();
            break;
        case 2:
            drawActionList[index] = new Rect();
            break;
        case 3:
            drawActionList[index] = new FillRect();
            break;
        case 4:
            drawActionList[index] = new Oval();
            break;
        case 5:
            drawActionList[index] = new FillOval();
            break;
        case 6:
            drawActionList[index] = new Cirle();
            break;
        case 7:
            drawActionList[index] = new FillCirle();
            break;
        case 8:
            drawActionList[index] = new RoungRect();
            break;
        case 9:
            drawActionList[index] = new FillRoungRect();
            break;
        case 10:
            drawActionList[index] = new Rubber();
            break;
        }
        drawActionList[index].R = R;
        drawActionList[index].G = G;
        drawActionList[index].B = B;
        drawActionList[index].stroke = stroke;
    }

    public void setCurrentId(int i)
    {
        currentId = i;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setStroke(int s)
    {
        stroke = s;
    }

    public void chooseColor()
    {
        color = JColorChooser.showDialog(rDrawPad, "Please选择颜色", color);
        try
        {
            R = color.getRed();
            G = color.getGreen();
            B = color.getBlue();
        }
        catch (Exception e)
        {
            R = 0;
            G = 0;
            B = 0;
        }
        drawActionList[index].R = R;
        drawActionList[index].G = G;
        drawActionList[index].B = B;
    }

    public void setStroke()// 画笔粗细的调整
    {
        String input;
        input = JOptionPane.showInputDialog("请输入画笔的粗细( >0 )");
        try
        {
            stroke = Integer.parseInt(input);

        }
        catch (Exception e)
        {
            stroke = 1;
        }
        drawActionList[index].stroke = stroke;

    }

    class drawMouseListen extends MouseAdapter implements MouseListener
    {

        @Override
        public void mouseReleased(MouseEvent e)
        {
            rDrawPad.setBottomBar("鼠标松开，位置：[" + e.getX() + "," + e.getY() + "]");
            if (currentId == 0 || currentId == 10)
            {
                drawActionList[index].x1 = e.getX();
                drawActionList[index].y1 = e.getY();
            }
            drawActionList[index].x2 = e.getX();
            drawActionList[index].y2 = e.getY();
            repaint();
            index++;
            createNewItem();
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            // TODO Auto-generated method stub
            rDrawPad.setBottomBar("鼠标按下，位置：[" + e.getX() + "," + e.getY() + "]");

            drawActionList[index].x1 = drawActionList[index].x2 = e.getX();
            drawActionList[index].y1 = drawActionList[index].y2 = e.getY();

            // if choice pen||rubber
            if (currentId == 0 || currentId == 10)
            {
                drawActionList[index].x1 = drawActionList[index].x2 = e.getX();
                drawActionList[index].y1 = drawActionList[index].y2 = e.getY();
                index++;
                createNewItem();
            }
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            // TODO Auto-generated method stub
            rDrawPad.setBottomBar("鼠标退出，位置：[" + e.getX() + "," + e.getY() + "]");
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            rDrawPad.setBottomBar("鼠标未点击，位置：[" + e.getX() + "," + e.getY() + "]");
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }
    }

    class drawMotionAdapter extends MouseMotionAdapter
    {

        @Override
        public void mouseMoved(MouseEvent e)
        {
            rDrawPad.setBottomBar("鼠标移动，位置：[" + e.getX() + "," + e.getY() + "]");
        }

        // 鼠标拖动
        @Override
        public void mouseDragged(MouseEvent e)
        {
            rDrawPad.setBottomBar("鼠标拖动，位置：[" + e.getX() + "," + e.getY() + "]");
            if (currentId == 0 || currentId == 10)
            {
                drawActionList[index
                        - 1].x1 = drawActionList[index].x2 = drawActionList[index].x1 = e.getX();
                drawActionList[index
                        - 1].y1 = drawActionList[index].y2 = drawActionList[index].y1 = e.getY();
                index++;
                createNewItem();
            }
            else
            {
                drawActionList[index].x2 = e.getX();
                drawActionList[index].y2 = e.getY();
            }
            repaint();
        }
    }
}
