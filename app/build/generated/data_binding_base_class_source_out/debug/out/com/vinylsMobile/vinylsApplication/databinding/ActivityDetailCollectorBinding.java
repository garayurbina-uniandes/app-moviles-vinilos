// Generated by view binder compiler. Do not edit!
package com.vinylsMobile.vinylsApplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.vinylsMobile.vinylsApplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailCollectorBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final TextView collectorLabel;

  @NonNull
  public final TextView comments;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextView contentFavoritePerformers;

  @NonNull
  public final CoordinatorLayout detailAlbum;

  @NonNull
  public final TextView favoritePerformers;

  @NonNull
  public final TextView textContentCollector;

  @NonNull
  public final TextView textContentComments;

  @NonNull
  public final Toolbar toolbar;

  private ActivityDetailCollectorBinding(@NonNull CoordinatorLayout rootView,
      @NonNull AppBarLayout appBarLayout, @NonNull TextView collectorLabel,
      @NonNull TextView comments, @NonNull ConstraintLayout constraintLayout,
      @NonNull TextView contentFavoritePerformers, @NonNull CoordinatorLayout detailAlbum,
      @NonNull TextView favoritePerformers, @NonNull TextView textContentCollector,
      @NonNull TextView textContentComments, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.collectorLabel = collectorLabel;
    this.comments = comments;
    this.constraintLayout = constraintLayout;
    this.contentFavoritePerformers = contentFavoritePerformers;
    this.detailAlbum = detailAlbum;
    this.favoritePerformers = favoritePerformers;
    this.textContentCollector = textContentCollector;
    this.textContentComments = textContentComments;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailCollectorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailCollectorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_collector, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailCollectorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.collector_label;
      TextView collectorLabel = ViewBindings.findChildViewById(rootView, id);
      if (collectorLabel == null) {
        break missingId;
      }

      id = R.id.comments;
      TextView comments = ViewBindings.findChildViewById(rootView, id);
      if (comments == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.content_favorite_performers;
      TextView contentFavoritePerformers = ViewBindings.findChildViewById(rootView, id);
      if (contentFavoritePerformers == null) {
        break missingId;
      }

      CoordinatorLayout detailAlbum = (CoordinatorLayout) rootView;

      id = R.id.favorite_performers;
      TextView favoritePerformers = ViewBindings.findChildViewById(rootView, id);
      if (favoritePerformers == null) {
        break missingId;
      }

      id = R.id.textContentCollector;
      TextView textContentCollector = ViewBindings.findChildViewById(rootView, id);
      if (textContentCollector == null) {
        break missingId;
      }

      id = R.id.textContentComments;
      TextView textContentComments = ViewBindings.findChildViewById(rootView, id);
      if (textContentComments == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityDetailCollectorBinding((CoordinatorLayout) rootView, appBarLayout,
          collectorLabel, comments, constraintLayout, contentFavoritePerformers, detailAlbum,
          favoritePerformers, textContentCollector, textContentComments, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
