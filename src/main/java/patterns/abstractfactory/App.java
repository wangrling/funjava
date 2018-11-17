package patterns.abstractfactory;

public class App {
    private static final String TAG = "AbstractFactory";

    private King mKing;
    private Castle mCastle;
    private Army mArmy;


    /**
     * 创建工厂，传入不同的工厂实现创建不同的工厂。
     */
    public void createKingdom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setCastle(factory.createCastle());
        setArmy(factory.createArmy());
    }

    public static void main(String[] args) {
        App app = new App();

        System.out.println("Elven kingdom");
        app.createKingdom(FactoryMaker.makeFactory(
                FactoryMaker.KingdomType.ELVEN));

        System.out.println(app.getArmy().getDescription());
        System.out.println(app.getCastle().getDescription());
        System.out.println(app.getKing().getDescription());

        System.out.println("Orcish kingdom");
        app.createKingdom(FactoryMaker.makeFactory(
                FactoryMaker.KingdomType.ORCISH));
        System.out.println(app.getArmy().getDescription());
        System.out.println(app.getCastle().getDescription());
        System.out.println(app.getKing().getDescription());
    }

    /**
     * The factory of kingdom factories.
     */
    public static class FactoryMaker {

        /**
         * Enumeration for the different types of Kingdoms.
         */
        public enum KingdomType {
            ELVEN, ORCISH
        };

        /**
         * The factory method to create KingdomFactory concrete objects.
         */
        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELVEN:
                    return new ElvenKingdomFactory();
                case ORCISH:
                    return new OrcishKingdomFactory();
                default:
                    throw new IllegalArgumentException(
                            "Kingdom type is not supported!");
            }
        }
    }

    public King getKing() {
        return mKing;
    }

    public void setKing(King king) {
        mKing = king;
    }

    public Castle getCastle() {
        return mCastle;
    }

    public void setCastle(Castle castle) {
        mCastle = castle;
    }

    public Army getArmy() {
        return mArmy;
    }

    public void setArmy(Army army) {
        mArmy = army;
    }
}
