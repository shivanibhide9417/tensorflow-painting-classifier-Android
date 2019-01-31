/* Copyright 2015 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package org.tensorflow.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import org.tensorflow.demo.Classifier.Recognition;

import java.util.List;

import static android.R.color.black;

public class RecognitionScoreView extends View implements ResultsView {
  private static final float TEXT_SIZE_DIP = 24;
  private List<Recognition> results;
  private final float textSizePx;
  private final Paint fgPaint;
  private final Paint bgPaint;
  String lineSeparator = System.getProperty("line.separator");
  public String starry="STARRY NIGHT "+lineSeparator+" Artist: Van Gogh"+lineSeparator+"1678";
  public String lisa="MONA LISA "+lineSeparator+" Artist: Leonardo Da Vinci"+lineSeparator+"1689";
  public String supper="THE LAST SUPPER "+lineSeparator+"Artist: Leonardo Da Vinci"+lineSeparator+"1978";
  public String quixote="DON QUIXOTE "+lineSeparator+" Artist: Pablo Picasso"+lineSeparator+"1998";
  public String whistler="WHISTLER'S MOTHER" +lineSeparator+"Artist : James Mcneill Whistler"+lineSeparator+"1878";
  public String guernica="GUERNICA"+lineSeparator+" Artist: Pablo Picasso"+lineSeparator+"1999";





  public RecognitionScoreView(final Context context, final AttributeSet set) {
    super(context, set);

    textSizePx =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
    fgPaint = new Paint();
   // fgPaint.setTextSize(textSizePx);
    fgPaint.setTextSize(70);
   // fgPaint.setColor(17170444);

    bgPaint = new Paint();
    bgPaint.setColor(17170443);
  }

  @Override
  public void setResults(final List<Recognition> results) {
    this.results = results;
    postInvalidate();
  }

  @Override
  public void onDraw(final Canvas canvas) {
    final int x = 10;
    int y = (int) (fgPaint.getTextSize() * 1.5f);

    canvas.drawPaint(bgPaint);

    if (results != null) {
      Recognition recog=results.get(0);
     // for (final Recognition recog : results) {


        if (recog.getTitle().equalsIgnoreCase("guernica"))
        {canvas.drawText(guernica , x, y, fgPaint);}

        if (recog.getTitle().equalsIgnoreCase("lisa")) {
          canvas.drawText(lisa, x, y, fgPaint);
        }

        if (recog.getTitle().equalsIgnoreCase("starry")) {
          canvas.drawText(starry, x, y, fgPaint);
        }

        if (recog.getTitle().equalsIgnoreCase("supper")) {
          canvas.drawText(supper, x, y, fgPaint);
        }

        if (recog.getTitle().equalsIgnoreCase("quixote"))

        {canvas.drawText(quixote , x, y, fgPaint);}

        if (recog.getTitle().equalsIgnoreCase("whistlers"))
        {canvas.drawText(whistler , x, y, fgPaint);}

        y += fgPaint.getTextSize() * 1.5f;
      }
    }

}
