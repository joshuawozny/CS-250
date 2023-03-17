import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}
	// Changed background color to improve readability and resize to account for the image source text
	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.pink);  //changed to pink
		textPane.setBounds(5, 470, 790, 60);  //resize height to 60
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 2)); //vgap adjusted to 2

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}
	/*
	 * Images have been updated to more closely reflect the new Destinations (see section below)
	 * PLEASE NOTE THAT IMAGAGES ARE REPSENTATIVE ONLY AND NO NOT DEPICT THE ACTUAL DESTINATIIONS
	 * IN THE ACTUAL APPLICATION, LICENSED IMAGES OF THE ACTUAL DESTINATIONS WOULD BE USED
	 */
	
	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><a ><img width= '800' height='500' src='" + getClass().getResource("/resources/Luna.jpg") + "'</a></body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Eastman.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Isrotel.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sedona.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Nobu.jpg") + "'</body></html>";
		}
		return image;
	}
	/*
	 * Destinations have been update and are from Forbes Best Health and Wellness Retreats, 
	 * The short descriptions a paraphrased from the same source
	 * 
	 * REFERENCE:
	 * 	  Porter, M. (2019, August 21). Detox Destinations: The Best Health And Wellness Retreats. Forbes. 
	 *      https://www.forbes.com/sites/miriamporter/2019/08/26/
	 *      detox-destinations-the-best-health-and-wellness-retreats/?sh=2fa86186392e
	 *       
	 *	1. Cala Luna Boutique Hotels & Villas 
	 *	Photo by Cole Allen on Unsplash
	 *
	 *	2. Spa Eastman (Quebec, Canada)
	 *	Photo by Jernej Graj on Unsplash
	 *	
	 *	3. Isrotel Dead Sea Resort & Spa (Israel)
	 *	Photo by Alex Bertha on Unsplash
‌	 *
	 * 	4. Hilton Sedona Resort At Bell Rock (Sedona, Arizona)
	 *	Photo by Eneko Uruñuela on Unsplash
	 *
	 *	5. Nobu Hotel Los Cabos (Cabo San Lucas, Mexico)
	 *	Photo by Roberto Nickson on Unsplash
	 */
	
	 
	// Updated the Destination and description
	// Added source of image
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='2'>Photo by Cole Allen on Unsplash</font> <br><font size='4'>#1 Cala Luna Boutique Hotels & Villas</font> <br>Wellness experience in a tropical paradise. </body></html>";
		} else if (i==2){
			text = "<html><body><font size='2'>Photo by Jernej Graj on Unsplash</font> <br>#2 Spa Eastman (Quebec, Canada) <br>Wake your senses as you submerge in a hot pool on a cold day.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='2'>Photo by Alex Bertha on Unsplash</font> <br>#3 Isrotel Dead Sea Resort & Spa (Israel) <br>Enjoy the Dead Sea's natural wonders and sulfur pools.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='2'>Photo by Eneko Uruñuela on Unsplash</font> <br>#4 Hilton Sedona Resort At Bell Rock (Sedona, Arizona) <br>Locally inspired therapies featuring an invigorating red clay body wrap.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='2'>Photo by Roberto Nickson on Unsplash</font> <br>#5 Nobu Hotel Los Cabos (Cabo San Lucas, Mexico) <br>Clear your mind, body, and spirit with Asian-inspired traditions.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}