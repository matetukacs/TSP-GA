import java.util.List;
import java.util.Random;
/**
 * Write a description of class SimpleInversionMutation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleInversionMutation extends ConsecutiveArrayElementOperation {
    
    private static Random random = new Random();
    
    //for testing
    public static SimpleInversionMutation getSimpleInversionMutation(int lowerCrossoverPoint, int higherCrossoverPoint) {
        
        return new SimpleInversionMutation(lowerCrossoverPoint, higherCrossoverPoint - 1);
    }
    
    public static SimpleInversionMutation getSimpleInversionMutation(int arrayLength) {
        
        int cutPoint1 = random.nextInt(arrayLength + 1);
        int cutPoint2 = random.nextInt(arrayLength + 1);
        
        int lowerCutPoint = Math.min(cutPoint1, cutPoint2);
        int higherCutPoint = Math.max(cutPoint1, cutPoint2);
        
        return new SimpleInversionMutation(lowerCutPoint, higherCutPoint - 1);
    }
    
    protected SimpleInversionMutation(int firstElementIndex, int lastElementIndex) { 
        
        super(firstElementIndex, lastElementIndex);
    }
    
    @Override
    protected int[] performElementOperation(int relativeElementIndex, List<int[]> originalArrays) {
        
        int swapPartnerRelativeIndex = getImpactedSubsetLength() - relativeElementIndex;
        int swapPartnerIndex = getFirstElementIndex() + swapPartnerRelativeIndex;
        int swapPartner = originalArrays.get(0)[swapPartnerIndex];
        
        return ArrayUtils.getElementsAsArray(swapPartner);
    }
    
}
