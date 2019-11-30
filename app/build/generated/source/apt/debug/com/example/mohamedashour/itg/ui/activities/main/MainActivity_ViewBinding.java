// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.activities.main;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f080088;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.charactersRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_main_characters, "field 'charactersRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.img_search, "method 'onSearchClick'");
    view7f080088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSearchClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.charactersRecyclerView = null;

    view7f080088.setOnClickListener(null);
    view7f080088 = null;
  }
}
