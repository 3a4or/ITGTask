// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.activities.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CurrenciesAdapter$ViewHolder_ViewBinding implements Unbinder {
  private CharactersAdapter.ViewHolder target;

  @UiThread
  public CurrenciesAdapter$ViewHolder_ViewBinding(CharactersAdapter.ViewHolder target,
                                                  View source) {
    this.target = target;

    target.keyTextView = Utils.findRequiredViewAsType(source, R.id.tv_key, "field 'keyTextView'", TextView.class);
    target.flagImageView = Utils.findRequiredViewAsType(source, R.id.img_flag, "field 'flagImageView'", CircleImageView.class);
    target.valEditText = Utils.findRequiredViewAsType(source, R.id.et_val, "field 'valEditText'", EditText.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.ll_container, "field 'container'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CharactersAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.keyTextView = null;
    target.flagImageView = null;
    target.valEditText = null;
    target.container = null;
  }
}
