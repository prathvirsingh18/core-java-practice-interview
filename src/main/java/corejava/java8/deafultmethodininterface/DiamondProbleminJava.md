In java if multiple interfaces have same default method and if class implementing both this interfaces then compiler get confused which
method to invoke and it will give errror, so to solve this issue we need to override that method in our class inorder to solve the issue.

interface A{
default void fun(){
sout("hello:);
} }

interface B{
default void fun(){
sout("hello:);
} }

class Test implemets A,B{
@override // we neeed to override it otherwise diamond problem will occur
public void fun(){
//logic
}
}