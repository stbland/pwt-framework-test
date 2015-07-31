package org.stbland.testpwt.client.views.treeview;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import fr.putnami.pwt.core.inject.client.annotation.PresentHandler;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.widget.client.Label;

/**
 * Classe TreeviewView
 *
 * @author stbland
 */
@Templated
public class TreeviewView extends Composite implements View {

    @UiField
    Tree gwtTree;

    @PresentHandler
    void present(TreeviewPlace place) {

//        fillGwtTreeWithGwtWidget();
        fillGwtTreeWithPwtWidget();
    }

    TreeItem newChildTreeItem(TreeItem parent, String text) {
        TreeItem child = newTreeItem(text);
        parent.addItem(child);
        return child;
    }

    TreeItem newTreeItem(String text) {
        Label label = new Label();
        label.setText(text);
        return new TreeItem(label);
    }

    private void fillGwtTreeWithGwtWidget() {
        TreeItem root = new TreeItem();
        root.setText("root");
        //  root.addStyleName("p-icon icon-plus");

        root.addTextItem("item0");
        root.addTextItem("item1");
        root.addTextItem("item2");

        // Add a CheckBox to the tree
        TreeItem item = new TreeItem(new CheckBox("item3"));
        root.addItem(item);

        gwtTree.addItem(root);
    }

    private void fillGwtTreeWithPwtWidget() {
        /*
        TreeItem root = newTreeItem("root");

        newChildTreeItem(root, "item0");
        newChildTreeItem(root, "item1");
        newChildTreeItem(root, "item2");
        
        gwtTree.addItem(root);
        */
        
        TreeItem parent1 = newTreeItem("Parent 1");
        TreeItem child1 = newChildTreeItem(parent1, "Child 1");
        newChildTreeItem(child1, "Grandchild 1");
        newChildTreeItem(child1, "Grandchild 2");
        newChildTreeItem(parent1, "Child 2");              
        
        gwtTree.addItem(parent1);
        gwtTree.addItem(newTreeItem("Parent 2"));
        gwtTree.addItem(newTreeItem("Parent 3"));
        gwtTree.addItem(newTreeItem("Parent 4"));
        gwtTree.addItem(newTreeItem("Parent 5"));

        
    }

}
