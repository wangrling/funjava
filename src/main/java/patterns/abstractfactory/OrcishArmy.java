package patterns.abstractfactory;

public class OrcishArmy implements Army {

    final static String DESCRIPTION = "This is Orcish army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
