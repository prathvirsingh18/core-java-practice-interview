package OOPS.encapsulation;

public class Encapsulation {

    private int accountNumber; //data hiding
    private String accountHolderName;

    Encapsulation(int accountNumber, String accountHolderName){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountNumber(int accountNumber) {//variable account number cant be access directly
        this.accountNumber = accountNumber;
    }
}

class Test{

    public static void main(String[] args) {
        Encapsulation encapsulation = new Encapsulation(123, "abc");
        System.out.println(encapsulation.getAccountHolderName());
    }
}
