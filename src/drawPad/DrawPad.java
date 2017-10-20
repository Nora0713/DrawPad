package drawPad;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
/**
 * @author 10151590121 赵宁
 * 计算机图形学第一次作业
 */

public class DrawPad extends JFrame implements ActionListener{
	private static String title = "小宁宁的画图板";
	private JToolBar rToolBar;
	private Canvas rCanvas;
	private JLabel bottomBar;
	// 定义工具栏图标的名称
	private String[] tiptext = {"pen","line", "rect", "frect", "oval", "foval","circle", "fcircle", 
			"roundrect", "froundrect","rubber", "color","stroke"};
	// 定义图象数组
	private Icon icons[];
	private String toolName[] = { // 这里是鼠标移到相应的按钮上给出相应的提示
			  "画笔","画直线", "画空心矩形", "填充矩形", "画空心椭圆", "填充椭圆", "画空心圆", "填充圆", "画圆角矩形",
			"填充圆角矩形","橡皮擦", "颜色", "选择线条的粗细" };
	JButton button[];// 定义工具条中的按钮组
	
	public DrawPad() {
		super(title);
		// 工具栏的初始化
		rToolBar = new JToolBar(JToolBar.HORIZONTAL);
		button = new JButton[toolName.length];
		for(int i=0;i<toolName.length;i++)
		{
			button[i] = new JButton(toolName[i]);
			button[i].setBackground(Color.gray);
			button[i].setToolTipText(tiptext[i]);
			button[i].setPreferredSize(new Dimension(120,30));
			rToolBar.add(button[i]);
			button[i].addActionListener(this);
		}
		
		//绘画区的初始化
		rCanvas = new Canvas(this);
		// 状态栏的初始化
		bottomBar = new JLabel("你猜我在哪儿");
		
		//内容面板及布局，此处的north和south真是有趣
		Container rContainer = getContentPane();
		rContainer.add(rToolBar,BorderLayout.NORTH);
		rContainer.add(rCanvas,BorderLayout.CENTER);
		rContainer.add(bottomBar,BorderLayout.SOUTH);
		
		Toolkit rToolkit = getToolkit();
		Dimension rDimension = rToolkit.getScreenSize();
		setBounds(40, 40, rDimension.width-70, rDimension.height-70);//设置窗口界面的位置和尺寸
		setVisible(true);
		validate();//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
		
	}
	
	public void setBottomBar(String s) {
		bottomBar.setText(s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 11 ; i++ )
		{
			if(e.getSource()==button[i])
			{
				rCanvas.setCurrentId(i);
				rCanvas.createNewItem();
				rCanvas.repaint();
			}
		}
		
		if (e.getSource() == button[11])
		{
			rCanvas.chooseColor();
		}
		else if(e.getSource() == button[12]){
			rCanvas.setStroke();// 画笔粗细的调整
		}
		
	}

}
