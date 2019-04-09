# AOP Demos
## Compile time weaving
- [AspectJ ajc](https://github.com/fanjingdan012/aop-learn/tree/master/aop-aspectj-ctw)
  - 依赖 ASM
- AspectJ 编译后织入
  - 依赖 ASM
- JDK静态代理（自己手写Proxy，没意思）
## Load time weaving
- AspectJ ltw
  - 依赖 [Java agent](https://github.com/fanjingdan012/aop-learn/tree/master/aop-java-agent)
## Run time weaving
- Spring CGLib
  - 依赖 CGLib
    - 依赖 ASM
- JDK Proxy 动态代理