# JVM

- [程序计数器](readme/JVMPC.md)
- [虚拟机栈](readme/JVMStack.md)
- [GC算法](readme/GC-Algorithm.md)
- [GC回收器](readme/GC.md)

## 结构图

![JVM结构图](readme/static/uml/JVM_Struct.svg)

## 线程模型

- 每个线程: 独立包括程序计数器、栈、本地方法栈
- 线程间共享: 堆、堆外内存(永久代或元空间、代码缓存)

![JVM线程模型](readme/static/uml/JVM_Thread_Struct.svg)