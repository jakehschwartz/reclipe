package reclipe

import org.scalajs.dom
import org.scalajs.dom.raw.Element

import scala.scalajs.js.JSON

object Scraper {

  def main(args: Array[String]): Unit = {
    findRecipe(dom.document.body) match {
      case Some(elem) =>
        val fields = "title" -> dom.document.title :: parseRecipe(elem)
        val map = fields.groupBy(_._1).mapValues(_.map(_._2))

        notify(s"Hooray! This looks like a recipe!!!\n${JSON.stringify(map)}")
      case None => notify("This is not a recipe :(")
    }
  }

  /**
   * Recursively looks for the beginning of a recipe in the DOM
   *
   * @param elem - the parent element
   * @return element where the recipe begins, if it exists
   */
  def findRecipe(elem: Element): Option[Element] = {
    if (elem.hasAttribute("itemtype") && elem.getAttribute("itemtype") == "http://schema.org/Recipe") {
      Some(elem)
    } else (0 until elem.children.length).map(elem.children.item).flatMap(x => findRecipe(x)).headOption
  }

  /**
   * Parse the DOM for attributes that the define a recipe
   *
   * @param elem - the parent element
   * @return a list of property names and values
   */
  def parseRecipe(elem: Element): List[(String, String)] = {
    // For images, use the src attribute
    if (elem.hasAttribute("itemprop") && elem.tagName == "img") {
      (elem.getAttribute("itemprop"), elem.getAttribute("src")) :: Nil
    } else if (elem.hasAttribute("itemprop")) {
      (elem.getAttribute("itemprop"), elem.innerHTML) :: Nil
    } else (0 until elem.children.length).map(elem.children.item).toList.flatMap(parseRecipe)
  }

  def notify(text: String): Unit = {
    dom.window.alert(text)
  }
}
