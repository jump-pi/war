package appl.config;

import java.util.Hashtable;

import com.jumppi.frwk.sql.DB;
import com.jumppi.frwk.sql.DBDescriptor;
import com.jumppi.frwk.sql.IDBConfig;
import com.jumppi.frwk.util.Util;

public class DBConfig implements IDBConfig {
		
	public void setup(Hashtable<String, DBDescriptor> gDbMap, String dbUcsimDbName, String dbUcsimUsername, String dbUcsimPassword) {
        DBDescriptor dbd = null;

        //////////////////////////////////////////////////////////////
        dbd = new DBDescriptor();
        dbd.protocol = "jdbc:mysql";
        dbd.jdbcDriver = "com.mysql.jdbc.Driver";
        dbd.dbName = dbUcsimDbName;
        dbd.params = "autoReconnect=true&characterEncoding=utf-8&useUnicode=true";

        dbd.server = "127.0.0.1";
        dbd.port = "3306";
        dbd.username = dbUcsimUsername;
        if (Util.haveIp("x.x.x.x")) {                  // Production environment
            dbd.password = "yyyyy";
        } else {
            dbd.password = dbUcsimPassword;
        }

        gDbMap.put(dbd.dbName, dbd);
	}

	public void closeResourcesEndOfThread() {
        DB.closeAll();
	}
}

