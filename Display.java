// Johan Pena
// Display
// 02-17-2019

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display extends JFrame
{
	private JPanel imagePanel;					// To hold the label
	private JPanel buttonPanel;					// To hold a button
	private JLabel imageLabel;					// To show an image
	private JButton button;						// To start timer
	private Timer timer;						// Timer object
	private final int TIME_DELAY = 160; 		// Time delay
	private int count = 0;						// Keeps track of loop
	private final int WINDOW_WIDTH = 350; 		// Window width
	private final int WINDOW_HEIGHT = 350;		// Window height

	/**
		Constructor
	*/
	public Display()
	{
		// Set the title.
		setTitle("Animation");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager.
		setLayout(new BorderLayout());

		// Build the panels.
		buildImagePanel();
		buildButtonPanel();

		// Add the panel to the content pane.
		add(imagePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// Pack and display the window.
		pack();
		setVisible(true);
	}

	/**
		The buildImagePanel method adds a label to a panel.
	*/
	private void buildImagePanel()
	{
		// Create a panel.
		imagePanel = new JPanel();

		// Create a label.
		imageLabel = new JLabel("Click the button to" +
								"start animation.");

		// Add the label to panel.
		imagePanel.add(imageLabel);
	}

	/**
		The buildButtonPanel method adds a button
		to a panel.
	*/
	private void buildButtonPanel()
	{
		// Create a panel.
		buttonPanel = new JPanel();

		// Create a button.
		button = new JButton("Start Animation");

		// Register an action listener with the button.
		button.addActionListener(new ButtonListener());

		// Add the button to the panel.
		buttonPanel.add(button);
	}

	/**
		Private inner class that handles the event when
		the user clicks the button.
	*/
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			timer = new Timer(TIME_DELAY, new TimerListener());
			timer.start();
		}
	}

	/**
		Private inner class that handles the Timer object's
		action events.
	*/
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Read the image file into an ImageIcon object.
			ImageIcon[] image = new ImageIcon[2];
			image[0] = new ImageIcon("Game 1.png");
			image[1] = new ImageIcon("Game 2.png");

			if(count < 2)
			{
				// Display the image in the label.
				imageLabel.setIcon(image[count]);

				// Remove the text from the label.
				imageLabel.setText(null);

				// Increment count
				count++;

				// Pack the frame again to accommodate the
				// new size of the label.
				pack();
			}
			else
			count = 0;
		}
	}

	/**
		The main method creates an instance of the Image
		class, which causes it to display its window.
	*/
	public static void main(String[] args)
	{
		new Display();
	}
}

