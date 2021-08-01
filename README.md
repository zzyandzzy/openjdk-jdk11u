# jdk11

Welcome to the JDK!
===================

For information about building the JDK, including how to retrieve all
of the source code, please see either of these files:

  * doc/building.html   (html version)
  * doc/building.md     (markdown version)

See http://openjdk.java.net/ for more information about the OpenJDK
Community and the JDK.

## 导航

- [jvm](learn/src/main/resources/jvm/README.md)
- [java.lang](learn/src/main/resources/java/lang/README.md)
- [java.util](learn/src/main/resources/java/util/README.md)

编译jdk11需要`boot jdk`，也就是另外一个JDK来编译这个JDK...（经典套娃）。

- JDK版本必须大于等于`10`。
- make版本最好是`4.2.1`
- gcc版本最好gcc-9

## build

### 参数

--with-debug-level=slowdebug 启用slowdebug级别调试

--enable-dtrace 启用dtrace

--with-jvm-variants=server 编译server类型JVM

--with-target-bits=64 指定JVM为64位

--enable-ccache 启用ccache，加快编译

--with-num-cores=8 编译使用CPU核心数

--with-memory-size=8000 编译使用内存

--disable-warnings-as-errors 忽略警告 , mac 使用 xcode 编译, 官方要求加上这个参数.

--with-freetype 设置freetype的路径

### linux

1. 首先安装JDK11

**gentoo**

```bash
sudo emerge -av dev-java/openjdk freetype
```

2. 工具链版本

确保make版本是`4.2.1`

```bash
make -v
GNU Make 4.2.1
为 x86_64-pc-linux-gnu 编译
Copyright (C) 1988-2016 Free Software Foundation, Inc.
许可证：GPLv3+：GNU 通用公共许可证第 3 版或更新版本<http://gnu.org/licenses/gpl.html>。
本软件是自由软件：您可以自由修改和重新发布它。
在法律允许的范围内没有其他保证。
```

确保gcc版本是gcc-9

```bash
➜  ~ git:(master) ✗ gcc -v
使用内建 specs。
COLLECT_GCC=gcc
COLLECT_LTO_WRAPPER=/usr/libexec/gcc/x86_64-pc-linux-gnu/9.4.0/lto-wrapper
目标：x86_64-pc-linux-gnu
配置为：/var/tmp/portage/sys-devel/gcc-9.4.0/work/gcc-9.4.0/configure --host=x86_64-pc-linux-gnu --build=x86_64-pc-linux-gnu --prefix=/usr --bindir=/usr/x86_64-pc-linux-gnu/gcc-bin/9.4.0 --includedir=/usr/lib/gcc/x86_64-pc-linux-gnu/9.4.0/include --datadir=/usr/share/gcc-data/x86_64-pc-linux-gnu/9.4.0 --mandir=/usr/share/gcc-data/x86_64-pc-linux-gnu/9.4.0/man --infodir=/usr/share/gcc-data/x86_64-pc-linux-gnu/9.4.0/info --with-gxx-include-dir=/usr/lib/gcc/x86_64-pc-linux-gnu/9.4.0/include/g++-v9 --with-python-dir=/share/gcc-data/x86_64-pc-linux-gnu/9.4.0/python --enable-languages=c,c++,fortran --enable-obsolete --enable-secureplt --disable-werror --with-system-zlib --enable-nls --without-included-gettext --enable-checking=release --with-bugurl=https://bugs.gentoo.org/ --with-pkgversion='Gentoo 9.4.0 p1' --disable-esp --enable-libstdcxx-time --enable-shared --enable-threads=posix --enable-__cxa_atexit --enable-clocale=gnu --enable-multilib --with-multilib-list=m32,m64 --disable-fixed-point --enable-targets=all --enable-libgomp --disable-libssp --disable-libada --disable-systemtap --enable-vtable-verify --enable-lto --without-isl --enable-default-pie --enable-default-ssp
线程模型：posix
gcc 版本 9.4.0 (Gentoo 9.4.0 p1)
```

3. 编译

```bash
./configure --with-debug-level=fastdebug --with-jvm-variants=server --with-target-bits=64 --with-num-cores=8 --with-memory-size=16384 --disable-warnings-as-errors --with-freetype=system --with-boot-jdk=/usr/lib64/openjdk-11

# 编译器能够识别源码，如CLion
make compile-commands
make all
```

### macOS

```bash
# 安装freetype
brew install freetype

chmod +x ./configure

./configure --with-debug-level=slowdebug --enable-dtrace --with-jvm-variants=server --with-target-bits=64 --with-num-cores=8 --with-memory-size=16384 --disable-warnings-as-errors --with-freetype=bundled --with-boot-jdk=/Library/Java/JavaVirtualMachines/openjdk-11.jdk/Contents/Home
```

```bash
# 编译
make images
# 因为make版本太新导致的错误参考用
➜  ~ make --version 
GNU Make 4.2.1 
Built for x86_64-pc-linux-gnu 
Copyright (C) 1988-2016 Free Software Foundation, Inc. 
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html> 
This is free software: you are free to change and redistribute it. 
There is NO WARRANTY, to the extent permitted by law. 

gcc-9 (Homebrew GCC 9.3.0_2) 9.3.0
Copyright (C) 2019 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

# 因为gcc10太新导致的错误，建议用gcc 9
# https://bugs.openjdk.java.net/browse/JDK-8235903

# 清理
make clean && make dist-clean

# 快速编译jdk
make jdk
```

## 参考

- [写Java这么久，JDK源码编译过没？编译JDK源码踩坑纪实](https://segmentfault.com/a/1190000023251649)
- [OpenJDK 编译调试指南(Ubuntu 16.04 + MacOS 10.15)](https://juejin.cn/post/6847902216414560264)