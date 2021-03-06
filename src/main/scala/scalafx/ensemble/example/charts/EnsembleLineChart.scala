/*
 * Copyright (c) 2012, ScalaFX Ensemble Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.ensemble.example.charts

import scalafx.Includes._
import scalafx.ensemble.commons.EnsembleExample
import scalafx.geometry.Insets
import scalafx.scene.chart.LineChart
import scalafx.scene.chart.NumberAxis
import scalafx.scene.chart.XYChart
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox
import scalafx.scene.text.Font

class EnsembleLineChart extends EnsembleExample {
  def getContent = {
    new VBox {
      vgrow = scalafx.scene.layout.Priority.ALWAYS
      hgrow = scalafx.scene.layout.Priority.ALWAYS
      spacing = 10
      margin = Insets(50, 0, 0, 50)
      content = List(
        new Label {
          text = "Ensemble Line Chart"
          font = new Font("Verdana", 20)
        },
        createLineChart)
    }
  }

  val createLineChart = {

    val xAxis = NumberAxis("Values for X-Axis", 0, 3, 1)
    val yAxis = NumberAxis("Values for Y-Axis", 0, 3, 1)

    val bcSeries1 = new XYChart.Series[Number, Number]()
    bcSeries1.setName("Series 1")
    // create sample data
    bcSeries1.getData().add(XYChart.Data[Number, Number](0.0, 1.0))
    bcSeries1.getData().add(XYChart.Data[Number, Number](1.2, 1.4))
    bcSeries1.getData().add(XYChart.Data[Number, Number](2.2, 1.9))
    bcSeries1.getData().add(XYChart.Data[Number, Number](2.7, 2.3))
    bcSeries1.getData().add(XYChart.Data[Number, Number](2.9, 0.5))

    val bcSeries2 = new XYChart.Series[Number, Number]()
    bcSeries2.setName("Series 2")
    // create sample data
    bcSeries2.getData().add(XYChart.Data[Number, Number](0.0, 1.6))
    bcSeries2.getData().add(XYChart.Data[Number, Number](0.8, 0.4))
    bcSeries2.getData().add(XYChart.Data[Number, Number](1.4, 2.9))
    bcSeries2.getData().add(XYChart.Data[Number, Number](2.1, 1.3))
    bcSeries2.getData().add(XYChart.Data[Number, Number](2.6, 0.9))

    val lineChart = LineChart[Number, Number](xAxis, yAxis)
    lineChart.getData.add(bcSeries1)
    lineChart.getData.add(bcSeries2)
    lineChart
  }
}