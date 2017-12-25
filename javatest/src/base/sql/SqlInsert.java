package base.sql;

import java.sql.SQLException;


/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: SqlInsert.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年5月31日 下午1:50:24 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class SqlInsert {

	 static String driver = "com.mysql.jdbc.Driver";
     static String dbName = "ord";
     static String pwd = "root";
     static String userName = "root";
     static String url = "Jdbc:mysql://10.11.18.104:3306/" + dbName;
	public static void main(String[] args) throws SQLException {
		Jdbc jdbc = new Jdbc();
		jdbc.jdbcComm(driver, dbName, userName, pwd, url);
		int userOrderId = 130000000;
		int resultInt = 0;
		boolean commitFlag=false;
		for (int i = 0; i <= 10000000; i++) {
			userOrderId = userOrderId +1;
			String sqlUpdate = "INSERT INTO ord.`ord_user_22` (`USER_ORDER_ID`, `CUSTOMER_ORDER_ID`, `USER_ID`, `PROD_CATALOG_ID`, `CUST_ID`, `CUST_TYPE`, `BILL_ID`, `SUB_BILL_ID`, `FIRST_USE_DATE`, `ACTIVE_DATE`, `PRE_DESTORY_TIME`, `LAST_TRANS_DATE`, `CREDIT_LEVEL`, `OWE_AMOUNT`, `PASSWORD_TYPE`, `PASSWORD`, `USER_TYPE`, `NOTICE_FLAG`, `AREA_ID`, `AREA_CODE`, `COUNTRY_CODE`, `ADDRESS_ID`, `ADDRESS_DESC`, `EXCHANGE_ID`, `IS_OUT_NET`, `BAL_ORG_ID`, `RISK_FLAG`, `STATE`, `ORDER_STATE`, `INS_STATE`, `CONT_ID`, `REGION_ID`, `USER_REGION_ID`, `OP_ID`, `ORG_ID`, `CREATE_OP_ID`, `CREATE_ORG_ID`, `DONE_CODE`, `CREATE_DATE`, `DONE_DATE`, `EFFECTIVE_DATE`, `EXPIRE_DATE`, `OBJ_EFFECTIVE_DATE`, `OBJ_EXPIRE_DATE`, `EFFECTIVE_DATE_TYPE`, `EXPIRE_DATE_TYPE`, `REMARKS`, `LAST_INS_DONE_CODE`, `INS_DONE_CODE`, `PREPAY_VALIDITY_DATE`) VALUES('"+userOrderId+"','32209000026122','41209389422532','171000000001','21220010023001','1','84840231','238029901021674',NULL,'2015-11-30 07:19:03',NULL,NULL,'0','0','0','35393db4e02c4d07','1','0',NULL,'2209',NULL,NULL,NULL,NULL,'0','21000000','0','2','1','1',NULL,'2209','2209','410001030','21000000','100001314','21000000','22003','2015-11-30 07:19:03','2015-11-30 07:19:04','2015-11-27 03:12:03','2099-12-31 23:59:59','2015-11-27 03:12:03','2099-12-31 23:59:59','0','0',NULL,'22001',NULL,NULL)";
			if(i%50000==0)
			{
				commitFlag = true;
			}else{
				commitFlag = false;
			}
			resultInt = jdbc.update(sqlUpdate,commitFlag);
		}
		System.out.println("resultInt : "+resultInt);
		
	}

}
