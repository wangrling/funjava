package tutorials.language;

class SuperClass {
    public void printMethod() {
        System.out.println("Printed in SuperClass.");
    }
}

public class SubClass extends SuperClass {

        // Override printMethod in SuperClass.
        public void printMethod() {
            super.printMethod();
            System.out.println("Printed in SubClass.");
        }

        public static void main(String[] args) {
            SubClass s = new SubClass();
            s.printMethod();
        }
}
