package creator.util;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReadOnlyList<T> {
    private final ArrayList<T> arrayList;

    public ReadOnlyList(ArrayList<T> list){
        this.arrayList = list;
    }

    public T get(int index){
        return arrayList.get(index);
    }

    public boolean contains(T obj){
        return arrayList.contains(obj);
    }

    public boolean forAny(Predicate<? super T> predicate){
        return arrayList.stream().anyMatch(predicate);
    }
    public boolean forAll(Predicate<? super T> predicate){
        return arrayList.stream().allMatch(predicate);
    }

    public Stream<T> stream(){
        return arrayList.stream();
    }
}
