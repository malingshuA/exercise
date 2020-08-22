# spring Boot 笔记

## 1.主启动类

1. **@SpringBootApplication：**标注在某个类上说明这个类是Spring Boot 的主配置类，Spring Boot就应该运行这个类的main方法来启动Spring Boot 应用。

   ```java
   @SpringBootConfiguration
   @EnableAutoConfiguration
   @ComponentScan(
       excludeFilters = {@Filter(
       type = FilterType.CUSTOM,
       classes = {TypeExcludeFilter.class}
   ), @Filter(
       type = FilterType.CUSTOM,
       classes = {AutoConfigurationExcludeFilter.class}
   )}
   )
   public @interface SpringBootApplication {
       // ......
   }
   ```

   * **@ComponentScan：**这个注解在Spring很重要，它对应XML配置中的元素；自动扫描并加载符合条件的组件或者bean，将这个bean定义加载到IOC容器中。

   * **@SpringBootConfiguration：**SpringBoot配置类，标注在某个类上，表示这是一个SpringBoot的配置类。
     
     ```java
     //点进去得到下面的@Component
     @Comfiguration
     public @interface SpringBootConfiguration{}
     
     @Component
     public @interface Configuration{}
     ```
     
     * **@Configuration：**说明这是一个配置类，配置类就是对应Spring的XML文件；
     * **@Component：**这就说明，启动类本身也是Spring中的一个组件而已，负责启动应用。
     
   * **@EnableAutoConfigUration：**

     * **@EnableAutoConfiguration：**告诉Spring boot 开启自动配制功能，这样自动配制才能生效。
     * **@AutoConfigurationPackage：**自动配制包。

     ```java
     @Import({Registrar.class})
     public @interface AutoConfigurationPackage{
         
     }
     ```

     	+ **@import：**Spring 底层注解@import，给容器中导入一个组件。

     + **Registrar.class** 作用：将主启动类的所在包及下面所有的子包里面的所有组件扫描到Spring容器；
     + **Import（{AutoConfigurationImportSelector.class})：**给容器导入组件；
       + **AutoConfigurationImportSelector：**自动配制导入选择器，

## yaml语法：

SpringBoot使用了一个全局配置文件，名称固定，两种方式：

* application.properties
  * 语法结构：key = value
* application.yml
  * 语法结构：key:(空格)value

配置文件的作用：修改SpringBoot的配置的默认值。



**@PropertySource：**加载指定的配置文件；

**@configurationProperties：**默认从全局配置中获取值；



## JSR303 数据校验

Springboot 中可以用 @validated 来检验数据，如果数据异常则会统一抛出异常，方便异常中心统一处理。

```java
@Component //注册bean
@ConfigurationProperties(prefix = "person")
@Validated  //数据校验
public class Person {

    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String name;
}
```

**常见的参数：**

* @NotNull(message="名字不能为空")
  private String userName;
* @Max(value=120,message="年龄最大不能查过120")
  private int age;
* @Email(message="邮箱格式错误")
  private String email;

* 空检查
  @Null       验证对象是否为null
  @NotNull    验证对象是否不为null, 无法查检长度为0的字符串
  @NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
  @NotEmpty   检查约束元素是否为NULL或者是EMPTY.

* Booelan检查
  @AssertTrue     验证 Boolean 对象是否为 true  

  @AssertFalse    验证 Boolean 对象是否为 false  

* 长度检查
  @Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内 
  @Length(min=, max=) string is between min and max included.

* 日期检查
  @Past       验证 Date 和 Calendar 对象是否在当前时间之前  

  @Future     验证 Date 和 Calendar 对象是否在当前时间之后  

  @Pattern    验证 String 对象是否符合正则表达式的规则

**多环境切换：**

application-{profile}.properties/yml，用来指定多个环境的版本。

例如：

* application-test.properties：代表测试环境配置
* application-dev.properties：代表开发环境配置

需要在主配置文件上写上：

```properties
spring.profiles.active=dev
```

**访问的优先级：**

* 优先级1：项目路径下的config文件夹配置文件。
* 优先级2：项目路径下配置文件。
* 优先级3：资源路径下的config文件夹配置文件。
* 优先级4：资源路径下配置文件。

springBoot 会从这四个位置全部加载主配置文件；互补配置；

**分析自动配置原理：**

我们以HttpEncodingAutoConfiguration（http编码自动配置）为例解释自动配置原理；

```java
//表示这是一个配置类，和以前编写的配置文件一样，也可以给容器中添加组件；
@Configuration 

//启动指定类的ConfigurationProperties功能；
  //进入这个HttpProperties查看，将配置文件中对应的值和HttpProperties绑定起来；
  //并把HttpProperties加入到ioc容器中
@EnableConfigurationProperties({HttpProperties.class}) 

//Spring底层@Conditional注解
  //根据不同的条件判断，如果满足指定的条件，整个配置类里面的配置就会生效；
  //这里的意思就是判断当前应用是否是web应用，如果是，当前配置类生效
@ConditionalOnWebApplication(
    type = Type.SERVLET
)

//判断当前项目有没有这个类CharacterEncodingFilter；SpringMVC中进行乱码解决的过滤器；
@ConditionalOnClass({CharacterEncodingFilter.class})

//判断配置文件中是否存在某个配置：spring.http.encoding.enabled；
  //如果不存在，判断也是成立的
  //即使我们配置文件中不配置pring.http.encoding.enabled=true，也是默认生效的；
@ConditionalOnProperty(
    prefix = "spring.http.encoding",
    value = {"enabled"},
    matchIfMissing = true
)

public class HttpEncodingAutoConfiguration {
    //他已经和SpringBoot的配置文件映射了
    private final Encoding properties;
    //只有一个有参构造器的情况下，参数的值就会从容器中拿
    public HttpEncodingAutoConfiguration(HttpProperties properties) {
        this.properties = properties.getEncoding();
    }
    
    //给容器中添加一个组件，这个组件的某些值需要从properties中获取
    @Bean
    @ConditionalOnMissingBean //判断容器没有这个组件？
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.properties.getCharset().name());
        filter.setForceRequestEncoding(this.properties.shouldForce(org.springframework.boot.autoconfigure.http.HttpProperties.Encoding.Type.REQUEST));
        filter.setForceResponseEncoding(this.properties.shouldForce(org.springframework.boot.autoconfigure.http.HttpProperties.Encoding.Type.RESPONSE));
        return filter;
    }
    //。。。。。。。
}
```

一句话总结：根据当前不的条件判断，决定这个配置类是否生效！

* 一旦这个配置类生效，这个配置类就会给容器中添加各种组件。
* 这些组件的属性是从对应的properties类中获取的，这些类里面的每一个属性又是和配置文件绑定的；
* 所有在配置文件中能配置的属性都是在xxxxProperties类中封装着。
* 配置文件能配置什么就可以参照某个功能对应的这个属性类