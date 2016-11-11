import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class ListUtils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListUtils
{
    public static <T> List<T> getElementsAsList(T... elements) {
        
        List<T> list = new ArrayList<T>();
        
        for (T element : elements) {
            list.add(element);
        }
        
        return list;
    }
}
