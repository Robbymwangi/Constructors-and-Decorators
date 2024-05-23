 // this is an example of the observer pattern

import java.util.List;
import java.util.ArrayList;

public class App {
   
//first, we have to create the behaviour for the observers - we could do that in a concrete manner but that would be too much work
 // So what you can do here is create an abstract class  or an interface that the observer classes can inherit. in my case, I will use an abstract class
 public interface InnerApp {
    void update (String planet);
    
 }

 //second, we can create two observers here. The two observers will print a message when the Update method is called.
 public class InnerApp_1 implements InnerApp{
 @Override
 public void update (String planet){
    System.out.println("Coming to you live from " + planet);
 }
    
 }

public class InnerApp_2 implements InnerApp{
    @Override
    public void update (String planet){
       System.out.println("Coming to you live from " + planet);
    }
       
    }

//third, we can create the observable class. This class will have a list of observers and a method to add observers to the list. It will also have a method to notify the observers when the state of the observable changes.
    private List<InnerApp> observers = new ArrayList<>(); 
    private String planet; // to add a state to the observable class

 // there are usually three methods in the observable class : add observer, remove observer and notify observer
 // this is the add observer method
 public void addObserver(InnerApp observer){
    observers.add(observer);
    }

// if we wanted to add an observer to the list of observers, we would call the addObserver method and pass the observer as an argument like this:

// public class InnerApp_3 implements InnerApp{
//     @Override
//     public void update (String planet){
//        System.out.println("Coming to you live from " + planet);
//     }

//    public static void main(String[] args){
//        App observable = new App();
//        InnerApp_1 observer1 = new InnerApp_1();
//        InnerApp_2 observer2 = new InnerApp_2();
//        InnerApp_3 observer3 = new InnerApp_3();
//        observable.addObserver(observer1);
//        observable.addObserver(observer2);
//        observable.addObserver(observer3);
//        observable.notifyObservers();
//    }


// this is the remove observer method
public void removeObserver(InnerApp observer){
    observers.remove(observer);
    }

// this is the notify observer method
public void notifyObservers(){
    for (InnerApp observer : observers){
        observer.update(planet);
    }
    }


// this is a set method to change the state of the observable class
public void setPlanet(String planet){
    this.planet = planet;
    notifyObservers();
    }

// this is the main method
public static void main(String[] args){
    App observable = new App();
    App.InnerApp_1 observer1 = observable.new InnerApp_1(); // Create an instance of InnerApp_1 using an instance of App
    App.InnerApp_2 observer2 = observable.new InnerApp_2(); // Create an instance of InnerApp_2 using an instance of App
    
    observable.addObserver(observer1);
    observable.addObserver(observer2);
    
    observable.setPlanet("Mars");
    observable.setPlanet("Jupiter");
    
    observable.removeObserver(observer1);
    
    observable.setPlanet("Saturn");
}
}
