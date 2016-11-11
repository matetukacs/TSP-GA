import java.util.List;
import java.util.Random;
/**
 * Write a description of class ExchangeMutation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartiallyMappedCrossover extends ConsecutiveArrayElementOperation {
    
    private static Random random = new Random();
    
    //for testing
    public static PartiallyMappedCrossover getPartiallyMappedCrossover(int lowerCrossoverPoint, int higherCrossoverPoint) {
        
        return new PartiallyMappedCrossover(lowerCrossoverPoint, higherCrossoverPoint - 1);
    }
    
    public static PartiallyMappedCrossover getPartiallyMappedCrossover(int arrayLength) {
        int crossoverPoint1 = random.nextInt(arrayLength + 1);
        int crossoverPoint2 = random.nextInt(arrayLength + 1);
        
        int lowerCrossoverPoint = Math.min(crossoverPoint1, crossoverPoint2);
        int higherCrossoverPoint = Math.max(crossoverPoint1, crossoverPoint2);
        
        return new PartiallyMappedCrossover(lowerCrossoverPoint, higherCrossoverPoint - 1);
    }
    
    protected PartiallyMappedCrossover(int firstElementIndex, int lastElementIndex) { 
        
        super(firstElementIndex, lastElementIndex);
        
    }
    @Override
    protected int[] performElementOperation(int relativeElementIndex, List<int[]> originalArrays) {
        
        int actualIndex = getActualElementIndex(relativeElementIndex);

        int firstArrayNewElement = originalArrays.get(1)[actualIndex];
        
        int secondArrayNewElement = originalArrays.get(0)[actualIndex];
        
        return ArrayUtils.getElementsAsArray(firstArrayNewElement, secondArrayNewElement);
    }
    
    private int getActualElementIndex(int relativeIndex) {
        return getFirstElementIndex() + relativeIndex;
    }
    
    @Override
    protected void onPostOperation(List<int[]> prevIterationArrays, int relativeElementIndex, List<int[]> arrays) {
        
        for (int i = 0; i < prevIterationArrays.size(); i++) {
            performPostOperationChangesOnArray(prevIterationArrays.get(i), relativeElementIndex, arrays.get(i));
        }
    }
    
    private void performPostOperationChangesOnArray(int[] prevIterationArray, int relativeElementIndex, int[] array) {
        
        for (int i = 0; i < array.length; i++) {
            
            int originalElement = prevIterationArray[getActualElementIndex(relativeElementIndex)];
                
            int newElement = array[getActualElementIndex(relativeElementIndex)];
            
            if (i != getActualElementIndex(relativeElementIndex) && array[i] == newElement) {
                array[i] = originalElement;
            }
        }
    }
}
