// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FilmsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private FilmsAdapter.ViewHolder target;

  @UiThread
  public FilmsAdapter$ViewHolder_ViewBinding(FilmsAdapter.ViewHolder target, View source) {
    this.target = target;

    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.tv_film_name, "field 'nameTextView'", TextView.class);
    target.photo = Utils.findRequiredViewAsType(source, R.id.img_film, "field 'photo'", ImageView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.ll_container, "field 'container'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FilmsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameTextView = null;
    target.photo = null;
    target.container = null;
  }
}
