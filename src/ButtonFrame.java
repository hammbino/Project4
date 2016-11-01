/**
 * Created by jeffreyhammond on 11/1/16.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A frame with a button panel
 * */
class ButtonFrame extends JFrame {
    public JPanel actionPanel;

    public ButtonFrame() {

//        // create buttons
//        JButton openButton = new JButton("Open");
//        JButton zoomInButton = new JButton("Zoom In");
//        JButton zoomOutButton = new JButton("Zoom Out");
//        JButton defaultSizeButton = new JButton("100%");
        JButton quitButton = new JButton("Quit");

        actionPanel = new JPanel();

        makeButton("Open", Color.yellow);
        makeButton("Zoom In", Color.blue);
        makeButton("100%", Color.white);
        makeButton("Zoom Out", Color.red);
//        makeButton("Quit", Color.black);
        actionPanel.add(quitButton);
        actionPanel.add(new ImageComponent());

//        // add buttons to panel
//        actionPanel.add(openButton);
//        actionPanel.add(zoomInButton);
//        actionPanel.add(zoomOutButton);
//        actionPanel.add(defaultSizeButton);
//        actionPanel.add(quitButton);
//        actionPanel.add(new ImageComponent());


        // add panel to frame
        add(actionPanel);

//        // create button actions
//        ColorAction yellowAction = new ColorAction(Color.YELLOW);
//        ColorAction blueAction = new ColorAction(Color.BLUE);
//        ColorAction redAction = new ColorAction(Color.RED);
//        ColorAction quitAction = new ColorAction(Color.WHITE);
//        ColorAction defaultSizeAction = new ColorAction(Color.BLACK);
//        QuitAction quitAction = new QuitAction();
//
//
//        // associate actions with buttons
//        openButton.addActionListener(yellowAction);
//        zoomInButton.addActionListener(blueAction);
//        zoomOutButton.addActionListener(redAction);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


//        defaultSizeButton.addActionListener(defaultSizeAction);

        pack();
    }

    public void makeButton(String name, final Color backgroundColor)
    {
        JButton button = new JButton(name);
        actionPanel.add(button);
        button.addActionListener(event -> actionPanel.setBackground(backgroundColor));
    }

//    /**
//     * An action listener that sets the panel's background color.
//     **/
//    class ColorAction implements ActionListener {
//        private Color backgroundColor;
//
//        public ColorAction(Color c) {
//            backgroundColor = c;
//        }
//
//        public void actionPerformed(ActionEvent event) {
//            actionPanel.setBackground(backgroundColor);
//        }
//    }

}