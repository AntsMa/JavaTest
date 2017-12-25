package base.sql;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class DbStoreHelper {

//	private static String insert_sql = "INSERT INTO `ord_user_22` (`USER_ORDER_ID`, `PASSWORD`) VALUES(?,?)";
	private static String insert_sql = "INSERT INTO ord.`ord_user_22` (`USER_ORDER_ID`, `CUSTOMER_ORDER_ID`, `USER_ID`, `PROD_CATALOG_ID`, `CUST_ID`, `CUST_TYPE`, `BILL_ID`, `SUB_BILL_ID`, `FIRST_USE_DATE`, `ACTIVE_DATE`, `PRE_DESTORY_TIME`, `LAST_TRANS_DATE`, `CREDIT_LEVEL`, `OWE_AMOUNT`, `PASSWORD_TYPE`, `PASSWORD`, `USER_TYPE`, `NOTICE_FLAG`, `AREA_ID`, `AREA_CODE`, `COUNTRY_CODE`, `ADDRESS_ID`, `ADDRESS_DESC`, `EXCHANGE_ID`, `IS_OUT_NET`, `BAL_ORG_ID`, `RISK_FLAG`, `STATE`, `ORDER_STATE`, `INS_STATE`, `CONT_ID`, `REGION_ID`, `USER_REGION_ID`, `OP_ID`, `ORG_ID`, `CREATE_OP_ID`, `CREATE_ORG_ID`, `DONE_CODE`, `CREATE_DATE`, `DONE_DATE`, `EFFECTIVE_DATE`, `EXPIRE_DATE`, `OBJ_EFFECTIVE_DATE`, `OBJ_EXPIRE_DATE`, `EFFECTIVE_DATE_TYPE`, `EXPIRE_DATE_TYPE`, `REMARKS`, `LAST_INS_DONE_CODE`, `INS_DONE_CODE`, `PREPAY_VALIDITY_DATE`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    static String dbName = "ord";
    static String url = "Jdbc:mysql://10.11.18.104:3306/" + dbName;
    static String userName = "root";
    static String pwd = "root";

	public DbStoreHelper() {
	}

	private static void doStore() throws ClassNotFoundException,	SQLException, IOException {
		Random random = new Random();  
		url += "?useServerPrepStmts=false&rewriteBatchedStatements=true";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName,pwd);
		conn.setAutoCommit(false); // 设置手动提交
		int count = 0;
		String line = null;
		long fileTime = System.currentTimeMillis();  
		PreparedStatement psts = conn.prepareStatement(insert_sql);
	    for (int i = 0; i < 3000000; i++) {
	    	fileTime += random.nextInt(100000000);  
	    	psts.setString(1,"3226123"+i);
	    	psts.setString(2,"32206000027600");
	    	psts.setString(3,"42206100001001");
	    	psts.setString(4,"171000000001");
	    	psts.setString(5,"21220410024601");
	    	psts.setString(6,"1");
	    	psts.setString(7,"84840254");
	    	psts.setString(8,"238029901021636");
	    	psts.setString(9,null);
	    	psts.setString(10,null);
	    	psts.setString(11,null);
	    	psts.setString(12,null);
	    	psts.setString(13,null);
	    	psts.setString(14,null);
	    	psts.setString(15,"0");
	    	psts.setString(16,"acd7abb23d49c13a"   );
	    	psts.setString(17,"1");
	    	psts.setString(18,"0");
	    	psts.setString(19,null);
	    	psts.setString(20,"2206");
	    	psts.setString(21,null);
	    	psts.setString(22,null);
	    	psts.setString(23,null);
	    	psts.setString(24,null);
	    	psts.setString(25,"0");
	    	psts.setString(26,"21000000");
	    	psts.setString(27,"0");
	    	psts.setString(28,"1");
	    	psts.setString(29,"1");
	    	psts.setString(30,"1");
	    	psts.setString(31,null);
	    	psts.setString(32,"2206");
	    	psts.setString(33,"2206");
	    	psts.setString(34,"100001314");
	    	psts.setString(35,"21000000");
	    	psts.setString(36,"100001314");
	    	psts.setString(37,"21000000");
	    	psts.setString(38,"22801");
	    	psts.setTimestamp(39, new Timestamp(fileTime));
	    	psts.setTimestamp(40,new Timestamp(fileTime));
	    	psts.setTimestamp(41,new Timestamp(fileTime));
	    	psts.setTimestamp(42,new Timestamp(fileTime));
	    	psts.setTimestamp(43,new Timestamp(fileTime));
	    	psts.setTimestamp(44,new Timestamp(fileTime));
	    	psts.setString(45,"0");
	    	psts.setString(46,"0");
	    	psts.setString(47,null);
	    	psts.setString(48,null);
	    	psts.setString(49,null);
	    	psts.setString(50,null);

			psts.addBatch();          // 加入批量处理
			count++;	
	     }
		psts.executeBatch(); // 执行批量处理
		conn.commit();  // 提交
		System.out.println("All down : " + count);
		conn.close();
	}
	
	/*public void doSql() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connectStr, username,password);
		conn.setAutoCommit(false); // 设置手动提交
		PreparedStatement psts = conn.prepareStatement(insert_sql);

	}*/
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		long startTime = System.currentTimeMillis();
		doStore();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

}
