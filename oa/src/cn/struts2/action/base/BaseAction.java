package cn.struts2.action.base;

import java.lang.reflect.ParameterizedType;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 这里封装一些共用的内容
 * @author Administrator
 *
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	public static final String LISTACTION = "listAction";  
	public static final String ADDUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public String listAction = LISTACTION;
	public String updateUI = UPDATEUI;
	public String addUI = ADDUI;
	public String action2action = ACTION2ACTION;
	public T model;
	public Class classt;
	public BaseAction(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		classt = (Class) type.getActualTypeArguments()[0];
		
		try {
			this.model = (T) classt.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public T getModel() {
		return this.model;
	}
	
}
