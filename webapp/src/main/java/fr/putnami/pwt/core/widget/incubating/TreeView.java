package fr.putnami.pwt.core.widget.incubating;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.IsWidget;

import fr.putnami.pwt.core.editor.client.factory.CloneableWidget;
import fr.putnami.pwt.core.model.client.base.HasHtmlId;
import fr.putnami.pwt.core.theme.client.CssStyle;
import fr.putnami.pwt.core.widget.client.base.AbstractPanel;
import fr.putnami.pwt.core.widget.client.base.SimpleCollapse;
import fr.putnami.pwt.core.widget.client.base.SimpleStyle;
import fr.putnami.pwt.core.widget.client.util.StyleUtils;

/**
 *
 * @author sbeaufort
 */
public class TreeView extends AbstractPanel implements CloneableWidget, HasHtmlId {

    private static final CssStyle STYLE_TREEVIEW = new SimpleStyle("treeview");
    private JSONObject options;

    public class TreeViewListGroup extends SimpleCollapse {

        public TreeViewListGroup() {
            super(UListElement.TAG);
        }

    }

    public interface Css extends CssResource {

    }

    public interface ResourceBundle extends ClientBundle {

        public static final ResourceBundle INSTANCE = GWT.create(ResourceBundle.class);

        @NotStrict
        @Source("fr/putnami/pwt/core/widget/incubating/bootstrap-treeview.min.css")
        public Css treeviewCss();

        @Source("fr/putnami/pwt/core/widget/incubating/jquery-1.11.3.min.js")
        public TextResource jqueryScript();

        @Source("fr/putnami/pwt/core/widget/incubating/bootstrap-treeview.min.js")
        public TextResource treeviewScript();
    }

    private TreeViewListGroup listGroup;

    public TreeView() {
        this(new JSONObject());
    }

    public TreeView(JSONObject options) {
        super(DivElement.TAG);
        GWT.log("TreeView(JSONObject options)");

        this.options = options;

        listGroup = new TreeViewListGroup();
        add(listGroup);

        this.endConstruct();
    }

    protected TreeView(TreeView source) {
        super(source);

        GWT.log("TreeView(TreeView source)");

        this.options = source.options;

        this.cloneSourceWidgets(source);
        this.endConstruct();
    }
    
    private void endConstruct() {
        GWT.log("TreeView.endConstruct");

        StyleInjector.inject(ResourceBundle.INSTANCE.treeviewCss().getText());
        StyleUtils.addStyle(this, TreeView.STYLE_TREEVIEW);
        
        ScriptInjector.fromString(ResourceBundle.INSTANCE.jqueryScript().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(ResourceBundle.INSTANCE.treeviewScript().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();        
    }

    private native void createTreeViewJS(TreeView treeview, String htmlId, JavaScriptObject options) /*-{                   
     console.log("createTreeViewJS htmlId=" + htmlId);
            
     var defaultData = [
     {
     text: 'Parent 1',
     href: '#parent1',
     tags: ['4'],
     nodes: [
     {
     text: 'Child 1',
     href: '#child1',
     tags: ['2'],
     nodes: [
     {
     text: 'Grandchild 1',
     href: '#grandchild1',
     tags: ['0']
     },
     {
     text: 'Grandchild 2',
     href: '#grandchild2',
     tags: ['0']
     }
     ]
     },
     {
     text: 'Child 2',
     href: '#child2',
     tags: ['0']
     }
     ]
     },
     {
     text: 'Parent 2',
     href: '#parent2',
     tags: ['0']
     },
     {
     text: 'Parent 3',
     href: '#parent3',
     tags: ['0']
     },
     {
     text: 'Parent 4',
     href: '#parent4',
     tags: ['0']
     },
     {
     text: 'Parent 5',
     href: '#parent5'  ,
     tags: ['0']
     }
     ];
            
     options.data = defaultData;        
        options.expandIcon = 'p-icon icon-plus';
            options.collapseIcon = 'p-icon icon-minus';
            options.emptyIcon = 'p-icon';
            
     $wnd.$("#" + htmlId).treeview(options);
     }-*/;

    @Override
    public IsWidget cloneWidget() {
        GWT.log("TreeView.cloneWidget");
        return new TreeView(this);
    }

    @Override
    public void add(IsWidget w) {
        //if (w instanceof BreadcrumbLink) {
        this.append(w);
        //}
    }

    @Override
    public void setHtmlId(String htmlId) {
        GWT.log("TreeView.setHtmlId " + htmlId);
        getElement().setId(htmlId);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        GWT.log("TreeView.onLoad");
        createTreeViewJS(this, getHtmlId(), options.getJavaScriptObject());
    }

    @Override
    public String getHtmlId() {
        return getElement().getId();
    }

}
