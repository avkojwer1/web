package cn.aop.xml;

import java.util.List;

import org.aspectj.lang.JoinPoint;

import cn.dao.jdkproxy.Person;


public class Transaction {
	/**
	 * 前置通知
	 *    通过JoinPoint获取连接点的信息
	 */
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
