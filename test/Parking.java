import java.util.*;

class Parking
{
    MyStack s1, temp;

    Parking()
    {
        s1 = new MyStack();
        temp = new MyStack();
    }

    public void park(int number)
    {
        if (s1.isFull()) {
            System.out.println("Sorry! Parking is full");
        } else {
            s1.push(number);
            System.out.println("Successfully pushed");
        }
    }

    public void remove(int number)
    {
        int car;
        while (true) {
            if (s1.isEmpty()) {
                System.out.println("Your car not found");
                break;
            }

            car = s1.pop();
            if (car == number) {
                System.out.println("Now your car is being removed");
                break;
            } else {
                System.out.println("Removing car: " + car);
                temp.push(car);
            }
        }

        // Push it back in the stack
        while (!temp.isEmpty()) {
            s1.push(temp.pop());
        }
    }

    public static void main(String[] args)
    {
        int choice;
        int number;
        Parking p = new Parking();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose your option");
            System.out.println("1. Park a car");
            System.out.println("2. Remove a car");
            System.out.println("3. Exit");

            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter car number");
                number = sc.nextInt();
                p.park(number);

            } else if(choice == 2) {
                System.out.println("Enter car number to remove");
                number = sc.nextInt();
                p.remove(number);

            } else {
                break;
            }
        }
    }
}
