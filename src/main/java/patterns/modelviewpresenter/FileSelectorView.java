package patterns.modelviewpresenter;

import java.io.Serializable;

/**
 * This interface represents the View component in the Model-View-Presenter pattern. It can be
 * implemented by either the GUI components, or by the Stub.
 */

public interface FileSelectorView extends Serializable {


    // Opens the view.
    void open();

    // Closes the view.
    void close();

    boolean isOpened();

    /**
     * Sets the presenter component, to the one given as parameter.
     * @param presenter The new presenter comp
     */
    void setPresenter(FileSelectorPresenter presenter);

    FileSelectorPresenter getPresenter();

    void setFileName(String name);

    String getFileName();


    /**
     * Displays a message to the users.
     * @param message The message to be displayed.
     */
    void showMessage(String message);

    /**
     * Display the data to the view.
     * @param data The data to be written.
     */
    void displayData(String data);
}
