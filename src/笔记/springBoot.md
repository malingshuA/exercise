# spring Boot 笔记

## 1.主启动类

1. **@SpringBootApplication：**标注在某个类上说明这个类是Spring Boot 的主配置类，Spring Boot就应该运行这个类的main方法来启动Spring Boot 应用。
   * **@ComponentScan：**这个注解在Spring很重要，它对应XML配置中的元素；自动扫描并加载符合条件的组件或者bean，将这个bean定义加载到IOC容器中。
   * **@SpringBootConfiguration：**SpringBoot配置类，标注在某个类上，表示这是一个SpringBoot的配置类。
     * **@Configuration：**说明这是一个配置类，配置类就是对应Spring的XML文件；
     * **@Component：**这就说明，启动类本身也是Spring中的一个组件而已，负责启动应用。

