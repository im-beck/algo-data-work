package Queues;

public class Main {
    public static void main(String[] args) {
        AnimalQueue shelter = new AnimalQueue();

        Dog dog1 = new Dog("Dog1");
        Cat cat1 = new Cat("Cat1");
        Dog dog2 = new Dog("Dog2");
        Cat cat2 = new Cat("Cat2");

        shelter.enqueue(dog1);
        shelter.enqueue(cat1);
        shelter.enqueue(dog2);
        shelter.enqueue(cat2);

        System.out.println("Dequeued any: " + shelter.dequeueAny().name); // Should dequeue dog1
        System.out.println("Dequeued dog: " + shelter.dequeueDog().name); // Should dequeue dog2
        System.out.println("Dequeued cat: " + shelter.dequeueCat().name); // Should dequeue cat1
        System.out.println("Dequeued any: " + shelter.dequeueAny().name); // Should dequeue cat2
    }


    // An animal shelter, which holds only dogs and cats, operates on a strictly
// "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of
//  all animals at the shelter, or they can select whether they would
//  prefer a dog or a cat (and will receive the oldest animal of that type).
//   They cannot select which specific animal they would like.
//   Create the data structures to maintain this system and implement
//   operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
}

