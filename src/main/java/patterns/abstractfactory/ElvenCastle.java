package patterns.abstractfactory;

public class ElvenCastle implements Castle {

    static final String DESCRIPTION = "This is the Elven castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
