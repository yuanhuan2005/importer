package com.tcl.idm.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcl.idm.connectionpool.DBConnectionManager;
import com.tcl.idm.model.DBSelectResult;

public class DatabaseUtils
{
	final static private Log DEBUGGER = LogFactory.getLog(DatabaseUtils.class);

	final static private String CONNECTION_POOL_NAME = "mysql";

	// execute selection language
	public static DBSelectResult select(String sql)
	{
		DBConnectionManager connectionMan = DBConnectionManager.getInstance();
		Connection conn = connectionMan.getConnection(DatabaseUtils.CONNECTION_POOL_NAME);
		Statement statement = null;
		ResultSet resultSet = null;
		try
		{
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			DBSelectResult dbSelectResult = new DBSelectResult();
			dbSelectResult.setResultSet(resultSet);
			dbSelectResult.setStatement(statement);
			return dbSelectResult;
		}
		catch (Exception e)
		{
			DatabaseUtils.DEBUGGER.error("Exception: " + e.toString());
		}
		finally
		{
			connectionMan.freeConnection(DatabaseUtils.CONNECTION_POOL_NAME, conn);
		}

		return null;
	}

	// execute insertion language
	public static boolean insert(String sql)
	{
		DBConnectionManager connectionMan = DBConnectionManager.getInstance();
		Connection conn = connectionMan.getConnection(DatabaseUtils.CONNECTION_POOL_NAME);
		Statement statement = null;

		try
		{
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			conn.commit();
			return true;
		}
		catch (Exception e)
		{
			DatabaseUtils.DEBUGGER.error("Exception: " + e.toString());
		}
		finally
		{
			try
			{
				if (null != statement)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}
			connectionMan.freeConnection(DatabaseUtils.CONNECTION_POOL_NAME, conn);
		}

		return false;
	}

	// execute delete language
	public static boolean delete(List<String> sqls)
	{
		return DatabaseUtils.update(sqls);
	}

	// execute update language
	public static boolean update(List<String> sqls)
	{
		DBConnectionManager connectionMan = DBConnectionManager.getInstance();
		Connection conn = connectionMan.getConnection(DatabaseUtils.CONNECTION_POOL_NAME);

		Statement statement = null;

		if (null == sqls || sqls.isEmpty())
		{
			return false;
		}

		try
		{
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			for (int i = 0; i < sqls.size(); i++)
			{
				statement.executeUpdate(sqls.get(i));
			}
			conn.commit();
			return true;
		}
		catch (Exception e)
		{
			DatabaseUtils.DEBUGGER.error("Exception: " + e.toString());
		}
		finally
		{
			try
			{
				if (null != statement)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}
			connectionMan.freeConnection(DatabaseUtils.CONNECTION_POOL_NAME, conn);
		}

		return false;
	}
}
