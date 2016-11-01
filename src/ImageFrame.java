/**
 * Created by jeffreyhammond on 11/1/16.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A frame with an image component
 * */
class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        add(new ImageComponent());
        pack();
    }
}

/**
 * A component that displays an image
 * */
class ImageComponent extends JComponent {

    BufferedImage image;


    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public ImageComponent() {
        try {
            image = ImageIO.read(new File("baseball.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void paintComponent(Graphics g) {
        if (image == null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        // draw the image in the upper-left corner
        g.drawImage(image, 0, 0, null);
    }

//    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }


    public Dimension getPreferredSize() {
        if (image == null) {
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            return new Dimension(screenSize.width / 2, screenSize.height /2);
        } else {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }
}