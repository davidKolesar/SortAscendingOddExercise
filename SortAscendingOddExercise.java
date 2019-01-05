import java.util.*;

public class Kata {
  public static int[] sortArray(int[] array) {
       //key is place, value is value
        Map<Integer, Integer> numeralsWithPlaceholder = new HashMap<Integer, Integer>();
        List<Integer> oddsList = new ArrayList<>();

        numeralsWithPlaceholder.clear();
        oddsList.clear();

        //perform null check
        if (nullOrEmptyCheck(array))
        {
            return array;
        }

        for (int i = 0; i < array.length; i++)
        {
            //saving placeholder and value of evens
            if (array[i] % 2 == 0 || array[i] == 0)
            {
                System.out.println(array[i] + " is added to even at space " + i);
                numeralsWithPlaceholder.put(i, array[i]);
            }
            else
            {
                //saving odd numbers
                oddsList.add(array[i]);
                System.out.println(array[i] + " is added to odd");
            }
        }

        //put odds in ascending order   
        Collections.sort(oddsList);

        //add placeholders to oddsList to prevent Array Out Of Bounds Error
        for (int i = 0; i < oddsList.size() + numeralsWithPlaceholder.size(); i++)
        {

            if (numeralsWithPlaceholder.containsKey(i))
            {
                oddsList.add(i, 0);
            }
        }


        //create the new array
        int[] organizedIntegers = new int[array.length];


        for (int i = 0; i < array.length; i++)
        {

            //evaluate if this place in array contains an even number
            if (numeralsWithPlaceholder.containsKey(i))
            {
                System.out.println(i + " placeholder was originally even and was added here");
                organizedIntegers[i] = numeralsWithPlaceholder.get(i);

            }
            else
            {
                System.out.println(i + " placeholder was originally odd and was added here");
                organizedIntegers[i] = oddsList.get(i);
            }
        }
        return organizedIntegers;
    }

    private static boolean nullOrEmptyCheck(int[] array)
    {
        if (array.length == 0 || array == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}