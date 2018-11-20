package tutorials.language;

interface IAnimal {
    default public String identifyMySelf() {
        return "I am an animal.";
    }
}

interface EggLayer extends IAnimal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}

interface FireBreather extends IAnimal {

}

public class Dragon implements EggLayer, FireBreather {
    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}
