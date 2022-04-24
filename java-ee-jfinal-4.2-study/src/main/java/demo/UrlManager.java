package demo;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class UrlManager extends Model<UrlManager>{
  public static final UrlManager dao=new UrlManager().dao();
}
