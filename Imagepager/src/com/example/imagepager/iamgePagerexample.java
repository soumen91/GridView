package com.example.imagepager;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

private class ImagePagerAdapter extends PagerAdapter {

	private ArrayList<PagerBaen> images;
	private LayoutInflater inflater;

	ImagePagerAdapter(ArrayList<PagerBaen> images) {
		this.images = images;
		inflater = getLayoutInflater();
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public void finishUpdate(View container) {
	}

	@Override
	public int getCount() {
		return images.size();
	}

	@Override
	public Object instantiateItem(View view, int position) {
		final View imageLayout = inflater.inflate(R.layout.pager_row, null);
		final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.pagerimage);
		final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);

		imageLoader.displayImage("http://billbahadur.com/demo/kaleidespokedev/multiple_file_upload/server/php/album_photo/medium/"+images.get(position).getAlbumPhotos(), imageView, options, new ImageLoadingListener() {
			@Override
			public void onLoadingStarted() {
				spinner.setVisibility(View.VISIBLE);
			}

			@Override
			public void onLoadingFailed(FailReason failReason) {
				String message = null;
				switch (failReason) {
					case IO_ERROR:
						message = "Input/Output error";
						break;
					case OUT_OF_MEMORY:
						message = "Out Of Memory error";
						break;
					case UNKNOWN:
						message = "Unknown error";
						break;
				}
				Toast.makeText(ImagePagerActivity.this, message, Toast.LENGTH_SHORT).show();

				spinner.setVisibility(View.GONE);
				imageView.setImageResource(android.R.drawable.ic_delete);
			}

			@Override
			public void onLoadingComplete(Bitmap loadedImage) {
				spinner.setVisibility(View.GONE);
				Animation anim = AnimationUtils.loadAnimation(ImagePagerActivity.this, R.anim.fade_in);
				imageView.setAnimation(anim);
				anim.start();
			}

			@Override
			public void onLoadingCancelled() {
				// Do nothing
			}
		});

		((ViewPager) view).addView(imageLayout, 0);
		return imageLayout;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View container) {
	}
}
