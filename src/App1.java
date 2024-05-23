// This is an example of the Decorator pattern

public class App1 {

    // First, we define the Component interface
    public interface Coffee {
        String getDescription();
        double getCost();
    }

    // Second, we create a concrete implementation of the Component interface
    public class SimpleCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "Simple Coffee";
        }

        @Override
        public double getCost() {
            return 5.0;
        }
    }

    // Third, we create the abstract Decorator class that implements the Component interface
    public abstract class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription();
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost();
        }
    }

    // Fourth, we create concrete decorators that extend the abstract decorator
    public class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", with Milk";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 1.5;
        }
    }

    public class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", with Sugar";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 0.5;
        }
    }

    // Example usage
    public static void main(String[] args) {
        App1 appInstance = new App1();

        // Creating a simple coffee
        Coffee simpleCoffee = appInstance.new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " $" + simpleCoffee.getCost());

        // Decorating the simple coffee with milk
        Coffee milkCoffee = appInstance.new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.getCost());

        // Decorating the simple coffee with sugar
        Coffee sugarCoffee = appInstance.new SugarDecorator(simpleCoffee);
        System.out.println(sugarCoffee.getDescription() + " $" + sugarCoffee.getCost());

        // Decorating the simple coffee with both milk and sugar
        Coffee milkAndSugarCoffee = appInstance.new SugarDecorator(milkCoffee);
        System.out.println(milkAndSugarCoffee.getDescription() + " $" + milkAndSugarCoffee.getCost());
    }
}
