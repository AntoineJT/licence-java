package designpatterns.proxy;

import static utils.ExAssert.exAssert;

import java.util.ArrayList;
import java.util.List;

public class ProxySum {
    private final List<Long> cache;

    public ProxySum() {
        cache = new ArrayList<>();
    }

    public long sumFromOneTo(int to) {
        exAssert(to > 1, "Your call to ProxySum#sumFromOneTo is useless: result will be 1 because to=" + to);

        if (cache.size() >= to) {
            return cache.get(to);
        }

        final int size = cache.size();
        long result = size > 0 ? cache.get(size - 1) : 1;

        for (int i = size + 2; i <= to; ++i) {
            result += i;
            cache.add(result);
        }
        return result;
    }

    public static void main(String[] args) {
        ProxySum ps = new ProxySum();
        System.out.println(ps.sumFromOneTo(2));
        System.out.println(ps.sumFromOneTo(3));
        System.out.println(ps.sumFromOneTo(5));
        System.out.println();
        ps.cache.forEach(System.out::println);
    }
}
