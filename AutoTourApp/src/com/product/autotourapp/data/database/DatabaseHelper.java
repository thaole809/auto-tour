package com.product.autotourapp.data.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper<T> extends OrmLiteSqliteOpenHelper {

	private final static String databaseName = "Example";
	private final static int databaseVersion = 1;
	
	private RuntimeExceptionDao<T, Integer> runtimeExceptionDao = null;
	
	public DatabaseHelper(Context context) {
		super(context, databaseName, null, databaseVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {

		Log.v("----------------onCreate----------------", DatabaseHelper.class.getName());
		try {
			TableUtils.createTable(connectionSource, (Class<T>)getClass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		RuntimeExceptionDao<T, Integer> runtimeDao = getRunTimeExceptionDao();
//		String name = "Enbake";
//		long date = System.currentTimeMillis();
//		DemoORMLite demo = new DemoORMLite(name, "Jonathan", date	);
//		runtimeDao.create(demo);
//		
//		name = "Nguyen Quoc";
//		date = System.currentTimeMillis();
//		demo = new DemoORMLite(name, "Le Hung", date	);
//		runtimeDao.create(demo);
		
		Log.v(DatabaseHelper.class.getName(), "create new entries in onCreate: ");
	}

	
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		//cach 1 sua tren database cu
		arg0.execSQL("ALTER TABLE " + "DATABASE_TABLE" + " ADD COLUMN " + "NEW_COLUMN_NAME" + "TYPE");
		
		//cach 2 drop table cu create table moi, minh nghi mat data
		try {  
			Log.v("----------------onUpgrade----------------", DatabaseHelper.class.getName());  
			TableUtils.dropTable(connectionSource, (Class<T>)getClass(), true);  
			// after we drop the old databases, we create the new ones  
			onCreate(arg0, connectionSource);  
		} catch (SQLException e) {  
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);  
			throw new RuntimeException(e);  
		}  
	}

	@Override
	public void close() {
		super.close();
		runtimeExceptionDao = null;
	}
	
	public RuntimeExceptionDao<T, Integer> getRunTimeExceptionDao() {
		if(runtimeExceptionDao == null) {
			runtimeExceptionDao = getRuntimeExceptionDao((Class<T>)getClass());
		}
		return runtimeExceptionDao;
	}

}
