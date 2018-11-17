package patterns.modelviewpresenter;

import java.io.*;

/**
 * Every instance of this class represents the Model component in the Model-View-Presenter
 * architectural pattern.
 * <p>
 * It is responsible for reading and loading the contents of a given file.
 */

public class FileLoader implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -4745803872902019069L;

    // Indicates if the file is loaded or not.
    private boolean isLoaded;

    // The name of the file that we want to load.
    private String fileName;

    // Loads the data of the file specified.
    public String loadData() {
        String dataFileName = fileName;

        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFileName));

            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            isLoaded = true;

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean fileExists() {
        return new File(fileName).exists();
    }

    public boolean isLoaded() {
        return isLoaded;
    }

}
