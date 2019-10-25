package http3Cookie;

public class Cookie {
	private String name;
	private String value;
	private String path;
	private String domain;
	private Integer maxAge;
	
	
	
	@Override
	public String toString() {
		String ret="Set-Cookie:"+name+"="+value+"; ";
		//expries=Thu, 19-Nov-15 14:14:50 GMT; domain=www.daidu.com; path=/";
		ret += path ==null? "":("path=" +path+";");
		ret += domain ==null? "":("domain=" +domain + ";");
		ret += maxAge ==null? "":("max-Age=" +maxAge+";");
		return ret;
	}
	
	public Cookie(String name,String value){
		super();
		this.name=name;
		this.value=value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	
	
}
