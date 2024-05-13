package Arrays;
import java.util.Arrays;

/*
 * 1. insert into an array
 * 2. traverse an array
 * 3. delete array
 * 4. search in an array
 */

 public class SingleDimensionArray {
    int arr[] = null; // array declaration

    public SingleDimensionArray(int sizeOfArray){
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int valueToInsert){
        try {
            if (arr[location] == Integer.MIN_VALUE){
                arr[location] = valueToInsert;
                System.out.println("Successfully inserted " + valueToInsert + " at location " + location);
            } else {
                System.out.println("This cell is already occupied by another value.");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array!");
        }
    }

    //traverse
    public void traverseArray(){
        try {
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e){
            System.out.println("Array no longer exists!");
        }
    }

    //delete
    public void delete(int location){
        try {
            arr[location] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array!");
        }
    }

    //search
    public void search(int valueToSearch){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == valueToSearch){
                System.out.println("Value found at location " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found in the array.");
    }


    public static void main(String[] args) {
        SingleDimensionArray singleDimensionArray = new SingleDimensionArray(5);
        singleDimensionArray.insert(0, 1);
        singleDimensionArray.insert(1, 2);
        singleDimensionArray.insert(2, 3);
        singleDimensionArray.insert(3, 4);
        singleDimensionArray.insert(4, 5);
        System.out.println(singleDimensionArray);
        System.out.println(Arrays.toString(singleDimensionArray.arr));
        singleDimensionArray.traverseArray();
        singleDimensionArray.delete(2);
        singleDimensionArray.search(4);
    }
}
