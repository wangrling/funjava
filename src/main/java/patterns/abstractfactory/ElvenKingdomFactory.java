package patterns.abstractfactory;

public class ElvenKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new ElvenCastle();
    }

    @Override
    public King createKing() {
        return new ElvenKing();
    }

    @Override
    public Army createArmy() {
        return new ElvenArmy();
    }
}
