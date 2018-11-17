package patterns.abstractfactory;

public class OrcishKing implements King {

    final static String DESCRIPTION = "This is Orcish king!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
