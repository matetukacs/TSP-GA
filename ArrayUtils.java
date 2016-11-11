import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class ArrayUtils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayUtils
{
    
    private static Random random = new Random();

    public static int[] getArrayWithConsecutiveNumbers(int fromInclusive, int toExclusive) {
        
        if (fromInclusive > toExclusive) {
            throw new IllegalArgumentException("fromInclusive argument has to be smaller than toExclusive argument");
        }
        
        int arrayLength = toExclusive - fromInclusive;
        
        int[] array = new int[arrayLength];
        
        for (int i = 0; i < arrayLength; i++) {
            
            array[i] = fromInclusive + i;
        }
        
        return array;
    }
    
    public static int[] copyArray(int[] arrayToCopy) {
        
        int[] newArray = new int[arrayToCopy.length];
        
        for (int i = 0; i < newArray.length; i++) {
            
            newArray[i] = arrayToCopy[i];
        }
        
        return newArray;
    }
    
    public static List<int[]> copyArrays(List<int[]> arraysToCopy) {
        
        List<int[]> newArrays = new ArrayList<>();
        
        for (int[] arrayToCopy : arraysToCopy) {
            newArrays.add(copyArray(arrayToCopy));
        }
        
        return newArrays;
    }
    
    public static int[][] copy2DArray(int[][] arrayToCopy, int width, int height) {
        
        int[][] new2DArray = new int[width][height];
        
        for (int i = 0; i < width; i ++) {
            
            new2DArray[i] = copyArray(arrayToCopy[i]);
        }
        
        return new2DArray;
    }
    
    public static int indexOfElmentInArray(int element, int[] array) {
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOfElmentIn2DArray(int[] element, int[][] array) {
        
        for (int i = 0; i < array.length; i++) {
            if (arraysMatch(array[i], element)) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean arraysMatch(int[] array1, int[] array2) {
        
        if (array1.length != array2.length) {
            return false;
        }
        
        for (int i = 0; i < array1.length; i++) {
            
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
    //https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
    public static void shuffleArray(int[] array) {
       
        
        for (int i = array.length-1; i > 0; i--) {
            
            int swapPosition = random.nextInt(i+1);
            
            int swapValue = array[swapPosition];
            array[swapPosition] = array[i];
            array[i] = swapValue;
            
        }
    }
    
    public static void shuffleArray(int[][] array) {
       
        
        for (int i = array.length-1; i > 0; i--) {
            
            int swapPosition = random.nextInt(i+1);
            
            int[] swapValue = array[swapPosition];
            array[swapPosition] = array[i];
            array[i] = swapValue;
            
        }
    }
    
    public static int[] getElementsAsArray(int... elements) {
        
        return elements;
    }
}
