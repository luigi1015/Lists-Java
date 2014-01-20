package net.codehobby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ListApp extends JFrame
{

	private static final long serialVersionUID = 7438349917268570581L;//Automatically generated serial version ID.
	
	private JPanel panel;
	
	public ListApp()
	{
		initUI();
	}

	private void initUI()
	{//Initialize the user interface elements.
		//Set up the main panel.
		panel = new JPanel();
		getContentPane().add( panel );
		panel.setLayout( null );

		setTitle( "List" );
		setSize( 600, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );//Set it to shut down once the close button is pressed.
	}

	public static void main(String[] args) {
		//The invokeLater puts the application on the Swing Event Queue to make sure all UI updates are concurrency safe.
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				ListApp la = new ListApp();
				la.setVisible( true );
			}
		});
	}

}
