package net.brilliant.mvp.bean;

import com.github.adminfaces.template.bean.BreadCrumbMB;
import com.github.adminfaces.template.model.BreadCrumb;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by rmpestano on 22/01/17.
 */
@Named
@SessionScoped
public class BreadcrumbExampleMB implements Serializable{

    /**
   * 
   */
  private static final long serialVersionUID = 4173570434978990240L;
    private String link;
    private String title;

    @Inject
    private BreadCrumbMB breadCrumbMB;

    public void add(){
        breadCrumbMB.add(new BreadCrumb(link,title));
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
