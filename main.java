import java.util.concurrent.TimeUnit;

class myArray{
    private int numelem;
    private int[] array;

    public myArray(int length){
        array = new int[length];
        numelem = 0;
    }

    public void setArray(int element){
        array[numelem] = element;
        numelem++;
    }

    public int searchElement(int key) {
        for (int count = 0; count < numelem; count++) {
            if (array[count] == key) {
                //System.out.println(key + " Was Found at Index #" + count);
                return count;
            }

        }
        System.out.println("I did not find " + key);
        return -1;
    }

    public void deleteElement(int key){
        int index = searchElement(key);
        if(index == -1){
            System.out.println("I did not find " + key);
        }
        else{
            for(int count = index; count < numelem-1; count++){
                array[count] = array[count+1];
            }
            array[numelem] = 0;
            numelem--;
        }

    }

    public void printArray(){
        int x = 0;
        while(x < numelem) {
            System.out.println(array[x]);
            x++;
        }
    }

    public void bubbleSort(){
    for(int count = numelem-1; count > 0; count--){
        for (int count1 = 0; count1 < count; count1++) {
            if (array[count1] > array[count1 + 1]) {
                int copy = array[count1];
                array[count1] = array[count1 + 1];
                array[count1 + 1] = copy;
            }
        }
        }
    }

    public void selectionSort(){
        for(int count = 0; count < numelem - 1; count++){   
            int min = count;
            for(int count2 = count + 1; count2 < numelem; count2++){
                if(array[count2] < array[min]){
                    min = count2;
                }
            }
            int holder = array[min];
            array[min] = array[count];
            array[count] = holder;
        }

    }

    public void insertionSort(){
        for(int count = 1; count < numelem; count++){
            int min = array[count];
            int count1;
            for(count1 = count - 1; count1 >= 0 && array[count1] > min; count1--){
                array[count1 +1] = array[count1];
            }
            array[count1 +1] = min;

        }
    }

    public void timer(long startTime, long endTime){
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime + " Nanoseconds");
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.println(elapsedTimeInSeconds + " Second(s)");
    }

}

public class main {
    public static void main(String[] args) {

        //Arrays
        myArray sortedArray = new myArray(1000000);

        myArray reverseSortedArrayBubble = new myArray(100000);
        myArray randomArrayBubble = new myArray(1000000);

        myArray reverseSortedArrayInsertion = new myArray(100000);
        myArray randomArrayInsertion = new myArray(1000000);

        myArray reverseSortedArraySelection = new myArray(100000);
        myArray randomArraySelection = new myArray(1000000);


        //Put numbers into sorted array
        for(int i = 0; i < 100000; i++){
            sortedArray.setArray(i + 1);
        }

        //Put numbers into reverse sorted array
        for(int i = 100000; i > 0; i--){
            reverseSortedArrayBubble.setArray(i);
        }

        for(int i = 100000; i > 0; i--){
            reverseSortedArrayInsertion.setArray(i);
        }

        for(int i = 100000; i > 0; i--){
            reverseSortedArraySelection.setArray(i);
        }

        //Generate numbers randomly for array
        for(int i = 0; i < 100000; i++){
            randomArrayBubble.setArray((int) (Math.random() * 100000));
        }

        for(int i = 0; i < 100000; i++){
            randomArrayInsertion.setArray((int) (Math.random() * 100000));
        }
        
        for(int i = 0; i < 100000; i++){
            randomArraySelection.setArray((int) (Math.random() * 100000));
        }


        System.out.println("---------BUBBLE SORTED ARRAY---------");

        long startTime = System.nanoTime();
        sortedArray.bubbleSort();
        long endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);

        System.out.println("---------BUBBLE REVERSE SORTED ARRAY---------");

        startTime = System.nanoTime();
        reverseSortedArrayBubble.bubbleSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);


        System.out.println("---------BUBBLE RANDOM SORTED ARRAY---------");

        startTime = System.nanoTime();
        randomArrayBubble.bubbleSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);


       System.out.println("--------SELECTION SORTED ARRAY-------");

        startTime = System.nanoTime();
        sortedArray.selectionSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);


        System.out.println("--------SELECTION REVERSE SORTED ARRAY-------");

        startTime = System.nanoTime();
        reverseSortedArraySelection.selectionSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);


        System.out.println("--------SELECTION RANDOM SORTED ARRAY-------");

        startTime = System.nanoTime();
        randomArraySelection.selectionSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);

        System.out.println("--------INSERTION SORTED ARRAY-------");

        startTime = System.nanoTime();
        sortedArray.insertionSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);


        System.out.println("--------INSERTION REVERSE SORTED ARRAY-------");

        startTime = System.nanoTime();
        reverseSortedArrayInsertion.insertionSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);


        System.out.println("--------INSERTION RANDOM SORTED ARRAY-------");

        startTime = System.nanoTime();
        randomArrayInsertion.insertionSort();
        endTime = System.nanoTime();
        sortedArray.timer(startTime,endTime);
    }
}
