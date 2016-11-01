package JXMapClasses;
import javax.swing.*;

public interface ControlPanel {
    JComponent getControlPanel();

    void configureControlPanel();

    int getPreferredHeight();
}