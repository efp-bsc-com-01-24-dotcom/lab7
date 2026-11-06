public class Main {
    static String sound(Object animal) {
        return ((Mammle)animal).speak();
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Lion lion = new Lion();

        Object[] arr = new Object[3];
        arr[0] = cat;
        arr[1] = dog;
        arr[2] = lion;
        for (int i = 0; i < 3; i++) {
            System.out.println(sound(arr[i]));
        }

    } 
}