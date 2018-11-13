package io.ibicfly.service0.basic;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/27 11:18
 * @Description: 作用描述
 */
public class PolymorphismTest extends PortableLunch {
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();
    private  static  Lunch lunch=new Lunch();

    public PolymorphismTest() {
        System.out.println("PolymorphismTest");
    }

    public static void main(String[] args) {
        new PolymorphismTest();
    }
}

class Meal {
    Meal() {
        System.out.println("Meal");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch");
    }
}

