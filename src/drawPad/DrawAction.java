package drawPad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 * @author 10151590121 赵宁
 * 计算机图形学第一次作业
 */

public class DrawAction implements Serializable{
	int x1,x2,y1,y2;
	int R,G,B;
	int stroke;
	
	void paint(Graphics2D graphics2d)
	{
		
	}
}

class pen extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawLine(x1, y1, x2, y2);
	}
}

class Line extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawLine(x1, y1, x2, y2);
	}
}

class Rect extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
}

class FillRect extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
}

class Oval extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
}

class FillOval extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
}

class Cirle extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),Math.max(Math.abs(x1-x2), 
				Math.abs(y1-y2)), Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
	}
}

class FillCirle extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.fillOval(Math.min(x1, x2), Math.min(y1, y2),Math.max(Math.abs(x1-x2), 
				Math.abs(y1-y2)), Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
	}
}

class RoungRect extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2),50,30);
	}
}

class FillRoungRect extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(R,G,B));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2),50,30);
	}
}

class Rubber extends DrawAction{
	@Override
	void paint(Graphics2D graphics2d)
	{
		graphics2d.setPaint(new Color(255,255,255));
		graphics2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		graphics2d.drawLine(x1, y1, x2, y2);;
	}
}

