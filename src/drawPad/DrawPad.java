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
 * @author 10151590121 ����
 * �����ͼ��ѧ��һ����ҵ
 */

public class DrawPad extends JFrame implements ActionListener{
	private static String title = "С�����Ļ�ͼ��";
	private JToolBar rToolBar;
	private Canvas rCanvas;
	private JLabel bottomBar;
	// ���幤����ͼ�������
	private String[] tiptext = {"pen","line", "rect", "frect", "oval", "foval","circle", "fcircle", 
			"roundrect", "froundrect","rubber", "color","stroke"};
	// ����ͼ������
	private Icon icons[];
	private String toolName[] = { // ����������Ƶ���Ӧ�İ�ť�ϸ�����Ӧ����ʾ
			  "����","��ֱ��", "�����ľ���", "������", "��������Բ", "�����Բ", "������Բ", "���Բ", "��Բ�Ǿ���",
			"���Բ�Ǿ���","��Ƥ��", "��ɫ", "ѡ�������Ĵ�ϸ" };
	JButton button[];// ���幤�����еİ�ť��
	
	public DrawPad() {
		super(title);
		// �������ĳ�ʼ��
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
		
		//�滭���ĳ�ʼ��
		rCanvas = new Canvas(this);
		// ״̬���ĳ�ʼ��
		bottomBar = new JLabel("��������Ķ�");
		
		//������弰���֣��˴���north��south������Ȥ
		Container rContainer = getContentPane();
		rContainer.add(rToolBar,BorderLayout.NORTH);
		rContainer.add(rCanvas,BorderLayout.CENTER);
		rContainer.add(bottomBar,BorderLayout.SOUTH);
		
		Toolkit rToolkit = getToolkit();
		Dimension rDimension = rToolkit.getScreenSize();
		setBounds(40, 40, rDimension.width-70, rDimension.height-70);//���ô��ڽ����λ�úͳߴ�
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
			rCanvas.setStroke();// ���ʴ�ϸ�ĵ���
		}
		
	}

}
