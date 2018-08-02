package ru.cloudinfosys.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUtils {
    // I use copy of array for output because removing elements from original list
    // would cause tail copy and is not cost effective

    /** Method return list with removed continuous duplicates
     * if there count more or equal dupCount */
    public static final List<Integer> removeContinuousDuplicates(List<Integer> list, int dupCount) {
        if (list == null) throw new IllegalArgumentException("list arg must be not null");
        if (dupCount < 2) throw new IllegalArgumentException("dupCount arg must be more or equal 2");

        int lastValue = 0;
        int count = 0;
        List<Integer> resultList = new ArrayList<>();

        for (Integer i : list) {
            if (i == null) throw new IllegalArgumentException("list must not contain null values");

            // First condition show is lastValue initialized
            if (count != 0 && lastValue == i) {
                count++;
            } else {
                // if count lower then duplicate count, restore sequence in a list
                if (count < dupCount) {
                    for (int j = 0; j < count; j++) {
                        resultList.add(lastValue);
                    }
                }

                count = 1;
                lastValue = i;
            }
        }

        // if count lower then duplicate count, restore sequence in a list
        if (count < dupCount) {
            for (int j = 0; j < count; j++) {
                resultList.add(lastValue);
            }
        }

        return resultList;
    }

    /** Remove continuous duplicates if there count more or equal dupCount */
    public static final void deleteContinuousDuplicates(List<Integer> list, int dupCount) {
        // Self modified version

        List<Integer> newList = removeContinuousDuplicates(list, dupCount);
        list.clear();
        list.addAll(newList);
    }


    /** Method return list with removed duplicates
     * if there count more or equal dupCount */
    public static final List<Integer> removeDuplicates(List<Integer> list, int dupCount) {
        if (list == null) throw new IllegalArgumentException("list arg must be not null");
        if (dupCount < 2) throw new IllegalArgumentException("dupCount arg must be more or equal 2");

        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer i : list) {
            if (i == null) throw new IllegalArgumentException("list must not contain null values");

            Integer value = countMap.get(i);
            countMap.put(i, value == null ? 1 : value + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : list) {
            if (countMap.get(i) < dupCount) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    /** Remove duplicates if there count more or equal dupCount */
    public static final void deleteDuplicates(List<Integer> list, int dupCount) {
        // Self modified version

        List<Integer> newList = removeDuplicates(list, dupCount);
        list.clear();
        list.addAll(newList);
    }

}
