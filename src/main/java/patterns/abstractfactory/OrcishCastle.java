package patterns.abstractfactory;

public class OrcishCastle implements Castle {

    static final String DESCRIPTION = "This is Orcish castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
