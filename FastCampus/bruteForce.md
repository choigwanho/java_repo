# 완전 탐색(Brute Force) 알고리즘
## 완전탐색(Brute Force)이란?
### 완전탐색 
- **문제를 해결하기 위해 확인해야하는 모든 경우**를 전부 탐색하는 방법
- 단순 For문 만을 사용하는 것이 아닌, 백 트래킹(Back-Tracking)을 통해서 혹은, 재귀함수를 통해서 문제를 해결해야하는 상황

### 장점
- 모든 경우를 보아 어떻게든 정답을 구할 수 있기 때문에 **부분점수를 얻기 좋다**

### 단점
- 전부 탐색하기 때문에 시간 복잡도가 일반적으로 높다.

### 코테에 나오는 완전 탐색 종류 
1) N개중 중복 허용을 허용해서
2) N개중 중복 없이
N개중 M개를
A) M개를 순서 있게 나열하기
B) M개를 고르기

### 일반적인 풀이
0) 사람이 어떻게 풀지 파악
1) 시간복잡도, 공간복잡도 계산
2) 함수 정의
- 완전 탐색은 함수 정의가 50%
3) 구현

## 예제 : 15651, 15649, 15652, 15650
### BOJ 15651: N개 중 중복을 허용해서 M개를 순서있게 나열하기 예제 (1+A)
1. 복잡도
시간: O(N^M) =7^7=82만 (1초에 1억번 연산, 1초이내 연산가능)
공간: 표현해야 하는 숫자가 M개 임으로 O(M)

2. 함수 스케치
- 재귀함수(Recurrence Function)로 접근
> i) M개를 전부 고름 => 조건에 맞는 한 가지 탐색 성공
> ii) 아직 M개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법 시도  

3. 구현
```java
static int N, M; 
static int[] selected;
static void rec_func(int k){
    if(k == M + 1){
        for(int i=1;i<M;i++>) sb.append(selected[i]).append('');
        s.appedn('\n');
    }else{
        for(int cand=1;cand<=N;cand++>){
            selected[k] = cand;
            rec_func(k+1);
            selected[k] = 0;
        }
    }
}
```

### BOJ 15649: N개 중 중복 없이 M개를 순서있게 나열하기 예제 (2+A)
1. 복잡도
시간: O(N!/(N-M)!) =8!/0!=4만 (1초에 1억번 연산, 1초이내 연산가능)
공간: 표현해야 하는 숫자가 M개 임으로 O(M)

2. 함수 스케치
- 재귀함수(Recurrence Function)로 접근
> i) M개를 전부 고름 => 조건에 맞는 한 가지 탐색 성공
> ii) 아직 M개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법 시도 
+ 중복이 있는지 여부 체크 

3. 구현
- for문 이용 버전
```java
static int N, M; 
static int[] selected;
static void rec_func(int k){
    if(k == M + 1){
        for(int i=1;i<M;i++>) sb.append(selected[i]).append('');
        s.appedn('\n');
    }else{
        for(int cand=1;cand<=N;cand++>){
            boolean isUsed =false;
            for (int i=1;i<k;i++)
                if(cand==selected[i])
                    isUsed=true;
            // k 번째에 cand 가 올 수 있으면
            if(!isUsed){
                selected[k] = cand;
                rec_func(k+1);
                selected[k]=0;
            }
        }
    }
}
```
- used 배열 이용 버전
```java
static int N, M; 
static int[] selected, used;
static void rec_func(int k){
    if(k == M + 1){
        for(int i=1;i<M;i++>) sb.append(selected[i]).append('');
        s.appedn('\n');
    }else{
        for(int cand=1;cand<=N;cand++>){
            if (used[cand]==1) continue;
            // k 번째에 cand 가 올 수 있으면
            selected[k] = cand;     used[cand]=1;

            reg_func(k+1);

            selected[k]=0;      used[cand]=0;
        }
    }
}
```


### BOJ 15652: N개 중 중복을 허용해서 M개를 고르기 예제 (1+B)
1. 복잡도
시간: O(N^M) 보단 작다 => 8^8 = 1677만 (1초에 1억번 연산, 1초이내 연산가능)
공간: 표현해야 하는 숫자가 M개 임으로 O(M)

2. 함수 스케치
- 재귀함수(Recurrence Function)로 접근
> i) M개를 전부 고름 => 조건에 맞는 한 가지 탐색 성공
> ii) 아직 M개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법 시도 
+ 이전에 사용했던 숫자보단 크거나 같아야 함

3. 구현
```java
static int N, M; 
static int[] selected;
static void rec_func(int k){
    if(k == M + 1){
        for(int i=1;i<M;i++>) sb.append(selected[i]).append('');
        s.appedn('\n');
    }else{
        int start = selected[k-1];
        if(start == 0) start =1;
        for(int cand=start;cand<=N;cand++){
            if (used[cand]==1) continue;
            // k 번째에 cand 가 올 수 있으면
            selected[k] = cand;
            reg_func(k+1);
            selected[k]=0;
        }
    }
}
```

### BOJ 15650: N개 중 중복없이 M개를 고르기 예제 (2+B)
1. 복잡도
시간: O(N!/((M!(N-M)!))  => 8!/(4!4!) = 70 (1초에 1억번 연산, 1초이내 연산가능)
공간: 표현해야 하는 숫자가 M개 임으로 O(M)

2. 함수 스케치
- 재귀함수(Recurrence Function)로 접근
> i) M개를 전부 고름 => 조건에 맞는 한 가지 탐색 성공
> ii) 아직 M개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법 시도 
+ 이전에 사용했던 숫자보다 작아야함

3. 구현
```java
static int N, M; 
static int[] selected;
static void rec_func(int k){
    if(k == M + 1){
        for(int i=1;i<M;i++>) sb.append(selected[i]).append('');
        s.appedn('\n');
    }else{
        for(int cand=selected[k-1];cand<=N;cand++){
            selected[k] = cand;
            reg_func(k+1);
            selected[k]=0;
        }
    }
}
```
