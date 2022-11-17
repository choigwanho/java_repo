package algorithm.basicMath;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SumEachNum {

    @Test
    public void test() {
        assertThat(solution(0), is(0));
        assertThat(solution(235), is(10));
        assertThat(solution(235678), is(31));
        assertThat(solution(-1), is(1));
    }

    public int solution(int value){
        int base = Math.abs(value);
        int result = 0;

        while (base>0){
            result  += base%10;
            base = base/10;
        }
        return result;
    }
}
