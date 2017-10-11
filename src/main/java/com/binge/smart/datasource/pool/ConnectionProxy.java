package com.binge.smart.datasource.pool;

import java.lang.reflect.Method;
import java.sql.Connection;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author binge
 * @datetime 2017年10月11日
 * @version
 * @encoding UTF8
 * @Description connection 代理类
 */

public class ConnectionProxy implements MethodInterceptor {

    private Connection conn;
    private ConnectionPool cp;
    private Connection proxyConn;

    public ConnectionProxy(ConnectionPool cp, Connection conn) {
        this.cp = cp;
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getProxy(Class<Connection> cls) {
        this.proxyConn = (Connection) Enhancer.create(cls, this);
        return proxyConn;
    }

    @Override
    public Object intercept(Object targetObject, Method method, Object[] methodParams, MethodProxy methodProxy)
            throws Throwable {
        if (method.getName().equals("close")) {
            cp.releaseConn(this.proxyConn);
            return null;
        } else if(method.getName().equals("equals")){
            return methodProxy.invokeSuper(targetObject, methodParams);
        }else {
            // 如果不是调用close方法，就原样处理
            return method.invoke(this.conn, methodParams);
        }
    }

}
