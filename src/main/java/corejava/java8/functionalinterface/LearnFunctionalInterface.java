package corejava.java8.functionalinterface;
@FunctionalInterface //If we mark this interface with this annotation then it will
//not allow more than one abstract method, we can also remove this annotation
//but to follow functional interface property we should not have more than
//one abstract method
//Note: if one other interface extend this then we cannot have any abstract method in extended interface
//bcoz it will give error as soon as we add funtionalinterface annotation
//However we can have same name of abstract method in child or extended interface
public interface LearnFunctionalInterface {
    void run();

}
