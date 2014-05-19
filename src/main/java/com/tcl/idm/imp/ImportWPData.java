package com.tcl.idm.imp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ImportWPData
{
	/**
	 * 构造单个产品的XML格式Item属性段
	 * 
	 * @param productCategory
	 * @param productZhCNName
	 * @param productZhTWName
	 * @param productEnUSName
	 * @param productPrice
	 * @param postId
	 * @param thumbnailId
	 * @return
	 */
	private static List<String> genItemStringList(String productCategory, String productZhCNName,
	        String productZhTWName, String productEnUSName, String productPrice, int postId, int thumbnailId)
	{
		List<String> itemStringList = new ArrayList<String>();
		itemStringList.add("	<item>");
		itemStringList.add("		<title>[:en]" + productEnUSName + "[:zh]" + productZhCNName + "[:tw]" + productZhTWName
		        + "</title>");
		itemStringList.add("		<link>http://127.0.0.1/guandong/product/"
		        + productEnUSName.toLowerCase().replaceAll(" ", "_") + "/</link>");
		itemStringList.add("		<pubDate>Sat, 17 May 2014 12:57:20 +0000</pubDate>");
		itemStringList.add("        <dc:creator><![CDATA[admin]]></dc:creator>");
		itemStringList.add("		<guid isPermaLink=\"false\">http://127.0.0.1/guandong/?post_type=product&#038;p="
		        + postId + "</guid>");
		itemStringList.add("		<description>[:en]" + productEnUSName + "[:zh]" + productZhCNName + "[:tw]"
		        + productZhTWName + "</description>");
		itemStringList.add("		<content:encoded><![CDATA[[:en]" + productEnUSName + "[:zh]" + productZhCNName + "[:tw]"
		        + productZhTWName + "]]></content:encoded>");
		itemStringList.add("		<excerpt:encoded><![CDATA[]]></excerpt:encoded>");
		itemStringList.add("		<wp:post_id>" + postId + "</wp:post_id>");
		itemStringList.add("        <wp:post_date>2014-05-17 20:57:20</wp:post_date>");
		itemStringList.add("		<wp:post_date_gmt>2014-05-17 12:57:20</wp:post_date_gmt>");
		itemStringList.add("		<wp:comment_status>closed</wp:comment_status>");
		itemStringList.add("		<wp:ping_status>closed</wp:ping_status>");
		itemStringList.add("		<wp:post_name>[:en]" + productEnUSName + "[:zh]" + productZhCNName + "[:tw]"
		        + productZhTWName + "</wp:post_name>");
		itemStringList.add("		<wp:status>publish</wp:status>");
		itemStringList.add("		<wp:post_parent>0</wp:post_parent>");
		itemStringList.add("		<wp:menu_order>0</wp:menu_order>");
		itemStringList.add("		<wp:post_type>product</wp:post_type>");
		itemStringList.add("		<wp:post_password></wp:post_password>");
		itemStringList.add("		<wp:is_sticky>0</wp:is_sticky>");
		itemStringList.add("		<category domain=\"product_cat\" nicename=\"cold-apptizers\"><![CDATA[" + productCategory
		        + "]]></category>");
		itemStringList.add("		<category domain=\"product_type\" nicename=\"simple\"><![CDATA[simple]]></category>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>_edit_last</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[1]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>_thumbnail_id</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[" + thumbnailId + "]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>regular_price</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[" + productPrice + "]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>sale_price</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>length</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[0]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>width</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[0]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>tax_status</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[taxable]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>tax_classes</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[a:1:{i:0;s:1:\"*\";}]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>visibility</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[visible]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>featured</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>customizable</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[no]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>customized_length</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>product_attributes</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[a:0:{}]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>manage_stock</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>stock_status</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[instock]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>sale_price_dates_from</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("		<wp:postmeta>");
		itemStringList.add("			<wp:meta_key>sale_price_dates_to</wp:meta_key>");
		itemStringList.add("			<wp:meta_value><![CDATA[]]></wp:meta_value>");
		itemStringList.add("		</wp:postmeta>");
		itemStringList.add("	</item>");

		return itemStringList;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		// TODO begin 需要根据实际情况修改下面变量的值
		int nextPostId = 122; // 下一个Post ID，在wp-posts表中查找最大ID，然后加1即可得到该数字。
		int defaultThumbnailId = 73; // 默认图片的ID，在后台上传了该默认图片之后，即可在wp-posts表中找到其ID。
		String outputPath = "D:/items.txt"; // 输出文件路径，XML格式，用于后台批量导入。
		String menuTextFile = "D:/guandong_menu.txt"; // 输入的文件路径，text文本格式
		// TODO end

		String content = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(menuTextFile), "UTF-8"));
		String[] contentSplit = null;
		String productCategory = "";
		String productZhCNName = "";
		String productZhTWName = "";
		String productEnUSName = "";
		String productPrice = "";
		String thumbnailIdStr = "";

		FileWriter fw = new FileWriter(outputPath, true);
		PrintWriter pw = new PrintWriter(fw);
		while (null != (content = br.readLine()))
		{
			if (StringUtils.isEmpty(content) || content.startsWith(",") || StringUtils.isEmpty(content)
			        || StringUtils.isEmpty(content.trim()))
			{
				continue;
			}

			// 判断是否为产品类别
			if (content.indexOf(",,") > 0 || content.indexOf(",") < 0)
			{
				productCategory = content.replaceAll(",", "").trim();
				continue;
			}

			// 解析文本行
			contentSplit = content.split(",");
			productZhCNName = contentSplit[2];
			productZhTWName = contentSplit[1];
			productEnUSName = contentSplit[3];
			productPrice = contentSplit[4];
			try
			{
				thumbnailIdStr = contentSplit[5];
				if (StringUtils.isNotEmpty(thumbnailIdStr))
				{
					defaultThumbnailId = Integer.valueOf(thumbnailIdStr);
				}
			}
			catch (Exception e)
			{
			}

			// 构造每个产品的Item段，并写入输出文件。
			List<String> itemStringList = ImportWPData.genItemStringList(productCategory, productZhCNName,
			        productZhTWName, productEnUSName, productPrice, nextPostId, defaultThumbnailId);
			for (String itemString : itemStringList)
			{
				pw.println(itemString);
				System.out.println(itemString);
			}
			nextPostId++;
		}

		pw.close();
		fw.close();
	}
}
