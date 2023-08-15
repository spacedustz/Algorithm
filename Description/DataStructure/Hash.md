## **💡 Hash**  

연결 리스트에 비해 검색 & 추가 & 제거 & 수정의 시간복잡도 효율이 좋은 자료구조인 키 & 값 기반의 Hash

Hash -> Key & Value Array의 구조로 가정함

해시는 사실상 배열 1개로 구성되어 있다.

<br>

### **Hash의 메서드**

- 시간복잡도를 효율적으로 바꿀 수 있는 메서드들
  - add()
  - remove(0
  - lookup() / find() / contains()
  - change()
- 시간복잡도가 최소 O(n)이 걸릴수 밖에 없는 메서드들
  - all entries
  - all keys
  - all values
- Hash에선 시간복잡도가 O(1)이지만 연결 리스트에선 O(n)이던 메서드들
  - size()
  - isEmpty()
  - isFull()
  - loadFactor()

```java
public static void main(String[] args) {
    // Map 선언
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
    // Map 안에 값 넣기
    // Map의 Key는 중복 불가, 동일한 Key에 다른 값을 넣을 경우 최근에 넣은 값 적용
	map.put("Soraka", 450);
	map.put("Garen", 4800); 
	map.put("Garen", 1350);
	
     // Key를 사용하여 Map 안의 값 가져오기
	System.out.println("Map Value : " + map.get("Garen")); 
    // 맵 크기 확인
	System.out.println("Map size : " + map.size());
	
    // Key 값의 내용을 변경
	map.replace("Garen", 450);
	System.out.println("Garen Value : " + map.get("Garen")); 
	
    // Key, Value가 존재하는지 확인
	System.out.println("Key Exist : " + map.containsKey("Garen"));
   	System.out.println("Value Exist : " + map.containsValue(450));
	
    // Map의 크기가 0인지 확인
	System.out.println("Map Empty : " + map.isEmpty());
	
    // key에 해당하는 값 삭제
	map.remove("Garen");
	map.put(null, 150);
	map.put("Garen", 450);
	
    // 키가 있으면 키의 값 반환, 없으면 default로 설정한 값 반환
	System.out.println
        ("Key가 있으면 Value 없으면 default : " + map.getOrDefault("Ahri", 6300));
	
	// Key가 없거나 Value가 null일 때만 삽입
	map.putIfAbsent("Master Yi", 6300);
	map.putIfAbsent("Garen", 6300);
	System.out.println
        ("Key가 없거나 Value가 null일 때만 삽입 : " + map.get("Master Yi"));
	System.out.println
        ("Key가 없거나 Value가 null일 때만 삽입 : " + map.get("Garen"));
}
```

---

## 💡 HashCode

객체의 주소값을 변환하여 생성된 객체의 고유한 정수값이다.

두 객체가 동일한 객체인지 동일성을 체크할 때 사용한다.

<br>

아래 예시의 person1과 person2의 hashCode는 당연히 다르다.

hashCode는 주소값을 기반으로 생성된 정수 값이기 때문에 2,3의 hashCode는 동일하다.

```java
public class HashCode {
    public static void main(String[] args) {
        Person person1 = new Person("Kim");
        Person person2 = new Person(new String("Kim"));
        Person person3 = person2;

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Person anotherObj = (Person) obj;
        return (this.name.equals(anotherObj.name));
    }
}

// 결과값
// 3565735997
// 1735600054
// 1735600054
```

<br>

### String 클래스의 hashCode()

String은 재정의한 equals()에서 각 문자열에서 한 글자씩 비교하는 방식이다.

아래 코드는 문자열에서 한글자씩 가져와서 정수값으로 변경하고 정수와 더하면
해당 글자의 아스키 코드의 값을 사용한다.

31을 곱하는 이유는 홀수이기 때문이다.

짝수를 곱했을 때 오버플로우 되면 정보 손실이 발생할 수 있기 때문이다.

이진수에서 2를 곱하면 비트가 왼쪽으로 1칸씩 이동한다.

홀수 중 31의 장점은 **31 * i가 (i << 5) - i** 와 같기 때문에 곱셈 대신 비트 이동 및 뺄셈으로 처리하여
성능상 이점이 있기 떄문이며, 요즘은 VM에서 자동으로 최적화를 해준다.

결론적으로 주소값을 기준으로 정수값의 hashCode를 생성하는 것이 아닌, 서로 다른 String 객체도
문자열이 같으면 hashCode가 같은 것이다.

```java
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;
        
        for (int i=0; i<value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
```

---

### String 클래스의 hashCode()

String은 재정의한 equals()에서 각 문자열에서 한 글자씩 비교하는 방식이다.

아래 코드는 문자열에서 한글자씩 가져와서 정수값으로 변경하고 정수와 더하면
해당 글자의 아스키 코드의 값을 사용한다.

31을 곱하는 이유는 홀수이기 때문이다.

짝수를 곱했을 때 오버플로우 되면 정보 손실이 발생할 수 있기 때문이다.

이진수에서 2를 곱하면 비트가 왼쪽으로 1칸씩 이동한다.

홀수 중 31의 장점은 **31 * i가 (i << 5) - i** 와 같기 때문에 곱셈 대신 비트 이동 및 뺄셈으로 처리하여
성능상 이점이 있기 떄문이며, 요즘은 VM에서 자동으로 최적화를 해준다.

결론적으로 주소값을 기준으로 정수값의 hashCode를 생성하는 것이 아닌, 서로 다른 String 객체도
문자열이 같으면 hashCode가 같은 것이다.

```java
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;
        
        for (int i=0; i<value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
```

---

## **💡 Hash Collision**

- 서로 다른 값의 키가 일치하는 경우를 의미한다
- 충돌이 일어나지 않게 Folding 하는 방법
  - 함수를 구현할때 충돌을 피하고자 할때 어떻게 분포를 더 넓게 할지 생각하기
- 아래 사진은 전화번호를 받아서 3분할한 합을 키 배열에 저장하는 도중 Folding이 발생한 사진이다

<br>

번호를 3분할한것의 합을 키로 지정, 충돌 발생

![img](https://raw.githubusercontent.com/spacedustz/Obsidian-Image-Server/main/img/kub2.png) 

- hashCode에서의 충돌문제를 해결한 **문자열 표현**
- 문자는 유니코드로 변환하여 숫자로 나타낼 수 있고, 각 문자를 변환 후 그 숫자들을 합하면 된다
  하지만 그렇게 했을 경우 단순히 문자의 위치와 관계없이 같은 문자열이 있다면 **해시 충돌**이 발생한다
- 문자의 위치에 따라 상수 g를 곱하는 횟수를 다르게 해서 충돌 문제 해결
  - 116 + g(104 + g(105 + g(115)))

```java
    // 문자열을 기반으로 정수를 계산해주는 hashCode
    public int hashCode(String s) { // this 가 입력으로 들어온다고 가정
        int g = 31;
        int hash = 0; // 키 배열에 저장될 반환값

        // 상수 g를 문자의 위치만큼 제곱한뒤 곱한다
        for (int i=s.length()-1; i>=0; i--) { // s, i, h, t
            hash = g * hash + s.charAt(i);
        }
        return hash;
    }
```

<br>

같은 문자열이지만 문자의 위치에 따라 다른 결과값 반환, 충돌 문제 해결

![img](https://raw.githubusercontent.com/spacedustz/Obsidian-Image-Server/main/img/DataStructure_Hash_2.png)

<br>

### **Hash Collision 방지를 위한 해시 크기 최적화**

- ex 1: 해시의 크기를 홀수로 설정하여 % 연산자를 사용했을 때 다양한 결과가 출력되도록 한다
  - hashCode() 에서 반환된 정수값으로 배열의 인덱스값으로 쓸 수 있도록 최적화 (정수는 음&양수 둘다 해당 가능)
  - 테이블 크기 최적화 (테이블의 크기를 홀수 & 소수로 설정)
- ex 2: 해시의 크기를 소수로 설정하여 나머지 값이 더 다양한 결과가 출력되도록 함
- 테이블 크기를 늘리는것과 왜 충돌이 발생할까?
  - hashCode는 키 값에서 정수값을 계산하는데 이때 해시 테이블의 길이를 벗어나지 않기 위해서
    테이블 길이로 해시함수의 리턴값의 나머지 연산한다
  - 예를 들어, 테이블의 크기가 6이고 특정 해시 함수를 사용했을때
    2배의 배수를 반환한다면 2,4,6,8 등을 반환하는데 이것을 해시 테이블 사이즈에 맞게 조정(%)하면
    **2%6** = 2 | **4%6** = 4 | **6%6** = 0 | **8%6** = 2 | **10%4** = 4 로 변한다

![img](https://raw.githubusercontent.com/spacedustz/Obsidian-Image-Server/main/img/DataStructure_Hash_4.png) 

- 이때, 테이블의 크기를 소수로 만들면 값이 균등하게 들어간다
  (소수는 1과 자기 자신을 제외한 수의 배수가 될 수 밖에 없기 때문)
- 배수가 나오는 경우의 수를 최대한 줄일때 충돌을 최대한 방지할 수 있게 된다
- 홀수로 설정하는 경우도 마찬가지로 모든 짝수는 최소공약수인 2를 공유하기 때문이다

![img](https://raw.githubusercontent.com/spacedustz/Obsidian-Image-Server/main/img/DataStructure_Hash_3.png) 

<br>

### **2의** **보수 성질을 이용한 해시값의 양수 변환**

- 배열의 인덱스는 음수가 될 수 없기 때문에 양수로 변환을 해줘야 한다
- 해시 결과값(음수)과 0x7FFFFFFF를 And연산 해주고 양수로 변환된 값에 테이블의 사이즈를 % 하면 됨

```java
// data의 index 결정
int hashval = data.hashCode(s);
hashval = hashval & ox7FFFFFFF;
hashval = hashval % tableSize;
```

<br>

### **loadFactor() - 적재율**

- 테이블에 데이터가 얼마나 있는지 알려주는 메서드
- 0 = 비어있다 / 1 = 꽉 찼다