// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.activities.main;

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

public class CharactersAdapter$ViewHolder_ViewBinding implements Unbinder {
  private CharactersAdapter.ViewHolder target;

  @UiThread
  public CharactersAdapter$ViewHolder_ViewBinding(CharactersAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.titleTextView = Utils.findRequiredViewAsType(source, R.id.tv_item_main_title, "field 'titleTextView'", TextView.class);
    target.photo = Utils.findRequiredViewAsType(source, R.id.img_item_main_photo, "field 'photo'", ImageView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.rl_container, "field 'container'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CharactersAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleTextView = null;
    target.photo = null;
    target.container = null;
  }
}
