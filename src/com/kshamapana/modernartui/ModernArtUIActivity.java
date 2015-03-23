package com.kshamapana.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ModernArtUIActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modern_art_ui);

		final View view1 = findViewById(R.id.viewOne);
		final View view2 = findViewById(R.id.viewTwo);
		final View view3 = findViewById(R.id.viewThree);
		final View view4 = findViewById(R.id.viewFour);
		final View view5 = findViewById(R.id.viewFive);

		view1.setBackgroundColor(Color.LTGRAY);
		view2.setBackgroundColor(Color.rgb(0, 127, 0));
		view3.setBackgroundColor(Color.rgb(127, 0, 0));
		view4.setBackgroundColor(Color.rgb(0, 0, 127));
		view5.setBackgroundColor(Color.DKGRAY);

		final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				int doubleProgress = 2 * progress;
				view2.setBackgroundColor(Color.rgb(progress, 127, doubleProgress)); // 0,127,0 -> 127,127,254
				view3.setBackgroundColor(Color.rgb(127, doubleProgress, progress)); // 127,0,0 -> 127,254,127
				view4.setBackgroundColor(Color.rgb(doubleProgress, progress, 127)); // 0,0,127 -> 254,127,127
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.options, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		openOptionsDialog();
		return super.onOptionsItemSelected(item);
	}

	private void openOptionsDialog() {
		new AlertDialog.Builder(this).setTitle(R.string.dialog_title).setMessage(R.string.dialog_message)
				.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialoginterface, int i) {
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse("http://www.moma.org/m"));
						startActivity(intent);
					}
				}).setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {

					}
				}).show();
	}
}
