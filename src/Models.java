/*
public  class Models
{
    public void selection (int[] array)
    {
        for (int left = 0; left < array.length; left++)
        {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--)
            {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i])
                {
                    array[i + 1] = array[i];
                }
                else
                {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
    }
    static void printArray(int[] array)
    {
        for(int i=0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Conversion<E>
{

    private List<E> list = new ArrayList<>();

    public Conversion(E[] array)
    {
        list.addAll(Arrays.asList(array));
    }

    public void showList()
    {
        for (Object ls : list)
        {
            System.out.print(ls + " ");
        }
        System.out.println();
    }

    public void add(E element)
    {
        list.add(element);
    }

    public List getList()
    {
        return list;
    }
}
