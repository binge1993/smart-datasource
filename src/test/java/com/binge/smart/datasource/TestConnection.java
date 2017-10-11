package com.binge.smart.datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author binge
 * @datetime 2017年10月11日
 * @version
 * @encoding UTF8
 * @Description
 */

public class TestConnection {
    public static void main(String[] args) {
       RemoveObj rm = new RemoveObj();
       LinkedList list = new LinkedList<>();
       list.add(rm);
       
       list.remove(rm);
       System.out.println("ss");
    }
}
