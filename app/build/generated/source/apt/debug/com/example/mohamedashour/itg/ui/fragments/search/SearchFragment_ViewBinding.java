// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.fragments.search;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchFragment_ViewBinding implements Unbinder {
  private SearchFragment target;

  private View view7f08010c;

  @UiThread
  public SearchFragment_ViewBinding(final SearchFragment target, View source) {
    this.target = target;

    View view;
    target.searchEditText = Utils.findRequiredViewAsType(source, R.id.et_search, "field 'searchEditText'", EditText.class);
    target.resultsRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_search_results, "field 'resultsRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_search_cancel, "method 'onCancelClick'");
    view7f08010c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCancelClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.searchEditText = null;
    target.resultsRecyclerView = null;

    view7f08010c.setOnClickListener(null);
    view7f08010c = null;
  }
}
