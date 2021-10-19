<h1 align="center">Multi-thread POC (proof of concept)</h1>
<p align="center">This is a POC of multi-thread process that recover a list of defendants and generate hash of their names in a parallel approach.</p>


#### Technologies:

* Java with Spring Boot;
* java.util.concurrent.CountDownLatch;
* java.util.concurrent.ExecutorService;
* java.util.concurrent.Executors.

<hr>

#### Attention points:

* A regular Runnable class cannot inject Repositories interfaces (@Autowired) in a Spring Boot Application unless you make it as a @Component with @Scope("prototype") to return each Runnable Classe individually.

Example:
```java
/**
 * @author Bruno Paz (bscpaz)
 */

@Component
@Scope("prototype")
public class MyRunnable implements Runnable {
  private CountDownLatch countDownLatch = null;
  private someDto someDto = null;

  @Autowired
  private MyRepository repository;

  public MyRunnable() {
    super();
  }
  
  //Getters ans Setters
  
  @Override
  public void run() {
    // some code...
    
    List<MyEntity> myEntities = repository.findByName(this.someDto.getName());
    
    // more code...
  }
  
```
