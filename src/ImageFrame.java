/**
 * Created by jeffreyhammond on 11/1/16.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;


/**
 * A frame to view images
 * */
class ImageFrame extends JFrame {

    BufferedImage image;
    float zoom = 1;

    public ImageFrame() {
        setSize(getPreferredSize());
        JPanel buttonPanel = new JPanel();
        JPanel picPanel = new ImagePanel();

        JButton openButton = new JButton("Open");
        /**
         * Todo this needs some love and a refactor
         * */
        openButton.addActionListener(event -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
            chooser.addChoosableFileFilter(filter);
            int result = chooser.showOpenDialog(ImageFrame.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                try {
                    image = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Could not open file.");
                }
                repaint();
            } else if(result == JFileChooser.CANCEL_OPTION){
                System.out.println("No File Selected");
            }
        });

        JButton zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(e -> {
//            Graphics g = image.createGraphics();
//            g.drawImage(image, 0, 0, (int) ((image.getWidth() * .25) + image.getWidth()), (int) ((image.getHeight() * .25) + image.getHeight()), null);
//            g.drawImage(image, 0, 0, image.getWidth() * 2, image.getHeight() * 2, this);
//            this.repaint();
//            BufferedImage temp = resizeImage(image, image.getType());
//            Graphics g = temp.createGraphics();
//            g.drawImage(temp, 0, 0, this);
            zoom += .25;
            repaint();

        });

        JButton defaultSizeButton = new JButton("100%");
        defaultSizeButton.addActionListener(e -> {
//            Graphics g = image.createGraphics();
//            g.drawImage(image, 0, 0, this);
            zoom = 1;
            repaint();
        });

        JButton zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(e -> {
//            Graphics g = image.createGraphics();
//            g.drawImage(image, 0, 0, (int) (image.getWidth() - (image.getWidth() * .25)), (int) (image.getHeight() - (image.getHeight() * .25)), this);
//            this.repaint();
//            BufferedImage temp = resizeImageOut(image, image.getType());
//            Graphics g = temp.createGraphics();
//            g.drawImage(image, 0, 0, this);
            zoom -= .25;
            repaint();
        });

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(openButton);
        buttonPanel.add(zoomInButton);
        buttonPanel.add(defaultSizeButton);
        buttonPanel.add(zoomOutButton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(picPanel);
    }

    /**
     * A component that displays an image
     * */
    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//            g.drawImage(image, 0, 0, this);

//            Graphics2D g2d = (Graphics2D) g;

            // Backup original transform
//            AffineTransform originalTransform = g2d.getTransform();

//            g2d.translate(panX, panY);
//            g2d.scale(zoom, zoom);

            if(image != null) {
                int w = image.getWidth();
                int h = image.getHeight();
                g.drawImage(image, 0, 0, (int) (w * zoom), (int) (h * zoom), null);
//
//                int scale = 2;
//                g.drawImage(image, w, h, (w * scale), (h * scale), null);
            }
            // paint the image here with no scaling
//            g.drawImage(image, 0, 0, null);
//            g2d.drawImage(image, 0, 0, image.getWidth() * 2, image.getHeight() * 2, this);

            // Restore original transform
//            g2d.setTransform(originalTransform);
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        int imgWidth = (int) (originalImage.getWidth() + (originalImage.getWidth() * .25));
        int imgHeight = (int) (originalImage.getHeight() + (originalImage.getHeight() * .25));
        BufferedImage resizedImage = new BufferedImage(imgWidth, imgHeight , type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imgWidth, imgHeight, null);
        g.dispose();

        return resizedImage;
    }

    private static BufferedImage resizeImageOut(BufferedImage originalImage, int type){
        int imgWidth = (int) (originalImage.getWidth() - (originalImage.getWidth() * .25));
        int imgHeight = (int) (originalImage.getHeight() - (originalImage.getHeight() * .25));
        BufferedImage resizedImage = new BufferedImage(imgWidth, imgHeight , type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imgWidth, imgHeight, null);
        g.dispose();

        return resizedImage;
    }

    /**
     * Sets default dimensions of the JFrame
     * */
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