package exercise;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExercisesImpl implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().min((a,b)->a-b).orElseThrow();
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().max((a,b)->a-b).orElseThrow();
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o == o1;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> resList = new ArrayList<>();
        while(iterator.hasNext()){
            resList.add(iterator.next());
        }
        return resList;
    }

    @Override
    public int computeSumOfNumbers(int i) {
        int count = 0;
        for (int j = 0; j <= i; j++) {
            count += j;
        }
        return count;
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {
        int count = 0;
        for (int j = 0; j <= i; j++) {
            if (numberFilter.accept(j)){
                count += j;
            }
        }
        return count;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {
        return IntStream.range(1, i)
                .boxed().collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        return list.stream().mapToInt(v->v).boxed().collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(e->1)));
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {
        class IntegerGeneratorImpl implements IntegerGenerator{
            private Iterator numsIterator;

            public IntegerGeneratorImpl(int i, int i1) {
                List<Integer> nums = new ArrayList<>();
                for (int j = i; j < i1+1; j++) {
                    nums.add(j);
                }
                numsIterator = nums.iterator();
            }

            @Override
            public Integer getNext() {
                if (numsIterator.hasNext()){
                 return (Integer) numsIterator.next();
                } else {
                    return null;
                }
            }
        }
        return new IntegerGeneratorImpl(i, i1);
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        class IntegerGeneratorFiltered implements IntegerGenerator{
            private Iterator numsIterator;

            public IntegerGeneratorFiltered(IntegerGenerator intGen, NumberFilter myFilter) {
                List<Integer> nums = new ArrayList<>();

                while (intGen.getNext() != null) {
                    int num = intGen.getNext();
                    if (myFilter.accept(num)){
                        nums.add(num);
                    }
                }
                numsIterator = nums.iterator();
            }

            @Override
            public Integer getNext() {
                if (numsIterator.hasNext()){
                    return (Integer) numsIterator.next();
                } else {
                    return null;
                }
            }
        }

        return new IntegerGeneratorFiltered(integerGenerator, numberFilter);
    }
}
