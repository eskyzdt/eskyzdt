package cn.eskyzdt.modules.transaction.controller;

import cn.eskyzdt.modules.transaction.service.ExceptionOneImpl;
import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ExceptionOneController {

    @Resource
    private ExceptionOneImpl exceptionOne;

    @Resource
    private UserService userService;

    /**
     * 非运行时异常是RuntimeException以外的异常，类型上都属于Exception类及其子类。
     * 如IOException、SQLException等以及用户自定义的Exception异常。
     * 对于这种异常，JAVA编译器强制要求我们必需对出现的这些异常进行catch并处理，否则程序就不能编译通过
     */

    /**
     * 1 让checked(捕获)例外也回滚：在catch中写throw xxxException
     *    如果想在throw IOException时也回滚,那么就需要加上 @Transactional(rollbackFor=Exception.class)
     *
     * 2 让unchecked(未捕获)例外不回滚： @Transactional(noRollbackFor=RunTimeException.class)
     *      注意如果这里设置不回滚,而且catch (Exception e) {后面不抛异常不回滚的话,由于
     *      exceptionOne.exception();中设置的是回滚,那么此时整个程序会报错,并且会回滚
     *      如果想不回滚那么可以把exceptionOne.exception();中的事务传播逻辑设置为nested,
     *      或者exceptionOne.exception();中不回滚
     *
     *      其原理是因为默认的事务传播规则是required,将其内外视为一个事务
     *      那么既然这个事务一方面要被回滚,另一方面又不要回滚,产生了冲突,导致该bug产生
     *
     * */


    /**
     *  Spring 提供的几种事务控制
     *
     * 1.PROPAGATION_REQUIRED（加入已有事务）
     *     尝试加入已经存在的事务中，如果没有则开启一个新的事务。
     *
     * 2.RROPAGATION_REQUIRES_NEW（独立事务）
     *     挂起当前存在的事务，并开启一个全新的事务，新事务与已存在的事务之间彼此没有关系。
     *
     * 3.PROPAGATION_NESTED（嵌套事务）
     *     在当前事务上开启一个子事务（Savepoint）
     *     仅主事务出错, 那么都回滚(因为他们是同一个事务)
     *     仅子事务出错, 只会回滚子事务, 主事务不变.
     *     主子都出错, 都回滚
     *
     *
     * 4.PROPAGATION_SUPPORTS（跟随环境）
     *     是指 Spring 容器中如果当前没有事务存在，就以非事务方式执行；如果有，就使用当前事务。
     *
     * 5.PROPAGATION_NOT_SUPPORTED（非事务方式）
     *     是指如果存在事务则将这个事务挂起，并使用新的数据库连接。新的数据库连接不使用事务。
     *
     * 6.PROPAGATION_NEVER（排除事务）
     *     当存在事务时抛出异常，否则就已非事务方式运行。
     *
     * 7.PROPAGATION_MANDATORY（需要事务）
     *     如果不存在事务就抛出异常，否则就已事务方式运行。
     */
    /**
     *
     *
     *
     * 传播行为
     *
     * 1 不需要事务管理的(只查询的)方法：
     *  @Transactional(propagation=Propagation.NOT_SUPPORTED)
     *  PROPAGATION_NOT_SUPPORTED（非事务方式）
     *  当前事务挂起,新的方法不参与事务,当当前方法已经结束后,再重新恢复事务
     *  如果存在事务则将这个事务挂起，并使用新的数据库连接。新的数据库连接不使用事务。
     *
     *
     * 2. propagation = Propagation.REQUIRES_NEW
     *   如果当前存在事务则挂起当前事务，并开启一个全新的事务。新事务与已存在的事务之间彼此没有关系。
     *    REQUIRES_NEW 行为强调了独立性。它保证了每个事务状态管理范围内锁使用的数据库连接是彼此不一样的。例如独立事务会满足“A事务中存在B事务，当B事务递交的时候不影响A事务。A，B两个事务之间不存在相互关联关系。“
     *
     *   Suspent: 所谓“挂起”指的是将当前线程使用的数据库连接，暂时保存起来不在使用。取而代之的是一个新的数据库库连接。
     *   Suspent 特征只会出现在两种重播行为中
                独立事务（REQUIRES_NEW）
                非事务方式（NOT_SUPPORTED）
     *
     *
     */
    /**
     * @Transactional(rollbackFor=RuntimeException.class)
     * 默认情况,即不写时是上面这种
     * 在不写trycatch的时候,error和runtimeException都回滚
     * 如果写了trycatch,那么事务就不会回滚了
     * 所以如果用trycatch,那么就要手动回滚一波
     */
    @RequestMapping("/exe")
    @Transactional(rollbackFor = Exception.class)
    public void exceptionOneCon() {
        try {
            User user = new User();
            user.setUsername("fuck2");
            // 这里是个数据库操作,如果插入时失败那么必然会回滚(因为没有插入成功),所以如果这里报错且不回滚的话会报下面的错误
            // UnexpectedRollbackException:  Transaction rolled back because it has been marked as rollback-only] with root cause
            // 此时noRollbackFor不生效
            userService.insertUser(user);
            String name = Thread.currentThread().getName();
            System.out.println("主线程名" + name);
            try {
                // 对于这个异步线程, catch已经失效了, 因为执行catch的时候异步线程并未报错, 导致@transactional失效
                exceptionOne.exception();
            } catch (Exception e) {
               // e.printStackTrace();
                throw e;
            }
            System.out.println("主线程睡10s");
            System.out.println("主线程结束");
        } catch (Exception e) {
            /** 如果不加下面这一行,控制台和页面会显示spring自动回滚的信息(因为自动回滚了,给我们开发人员一个提示),而且数据库没有插入数据(因为自动回滚了)
             * 加上下面这一行,则是手动回滚,系统不提示
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
             返回的结果:
           Wed Feb 19 18:48:40 CST 2020
             There was an unexpected error (type=Internal Server Error, status=500).
             Transaction rolled back because it has been marked as rollback-only
             **/
            System.out.println("e.toString" + e.toString());
            System.out.println("e.getCause" + e.getCause());
            System.out.println("===================================");
          //  e.printStackTrace();
            System.out.println("=========================");
            System.out.println("e.getMessage()" + e.getMessage());
            // 手动回滚,页面不会报错
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("exe");
        }
    }


    public static void main(String[] args) {
    /*    String a = "[a-zA-Z0-9_-]+\\.[a-zA-Z0-9_-]+$";
        Pattern pattern = Pattern.compile(a);
        Matcher matcher = pattern.matcher("@#$@#");
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    */
        String s = "www-白3地.sdfsdf.wervd.32".replaceFirst(".+?\\.", "op.");
        System.out.println(s);
    }


    /**
     *  一、为什么要有当前连接？
     *
     *     一般数据库事务操作遵循（开启事务 -> 操作 -> 关闭事务）三个步骤，这三个步骤可以看作是固定的。你不能随意调换它们的顺序。在多线程下如果数据库连接共享，将会打破这个顺序。因为极有可能线程 A 将线程 B 的事务一起递交了。
     *
     *     所以为了减少不必要的麻烦我们使用“当前连接”来存放数据库连接，并且约定当前连接是与当前线程绑定的。也就是说您在线程A下启动的数据库事务，是不会影响到线程B下的数据库事务。它们之间使用的数据库连接彼此互不干预。
     *
     * 二、为什么需要引用计数？
     *
     *     引用计数是被用来确定当前数据库连接是否可以被 close。当引用计数器收到“减法”操作时候如果计数器为零或者小于零，则认为应用程序已经不在使用这个连接，可以放心 close。
     *
     * 三、为什么一个事务状态中只能存在一个子事务？
     *
     *     答：子事务与父事务会被封装到不同的两个事务状态中。因此事务管理器从设计上就不允许一个事务状态持有两个事务特征，这样会让系统设计变得复杂。
     *
     * 四、当前的数据库连接是可以被随时更换的，即使它的“引用计数不为0”
     *
     *     我们知道，随意更换当前连接有可能会引发数据库连接释放错误。但是依然需要这个风险的操作是由于“独立事务”的要求。
     *
     *     在独立事务中如果当前连接已经存在事务，则会新建一个数据库连接作为当前连接并开启它的事务。
     *
     *     独立事务的设计是为了保证，处于事务控制中的应用程序对数据库操作是不会有其它代码影响到它。并且它也不会影响到别人，故此称之为“独立”。
     *
     *     此外在前面提到的场景“为什么有了嵌套事务还需要独立事务？”也已经解释独立事务存在的必要性。
     *
     * 五、数据库连接具备“事务状态”
     *
     *     事务管理器在创建事务对象时，需要知道当前数据连接是否已经具有事务状态。
     *
     *     如果尚未开启事务，事务管理器可以认为这个连接是一个新的（new状态），此时在事务管理器收到 commit 请求时，具有new状态时可以放心大胆的去处理事务递交操作。
     *
     *     倘若存在事务，则很有可能在事务管理器创建事务对象之前已经对数据库进行了操作。基于这种情况下事务管理器就不能冒昧的进行 commit 或者 rollback。
     *
     *     因此事务状态是可以用来决定事务管理器是否真实的去执行 commit 和 rollback 方法。有时候这个状态也被称之为“new”状态。
     *
     */

}
