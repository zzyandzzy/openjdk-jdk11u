# GC

## 对比

![GC类型和对比](static/uml/GC_Type.svg)

- 新生代GC：Serial 、ParNew、Parallel Scavenge
- 老年代GC：Serial Old、Parallel Old、CMS
- 通用GC：G1

## 组合关系

![GC组合关系](static/uml/GC_Compose.svg)

## Serial GC：串行回收

- [测试用例](../../../../../src/test/java/cool/intent/jvm/gc/SerialGCTest.java)

Serial收集器是最基本、历史最悠久的垃圾收集器了。JDK1.3之前回收新生代唯一的选择。

Serial收集器作为HotSpot中Client模式下的默认新生代垃圾收集器。

Serial 收集器采用复制算法、串行回收和”Stop-The-World”机制的方式执行内存回收。

除了年轻代之外，Serial收集器还提供用于执行老年代垃圾收集的Serial Old收集器。Serial Old 收集器同样也采用了串行回收和"Stop The World”机制，只不过内存回收算法使用的是标记-压缩算法

Serial Old是运行在Client模式下默认的老年代的垃圾回收器

Serial Old在Server模式下主要有两个用途：
① 与新生代的Parallel Scavenge配合使用 
② 作为老年代CMS收集器的后备垃圾收集方案

![GC_Serial](static/uml/GC_Serial.svg)

这个收集器是一个单线程的收集器，但它的“单线程”的意义并不仅仅说明它**只会使用一个 CPU 或一条收集线程去完成垃圾收集工作**，更重要的是在它进行垃圾收集时，**必须暂停其他所有的工作线程**，直到它收集结束 (Stop The World)。

优势：

简单而高效（与其他收集器的单线程比），对于限定单个 CPU 的环境来说，Serial收集器由于没有线程交互的开销，专心做垃圾收集自然可以获得最高的单线程收集效率。

- 运行在Client模式下的虚拟机是个不错的选择。

在用户的桌面应用场景中，可用内存一般不大（几十MB至一两百MB）可以在较短时问内完成垃圾收集（几十ms至一百多ms），只要不频繁发生，使用串行回收器是可以接受的。

在Hotspot虚拟机中，使用 -xx:tuseserialGc 参数可以指定年轻代和老年代都使用串行收集器。

- 等价于 新生代用Serial GC，且老年代用Serial Old GC