import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
	//Create a new list frame object
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
	//Set Title
                topDestinationListFrame.setTitle("Top 5 Destination List");
	//Set visibility
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        //Uses the superclass' constructor
        super("Top Five Destination List");
        // Set Frame attributes
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        //Add NYC destination with downloaded image from unsplash, by Florian Wehde
        addDestinationNameAndPicture("1. New York City (The Big Apple)", new ImageIcon(getClass().getResource("/resources/NYC.jpg"))); 
        //Add Boston destination with downloaded image from unsplash, by Todd Kent
        addDestinationNameAndPicture("2. Boston (Home of the Red Sox)", new ImageIcon(getClass().getResource("/resources/Boston.jpg")));  
        //Add Washington DC destination with downloaded image from unsplash, by Harold Mendoza
        addDestinationNameAndPicture("3. Washington DC (United States Capitol)", new ImageIcon(getClass().getResource("/resources/DC.jpg"))); 
        //Add Old Orchard destination with downloaded image from unsplash, by Philippe Murray-Pietsch
        addDestinationNameAndPicture("4. Old Orchard Beach (Vacation Land)", new ImageIcon(getClass().getResource("/resources/OldOrchard.jpg"))); 
       //Add White Mountains destination with downloaded image from unsplash, by Andrew Keymaster
        addDestinationNameAndPicture("5. White Mountain National Forest (Outdoor Family Fun)", new ImageIcon(getClass().getResource("/resources/WhiteMountains.jpg"))); 

        /*    HTML version of image creators
         * 	NYC: Photo by <a href="https://unsplash.com/@florianwehde?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Florian Wehde</a> on <a href="https://unsplash.com/s/photos/NYC?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
		 *	Boston: Photo by <a href="https://unsplash.com/@churchoftodd?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">todd kent</a> on <a href="https://unsplash.com/s/photos/Boston?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
		 * 	Washington, DC: Photo by <a href="https://unsplash.com/es/@haroldrmendoza?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Harold Mendoza</a> on <a href="https://unsplash.com/s/photos/washington-dc?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
		 *	Old Orchard Beach: Photo by <a href="https://unsplash.com/@pmpietsch?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Philippe Murray-Pietsch</a> on <a href="https://unsplash.com/s/photos/Old-Orchard-Beach?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
		 *	White Mountain: Photo by <a href="https://unsplash.com/@arnidan?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Andrew Keymaster</a> on <a href="https://unsplash.com/s/photos/White-Mountains-NH?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
         */
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        
        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}