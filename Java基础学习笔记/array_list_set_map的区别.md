java语言来自C语言，C语言里是没有集合List的。

由于Java需要集合,所以就在数组上扩充了一下，这就是List，List基于数组Array，是动态的可扩展的数组。

由于需要不能重复的集合，于是就有了Set。

由于List，set是基于数组的封装，所以操作数组比List，Set都要快。

List，set失去了速度，同时也扩展了功能。

1.List，Set继承与collection接口，Map没有

2.List元素可重复，有序。

3.set元素不可重复，无序。

4.Map键值对，无序。

由于List有下标，所以可以使用for循环来获取元素，也可以使用迭代来获取。set只能使用迭代来获取。

LinkedList，ArrayList，HashSet是线程不安全的，vector是线程安全的。

map中hashmap线程不安全，hashtable线程安全。