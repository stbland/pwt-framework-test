package org.stbland.testpwt.client.views.tableeditor;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import fr.putnami.pwt.core.inject.client.annotation.Initialize;
import fr.putnami.pwt.core.inject.client.annotation.PresentHandler;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.widget.client.Form;
import fr.putnami.pwt.core.widget.client.Modal;
import fr.putnami.pwt.core.widget.client.TableEditor;
import fr.putnami.pwt.core.widget.client.event.ButtonEvent;
import org.stbland.testpwt.shared.constants.UserViewConstants;
import org.stbland.testpwt.shared.domain.User;
import org.stbland.testpwt.shared.repository.UserMemoryRepository;

/**
 *
 * @author sbeaufort
 */
@Templated
public class TableEditorView extends Composite implements View {

    @UiField
    @Initialize(constantsClass = UserViewConstants.class)
    Form<User> userEditor;

    @UiField
    @Initialize(constantsClass = UserViewConstants.class)
    TableEditor<User> userTable;

    @UiField
    Modal modal;

    @PresentHandler
    void present(TableEditorPlace place) {
        userTable.edit(UserMemoryRepository.get().getUserList());
    }

    @UiHandler("addButton")
    void onClickMeBouttonEvent(ButtonEvent event) {
        this.userEditor.edit(new User());
        this.modal.toggleVisibility();
    }
}
