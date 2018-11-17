package patterns.observer.generic;

public interface Observer<S extends Observable,
        O extends Observer<S, O, A>, A> {

    void update(S subject, A argument);
}
