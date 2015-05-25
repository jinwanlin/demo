package xjgz.com.tag;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagerBack extends TagSupport {
	private String url; // 请求URI
	public static int DEFAULT_PAGE_SIZE = 2; // 默认每页要显示的记录数
    private int pageSize = DEFAULT_PAGE_SIZE;  //每页要显示的记录数
	private Integer page; // 当前页号
	private Integer total; // 总记录数
	int pageCount;
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		
//		if(total==null){
			String totalStr = request.getAttribute("total").toString();
			total = Integer.parseInt(totalStr);
//		}
		
		String pageStr = request.getParameter("page");
		if(pageStr == null){
			page = 1;			
		} else {
			page = Integer.parseInt(pageStr);
		}
		
		pageCount = (total + pageSize - 1) / pageSize; // 计算总页数
		// 页号越界处理
		if (page > pageCount) {
			page = pageCount;
		}
		if (page < 1) {
			page = 1;
		}

		// 拼写要输出到页面的HTML文本
		StringBuilder sb = new StringBuilder();
		sb.append("<style type=\"text/css\">");
		sb.append(".pagination {padding: 5px;float:right;font-size:12px;}");
		sb.append(".pagination a, .pagination a:link, .pagination a:visited {padding:2px 5px;margin:2px;border:1px solid #aaaadd;text-decoration:none;color:#006699;}");
		sb.append(".pagination a:hover, .pagination a:active {border: 1px solid #ff0000;color: #000;text-decoration: none;}");
		sb.append(".pagination span.current {padding: 2px 5px;margin: 2px;border: 1px solid #ff0000;font-weight: bold;background-color: #ff0000;color: #FFF;}");
		sb.append(".pagination span.disabled {padding: 2px 5px;margin: 2px;border: 1px solid #eee; color: #ddd;}");
		sb.append("</style>\r\n");
		sb.append("<div class=\"pagination\">\r\n");
		if (total == 0) {
			sb.append("<strong>没有可显示的项目</strong>\r\n");
		} else {
			sb.append("<form method=\"post\" action=\"").append(this.url).append("\" name=\"qPagerForm\">\r\n");
			// 获取请求中的所有参数
			Enumeration<String> enumeration = request.getParameterNames();
			String name = null; // 参数名
			String value = null; // 参数值
			// 把请求中的所有参数当作隐藏表单域
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement();
				value = request.getParameter(name);
				// 去除页号
				if (!name.equals("page")) {
					sb.append("<input type=\"hidden\" name=\"").append(name).append("\" value=\"").append(value).append("\"/>\r\n");
				}
			}
			// 把当前页号设置成请求参数
			sb.append("<input type=\"hidden\" name=\"").append("page").append("\" value=\"").append(page).append("\"/>\r\n");
			
			

			// 输出统计数据
			//sb.append(" 共<strong>").append(total).append("</strong>项").append(",<strong>").append(pageCount).append("</strong>页: \r\n");

			
			// 上一页处理
			if (page == 1) {
				sb.append("<span class=\"disabled\">首页").append("</span>\r\n");
				sb.append("<span class=\"disabled\">上一页").append("</span>\r\n");
			} else {
				sb.append("<a href=\"javascript:turnOverPage(1)\">首页</a>\r\n");
				sb.append("<a href=\"javascript:turnOverPage(").append((page - 1)).append(")\">上一页</a>\r\n");
			}

			// 显示当前页附近的页
			int start = getStartPage();
			int end = getEndPage();
			
//			if(page==pageCount){
//				if(page-4>0){
//					start = page-4;
//				}
//			}
//			if(page==1){
//				if(page+4<=pageCount){
//					end = page+4;
//				}
//			}
			
			
			
			
			for (int i = start; i <= end; i++) {
				if (page == i) { // 当前页号不需要超链接
					sb.append("<span class=\"current\">").append(i).append("</span>\r\n");
				} else {
					sb.append("<a href=\"javascript:turnOverPage(").append(i).append(")\">").append(i).append("</a>\r\n");
				}
			}
			

			// 下一页处理
			if (page == pageCount) {
				sb.append("<span class=\"disabled\">下一页").append("</span>\r\n");
				sb.append("<span class=\"disabled\">末页").append("</span>\r\n");
			} else {
				sb.append("<a href=\"javascript:turnOverPage(").append((page + 1)).append(")\">下一页</a>\r\n");
				sb.append("<a href=\"javascript:turnOverPage(").append(pageCount).append(")\">").append("末页</a>\r\n");
			}
			
			
			sb.append("</form>\r\n");

			// 生成提交表单的JS
			sb.append("<script language=\"javascript\">\r\n");
			sb.append("  function turnOverPage(no){\r\n");
			sb.append("    if(no>").append(pageCount).append("){");
			sb.append("      no=").append(pageCount).append(";}\r\n");
			sb.append("    if(no<1){no=1;}\r\n");
			sb.append("    document.qPagerForm.page.value=no;\r\n");
			sb.append("    document.qPagerForm.submit();\r\n");
			sb.append("  }\r\n");
			sb.append("</script>\r\n");
		}
		sb.append("</div>\r\n");

		// 把生成的HTML输出到响应中
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY; // 本标签主体为空,所以直接跳过主体
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	private int getStartPage(){
		int start = 0;
		if(page==pageCount){
			if(page-4>0){
				start = page-4;
			}
		}else if(page==pageCount-1){
			if(page-3>0){
				start = page-3;
			}
		}else if(page-2>0){
			start = page-2;
		}else if(page-1>0){
			start = page-1;
		}else {
			start = page;	
		}
		return start;
	}
	
	private int getEndPage(){
		int end = 0;
		if(page==1){
			if(page+4<=pageCount){
				end = page+4;
			}
		}else if(page==2){
			if(page+3<=pageCount){
				end = page+3;
			}
		}else if(page+2<=pageCount){
			end = page+2;
		}else if(page+1<=pageCount){
			end = page+1;
		}else {
			end = page;	
		}
		return end;
	}
	
}