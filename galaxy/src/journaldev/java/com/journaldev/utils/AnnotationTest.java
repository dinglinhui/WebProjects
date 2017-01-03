package com.journaldev.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AnnotationTest implements InvocationHandler {
	private Object obj;

	public AnnotationTest(Object obj) {
		this.obj = obj;
	}

	// define annotation
	// keep this enum in the runtime
	@Retention(RetentionPolicy.RUNTIME)
	// 用在方法上
	@Target({ ElementType.METHOD })
	public @interface Transaction {
		public boolean value() default true;
	}

	// define interface
	public interface IDao {
		@Transaction
		// 使用注解
		public void remove();
	}

	// implement interface
	public static class DaoImpl implements IDao {
		Queue<String> queue;

		public DaoImpl(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void remove() {
			// delete error report, request rollback
			if (queue.peek().equals("stop")) {
				throw new NullPointerException();
			}
			System.err.println(queue.poll());
		}
	}

	// get proxy class
	public Object getProxy() {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object paramObject, Method paramMethod,
			Object[] paramArrayOfObject) throws Exception {
		// 取方法上面的注解Transaction
		Transaction tran = paramMethod.getAnnotation(Transaction.class);
		boolean isTran = false;
		if (tran != null) {
			isTran = tran.value();// 判断是否需要事务
		}
		Object rtnObj = null;
		try {
			if (isTran) {
				System.err.println("启动事务");
			}
			rtnObj = paramMethod.invoke(obj, paramArrayOfObject);
			if (isTran) {
				System.err.println("提交事务");
			}
		} catch (Exception e) {
			if (isTran) {
				System.err.println("回滚事务");
			}
			throw e;
		}
		return rtnObj;
	}

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		Collections.addAll(queue, "1", "stop", "2");

		AnnotationTest test = new AnnotationTest(new DaoImpl(queue));
		IDao dao = (IDao) test.getProxy();
		try {
			while (queue.peek() != null) {
				dao.remove();
			}
		} catch (Exception e) {
			System.out.println("-----------------");
			for (String str : queue) {
				System.out.println(str);
			}
		}
	}
}