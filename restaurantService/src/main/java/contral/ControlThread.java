package contral;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
public class ControlThread implements Runnable {
	private Socket client;
	//创建一个被代理的对象
	private Object o;
	//构造函数
	public ControlThread(Socket client, Object o) {
		super();
		this.client = client;
		this.o = o;
	}
	public void run() {
		// 获得输入流 用户接受客户端代理发送的方法名称 参数类型 参数列表
		try {
			ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
			//获取方法名称
			String methodName = ois.readUTF();
			//获取方法参数列表
			Class<?>[] methodTypes = (Class<?>[])ois.readObject();
			//获取方法参数列表
			Object[] methodParams =(Object[]) ois.readObject();
			//获取方法对象
			Method method=o.getClass().getMethod(methodName, methodTypes);
			//执行该方法返回结果
			Object result=method.invoke(o, methodParams);
			//创建输出流
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			//将结果发送给客户端
			oos.writeObject(result);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}