import java.util.List;
import java.util.ArrayList;


/**
 * Abstract class ConsecutiveArrayElementOperation - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class ConsecutiveArrayElementOperation
{
    private int firstElementIndex;
    private int lastElementIndex;
    private List<int[]> originalArrays;
    
    abstract int[] performElementOperation(int relativeElementIndex, List<int[]> originalArrays);
    
    void onPostOperation(List<int[]> prevIterationArrays, int relativeElementIndex, List<int[]> arrays) {
        
    }
    
    protected ConsecutiveArrayElementOperation(int firstElementIndex, int lastElementIndex) { 
        
        this.firstElementIndex = firstElementIndex;
        this.lastElementIndex = lastElementIndex;
    }
    
    private void doExecuteOnArrays(List<int[]> arrays) {
        
        
        if (firstElementIndex == lastElementIndex) {
            return;
        }
        originalArrays = ArrayUtils.copyArrays(arrays);
        
        for (int i = firstElementIndex; i < lastElementIndex + 1; i++) { 
            
            int relativeIndex = i - firstElementIndex;
            
            List<int[]> prevIterationArrays = ArrayUtils.copyArrays(arrays);
            
            int[] operatedElements = performElementOperation(relativeIndex, originalArrays);
            
            changeElementsAtIndex(operatedElements, i, arrays);
            
            onPostOperation(prevIterationArrays, relativeIndex, arrays);
        }
    }
    
    public void executeOnArrays(int[]... arrays) {
        doExecuteOnArrays(ListUtils.getElementsAsList(arrays));
    }
    
    private void changeElementsAtIndex(int[] newElements, int index, List<int[]> arrays){
        for (int i = 0; i < newElements.length; i++) {
                arrays.get(i)[index] = newElements[i];
            }
    }
    protected int getFirstElementIndex() {
        return firstElementIndex;
    }
    
    private int getLastElementIndex() {
        return lastElementIndex;
    }
        
    protected int getImpactedSubsetLength() {
        
        return lastElementIndex - firstElementIndex;
    }
}
