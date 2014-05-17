package com.tcl.idm.repository;

import com.tcl.idm.util.DatabaseUtils;

/**
 * 用于操作数据库
 * 
 * @author yuanhuan
 * 2014年3月26日 上午10:57:31
 */
public class WordPressRepository
{
	public static boolean createImage(String imgName)
	{
		String imgType = "";
		if (imgName.toLowerCase().endsWith("jpg") || imgName.toLowerCase().endsWith("jpeg"))
		{
			imgType = "jpeg";
		}
		else if (imgName.toLowerCase().endsWith("png"))
		{
			imgType = "png";
		}
		String sql = "insert into `wp_posts` "
		        + "(`ID`, `post_author`, `post_date`, `post_date_gmt`, `post_content`, `post_title`, `post_excerpt`,"
		        + " `post_status`, `comment_status`, `ping_status`, `post_password`, `post_name`, `to_ping`, `pinged`,"
		        + " `post_modified`, `post_modified_gmt`, `post_content_filtered`, `post_parent`, `guid`, `menu_order`,"
		        + " `post_type`, `post_mime_type`, `comment_count`)"
		        + " values('73','1','2014-05-10 15:07:43','2014-05-10 15:07:43',"
		        + "'http://127.0.0.1/guandong/wp-content/uploads/2014/05/" + imgName + "','" + imgName + "','',"
		        + "'inherit','open','open','','" + imgName + "','','','2014-05-10 15:07:43','2014-05-10 15:07:43','',"
		        + "'0','http://127.0.0.1/guandong/wp-content/uploads/2014/05/" + imgName + "','0','attachment',"
		        + "'image/" + imgType + "','0');";
		boolean result = DatabaseUtils.insert(sql);
		return result;
	}
}
