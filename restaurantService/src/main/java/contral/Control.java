package contral;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import active.restService;
import active.restServiceImpl;
//负责接收客户端连接 创建线程
public class Control {
	//创建服务器套接字对象
	private ServerSocket server;
	public static final int PORT=9999;  
	//创建线程池变量
	private ExecutorService es;
	//创建被代理的对象
	private restService service;
	//构造方法
	public Control() {
		try {
			System.out.println("服务器正在开启中....");
			//创建服务器
			this.server=new ServerSocket(PORT);
			Thread.sleep(1000);
			System.out.println("服务器已经开启中....");
			//			
			//实例化线程池对象
			es=Executors.newCachedThreadPool();
			this.service=new restServiceImpl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//这是总的控制语句
	public void start() {
		while(true) {
			//等待客户端连接
			try {
				Socket client = this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				//创建线程对象
				ControlThread ct=new ControlThread(client,service);
				//将线程对象交给线程池处理
				es.submit(ct);
				//返回当前处于活跃状态的线程数
				int activeCount = ((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前在线人数："+activeCount);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}


