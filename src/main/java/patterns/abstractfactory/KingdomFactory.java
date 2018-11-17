package patterns.abstractfactory;


/**
 * 王国里面有城堡，国王和军队。
 */

public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();
}
