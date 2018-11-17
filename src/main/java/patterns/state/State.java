package patterns.state;

/**
 * State interface.
 */

public interface State {

    void onEnterState();

    void observe();
}
