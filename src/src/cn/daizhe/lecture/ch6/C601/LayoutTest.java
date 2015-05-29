package cn.daizhe.lecture.ch6.C601;

/**
 * awt锟斤拷锟斤拷
 * @author venice
 * @version 2012-05-03
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LayoutTest extends Frame implements ActionListener {
	MenuBar bar = null;
	Menu men = null;
	MenuItem flow, border, grid;

	public LayoutTest() {
		setSize(500, 300);

		bar = new MenuBar();
		men = new Menu("布局");
		flow = new MenuItem("FlowLayout");
		border = new MenuItem("BorderLayout");
		grid = new MenuItem("GridLayout");
		men.add(flow);
		men.add(border);
		men.add(grid);
		bar.add(men);
		this.setMenuBar(bar);

		flow.addActionListener(this);
		border.addActionListener(this);
		grid.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == flow) {
			removeAll();
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.LEFT);
			fl.setHgap(20);
			fl.setVgap(40);
			setLayout(fl);
			for (int i = 0; i < 10; i++) {
				add(new Button("button" + (i + 1)));
			}
			validate();
		} else if (e.getSource() == border) {
			removeAll();
			setLayout(new BorderLayout());
			add(new Button("北"), BorderLayout.NORTH);
			add(new Button("南"), BorderLayout.SOUTH);
			add(new Button("东"), BorderLayout.EAST);
			add(new Button("西"), BorderLayout.WEST);
			add(new Button("中"), BorderLayout.CENTER);

			validate();
		} else if (e.getSource() == grid) {
			removeAll();
			setLayout(new GridLayout(4, 4));
			Label l[][] = new Label[4][4];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					l[i][j] = new Label();
					if ((i + j) % 2 == 0)
						l[i][j].setBackground(Color.black);
					else
						l[i][j].setBackground(Color.white);
					add(l[i][j]);
				}
			validate();
		}
	}

	public static void main(String args[]) {
		LayoutTest l = new LayoutTest();
		l.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	class sdfd implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
