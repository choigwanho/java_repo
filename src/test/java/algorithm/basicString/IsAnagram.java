package algorithm.basicString;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IsAnagram {

    /*
    * TASK
    * 주어진 문자열이 애너그램인지를 판단한다.
    * */

    // 방법 1. O(nlongn) : 정렬 후에 비교하기
    // 방법 2. O(n) : 문자열 개수를 세서 비교하기

    @Test
    public void test() {
        assertThat(애너그램판별_USE_MAP("arc", "car"), is(true));
        assertThat(애너그램판별_USE_MAP("caaabbb", "abababc"), is(true));
        assertThat(애너그램판별_USE_MAP("caabbbb", "abababc"), is(false));
        assertThat(애너그램판별_USE_MAP("arc", "carr"), is(false));
        assertThat(애너그램판별_USE_MAP("arc", "caz"), is(false));
    }

    private boolean 애너그램판별_USE_MAP(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> strMap = new HashMap<>();

        for (char c : str1.toCharArray()) {
            if (strMap.containsKey(c)) {
                strMap.put(c, strMap.get(c)+1);
            } else {
                strMap.put(c, 1);
            }
        }

        for (char c : str2.toCharArray()) {
            if (!strMap.containsKey(c)){
                return false;
            }
            if (strMap.get(c) == 0){
                return false;
            }
            strMap.put(c, strMap.get(c) - 1);
        }

        return true;
    }
}
