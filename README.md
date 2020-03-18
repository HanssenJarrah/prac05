CAB302 Software Development
===========================

# Week 5: Collections




## Exercise 1: Matrix

A [matrix](https://en.wikipedia.org/wiki/Matrix_(mathematics)) is a rectangular array of values arranged in rows and columns. For example:
$$
\begin{matrix}
  a & b & c & d \\
  e & f & g & h \\
  i & j & k & l
 \end{matrix}
$$
You are to implement a new collection, a `Matrix`. Ordinarily, new collections would implement the Collection interface, but for the purpose of this exercise, we will not do this so as to avoid implementing the eleven additional methods as part of the interface. However, because all collections can be instantiated with any type, your `Matrix` class will need to be generic. Therefore, the tests for this exercise will attempt to instantiate and test your `Matrix` class using both `Integer` and `String` cell values.

The provided skeleton will help you get started. The first step is to fix the current compiler errors by inserting the correct return types and parameters for each method (and constructor) according to the JavaDoc comments. The next step is figuring out how you will internally model the Matrix. Look into Collection types that currently exist and think about how you can use them and their methods as a backbone for the class.

Remember, your class will need to make correct use of a generic type, but it is suggested that you initially experiment with a non-generic type (e.g. by just using integers or strings for the cell values), until you achieve a working matrix. After which, replace your hard-coded cell value type with a generic type.

`toString()` should take the following form for `Integer` objects: 

```
8	14	16	10	20
16	21	4	12	2
21	4	10	19	8
21	16	4	2	9
21	7	7	3	7
3	3	13	13	6
2	16	16	12	15
```

And the following form for `String` objects:

```
J	VK	k	J	j	bX	fv
h	bO	UJ	gR	Tr	k	t
jA	Za	D	dg	rt	jh	AX
o	ql	P	pj	A	nd	hd
```

Note that the dimension size will be randomized in testing (the above two examples are randomized). The tests and the above two examples use tabs to separate the cell values. You can achieve the same result by inserting a `\t` character at the end of each cell value (except for the last cell of each row) when constructing the string.

Note that the implementation of the iterator must be in column-major order as per the API. See below for an example of this.

You can test your class by creating a main:

```java
public static void main(String[] args) {
    Matrix<String> m = new Matrix<String>(2, 2);
	
    m.insert(0, 0, "a");
    m.insert(0, 1, "b");
    m.insert(1, 0, "c");
    m.insert(1, 1, "d");
	
    System.out.println(m + "\n");
	
    for (String element : m) {
        System.out.println(element);
    }
}
```

In this case, the output should be:

```
a	b
c	d
	
a
c
b
d
```


## Exercise 2: MapSet

Implement a new class `MapSet<K, V>` that extends `AbstractMap<K, HashSet<V>>` and implements `Iterable<V>` where `K` represents a generic key, and `V` represents a generic value:

```Java
public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V>
```

The purpose of this class is to store a dictionary of keys `K` to `HashSet<V>` objects.

### Methods

Only three methods are required, but you may choose to add additional helper methods.

#### addValue

Implement `addValue` such that calling this method adds the given value to the `HashSet` associated with the given key. This method must have the following signature:

```Java
public void addValue(K, V)
```

#### iterator

Implement the iterator such that only values `V` are traversed. Values are traversed first in descending order of the size of `HashSet` objects associated with keys, and then in the iterator order for the `HashSet`.

#### entrySet

This method must be implemented and overridden from `AbstractMap`. It should simply return a `Set<Entry<K, HashSet<V>>` of the `MapSet`.

### Output

Example output is shown below. For the given main:

```java
public static void main(String[] args) {
    MapSet<String, Integer> map = new MapSet<>();
    map.addValue("B", 4);
    map.addValue("A", 0);
    map.addValue("A", 1);
    map.addValue("B", 3);
    map.addValue("A", 2);
    for (Integer value : map) {
        System.out.println(value);
    }
}
```

The expected output is:

```
0
1
2
3
4
```

Values in key `"A"`  are traversed first because it has the largest quantity of elements associated with it. Values within `"A"` are then traversed in the order of the iterator of its associated `HashSet`. Next, the traversal is repeated for `"B"`.