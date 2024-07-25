package Queues;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs;
    LinkedList<Cat> cats;
    private int order;

    public AnimalQueue() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        if (!dogs.isEmpty()) {
            return dogs.poll();
        } else {
            System.out.println("No dogs available for adoption.");
            return null;
        }
    }

    public Cat dequeueCat() {
        if (!cats.isEmpty()) {
            return cats.poll();
        } else {
            System.out.println("No cats available for adoption.");
            return null;
        }
    }

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }
}

