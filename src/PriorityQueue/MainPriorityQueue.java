package PriorityQueue;



import java.util.Comparator;
import java.util.PriorityQueue;

public class MainPriorityQueue {
    @Override
    public String toString() {
        return "MainPriorityQueue{}";
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("user1",2);
        Customer customer2 = new Customer("user2",15);
        Customer customer3 = new Customer("user3",12);

        PriorityQueue<Customer> priorityQueue = new PriorityQueue<>(new Comparators());
        priorityQueue.add(customer1);
        priorityQueue.add(customer2);
        priorityQueue.add(customer3);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
class Customer {
    String fullName;
    int loyaltyPoints;
    Customer(String fullName,int loyaltyPoints){
        this.fullName = fullName;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
class Comparators implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.loyaltyPoints - o2.loyaltyPoints;
    }
}