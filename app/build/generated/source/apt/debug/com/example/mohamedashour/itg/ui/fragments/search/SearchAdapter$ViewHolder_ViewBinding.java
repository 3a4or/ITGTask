// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.fragments.search;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SearchAdapter.ViewHolder target;

  @UiThread
  public SearchAdapter$ViewHolder_ViewBinding(SearchAdapter.ViewHolder target, View source) {
    this.target = target;

    target.titleTextView = Utils.findRequiredViewAsType(source, R.id.tv_search_name, "field 'titleTextView'", TextView.class);
    target.photo = Utils.findRequiredViewAsType(source, R.id.img_search_photo, "field 'photo'", ImageView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.rl_container, "field 'container'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleTextView = null;
    target.photo = null;
    target.container = null;
  }
}
