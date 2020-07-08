package creator.util;

import java.util.Objects;

public class Pair<T, D> {
    private final T fst;
    private final D snd;

    public Pair(T fst, D snd){
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return fst.equals(pair.fst) &&
                snd.equals(pair.snd);
    }

    public boolean has(T t, D d){
        return fst == t && snd == d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }
}
