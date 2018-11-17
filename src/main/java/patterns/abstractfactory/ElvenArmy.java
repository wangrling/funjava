package patterns.abstractfactory;

public class ElvenArmy implements Army {

    static final String DESCRIPTION = "This is Elven army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
