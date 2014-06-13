package cn.aop.annotation;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.dao.jdkproxy.Person;

@Component("transaction")
@Aspect
public class Transaction {
	
	@Pointcut("execution(* cn.aop.annotation.PersonDaoImpl.*(..))")
	private void aa(){}
	/**
	 * 前置通知
	 *    通过JoinPoint获取连接点的信息
	 */
	@Before("aa()")
	public void beginTransaction(JoinPoint joinPoint){
		joinPoint.getArgs();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName);
		System.out.println("begin transaction");
	}
	
	/**
	 * 后置通知
	 */
	public void commit(JoinPoint joinPoint,Object val){
		List<Person> list = (List<Person>) val;
		System.out.println(list.size());
		System.out.println("commit");
	}
	
	
	/**
	 * 异常通知
	 */
	public void exceptionMethod(Throwable ex){
		System.out.println(ex.getMessage());
	}
}
