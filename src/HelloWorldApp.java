import javax.swing.JFrame;


public class HelloWorldApp {

	public static void main(String[] args) {
		System.out.println("Hello World!");//Say Hello World!
		System.out.println("Hiya World!");//Say Hiya World!
		System.out.println("Hello World from Ubuntu!");//Say Hello World from Ubuntu!
		System.out.println("Testing from Ubuntu!");//Say Testing from Ubuntu!
		//Test test test.

		JFrame frame = new JFrame("Demo");//Creates the frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Sets the frame to exit on pressing the close button.
		frame.setVisible(true);//Tell the frame to show itself.
	}

}
