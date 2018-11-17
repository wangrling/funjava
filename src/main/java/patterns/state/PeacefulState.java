package patterns.state;

public class PeacefulState implements State {

    private Mammoth mammoth;

    public PeacefulState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void onEnterState() {
        System.out.println("{} is calm and peaceful.");
    }

    @Override
    public void observe() {
        System.out.println("{} calms down.");
    }
}
