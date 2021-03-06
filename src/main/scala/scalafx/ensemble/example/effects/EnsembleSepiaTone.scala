package scalafx.ensemble.example.effects

import scalafx.Includes._
import scalafx.ensemble.commons.EnsembleExample
import scalafx.geometry.Insets
import scalafx.scene.control.Label
import scalafx.scene.effect.SepiaTone
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.layout.VBox
import scalafx.scene.text.Font
import scalafx.scene.layout.Priority

class EnsembleSepiaTone extends EnsembleExample {
  def getContent = {
    new VBox {
      vgrow = Priority.ALWAYS
      hgrow = Priority.ALWAYS
      spacing = 10
      margin = Insets(50, 0, 0, 50)
      style = "-fx-padding: 8px"
      content = List(
        new Label {
          text = "Ensemble Sepia Tone"
          font = new Font("Verdana", 20)
        },
        new ImageView {
          image = new Image(this.getClass.getResourceAsStream("/scalafx/ensemble/images/boat.jpg"))
          effect = new SepiaTone() {
            level = 0.9d
          }
        })
    }
  }
}