package vzap.wandile;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockGUI extends JFrame implements Runnable
{
	private JPanel mainPanel;
	private JLabel digitalDisplay;
	private JButton startBut;
	private String timeFormat;
	private Thread thread;
	
	public ClockGUI()
	{
		thread = new Thread(this);
		timeFormat = new SimpleDateFormat("HH:mm:ss").format(new Date());
		mainPanel();
		setup();
		thread.start();
	}
	private void mainPanel()
	{
		mainPanel = new JPanel(new GridBagLayout());
		digitalDisplay = new JLabel(timeFormat);
		digitalDisplay.setFont(new Font("Arial", Font.BOLD, 100));
		digitalDisplay.setPreferredSize(new Dimension(500, 250));
		digitalDisplay.setForeground(Color.CYAN);
		startBut = new JButton("Start");
		
		mainPanel.add(digitalDisplay);
		mainPanel.add(startBut);
		mainPanel.setBackground(Color.BLACK);
	}
	private void setup()
	{
		this.setTitle("Clock");
		this.add(mainPanel);
		this.setSize(600, 300);
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void run()
	{
		for (int i = 0; i < 86000; i++)
		{
			timeFormat = new SimpleDateFormat("HH:mm:ss").format(new Date());
			digitalDisplay.setText(timeFormat);
			mainPanel.removeAll();
			mainPanel.validate();
			mainPanel.repaint();
			mainPanel.add(digitalDisplay);
			mainPanel.validate();
			mainPanel.repaint();
			try
			{
				Thread.sleep(1000);
				
			} catch (InterruptedException e)
			{
				e.getStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		new ClockGUI();
	}

}
