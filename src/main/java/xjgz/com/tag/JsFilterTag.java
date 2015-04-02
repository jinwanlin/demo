package xjgz.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 
 * @author i
 *
 */
public class JsFilterTag extends BodyTagSupport {
	public JsFilterTag() {
		super();
	}
	public int doStartTag() throws JspTagException {
		System.out.println("doStartTag...");
		return EVAL_BODY_TAG;
	}
	public void setBodyContent(BodyContent bodyContent) {
		System.out.println("setBodyContent...");
		this.bodyContent = bodyContent;
	}
	public void doInitBody() throws JspTagException {
		String content = getBodyContent().getString();
		System.out.println(content);
		System.out.println("doInitBody....");
	}
	public int doAfterBody() throws JspTagException {
		System.out.println("do end Tag...");

		BodyContent body = getBodyContent();
		String code = body.getString();
		JspWriter out = body.getEnclosingWriter();

		code = code.replaceAll("\n", "");
		code = code.replaceAll("\r", "");

		code = code.replaceAll("\'", "\\\\'");
		code = code.replaceAll("\"", "\\\\\"");

		code = code.replaceAll(">", "\\\\>");
		code = code.replaceAll("<", "\\\\<");
		try {
			out.print(code);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
	public int doEndTag() throws JspTagException {
		System.out.println("do end Tag...");
		return SKIP_BODY;
	}

}
