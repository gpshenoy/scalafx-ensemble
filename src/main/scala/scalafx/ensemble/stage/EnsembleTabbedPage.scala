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

package scalafx.ensemble.stage

import scalafx.scene.control.TabPane
import scalafx.scene.control.Tab
import scalafx.scene.layout.{Priority, StackPane}
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.ensemble.commons.ContentFactory
import scalafx.ensemble.commons.DisplayablePage

object EnsembleTabbedPage {

  def buildTab(ctrlName: String, ctrlgrop: String) = {
    val tabbedPage = new TabPane() {
      hgrow = Priority.ALWAYS
      vgrow = Priority.ALWAYS
    }
    val demoTab = new Tab()
    demoTab.text = "Demo"
    val srcTab = new Tab()
    srcTab.text = "Source"

    demoTab.closable = false
    srcTab.closable = false

    tabbedPage.getTabs().add(demoTab)
    tabbedPage.getTabs().add(srcTab)
    new EnsembleTabbedPage(tabbedPage, ctrlName, ctrlgrop)
  }

  def buildTabContent(node: Node) = {
    val demoTabStack = new StackPane {
      alignmentInParent = Pos.TOP_LEFT
      content = List(node)
    }
    demoTabStack
  }
}

class EnsembleTabbedPage(tabPane: TabPane, ctrlName: String, ctrlGroup: String)
  extends DisplayablePage {
  def getPage() = {
    tabPane.getTabs().get(0).setContent(
      EnsembleTabbedPage.buildTabContent(
        ContentFactory.createContent(ctrlName, ctrlGroup)))
    tabPane.getTabs().get(1).setContent(
      EnsembleTabbedPage.buildTabContent(
        ContentFactory.createSrcContent(ctrlName, ctrlGroup)))
    tabPane
  }
}
