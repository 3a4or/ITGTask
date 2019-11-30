// Generated code from Butter Knife. Do not modify!
package com.example.mohamedashour.itg.ui.fragments.characterdetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mohamedashour.itg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CharacterDetailsFragment_ViewBinding implements Unbinder {
  private CharacterDetailsFragment target;

  private View view7f080083;

  @UiThread
  public CharacterDetailsFragment_ViewBinding(final CharacterDetailsFragment target, View source) {
    this.target = target;

    View view;
    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.tv_character_details_name, "field 'nameTextView'", TextView.class);
    target.descTextView = Utils.findRequiredViewAsType(source, R.id.tv_character_details_desc, "field 'descTextView'", TextView.class);
    target.photo = Utils.findRequiredViewAsType(source, R.id.img_character_details_photo, "field 'photo'", ImageView.class);
    target.comicsRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_character_details_comics, "field 'comicsRecyclerView'", RecyclerView.class);
    target.seriesRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_character_details_series, "field 'seriesRecyclerView'", RecyclerView.class);
    target.storiesRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_character_details_stories, "field 'storiesRecyclerView'", RecyclerView.class);
    target.eventsRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_character_details_events, "field 'eventsRecyclerView'", RecyclerView.class);
    target.linksRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_character_details_links, "field 'linksRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.img_back, "method 'onBackClick'");
    view7f080083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBackClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CharacterDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameTextView = null;
    target.descTextView = null;
    target.photo = null;
    target.comicsRecyclerView = null;
    target.seriesRecyclerView = null;
    target.storiesRecyclerView = null;
    target.eventsRecyclerView = null;
    target.linksRecyclerView = null;

    view7f080083.setOnClickListener(null);
    view7f080083 = null;
  }
}
