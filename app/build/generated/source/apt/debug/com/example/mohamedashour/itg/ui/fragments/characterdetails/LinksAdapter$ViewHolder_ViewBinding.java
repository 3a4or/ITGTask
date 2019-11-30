// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LinksAdapter$ViewHolder_ViewBinding implements Unbinder {
  private LinksAdapter.ViewHolder target;

  @UiThread
  public LinksAdapter$ViewHolder_ViewBinding(LinksAdapter.ViewHolder target, View source) {
    this.target = target;

    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.tv_film_link, "field 'nameTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LinksAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameTextView = null;
  }
}
