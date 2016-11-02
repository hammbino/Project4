import java.awt.*;
import javax.swing.*;

public class JIMachine {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageFrame();
            frame.setTitle("JIMachine");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

//        The program will have five buttons:
//        Open— Display a file dialog box that lets the user select an image file.
//        Zoom In— Make the image display size 25% larger. If there is not enough room to show the whole image in the window,
// show the upper-left corner. The zoom should be cumulative, so that pressing the button twice will make the image larger
// than it was after pressing the button only once. (Don't change the bitmap itself to zoom in, just change the way your
// program draws it. See the Notes section below for more information.)
//        100%— Display the image at its original size.
//        Zoom Out— Make the image display size 25% smaller. As for zoom in, the zoom should be cumulative.
//        Quit— Exit the program.
//
//        Reading images
//        Use the ImageIO class from the javax.imageio package to read in image files. Read the file into a BufferedImage
// object. The BufferedImage class is in the java.awt.image package.
//
//        Drawing images
//        Use an inner class to define an extension of JComponent or JPanel that you will use for drawing images. You
// will need to define a paintComponent method that overrides the parent class's method. If you extend JPanel, make sure
// you call super.paintComponent at the beginning of paintComponent.
//
//        Notes
//        ImageTest.java (Core Java Vol. I, pp. 319-320 8th ed., p. 379 9th ed.) is an example of reading a bitmap image
// from a file and displaying it in a frame. Pay special attention to the first part of the paintComponent method and ignore
// the last part of the method where it tiles the image.
//
//        You can read about file dialog boxes (the FileChooser classs) in our textbook in Section 9.7.4 (Core Java Vol. I, 9th ed.)
// Don't worry about filters and other more complicated parts of the book's examples.
//
//        You'll probably want a floating-point instance variable to keep track of the zoom factor. To draw pictures of
// different sizes, use the version of drawImage that allows you to specify the height and width of an image. You can
// find documentation for the drawImage method in the Java docs for the Graphics class, which is in the java.awt package.
//
